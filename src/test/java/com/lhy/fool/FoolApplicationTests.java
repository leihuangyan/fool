package com.lhy.fool;

import com.lhy.fool.flr.entity.FlrExtension;
import com.lhy.fool.flr.entity.FlrStatement;
import com.lhy.fool.flr.entity.FlrStatementitem;
import com.lhy.fool.flr.entity.FlrWebsite;
import com.lhy.fool.flr.enums.EntityStatus;
import com.lhy.fool.util.other.DateUtil;
import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class FoolApplicationTests {

    public FlrExtension flrExtension;

    public FlrWebsite flrWebsite;

    public FlrStatement flrStatement;

    public FlrStatementitem flrStatementitem;

    @Before
    public void setUp() throws Exception {
         flrExtension = new FlrExtension();
         flrWebsite = new FlrWebsite();
         flrStatement = new FlrStatement();
         flrStatementitem = new FlrStatementitem();
        log.info("==============【程序开始】================");
    }

    @After
    public void tearDown() throws Exception {
        log.info("==============【程序关闭】================");
    }

    public Object  transformation(Object o,Class c){
        if(FlrExtension.class.equals(c)){
            FlrExtension flrExtension =  (FlrExtension)o;
            //【创建人】
            flrExtension.setCreateusercode("admin");
            //【创建时间】
            final Date date = new Date();
            flrExtension.setCreatetime(date);
            //【最后修改人】
            flrExtension.setModifyusercode("admin");
            //【最后修改时间】
            flrExtension.setModifytime(DateUtil.monthAddDate(date,1));
            //【逻辑状态】
            flrExtension.setLogicstate(EntityStatus.IS_EXIST.getCode());
            return flrExtension;
        }else  if(FlrWebsite.class.equals(c)){
            FlrWebsite flrwebsite =  (FlrWebsite)o;
            //【创建人】
            flrwebsite.setCreateusercode("admin");
            //【创建时间】
            final Date date = new Date();
            flrwebsite.setCreatetime(date);
            //【最后修改人】
            flrwebsite.setModifyusercode("admin");
            //【最后修改时间】
            flrwebsite.setModifytime(DateUtil.monthAddDate(date,1));
            //【逻辑状态】
            flrwebsite.setLogicstate(EntityStatus.IS_EXIST.getCode());
            return flrwebsite;
        }else  if(FlrStatement.class.equals(c)){
            FlrStatement flrstatement =  (FlrStatement)o;
            //【创建人】
            flrstatement.setCreateusercode("admin");
            //【创建时间】
            final Date date = new Date();
            flrstatement.setCreatetime(date);
            //【最后修改人】
            flrstatement.setModifyusercode("admin");
            //【最后修改时间】
            flrstatement.setModifytime(DateUtil.monthAddDate(date,1));
            //【逻辑状态】
            flrstatement.setLogicstate(EntityStatus.IS_EXIST.getCode());
            return flrstatement;
        }else  if(FlrStatementitem.class.equals(c)){
            FlrStatementitem flrstatementitem =  (FlrStatementitem)o;
            //【创建人】
            flrstatementitem.setCreateusercode("admin");
            //【创建时间】
            final Date date = new Date();
            flrstatementitem.setCreatetime(date);
            //【最后修改人】
            flrstatementitem.setModifyusercode("admin");
            //【最后修改时间】
            flrstatementitem.setModifytime(DateUtil.monthAddDate(date,1));
            //【逻辑状态】
            flrstatementitem.setLogicstate(EntityStatus.IS_EXIST.getCode());
            return flrstatementitem;
        }
        return o;
    }
}
