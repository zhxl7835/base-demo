package com.basedemo.middle.basedemo01middle.api;
import com.basedemo.common.basedemo01common.resultEntity.ResultCadData;
import com.basedemo.common.basedemo01common.vo.login.TbPowers;
import com.basedemo.common.basedemo01common.vo.login.TbUser;
import com.basedemo.middle.basedemo01middle.config.login.*;
import com.basedemo.middle.basedemo01middle.service.LoginService;
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
        TbUser userForBase = loginService.loginCheck(user.getUsername());
        if(userForBase == null){
            resultCadData.setMsg("登录失败,帐户不存在22");
            map.put("success",false);
            map.put("userInfo",null);
            map.put("token",null);
            resultCadData.setData(map);
            resultCadData.setCode(0);
            return resultCadData;
        }
        if (!userForBase.getPassword().equals(user.getPassword())) {
            resultCadData.setMsg("登录失败,密码错误11");
            map.put("success",false);
            map.put("userInfo",null);
            map.put("token",null);
            resultCadData.setData(map);
            resultCadData.setCode(0);
            return resultCadData;
        } else {
            //登录成功
            //获取token
            String token = tokenService.getToken(userForBase);
            /*Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);*/
            //获取用户权限
            List<TbPowers> list = loginService.getPowers(userForBase.getId(),userForBase.getUsername());
            int[] roles = null;
            if(list.size() == 0){
                roles = new int[1];
                roles[0] = 0; //0为没有配权限的用户，只可以访问没有配roleId的菜单
            }else{
                roles = new int[list.size()];
            }
            for(int i = 0;i<list.size();i++){
                roles[i] = list.get(i).getMenuid();
            }
            userForBase.setRoles(roles);

            resultCadData.setMsg("登录成功");
            map.put("success",true);
            map.put("userInfo",userForBase);
            map.put("token",token);
            resultCadData.setData(map);
            resultCadData.setCode(200);
            return resultCadData;
        }
    }

    @GetMapping("get_info")
    public String get_info(@RequestParam String token) {
        System.out.println("toke="+token);
        return "getInfo";
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