package com.lhy.fool.util.other;

import java.util.Collection;
import java.util.List;

/**
 * @author 98403
 * @date : 2019-04-01 17:10
 */
public class ListUtil {

    /**
     * 不是空
     * @param coll  Collection对象
     * @return true/false
     */
    public static Boolean isNotNull(Collection coll){
        if(null!= coll&&0!=coll.size()){
            return true;
        }
        return  false;
    }

    /**
     * 是空
     * @param coll  Collection对象
     * @return true/false
     */
    public static Boolean isNull(Collection coll){
        return  !isNotNull(coll);
    }


    /**
     * 是否被包含
     * @param ids 已经关注的id
     * @param id 需要验证的id
     * @return true/false
     */
    public static Boolean isContains(List<Integer> ids, Integer id){
        if(isNull(ids)){
            return false;
        }
        return  ids.contains(id);
    }

    /**
     * 是否被包含
     * @param ids 已经关注的id
     * @param id 需要验证的id
     * @return true/false
     */
    public static Boolean isContainsStr(List<String> ids,String id){
        if(isNull(ids)){
            return false;
        }
        return  ids.contains(id);
    }

}
