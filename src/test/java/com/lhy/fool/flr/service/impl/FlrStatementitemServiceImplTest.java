package com.lhy.fool.flr.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.fool.FoolApplicationTests;
import com.lhy.fool.flr.entity.FlrStatementitem;
import com.lhy.fool.flr.service.IFlrStatementitemService;
import com.lhy.fool.util.deppon.Guid;
import com.lhy.fool.util.other.RandomUtil;
import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 98403
 * @date: 2019-06-17 15:11
 */
@Log
public class FlrStatementitemServiceImplTest extends FoolApplicationTests {


    @Autowired
    private IFlrStatementitemService flrStatementitemService;

    @Test
    public void listByCondition() {
        Page page = new Page();
        final List list = flrStatementitemService.listByCondition(page, flrStatementitem);
        log.info("SIZE:" + list.size());
    }

    @Test
    public void listAll() {
        flrStatementitem.setOutsidelinenum("4G");
        flrStatementitem.setFid("DLSP1560775465642F191E390");
        final List<FlrStatementitem> list = flrStatementitemService.listAll(flrStatementitem);
        log.info("SIZE:" + list.size());
    }

    @Test
    public void findOne() {
        final FlrStatementitem flrStatementitem = flrStatementitemService.selectById("DLSP1560775465642F191E390C9");
        System.out.println(flrStatementitem.toString());
    }

    @Test
    public void insertOne() {
        final FlrStatementitem f = getStatementItem("DLSP156076457300241C3EDFA09");
        log.info("[此次插入FID]：" + f.getFid());
        final Integer integer = flrStatementitemService.insertOne(f);
        log.info("【" + integer + "】行受影响");
    }

    private FlrStatementitem getStatementItem(String statementnum) {
        Integer count = 5;
        //唯一标识
        FlrStatementitem f = new FlrStatementitem();
        f.setFid(Guid.newWFGuid());
        //对账单号
        f.setStatementnum(statementnum);
        //预提号   未预提时为空
        f.setWithholdingnum(null);
        //部门编号
        f.setDepartment(Guid.newDCGuid());
        //成本中心
        f.setCostcenter(RandomUtil.getStringRandom(count));
        //外线号
        f.setOutsidelinenum(RandomUtil.getStringRandom(count));
        //【总费用】线路费+号码费+实际通话费+需摊销金额+其他费用
        f.setTotalcost(400D);
        //【线路费】
        f.setLinecharges(100D);
        //【号码费】正常使用的6元/号/月
        f.setNumcharges(100D);
        //【需摊销金额】需摊销金额
        f.setAmortizationamount(100D);
        //【其他费用】设备损坏/分机费用减免/罚款扣减等
        f.setOtherexpenses(100D);
        //【低消差距】该部门内的总费用距离低消标准的差额
        f.setGap(100D);
        //备注
        f.setRemark(null);
        f = (FlrStatementitem) transformation(f, FlrStatementitem.class);
        return f;
    }

    @Test
    public void insertArray() {
        List<FlrStatementitem> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FlrStatementitem f = getStatementItem("DLSP156084947041820B915BD06");
            log.info("【此次FID】:" + f.getFid());
            list.add(f);
            //log.info("【当前List】:"+list.toString());
        }
        final Integer integer = flrStatementitemService.insertArray(list);
        log.info("【" + integer + "】行受影响");
    }

    @Test
    public void updateRemarks() {
        //@param flrStatementitem 对账单项(FID 备注)必填
        flrStatementitem.setFid("DLSP15608516539777AF5131D4D");
        flrStatementitem.setRemark("测试修改1");
        final Integer integer = flrStatementitemService.updateRemarks(flrStatementitem);
        log.info("【" + integer + "】行受影响");
    }

    //======


    @Test
    public void deleteLogicById() {
        final Integer integer = flrStatementitemService.deleteLogicById("DLSP1560775465642F191E390C9");
        log.info("【" + integer + "】行受影响");
    }

    @Test
    public void deleteLogicByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP1560775465644C95CB7E6C9");
        ids.add("DLSP1560775465642F191E390C8");
        final Integer integer = flrStatementitemService.deleteLogicByIds(ids);
        log.info("【" + integer + "】行受影响");
    }

    @Test
    public void deleteById() {
        final Integer integer = flrStatementitemService.deleteById("DLSP1560775465642F191E390C9");
        log.info("【" + integer + "】行受影响");
    }


    @Test
    public void deleteByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP1560775465644C95CB7E6C9");
        ids.add("DLSP1560775465642F191E390C8");
        final Integer integer = flrStatementitemService.deleteByIds(ids);
        log.info("【" + integer + "】行受影响");
    }

}



