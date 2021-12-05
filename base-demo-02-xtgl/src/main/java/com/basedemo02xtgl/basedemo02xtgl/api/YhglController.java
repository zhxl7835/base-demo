package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo01.login.common.basedemo01logincommon.resultEntity.ResultCadData;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PostMapping("/queryUser")
    public ResultCadData queryUser(@RequestBody TbUser user) {
        ResultCadData<Map> resultCadData = new ResultCadData();

        return resultCadData;
    }
}
