package com.xsm.flat.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.qcloud.cos.model.PutObjectResult;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Flat;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.User;
import com.xsm.flat.service.FlatService;
import com.xsm.flat.utils.QcloudUtil;
import com.xsm.flat.utils.SystemUtil;
import com.xsm.flat.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 薛时鸣 on 18-4-7.
 *
 * @author 薛时鸣
 * @date 18-4-7
 */

@RestController
@RequestMapping("/flat")
@CrossOrigin
public class FlatInfoController {

    @Autowired
    private FlatService flatService;

    /**
     * admin 上传图片到腾讯对象存储
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    public Object imgUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String rootPath = "C:\\Users\\fisherman\\Desktop\\毕业设计论文\\projectImg";
        //        String rootPath = "/home/xsm/Desktop/";
        //判断文件格式
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String prefix = filename.substring(0,filename.lastIndexOf("."));
        if(StringUtils.isBlank(filename)||StringUtils.isBlank(prefix)
                || (!".jpg".equalsIgnoreCase(suffix) && !".png".equalsIgnoreCase(suffix))){
            return WebUtil.paramError("文件格式错误，必须.jpg或.png后缀");
        }
        File dir = new File(rootPath + request.getSession().getServletContext().getContextPath());
        if  (!dir.exists()  && !dir.isDirectory()){
            System.out.println("文件夹不存在，进行创建");
            dir.mkdir();
        } else{
            System.out.println("目录存在");
        }
        System.out.println(rootPath+file.getOriginalFilename());
        String autoFileName = SystemUtil.getRandomString(10)+"_"+System.currentTimeMillis()+suffix;
        String path = rootPath + autoFileName;
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


    /**
     * admin添加房源信息
     * @param flat
     * @return
     */
    @RequestMapping(value = "addFlat", method = RequestMethod.POST)
    public AjaxResponse addFlat(Flat flat) {

        flatService.addFlat(flat);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    /**
     * client 按街道Id查询房源信息
     * @param sId
     * @return
     */
    @RequestMapping(value = "/queryBysId/{sId}", method = RequestMethod.GET)
    public AjaxResponse queryBysId(@PathVariable("sId") String sId) {
        List<Flat> flatListBysId = flatService.selectBysId(sId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,flatListBysId);
        return Ares;
    }

    /**
     * client 查询所有房源信息，数据初始化
     * @return
     */
    @RequestMapping(value = "/queryall/{pName}", method = RequestMethod.GET)
    public AjaxResponse queryAllFlat(@PathVariable("pName") String pName) {
        List<Flat> flatList = flatService.selectBypName(pName);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,flatList);
        return Ares;
    }


    /**
     * client 动态查询接口
     * @param flat
     * @return
     */
    @PostMapping("/combineselect")
    public AjaxResponse combineQuery(@ModelAttribute Flat flat) {
        //@RequestParam(value = "fHabitable",defaultValue = "",required = false)  String fHabitable

        /*System.out.println(fHabitable);
        Flat flat = new Flat();
        flat.setfHabitable(fHabitable);*/
        //System.out.println(flat);
        List<Flat> flatList = flatService.combineSelect(flat);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,flatList);
        return Ares;
    }

    /**
     * client 房源信息详情页查询
     * @param fId
     * @return
     */
    @RequestMapping(value = "/flatbyid/{fId}", method = RequestMethod.GET)
    public AjaxResponse selectFlatById(@PathVariable("fId") String fId) {

        List<Flat> flatListByfId = flatService.selectFlatByfId(fId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,flatListByfId);
        return Ares;
    }

    /**
     * client 首页模糊查询
     * @param flat
     * @return
     */
    @PostMapping("/fuzzysearch")
    public AjaxResponse fuzzySearchFlat(@ModelAttribute Flat flat) {
        List<Flat> flatList = flatService.fuzzySearchFlat(flat);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,flatList);
        return Ares;
    }

    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    public AjaxResponse queryall(Integer pageNum,
                                 Integer pageSize) {
        List<Flat> records = flatService.selectAll(pageNum,pageSize);
        PageInfo<Flat> page = new PageInfo<Flat>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }

}
