package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
import com.basedemo02xtgl.common.basedemo02xtglcommon.resultEntity.ResultCadData;
import com.basedemo02xtgl.common.basedemo02xtglcommon.utils.UUIDGenerator;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Name YhglController
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/xtgl/yhgl")
public class YhglController {
    @Autowired
    private YhglService yhglService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @PostMapping("/queryUsers")
    public ResultCadData queryUsers(@RequestBody TbUser tbUser) {
        ResultCadData<List> resultCadData = new ResultCadData();
        List<TbUser> list = yhglService.queryUsers(tbUser.getUsername());
        resultCadData.setMsg("查询成功");
        resultCadData.setData(list);
        resultCadData.setCode(200);

        return resultCadData;
    }
    @PostMapping(value = "/insertUsers")
    public ResultCadData insertUsers(@RequestBody TbUser tbUser) {
        ResultCadData<Object> resultCadData = new ResultCadData();
        tbUser.setId(UUIDGenerator.getUUID());
        Integer i = yhglService.insertUsers(tbUser);
        if(i == 1){
            resultCadData.setMsg("新增用户信息成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
            return resultCadData;
        }else{
            resultCadData.setMsg("新增用户信息失败");
            resultCadData.setData(null);
            resultCadData.setCode(500);
            return resultCadData;
        }
    }

    @PostMapping(value = "/deleteUsers")
    public ResultCadData deleteUsers(@RequestBody TbUser tbUser) {
        ResultCadData<Map> resultCadData = new ResultCadData();
        Integer i = yhglService.deleteUsers(tbUser);
        if(i == 1){
            resultCadData.setMsg("删除成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
        }
        return resultCadData;
    }
    @PostMapping(value = "/deleteAllUsers")
    public ResultCadData deleteAllUsers(@RequestParam String ids) {
        ResultCadData<Map> resultCadData = new ResultCadData();
        List list = Arrays.asList(ids.split(","));
        yhglService.deleteAllUsers(list);
        resultCadData.setMsg("批量删除成功");
        resultCadData.setData(null);
        resultCadData.setCode(200);
        return resultCadData;
    }
    @PostMapping(value = "/updateUsers")
    public ResultCadData updateUsers(@RequestBody TbUser tbUser) {
        ResultCadData<Object> resultCadData = new ResultCadData();
        Integer i = yhglService.updateUsers(tbUser);
        if(i == 1){
            resultCadData.setMsg("修改用户信息成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
            return resultCadData;
        }else{
            resultCadData.setMsg("修改用户信息失败");
            resultCadData.setData(null);
            resultCadData.setCode(500);
            return resultCadData;
        }
    }
}
