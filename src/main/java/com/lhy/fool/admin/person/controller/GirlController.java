package com.lhy.fool.admin.person.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhy.fool.admin.person.controller.supplier.SendCopDataModel;
import com.lhy.fool.admin.person.entity.Girl;
import com.lhy.fool.admin.person.entity.ResModel;
import com.lhy.fool.admin.person.service.IGirlService;
import com.lhy.fool.util.enrypt.EncryptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @name: GirlController
 * @author: 98403
 * @classPath: com.lhy.fool.admin.person.controller.GirlController
 * @date: 2019-07-28 3:23
 * @Version: 1.0
 * @description: TODO
 */
@RestController
    @RequestMapping("/girl")
@Slf4j
public class GirlController {


    @GetMapping("/test")
    public String test(){
        final String sign = new EncryptService().sign("[{data:'data'}]");
        return "ss";
    }

    @PostMapping("/post")
    public String post() throws JsonProcessingException {
        String modle ="{\"Models\":[{\"description\":\"XXXX申请说明\",\"controlUnitName\":\"上海德启信息科技有限公司\",\"empname\":\"孙伟\",\"supplier\":\"中国联通\",\"costcenter\":\"NBJ1006\",\"bank\":\"XXX银行\",\"invoiceTitle\":\"xxx发票抬头\",\"departmentType\":\"经营\",\"payee\":\"XXX收款人\",\"empAdminName\":\"仓储与供应链研发部\",\"workFlowName\":null,\"financialDepartment\":\"宁波鄞州区姜山营业部\",\"isReimburseTimeOut\":2,\"reimburseTotalAmount\":763596.0,\"accountType\":\"账户性质\",\"bankProvinces\":\"上海\",\"bankCity\":\"上海市\",\"bankBranch\":\"上海市XXXX支行\",\"payeeNum\":\"xxxx2121313131\",\"billStartTime\":1562555359287,\"invoiceDiff\":false},{\"description\":\"XXXX申请说明\",\"controlUnitName\":\"上海德启信息科技有限公司\",\"empname\":\"孙伟\",\"supplier\":\"中国联通\",\"costcenter\":\"NBJ1006\",\"bank\":\"XXX银行\",\"invoiceTitle\":\"xxx发票抬头\",\"departmentType\":\"经营\",\"payee\":\"XXX收款人\",\"empAdminName\":\"仓储与供应链研发部\",\"workFlowName\":null,\"financialDepartment\":\"宁波鄞州区姜山营业部\",\"isReimburseTimeOut\":2,\"reimburseTotalAmount\":763596.0,\"accountType\":\"账户性质\",\"bankProvinces\":\"上海\",\"bankCity\":\"上海市\",\"bankBranch\":\"上海市XXXX支行\",\"payeeNum\":\"xxxx2121313131\",\"billStartTime\":1562555359287,\"invoiceDiff\":false},{\"description\":\"XXXX申请说明\",\"controlUnitName\":\"上海德启信息科技有限公司\",\"empname\":\"孙伟\",\"supplier\":\"中国联通\",\"costcenter\":\"NBJ1006\",\"bank\":\"XXX银行\",\"invoiceTitle\":\"xxx发票抬头\",\"departmentType\":\"经营\",\"payee\":\"XXX收款人\",\"empAdminName\":\"仓储与供应链研发部\",\"workFlowName\":null,\"financialDepartment\":\"宁波鄞州区姜山营业部\",\"isReimburseTimeOut\":2,\"reimburseTotalAmount\":763596.0,\"accountType\":\"账户性质\",\"bankProvinces\":\"上海\",\"bankCity\":\"上海市\",\"bankBranch\":\"上海市XXXX支行\",\"payeeNum\":\"xxxx2121313131\",\"billStartTime\":1562555359287,\"invoiceDiff\":false}]}";
        return new ObjectMapper().writeValueAsString(modle);
    }
    @PostMapping(value = "/re",produces="application/json;charset=UTF-8")
    public String re(SendCopDataModel op, String sign, String key) throws JsonProcessingException {
        log.info("请求成功");
        log.info(op.toString());
        log.info(sign);
        log.info(key);
        Map<String,String> mp = new HashMap<>();
        mp.put("0","OK");
        return  new ObjectMapper().writeValueAsString(mp);
    }


    @Autowired
    private IGirlService girlService;

    private ResModel resModel;

    @GetMapping("/list")
    public String im(Integer page,Integer limit) throws JsonProcessingException {
        log.info("p：{}== l ：{}",page,limit);
        IPage<Girl> pa = new Page<>();
        pa.setCurrent(page);
        pa.setSize(limit);

        IPage<Girl> res =  girlService.page(pa,wrapper);
        //转JSON str
        resModel.setCode(0);
        resModel.setMsg("OK");
        resModel.setData(res.getRecords());
        resModel.setCount(res.getTotal());
        String str = mapper.writeValueAsString(resModel);
        return str;
    }

    IPage<Girl> pa;

    QueryWrapper<Girl> wrapper;

    ObjectMapper mapper ;

    @ModelAttribute
    public  void  init(){
        log.info("初始化了");
        pa = new Page<>();
        resModel = new ResModel();
        mapper = new ObjectMapper();
        wrapper  = new QueryWrapper<>();
    }

    @GetMapping("/list2")
    public String list2() throws JsonProcessingException {
        QueryWrapper<Girl> wrapper = new QueryWrapper<>();
        wrapper.select("name");
        wrapper.lambda().eq(Girl::getAge, 1)
                .eq(Girl::getAddress,"魔界");
        List<Girl> list =  girlService.list(wrapper);
        return  mapper.writeValueAsString(list);

    }

    static Integer n = 1;

    /**
     * @name: wrapper
     * @author: 98403
     * @date: 2019-07-28 5:38
     * @return: java.lang.String
     * @description: TODO
     * @Version: 1.0
     */
    @GetMapping("/insert")
    public String wrapper() throws JsonProcessingException {
        resModel.setCode(0);
        resModel.setMsg("OK");
        resModel.setData(girlService.save(new Girl("测试"+n,10+n)));
        n++;
        String str = mapper.writeValueAsString(resModel);
        return str;
    }


    @DeleteMapping("/del")
    public String del(Integer id) throws JsonProcessingException {
        resModel.setCode(0);
        resModel.setMsg("OK");
        if(null!=id){
            resModel.setData(girlService.removeById(id));
        }else {
            resModel.setData("删除时ID不能为空");
        }
        n++;
        String str = mapper.writeValueAsString(resModel);
        return str;
    }


    @PostMapping("/up")
    public String up(Girl girl) throws JsonProcessingException {
        resModel.setCode(0);
        resModel.setMsg("OK");
        if(null!=girl.getId()){
            resModel.setData(girlService.updateById(girl));
        }else {
            resModel.setData("时ID不能为空");
        }
        n++;
        String str = mapper.writeValueAsString(resModel);
        return str;
    }

}

