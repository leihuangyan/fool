package com.lhy;

import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @name: Application
 * @author： 98403
 * @classPath: com.lhy.Application
 * @date: 2019-07-30 18:33
 * @Version: 1.0
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(transactionManager = "transactionManager")
@Slf4j
public class Application {




    public static void main(String[] args) {
        String user = "15897476550@163.com";
        String subject = "xxx";
        MailUtil.sendHtml(user,subject,subject);

        //String url = "http://www.ilol.ylol3.top/index.php/index/lol.html";
        //HashMap<String, Object> paramMap = new HashMap<>();
        //paramMap.put("u", "1212121212");
        //paramMap.put("p", "8888888");
        //paramMap.put("bianhao", "852");

        //final String post = HttpUtil.post(url, paramMap)
                ;
        //log.info("POST:{}",post);
        //
        //Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
        //Accept-Encoding: gzip, deflate
        //Accept-Language: zh-CN,zh;q=0.9
        //Cache-Control: max-age=0
        //Connection: keep-alive
        //Content-Length: 31
        //Content-Type: application/x-www-form-urlencoded
        //Cookie: PHPSESSID=sjgqm7v2i3s2lg779raq5kug15; pgv_info=ssid=s4342015070; ts_last=www.ilol.ylol3.top/; ts_refer=mail.qq.com/; pgv_pvid=5170132192; ts_uid=2140745544
        //Host: www.ilol.ylol3.top
        //Origin: http://www.ilol.ylol3.top
        //Referer: http://www.ilol.ylol3.top/
        //Upgrade-Insecure-Requests: 1
        //User-Agent: Mozilla/layui.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36

    }
}
