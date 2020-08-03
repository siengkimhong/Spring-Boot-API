package com.kimhong.apispring.rest.response;

import java.io.Serializable;

public class ImageResponse implements Serializable {
    private String name;
    private String uri;
    private String fileType;
    private long fileSize;

    public ImageResponse() {
    }

    public ImageResponse(String name, String uri, String fileType, long fileSize) {
        this.name = name;
        this.uri = uri;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
