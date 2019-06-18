package com.lhy.fool.flr.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.fool.FoolApplicationTests;
import com.lhy.fool.flr.entity.FlrStatement;
import com.lhy.fool.flr.enums.StatementStatus;
import com.lhy.fool.flr.service.IFlrStatementService;
import com.lhy.fool.util.deppon.Guid;
import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 98403
 * @date: 2019-06-17 15:11
 */
@Log
public class FlrStatementServiceImplTest extends FoolApplicationTests {


    @Autowired
    private IFlrStatementService flrStatementService;

    @Test
    public void listByCondition() {
        //TODO
        Page<FlrStatement> page = new Page<>();
        //flrStatement.setSubsidiary("3");
        flrStatement.setFid("A8F");
        //flrStatement.setBillstatus(2);
        final List<FlrStatement> flrStatements = flrStatementService.listByCondition(page, flrStatement);
        log.info("================SIZE:"+flrStatements.size());
    }

    @Test
    public void listAll() {
        //flrStatement.setSubsidiary("3");
        //flrStatement.setFid("A8F");
        //flrStatement.setBillstatus(1);
        final List<FlrStatement> flrStatements = flrStatementService.listAll(flrStatement);
        //flrStatements.forEach(System.out::println);
        log.info("================SIZE:"+flrStatements.size());
    }




    @Test
    public void selectStatementById() {
        //TODO  待优化
         FlrStatement one = flrStatementService.selectStatementById("DLSP15607697978169E9E195A8F");
        if(null != one){
            System.out.println("==============ID："+one.getFid());
            //one.getItems().forEach(System.out::println);
            log.info("================SIZE:"+one.getItems().size());
        }else {
            log.info("==============【null】");
        }
    }

    @Test
    public void selectById() {
        final FlrStatement one = flrStatementService.selectById("DLSP156084939913921CA5D5378");
        if(null != one){
            log.info(one.toString());
        }
    }

    @Test
    public void insertOne() {
        FlrStatement f = getStatementItem();
        log.info("准备插入============"+f.toString());
        //final int insert = flrStatementMapper.insert();
        final int insert = flrStatementService.insertOne(f);
        log.info("新插入：【"+insert+"】====【ID】=="+f.getFid());
    }


    @Test
    public void insertArray() {
        List<FlrStatement> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FlrStatement f = getStatementItem();
            log.info("【此次插入FID】:"+f.getFid());
            list.add(f);
        }
        final Integer integer;
        integer = flrStatementService.insertArray(list);
        log.info("【"+integer+"】行受影响");

    }



    @Test
    public void deleteLogicById() {
        flrStatementService.deleteLogicById("DLSP156084947041859A996713F");
    }


    @Test
    public void deleteLogicByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP156082485105775145533E3");
        ids.add("DLSP15608248389801AAD5F17DD");
        log.info(ids.toString());
        final Integer integer = flrStatementService.deleteLogicByIds(ids);
        log.info("【"+integer+"】行受影响");

    }

    @Test
    public void deleteById() {
        final Integer integer = flrStatementService.deleteById("DLSP156084947041859A996713F");
        log.info("【"+integer+"】行受影响");
    }
    @Test
    public void deleteByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("DLSP15608248389801AAD5F17DD");
        ids.add("DLSP156082485105775145533E3");
        final Integer integer = flrStatementService.deleteByIds(ids);
        log.info("【"+integer+"】行受影响");

    }

    @Test
    public void updateRemarks() {
        //条件必填
        flrStatement.setFid("DLSP156082485105904C26F05E2");
        //选1必填
        flrStatement.setFinancialdepartment(null);
        flrStatement.setInvoicetitle("发票抬头");
        final Integer integer = flrStatementService.updateByStatement(flrStatement);
        log.info("【"+integer+"】行受影响");
    }


    private FlrStatement getStatementItem() {
        //唯一标识
        FlrStatement f = new FlrStatement();
        f.setFid(Guid.newWFGuid());
        f.setSubsidiary("子公司4");
        //【账期】话单对应的月份 Integer
        f.setPaymentday(new Date());
        //【预算项目】固定电话费
        f.setBudgetitem("固定电话费");
        //【通话费总金额】号码费+实际通话费+需摊销金额的汇总额
        f.setCalltotalamount(100D);
        //【装维费总金额】线路费汇总
        f.setInstalltotalamount(100D);
        //【其他费用总金额】其他费用汇总
        f.setOthertotalamount(100D);
        //"【报账总金额】通服费总金额+装维费总金额+其他费用总金额
        f.setReimbursetotalamount(100D);
        //*【账单状态】 1:已保存 2:已审核 3：待确认 4 ：已确认
        f.setBillstatus(StatementStatus.SAVE.getCode());
        //*【报账状态】 1；已提交 2 ：不同意 3 :已同意
        f.setReimbursstatus(StatementStatus.CONFIRMED.getCode());
        //【预提状态】1：未预提  2：已预提
        f.setWithholdingstatus(StatementStatus.NOT_WITHHOLDING.getCode());
        //【报销时效是否超时】报销时效是否超时  1：是 ;2 ：否
        f.setIsreimburseovertime(StatementStatus.TIMEOUT.getCode());
        //【所属财务部】所属财务部
        f.setFinancialdepartment("财务部");
        //【工作流名称】报账单工作流名称
        f.setWorkflowname(Guid.newWFGuid());
        f = (FlrStatement) transformation(f, FlrStatement.class);
        return f;
    }



}