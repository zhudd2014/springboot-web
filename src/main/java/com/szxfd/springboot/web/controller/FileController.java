/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FileController
 * Author:   admin
 * Date:     2019/4/6 18:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/4/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/uploadLog")
    public BaseResponse uploadLog(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String contextPath = request.getContextPath();//"/SpringMvcFileUpload"
            String servletPath = request.getServletPath();//"/gotoAction"
            String scheme = request.getScheme();//"http"
            String storePath = "E:\\project\\springboot-web\\WebRoot\\app\\log";//存放我们上传的文件路径
            String fileName = file.getOriginalFilename();
            File filepath = new File(storePath, fileName);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();//如果目录不存在，创建目录
            }
            try {
                file.transferTo(new File(storePath + File.separator + fileName));//把文件写入目标文件地址
            } catch (Exception e) {
                e.printStackTrace();
                return new BaseResponse("", e.getMessage());
            }
            return new BaseResponse(true, true);//返回到成功页面
        } else {
            return new BaseResponse("", "file is empty");//返回到失败的页面
        }
    }

//    @RequestMapping(value = "uploadBigFile", method = RequestMethod.POST)
//    public String uploadBigFile(MultipartHttpServletRequest request) {
//        // 获得第1张图片（根据前台的name名称得到上传的文件）
//        MultipartFile file = request.getFile("file");
//        if (file.getSize() != 0) {
//            // 获得文件名：
//            String filename = file.getOriginalFilename();
//            String timeType = null;
//            if (null != filename && !filename.equals("")) {
//                String imgtype = filename.substring(filename.lastIndexOf("."));
//                // 获取路径
//                String ctxPath = "E:\\project\\springboot-web\\WebRoot\\images";
//                // 创建文件
//                File dirPath = new File(ctxPath);
//                if (!dirPath.exists()) {
//                    dirPath.mkdirs();
//                }
//                //以时间为文件名
//                Date date = new Date();
//                SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMddHHmmss");//24小时制
//                String LgTime = sdformat.format(date);
//                timeType = LgTime + imgtype;
//                File uploadFile = new File(ctxPath + timeType);
//                try {
//                    InputStream is = file.getInputStream();
//                    FileOutputStream fos = new FileOutputStream(uploadFile);
//                    int b = -1;
//                    byte[] buffer = new byte[1024];
//
//                    while ((b = is.read(buffer)) != -1) {
//                        fos.write(buffer, 0, b);
//                    }
//                    fos.close();
//                    is.close();
//
//                    //FileCopyUtils.copy(file.getBytes(), uploadFile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return "redirect:/";
//    }

}