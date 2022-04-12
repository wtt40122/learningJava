package com.wt.tmall;

import com.wt.tmall.feign.FeignAndRibbonController;
import com.wt.tmall.util.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/11 16:30
 */
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        Utils.loadPropertySource(FeignAndRibbonController.class, "default.properties");
//        Utils.loadPropertySource(FeignAndRibbonController.class, "ribbon.properties");
        SpringApplication.run(Bootstrap.class, args);
    }
}
