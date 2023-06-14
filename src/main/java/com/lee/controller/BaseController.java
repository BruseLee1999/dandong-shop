package com.lee.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BaseController {
    //获取session对象中的id
    protected final Integer getidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("id")
                .toString());
    }
    //获取当前登录用户的username
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

    protected final Integer getPidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("pid")
                .toString());
    }

    protected final String getDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


    protected final String getUUID() {
        String replaceUUID = UUID.randomUUID().toString().replace("-", "");
        return replaceUUID;
    }
}
