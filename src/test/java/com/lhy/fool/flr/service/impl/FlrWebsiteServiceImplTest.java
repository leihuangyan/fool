package com.lhy.fool.flr.service.impl;

import com.lhy.fool.FoolApplicationTests;
import com.lhy.fool.flr.entity.FlrWebsite;
import com.lhy.fool.flr.service.IFlrWebsiteService;
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
public class FlrWebsiteServiceImplTest extends FoolApplicationTests {

    @Autowired
    private IFlrWebsiteService flrWebsiteService;

    private FlrWebsite getStatementItem() {
        //唯一标识
        FlrWebsite f = new FlrWebsite();
        f.setFid(Guid.newWFGuid());
        //【使用部门】从UUMS内获取的使用部门名称
        f.setDepartment("部门名称");
         //【子公司】部门映射的成本中心对应的子公司
        f.setSubsidiary("子公司");
        //【成本中心】部门映射对应的成本中心
        f.setCostcenter("部门成本中心");
        //【账期】话单对应的月份
        f.setPaymentday(new Date());
        //【总费用】
        // 线路费+号码费+实际通话费+需摊销金额+不计低消实际通话费+其他费用
        f.setTotalcost(1000D);
        //【总线路数】该部门分机号数量
        f.setLinenum(1);
        //【线路费】该部门总线路费
        f.setLinecharges(111D);
        //【号码费】该部门总号码费
        f.setNumcharges(10000D);
        //【实际通话费】该部门总实际通话费
        f.setActualcallcharge(10000D);
        //【低消差距】该部门内的总费用距离低消标准的差额
        f.setGag(100D);
        //【不计低消实际通话费】不计低消实际通话费
        f.setUnrealisticcallcharges(100D);
        //【需摊销金额】需摊销金额
        f.setAmortizationamount(100D);
        //【其他费用】该部门总其他费用
        f.setOtherexpenses(1000D);
        //【费用类型】固定电话费
        f.setExpensetype("固定电话费");
        f = (FlrWebsite) transformation(f, FlrWebsite.class);
        return f;
    }




    @Test
    public void insertOne() {
        final FlrWebsite f = getStatementItem();
        log.info("【此次插入FID】:"+f.getFid());
        final int insert = flrWebsiteService.insertOne(f);
        log.info("新插入：【"+insert+"】====【ID】=="+f.getFid());
    }


    @Test
    public void insertArray() {
        List<FlrWebsite> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final FlrWebsite f = getStatementItem();
            log.info("【此次插入FID】:"+f.getFid());
            list.add(f);
        }
        final Integer integer;
        integer = flrWebsiteService.insertArray(list);
        log.info("【"+integer+"】行受影响");

    }

    @Test
    public void deleteLogicById() {
        final Integer integer = flrWebsiteService.deleteLogicById("DLSP15608582667632CEB915BA8");
        log.info("【"+integer+"】行受影响");
    }


    @Test
    public void deleteLogicByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP15608583082541C20860395");
        ids.add("DLSP1560858308255A7A14FC99A");
        log.info(ids.toString());
        final Integer integer = flrWebsiteService.deleteLogicByIds(ids);
        log.info("【"+integer+"】行受影响");

    }

    @Test
    public void deleteById() {
        final Integer integer = flrWebsiteService.deleteById("DLSP15608582667632CEB915BA8");
        log.info("【"+integer+"】行受影响");
    }
    @Test
    public void deleteByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP15608583082541C20860395");
        ids.add("DLSP1560858308255A7A14FC99A");
        final Integer integer = flrWebsiteService.deleteByIds(ids);
        log.info("【"+integer+"】行受影响");

    }
}