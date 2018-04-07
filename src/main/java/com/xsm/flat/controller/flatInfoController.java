package com.xsm.flat.controller;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.model.PutObjectResult;
import com.xsm.flat.utils.QcloudUtil;
import com.xsm.flat.utils.SystemUtil;
import com.xsm.flat.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by 薛时鸣 on 18-4-7.
 *
 * @author 薛时鸣
 * @date 18-4-7
 */
public class flatInfoController {

    public static final String url = "";

    @RequestMapping("/imgUpload")
    public Object imgUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        JSONObject jsonObject = new JSONObject();
        //判断文件格式
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String prefix = filename.substring(0,filename.lastIndexOf("."));
        if(StringUtils.isBlank(filename)||StringUtils.isBlank(prefix)
                || (!".jpg".equalsIgnoreCase(suffix) && !".png".equalsIgnoreCase(suffix))){
            return WebUtil.paramError("文件格式错误，必须.jpg或.png后缀");
        }
        File dir = new File(url + request.getSession().getServletContext().getContextPath());
        if  (!dir.exists()  && !dir.isDirectory()){
            System.out.println("文件夹不存在，进行创建");
            dir.mkdir();
        } else{
            System.out.println("目录存在");
        }
        System.out.println(url+file.getOriginalFilename());
        String autoFileName = SystemUtil.getRandomString(10)+"_"+System.currentTimeMillis()+suffix;
        String path = url + autoFileName;
        File cosFile = new File(path);
        //输出文件
        file.transferTo(cosFile);
        //读取本地文件输入流
        PutObjectResult result = QcloudUtil.uploadFileToCos(autoFileName,cosFile);
        if(result==null){
            jsonObject.put("state",60004);
        }else{
            jsonObject.put("fileUrl",QcloudUtil.getQcloudFileUrl(autoFileName));
            jsonObject.put("state",200);
        }
        return jsonObject;
    }
}
