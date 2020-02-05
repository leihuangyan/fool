package com.cz.task.restul;

import com.cz.task.restul.constant.RefundConstant;
import com.cz.task.restul.domain.*;
import com.cz.task.restul.enums.FileTypeEnum;
import com.cz.task.restul.enums.PassengerTypeEnum;
import com.cz.task.restul.service.ISignService;
import com.cz.task.restul.service.SignServiceImpl;
import com.cz.task.restul.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @name: HttpUtil
 * @author： LHY
 * @classPath: com.cz.task.restul.HttpUtil
 * @date: 2020/2/4 12:29
 * @Version: 1.0
 */
@Slf4j
public class HttpUtil {


    /**
     * 测试main
     * @param args args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String url;

        //签名Service
        ISignService signService = new SignServiceImpl();

        //请求参数
        RequestParam orderRefund = new RequestParam();
        orderRefund.setPartner(RefundConstant.PARTNER);
        orderRefund.setRequestFmt(RefundConstant.REQUEST_FMT);
        orderRefund.setResponseFmt(RefundConstant.RESPONSE_FMT);
        orderRefund.setSignType(RefundConstant.SIGN_TYPE);
        orderRefund.setVersion(RefundConstant.VERSION);
        orderRefund.setAction("哈哈");

        //附件参数 url
//        List<UploadFileRequestParam> fileParams = getFileParams();
//        url = RefundConstant.FILE_UPLOAD_REFUND;
//        orderRefund.setFileParam(fileParams);

        //退票参数 url
        url = RefundConstant.ORDER_REFUND;
        List<RefundTicketApplyRequestParam> params = getRefundParams();
        orderRefund.setParam(params);

        String sign = signService.requestSign(orderRefund);
        log.error("最终sign:{} 长度:{}",sign,sign.length());
        orderRefund.setSign(sign);

        String xmlStr = XMLUtil.convertToXml(orderRefund);
        log.info("换行输出XML str--->\n{}",xmlStr);

        String result = HttpUtil.postXML(url, xmlStr);

        assert result != null;

        String decode = URLDecoder.decode(result, Consts.UTF_8.name());

        log.info("收到返回值--->\n{}",decode);

        InvalidTicketApplyResponseParam resp
                = (InvalidTicketApplyResponseParam)XMLUtil.convertXmlStrToObject(InvalidTicketApplyResponseParam.class, decode);

        log.info("转换返回值为对象--->\n{}",resp);
    }


    private static List<RefundTicketApplyRequestParam> getRefundParams() {
        RefundTicketApplyRequestParam param = new RefundTicketApplyRequestParam();

        param.setConsumer("111");
        param.setOrderId("NO-20200208-1");
        param.setOutOrderId("OUT-NO-20200208-1");
        param.setReason("吃蝙蝠");
        param.setRemark("吃蝙蝠的了肺炎");

        TRFlightList trFlightList = new TRFlightList();
        trFlightList.setFlightNo("天堂1号-001");
        trFlightList.setDepartTime(LocalDate.now().toString());


        TRFlightList trFlightList1 = new TRFlightList();
        BeanUtils.copyProperties(trFlightList,trFlightList1);
        trFlightList1.setFlightNo("天堂2号-002");

        List<TRFlightList> trFlightLists = Arrays.asList(trFlightList,trFlightList1);
        param.setTrFlightList(trFlightLists);


        Passenger passenger = new Passenger();
        passenger.setIdCard("431127199601124737");
        passenger.setName("王尼玛1");
        passenger.setTicketNo("NO-zxxxxx");
        passenger.setPassengerType(PassengerTypeEnum.ZZ.name());
        passenger.setLoseInvoice(new BigDecimal(1000));

        Passenger passenger1 = new Passenger();
        BeanUtils.copyProperties(passenger,passenger1);
        passenger1.setName("王尼玛2");

        List<Passenger> passengers = Arrays.asList(passenger,passenger1);
        param.setPassengerList(passengers);


        return Collections.singletonList(param);
    }


    private static List<UploadFileRequestParam> getFileParams() throws Exception {
        UploadFileRequestParam param = new UploadFileRequestParam();

        File file = new File("/Users/lhy/IdeaProjects/fool/test.jpg");
        param.setUserName("爱吃蝙蝠");
        param.setOrderId("NO-20200208-1");
        param.setOrgFileName("吃蝙蝠.jpg");
        param.setTypeId(FileTypeEnum.REFUND.getCode());

        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray);
        fis.close();
        param.setFileByte(bytesArray);

        return Collections.singletonList(param);
    }


    /**
     * 发送请求
     * @param url url
     * @param xml xmlStr
     * @return result
     */
    public static String postXML(String url,String xml){
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try{
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, ContentType.TEXT_XML.withCharset(Consts.UTF_8).getMimeType());
            client = HttpClients.createDefault();
            StringEntity entityParams = new StringEntity(xml,Consts.UTF_8);
            httpPost.setEntity(entityParams);
            client = HttpClients.createDefault();
            resp = client.execute(httpPost);
            return EntityUtils.toString(resp.getEntity(),Consts.UTF_8);
        }catch (Exception e){
            log.error("请求异常:{}",e.toString());
        }finally {
            try {
                if(client!=null){
                    client.close();
                }
                if(resp != null){
                    resp.close();
                }
            } catch (IOException e) {
                log.error("关闭流异常:{}",e.toString());
            }
        }
        return null;
    }



}
