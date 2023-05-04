package com.wt.tmall.product.exception;

import com.wt.common.exception.BizCodeEnum;
import com.wt.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wtt
 * @Date: 2021/1/16 13:37
 * @Description:
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.wt.tmall.product.controller")
public class TmallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException exception){
        log.info("数据类型校验出现异常{}，异常类型{}",exception.getMessage(),exception.getClass());
        Map<String,String> errorMap = new HashMap<String,String>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),
                BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data",errorMap);
    }

    @ExceptionHandler(value=Exception.class)
    public R handleException(Exception e){
        log.info("服务器异常",e);
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
