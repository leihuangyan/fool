package com.lhy.fool.util.other;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.NoArgsConstructor;

/**
 * @author 98403
 * @date  2019-04-03 16:07
 */
@NoArgsConstructor
public class PageUtil {

    private Integer r = 10;

    private Integer p =1;



    public PageUtil(Integer r, Integer p) {
        setP(p);
        setR(r);
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        if(null!=r&&r>=0){
            this.r = r;
        }
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        if(null!=p&&p>=1){
            this.p = p;
        }
    }

    public IPage initPage(IPage page){
        page.setSize(this.r);
        page.setCurrent(this.p);
        return  page;
    }
}
