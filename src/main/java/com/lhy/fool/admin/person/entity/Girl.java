package com.lhy.fool.admin.person.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhy
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Girl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;

    private String address;

    //设置导出list类
    public List<Object> toExportList() {
        // 定义导出字段集合
        List<Object> list = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        list.add(id==null?"0":id.toString());
        list.add(name);
        list.add(age==null?"0":age.toString());
        list.add(address);
        return list;
    }

}
