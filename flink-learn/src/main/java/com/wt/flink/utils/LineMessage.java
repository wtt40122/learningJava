package com.wt.flink.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/6/25 10:11
 */
public class LineMessage {
    public static transient String KEY_IP = "ip";
    public static transient String KEY_COLLECT_TIMESTAMP = "ct";
    public static transient String KEY_MQ_TOPIC = "t";
    public static transient String KEY_MQ_TOPIC_TAG = "tag";
    public static transient String KEY_MESSAGE_TYPE = "type";
    private Long lineNumber;
    private String fileName;
    private Long pointer;
    private Integer msgLength;
    private String msgBody;
    private Map<String, String> extMap;

    public LineMessage() {
    }

    public long getTimestamp() {
        String value = (String)this.extMap.get(KEY_COLLECT_TIMESTAMP);
        return StringUtils.isEmpty(value) ? 0L : Long.parseLong(value);
    }

    public void setTimeStamp(long time) {
        this.extMap.put(KEY_COLLECT_TIMESTAMP, String.valueOf(time));
    }

    public Long getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getPointer() {
        return this.pointer;
    }

    public void setPointer(Long pointer) {
        this.pointer = pointer;
    }

    public Integer getMsgLength() {
        return this.msgLength;
    }

    public void setMsgLength(Integer msgLength) {
        this.msgLength = msgLength;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getMsgBody() {
        return this.msgBody;
    }

    public Map<String, String> getExtMap() {
        return this.extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }

    public synchronized void setProperties(String key, String value) {
        if (null == this.extMap) {
            this.extMap = new HashMap();
        }

        this.extMap.put(key, value);
    }

    public String getProperties(String key) {
        return this.getProperties(key, (String)null);
    }

    public String getProperties(String key, String defaultValue) {
        if (null == this.extMap) {
            return defaultValue;
        } else if (StringUtils.isBlank(key)) {
            return defaultValue;
        } else {
            String value = (String)this.extMap.get(key);
            return StringUtils.isBlank(value) ? defaultValue : value;
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String toString() {
        return "LineMessage(lineNumber=" + this.getLineNumber() + ", fileName=" + this.getFileName() + ", pointer=" + this.getPointer() + ", msgLength=" + this.getMsgLength() + ", msgBody=" + this.getMsgBody() + ", extMap=" + this.getExtMap() + ")";
    }
}
