package com.wt.tmall.product.controller;

import com.wt.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wtt
 * @Date: 2020/12/21 10:31
 * @Description:
 */
@RestController
@RefreshScope
public class TestConfigController {

    @Value("${user.configName}")
    private String userName;
    @Value("${user.age}")
    private String age;

    @RequestMapping("/test/config")
    public R testConfig(){
        return R.ok().put("userName",userName).put("age",age);
    }
}
