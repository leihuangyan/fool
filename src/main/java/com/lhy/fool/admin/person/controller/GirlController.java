package com.lhy.fool.admin.person.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhy.fool.util.enrypt.EncryptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhy
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/person/girl")
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
}

