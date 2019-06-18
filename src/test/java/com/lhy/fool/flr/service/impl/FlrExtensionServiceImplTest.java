package com.lhy.fool.flr.service.impl;

import com.lhy.fool.FoolApplicationTests;
import com.lhy.fool.flr.entity.FlrExtension;
import com.lhy.fool.flr.service.IFlrExtensionService;
import com.lhy.fool.util.deppon.Guid;
import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 98403
 * @date: 2019-06-18 18:33
 */
@Log
public class FlrExtensionServiceImplTest extends FoolApplicationTests {

    @Autowired
    private IFlrExtensionService extensionService;

    private FlrExtension getStatementItem() {
        //唯一标识
        FlrExtension f = new FlrExtension();
        //唯一ID
        f.setFid(Guid.newWFGuid());
        //【使用部门】从UUMS内获取的使用部门名称
        f.setDepartment("测试部门");
        //【子公司】部门映射的成本中心对应的子公司
        f.setSubsidiary("测试子公司");
        //【成本中心】部门映射对应的成本中心
        f.setCostcenter("部门成本中心");
        //【账期】话单对应的月份
        f.setPaymentday(new Date());
        //【外线号】联通分配的外线号码
        f.setOutsidelinenum(Guid.newWFGuid());
        //【分机号】佳米平台注册的分机号
        f.setExtensionnumber(Guid.newDCGuid());
        //【开通日期】分机注册使用的时间
        f.setOpeningdate(new Date());
        //【是否计低消】根据联通合同规则判断是否计低消
        f.setIsoffset(1);
        //【总费用】线路费+号码费+实际通话费+需摊销金额+其他费用
        f.setTotalcost(10000D);
        //【总费用】线路费+号码费+实际通话费+需摊销金额+其他费用
        f.setLinecharges(1000D);
        //【号码费】正常使用的6元/号/月
        f.setNumcharges(100D);
        //【实际通话费】计费分钟数*0.075元/分钟
        f.setActualcallcharge(10D);
        //【计费分钟数】由COP平台及佳米记录的实际计费分钟数
        f.setMinutesnum(100D);
        //【内部通话分钟数】由COP平台及佳米记录的内部通话分钟数（不计费）
        f.setInsidecallminutes(10D) ;
        //【低消差距】该部门内的总费用距离低消标准的差额
        f.setGap(1100D);
        //【费用类型】【固定电话费】
        f.setExpensetype("固定电话费");
        //【其他费用】设备损坏/分机费用减免/罚款扣减等
        f.setOtherexpenses("设备损坏");
        //【其他费用备注】其他费用备注
        f.setOtherexpensesremarks("其他费用备注");
        f = (FlrExtension) transformation(f, FlrExtension.class);
        return f;
    }



    @Test
    public void insertOne() {
        final FlrExtension f = getStatementItem();
        log.info("【此次插入FID】:"+f.getFid());
        final int insert = extensionService.insertOne(f);
        log.info("新插入：【"+insert+"】====【ID】=="+f.getFid());
    }


    @Test
    public void insertArray() {
        List<FlrExtension> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final FlrExtension f = getStatementItem();
            log.info("【此次插入FID】:"+f.getFid());
            list.add(f);
        }
        final Integer integer;
        integer = extensionService.insertArray(list);
        log.info("【"+integer+"】行受影响");

    }

    @Test
    public void deleteLogicById() {
        final Integer integer = extensionService.deleteLogicById("DLSP1560858647926EAAFBB5F56");
        log.info("【"+integer+"】行受影响");
    }


    @Test
    public void deleteLogicByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP156085870493349ADD82B0E");
        ids.add("DLSP1560858704935FC5F5B802A");
        log.info(ids.toString());
        final Integer integer = extensionService.deleteLogicByIds(ids);
        log.info("【"+integer+"】行受影响");
    }

    @Test
    public void deleteById() {
        final Integer integer = extensionService.deleteById("DLSP1560858647926EAAFBB5F56");
        log.info("【"+integer+"】行受影响");
    }
    @Test
    public void deleteByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP156085870493349ADD82B0E");
        ids.add("DLSP1560858704935FC5F5B802A");
        final Integer integer = extensionService.deleteByIds(ids);
        log.info("【"+integer+"】行受影响");
    }
}