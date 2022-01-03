package com.wt.netty.rpc;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 23:06
 */
public class RpcClientProxy {
    public static Object createProxy(Class serviceClass) {
        return
                Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                        new Class[]{serviceClass}, (proxy, method, args) -> {
                            //1.封装request请求对象
                            RpcRequest rpcRequest = new RpcRequest();
                            rpcRequest.setRequestId(UUID.randomUUID().toString());
                            rpcRequest.setClassName(method.getDeclaringClass().getName());
                            rpcRequest.setMethodName(method.getName());
                            rpcRequest.setParameterTypes(method.getParameterTypes());
                            rpcRequest.setParameters(args);
                            //2.创建RpcClient对象
                            RpcClient rpcClient = new RpcClient("127.0.0.1", 9799);
                            try {
                                //3.发送消息
                                Object responseMsg = rpcClient.send(JSON.toJSONString(rpcRequest));
                                RpcResponse rpcResponse = JSON.parseObject(responseMsg.toString(), RpcResponse.class);
                                if (rpcResponse.getError() != null) {
                                    throw new RuntimeException(rpcResponse.getError());
                                }
                                //4.返回结果
                                Object result = rpcResponse.getResult();
                                return JSON.parseObject(result.toString(), method.getReturnType());
                            } catch (Exception e) {
                                throw e;
                            } finally {
                                rpcClient.close();
                            }
                        });
    }
}
