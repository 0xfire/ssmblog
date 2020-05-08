package com.zed.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class myUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static String getDATE(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        return ft.format(dNow);
    }
}
