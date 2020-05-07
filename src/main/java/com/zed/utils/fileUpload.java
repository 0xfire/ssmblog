package com.zed.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class fileUpload {
    //白名单
    private String whiteList[] = {"png", "jpg", "jpge"};

    public static String uploadAvater(HttpServletRequest request, MultipartFile userAvatar) {

        //获取上传头像的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdir();
        }

        String filename = userAvatar.getOriginalFilename();
        System.out.println(filename);
        String Ext = filename.substring(filename.lastIndexOf(".")).toLowerCase();

        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + Ext;
        try {
            userAvatar.transferTo(new File(path, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filename;
    }
}
