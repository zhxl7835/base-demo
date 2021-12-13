package com.basedemo.login.basedemo01login.api;


import com.basedemo.login.basedemo01login.config.login.NoToken;
import com.basedemo.login.basedemo01login.config.login.TokenService;
import com.basedemo.login.basedemo01login.config.login.TokenUtil;
import com.basedemo.login.basedemo01login.service.LoginService;
import com.basedemo01.login.common.basedemo01logincommon.resultEntity.ResultCadData;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbPowers;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenService tokenService;

    // 登录
    @NoToken
    @PostMapping("login")
    public ResultCadData login(@RequestBody TbUser user, HttpServletResponse response) {
        ResultCadData<Map> resultCadData = new ResultCadData();
        Map<String,Object> map = new HashMap<String,Object>();
        TbUser userInfo = null;
        try {
            userInfo = loginService.loginCheck(user.getUsername());
            if(userInfo == null){
                resultCadData.setCode(500);
                resultCadData.setMsg("登录失败,帐户不存在");
                map.put("token",null);
                resultCadData.setData(map);
                return resultCadData;
            }

            if (!userInfo.getPassword().equals(user.getPassword())) {
                resultCadData.setCode(500);
                resultCadData.setMsg("登录失败,密码错误");
                map.put("token",null);
                resultCadData.setData(map);
                return resultCadData;
            } else {
                //登录成功
                //获取token
                String token = tokenService.getToken(userInfo);
                /*Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                response.addCookie(cookie);*/
                //获取用户权限
                resultCadData.setCode(200);
                resultCadData.setMsg("登录成功");
                map.put("token",token);
                resultCadData.setData(map);
                return resultCadData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultCadData.setCode(500);
            resultCadData.setMsg("系统异常，请与管理员联系");
            map.put("token",null);
            resultCadData.setData(map);
            return resultCadData;
        }
    }

    @GetMapping("get_info")
    public ResultCadData get_info() {
        ResultCadData<TbUser> resultCadData = new ResultCadData();
        //获取用户信息
        TbUser userInfo = loginService.findUserById(TokenUtil.getTokenUserId());
        //获取用户权限
        List<TbPowers> list = loginService.getPowers(userInfo.getId(),userInfo.getUsername());
        String[] access = null;
        if(list.size() == 0){
            access = new String[1];
            access[0] = ""; //0为没有配权限的用户，只可以访问没有配roleId的菜单
        }else{
            access = new String[list.size()];
        }
        for(int i = 0;i<list.size();i++){
            access[i] = list.get(i).getMenuid();
        }
        userInfo.setAccess(access);
        resultCadData.setCode(200);
        resultCadData.setMsg("成功");
        resultCadData.setData(userInfo);
        return resultCadData;
    }

    /***
     * 这个请求是用来模仿登录获取token  所有不需要token就可以访问
     *
     * @author: ZHXL
     * @date 2021年12月02日 下午5:45:19
     * @return String 返回类型
     */
    @NoToken
    @GetMapping("loginTest")
    public String loginTest() {
        TbUser tbUser = new TbUser();
        tbUser.setId("1");
        tbUser.setUsername("admin");
        tbUser.setPassword("123456");
        String token = tokenService.getToken(tbUser);
        return "登录模拟接口，生成token："+token;
    }
    /***
     * 这个请求需要验证token才能访问
     *
     * @author: ZHXL
     * @date 2021年12月02日 下午5:45:19
     * @return String 返回类型
     */
    @GetMapping("/getMessage")
    public String getMessage() {
        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());
        return "访问成功。。你已通过token验证"+TokenUtil.getTokenUserId();
    }
    /***
     * 这个请求是验证无token非登录接口的请求，也可以访问
     *
     * @author: ZHXL
     * @date 2021年12月02日 下午5:45:19
     * @return String 返回类型
     */
    @NoToken
    @GetMapping("/getPassToken")
    public String getPassToken() {
        System.out.println("这个请求不需要验证token也能访问");
        return "访问成功。。这个请求不需要token验证也能访问";
    }
}
