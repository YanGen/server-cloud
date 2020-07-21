package com.muhuan.frame.common.constant;

public enum RedisNamespaceEnum {

    USER("user:");

    private String content;
    public String getContent() {
        return content;
    }

    RedisNamespaceEnum(String content){
        this.content = content;
    }
}
