package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.News;
import com.xsm.flat.entity.Order;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 插入订单信息
     * @param fId
     * @param uId
     * @return
     */
    @RequestMapping(value = "/orderinsert", method = RequestMethod.POST)
    public AjaxResponse insertOrder(@RequestParam("fId") Integer fId,
                                  @RequestParam("uId") String uId) {
        Boolean result = orderService.insertOrder(uId, fId);
        AjaxResponse res = new AjaxResponse();
        if(result){
            res.setSuccessMessageUpdate();
            return res;
        }else {
            res.setErrorMessage("已经有此房屋的订单",result);
            return res;
        }
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.POST)
    public AjaxResponse getAllOrders(@RequestParam("uId") String uId) {

        List<Order> list = orderService.getAllOrders(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }

    @RequestMapping(value = "/getAllOrderPage", method = RequestMethod.POST)
    public AjaxResponse getAllOrderPage(Integer pageNum,
                                         Integer pageSize) {

        List<Order> records = orderService.getAllOrderPage(pageNum,pageSize);
        PageInfo<Order> page = new PageInfo<Order>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public  AjaxResponse updateOrder(Order order) {

        orderService.updateOrder(order);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public  AjaxResponse deleteOrder(Order order) {

        orderService.deleteOrder(order);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }


    @RequestMapping(value = "/outPdf", method = RequestMethod.POST)
    public static AjaxResponse outPdf() {
           String HTML = "F:\\graduate-flat-springboot\\flat\\src\\main\\resources\\AijiaFangWu.html";
            try {

                Document document = new Document(PageSize.LETTER);
                PdfWriter pdfWriter = PdfWriter.getInstance(document,
                        new FileOutputStream("C:\\Users\\fisherman\\Desktop\\爱家房屋中介租赁平台条约.pdf"));
                document.open();
                document.addAuthor("爱家房屋科技有限公司");
                document.addCreator("爱家房屋科技有限公司");
                document.addSubject("爱家房屋");
                document.addCreationDate();
                document.addTitle("爱家房屋中介租赁平台条约");

                XMLWorkerHelper worker = XMLWorkerHelper.getInstance();

                worker.parseXHtml(pdfWriter, document, new FileInputStream(HTML), (InputStream) null, new AsianFontProvider());
                document.close();
                System.out.println("Done.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }
}
