package com.wt.netty21.domain;

/**
 * @author wtt
 * @version 1.0
 * @description 接口反馈信息类
 * @date 2023/5/5 9:38
 */
public class EasyResult {
    private boolean success;
    private String title;
    private String msg;

    public static EasyResult buildSuccessResult() {
        EasyResult easyResult = new EasyResult();
        easyResult.setSuccess(true);
        easyResult.setMsg("ok");
        return easyResult;
    }

    public static EasyResult buildErrResult(Exception e) {
        EasyResult easyResult = new EasyResult();
        easyResult.setSuccess(false);
        easyResult.setMsg(e.getMessage());
        return easyResult;
    }

    public static EasyResult buildErrResult(String msg) {
        EasyResult easyResult = new EasyResult();
        easyResult.setSuccess(false);
        easyResult.setMsg(msg);
        return easyResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
