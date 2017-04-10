package com.taifutech.entity;

import java.util.List;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/6
 * If you don't konw it,Please ask Google
 */
public class MessageInformation {
    private int teamid;
    private String teamname;
    private String message;

    public MessageInformation() {

    }

    public MessageInformation(String teamname) {
        this.teamname = teamname;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
