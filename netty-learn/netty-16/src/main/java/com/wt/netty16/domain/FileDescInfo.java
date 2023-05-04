package com.wt.netty16.domain;

/**
 * @author wtt
 * @version 1.0
 * @description 文件描述信息
 * @date 2023/5/3 18:48
 */
public class FileDescInfo {
    private String fileUrl;
    private String fileName;
    private Long fileSize;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
