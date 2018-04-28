package com.all.play.myeventbus.bean;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  14:32
 */

public class MessageOrg {

    private String message;

    public MessageOrg(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageOrg{" +
                "message='" + message + '\'' +
                '}';
    }
}
