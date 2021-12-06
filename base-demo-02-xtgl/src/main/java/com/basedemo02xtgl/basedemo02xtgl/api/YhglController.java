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

    public void funRedis(String type){
        if("1".equals(type)){
            /**
             * 设置保存string类型到redis
             */
            redisTemplate.opsForValue().set("key1","1");
            redisTemplate.opsForValue().set("key2","2");
            redisTemplate.opsForValue().set("key3","3");
        }else if("2".equals(type)){
            /**
             * 设置保存map类型到redis
             */
            Map<String,Object> map = new HashMap<>();
            map.put("name","张三");
            map.put("age","18");
            map.put("gender","男");

            redisTemplate.opsForHash().putAll("userInfo",map);
            redisTemplate.opsForHash().put("userInfo","sel","111");
        } else if("3".equals(type)){
            /**
             * 设置保存map类型到redis
             */
            Map<String,Object> map = new HashMap<>();
            map.put("name","张三");
            map.put("age","18");
            map.put("gender","男");

            redisTemplate.opsForHash().putAll("userInfo",map);
            redisTemplate.opsForHash().put("userInfo","sel","111");
        } else if("3".equals(type)){
            /**
             * 设置保存List类型到redis
             */
            List<String > list1 = new ArrayList<>();
            list1.add("hello1");
            list1.add("world1");

            List<String > list2 = new ArrayList<>();
            list2.add("hello2");
            list2.add("world2");

            redisTemplate.opsForList().leftPush("leftList",list1);
            redisTemplate.opsForList().rightPush("rightList",list2);
        } else if("4".equals(type)){
            /**
             * 设置保存Set类型到redis
             */
            SetOperations<Object, Object> set = redisTemplate.opsForSet();
            set.add("numberSet","1");
            set.add("numberSet","2");
            set.add("numberSet","3");
            Set<Object> resultSet =redisTemplate.opsForSet().members("numberSet");
        } else if("5".equals(type)){
            /**
             * 设置保存Zset类型到redis
             */
            ZSetOperations<Object,Object> zSetOperations = redisTemplate.opsForZSet();
            zSetOperations.add("zSet","one",1);
            zSetOperations.add("zSet","two",2);
            zSetOperations.add("zSet","three",3);

            System.out.println(redisTemplate.opsForZSet().range("zSet",1,3));
            System.out.println(redisTemplate.opsForZSet().range("zSet",0,zSetOperations.size("zSet")));
        }

    }
}
