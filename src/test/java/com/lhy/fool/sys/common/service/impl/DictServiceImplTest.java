package com.lhy.fool.sys.common.service.impl;

import com.lhy.fool.sys.dict.entity.Dict;
import com.lhy.fool.sys.dict.service.IDictService;
import com.lhy.fool.util.enums.DictEnum;
import com.lhy.fool.util.other.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
* DictServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 2, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DictServiceImplTest  {

    @Autowired
    private IDictService dictService;


    @Test
    public void insert(){

        Dict select ;

        Dict item ;
        for (int i = 1; i <= 10; i++) {
            select = new Dict();
            select.setId(0L);
            select.setItem("select_"+i);
            select.setVal("选项"+1);
            select.setParentId(0L);
            select.setLevel(DictEnum.LEVEL_SELECT.getCode());
            select.setOrderNum(i);
            select.setRemake("选项"+i);
            select.setCreateDate(DateUtil.dateConvertToLocalDateTime(new Date()));
            select.setUpdateDate(DateUtil.dateConvertToLocalDateTime(new Date()));
            log.info("select_,{}:插入{}",i,dictService.save(select));
            for (int j = 1; j <= 3; j++){
                item = new Dict();
                item.setId(0L);
                item.setItem("Item_"+j);
                item.setVal("子选项"+j);
                item.setParentId(select.getId());
                item.setLevel(DictEnum.LEVEL_ITEM.getCode());
                item.setOrderNum(j);
                item.setRemake("子选项"+j);
                item.setCreateDate(DateUtil.dateConvertToLocalDateTime(new Date()));
                item.setUpdateDate(DateUtil.dateConvertToLocalDateTime(new Date()));
                log.info("Item_,{}:插入{}",i,dictService.save(item));
            }
        }

    }

} 
