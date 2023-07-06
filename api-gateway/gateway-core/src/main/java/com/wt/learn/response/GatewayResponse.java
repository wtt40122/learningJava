package com.wt.learn.response;

import com.wt.learn.enums.ResponseCode;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Data;
import org.asynchttpclient.Response;

/**
 * @Author: wtt
 * @Date: 2023/7/5 22:33
 * @Version: 1.0
 * @Description:
 */
@Data
public class GatewayResponse {

    private HttpHeaders responseHeaders = new DefaultHttpHeaders();
    private HttpHeaders extraResponseHeaders = new DefaultHttpHeaders();

    private String content;

    private HttpResponseStatus httpResponseStatus;

    private Response futureResponse;


    public void putHeader(CharSequence key, CharSequence value) {
        responseHeaders.add(key, value);
    }

    /**
     * 构建异步响应信息
     *
     * @param futureResponse
     * @return
     */
    public static GatewayResponse buildGatewayResponse(Response futureResponse) {
        GatewayResponse response = new GatewayResponse();
        response.setFutureResponse(futureResponse);
        response.setHttpResponseStatus(HttpResponseStatus.valueOf(futureResponse.getStatusCode()));
        return response;
    }


    /**
     * 返回一个JSON类型的响应信息，失败时使用
     *
     * @param code
     * @param args
     * @return
     */
    public static GatewayResponse buildGatewayResponse(ResponseCode code, Object... args) {
        GatewayResponse response = new GatewayResponse();
//        response.setFutureResponse(futureResponse);
//        response.setHttpResponseStatus(HttpResponseStatus.valueOf(futureResponse.getStatusCode()));
        return response;
    }
}
