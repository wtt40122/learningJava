package com.wt.rpc.netty.provider;

import com.wt.netty.rpc.domain.Hi;
import com.wt.netty.rpc.service.HelloService;
import org.springframework.stereotype.Controller;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/11 10:28
 */
@Controller("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hi() {
        return "hi wtt rpc";
    }

    @Override
    public String say(String str) {
        return str;
    }

    @Override
    public String sayHi(Hi hi) {
        return hi.getUserName() + " say：" + hi.getSayMsg();
    }

}
