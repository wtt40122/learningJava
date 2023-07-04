package com.wt.learn.request;

import com.google.common.collect.Lists;
import com.jayway.jsonpath.JsonPath;
import com.wt.learn.constants.BasicConst;
import com.wt.learn.utils.TimeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.asynchttpclient.RequestBuilder;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @Author: wtt
 * @Date: 2023/7/4 22:45
 * @Version: 1.0
 * @Description:
 */
public class GateWayRequest implements IGatewayRequest {

    @Getter
    private final String uniqueId;
    @Getter
    private final long beginTime;
    @Getter
    private final long endTime;
    @Getter
    private final Charset charset;
    @Getter
    private final String clientIp;

    @Getter
    private final String host;

    @Getter
    private final String path;

    @Getter
    private final String uri;

    @Getter
    private final HttpMethod method;
    @Getter
    private final String contentType;
    @Getter
    private final HttpHeaders headers;
    @Getter
    private final QueryStringDecoder queryStringDecoder;
    @Getter
    private final FullHttpRequest fullHttpRequest;


    private String body;

    private Map<String, Cookie> cookieMap;

    private Map<String, List<String>> postParameters;

    private String modifyScheme;

    private String modifyHost;

    private String modifyPath;

    private final RequestBuilder requestBuilder;

    public GateWayRequest(String uniqueId, long beginTime, long endTime, Charset charset, String clientIp, String host, String path, String uri, HttpMethod httpMethod, String contentType, HttpHeaders httpHeaders, QueryStringDecoder queryStringDecoder, FullHttpRequest fullHttpRequest, RequestBuilder requestBuilder) {
        this.uniqueId = uniqueId;
        this.beginTime = TimeUtil.currentTimeMillis();
        this.endTime = endTime;
        this.charset = charset;
        this.clientIp = clientIp;
        this.method = httpMethod;
        this.contentType = contentType;
        this.headers = httpHeaders;
        this.queryStringDecoder = new QueryStringDecoder(uri, charset);
        this.fullHttpRequest = fullHttpRequest;
        this.requestBuilder = new RequestBuilder();

        this.host = host;
        this.path = queryStringDecoder.path();
        this.uri = uri;

        this.modifyHost = host;
        this.modifyPath = path;
        this.modifyScheme = BasicConst.HTTP_PREFIX_SEPARATOR;

        this.requestBuilder.setMethod(getMethod().name());
        this.requestBuilder.setHeaders(getHeaders());
        this.requestBuilder.setQueryParams(queryStringDecoder.parameters());

        ByteBuf contentBuffer = fullHttpRequest.content();
        if (Objects.nonNull(contentBuffer)) {
            this.requestBuilder.setBody(contentBuffer.nioBuffer());
        }
    }

    public String getBody() {
        if (StringUtils.isEmpty(body)) {
            body = fullHttpRequest.content().toString(charset);
        }
        return body;
    }

    public Cookie getCookie(String name) {
        if (null == cookieMap) {
            cookieMap = new HashMap();
            String cookieStr = getHeaders().get(HttpHeaderNames.COOKIE);
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieStr);
            for (Cookie cookie : cookies) {
                cookieMap.put(name, cookie);
            }
        }
        return cookieMap.get(name);
    }


    public List<String> getPostParamsMultiple(String name) {
        return queryStringDecoder.parameters().get(name);
    }


    public List<String> getQueryParamsMultiple(String name) {
        String body = getBody();
        if (isFormPost()) {
            if (null == postParameters) {
                QueryStringDecoder queryStringDecoder = new QueryStringDecoder(body, false);
                postParameters = queryStringDecoder.parameters();
            }
            if (null == postParameters || postParameters.isEmpty()) {
                return null;
            } else {
                return postParameters.get(name);
            }
        } else if (isJsonPost()) {
            return Lists.newArrayList(JsonPath.read(body, name).toString());
        }
        return null;
    }

    private boolean isJsonPost() {
        return HttpMethod.POST.equals(method) && (contentType.startsWith(HttpHeaderValues.FORM_DATA.toString()) || contentType.startsWith(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString()));
    }

    private boolean isFormPost() {
        return HttpMethod.POST.equals(method) && contentType.startsWith(HttpHeaderValues.APPLICATION_JSON.toString());
    }

    @Override
    public void setModifyHost(String host) {

    }

    @Override
    public String getModifyHost() {
        return null;
    }

    @Override
    public void setModifyPath(String path) {

    }

    @Override
    public String getModifyPath() {
        return null;
    }

    @Override
    public void addHeader(CharSequence name, String value) {

    }

    @Override
    public void setHeader(CharSequence name, String value) {

    }

    @Override
    public void addQueryParam(String name, String value) {

    }

    @Override
    public void addFormParam(String name, String value) {

    }

    @Override
    public void addOrReplaceCookie(Cookie cookie) {

    }

    @Override
    public void setRequestTimeout(int requestTimeout) {

    }

    @Override
    public String getFinalUrl() {
        return null;
    }

    @Override
    public IGatewayRequest build() {
        return null;
    }
}
