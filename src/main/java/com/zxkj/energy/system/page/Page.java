package com.zxkj.energy.system.page;

import com.zxkj.energy.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 刘万琼
 *
 * 重新定义mybatis分页的返回参数
 * @param <T>
 */
@Data
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private List<T> data = null;
    private String msg = "";
    private Integer code = 0;
    private Long count = 0L;

    public Page(List<T> list) {
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<T> page = (com.github.pagehelper.Page<T>) list;
            this.data = list;
            this.count = page.getTotal();
            this.msg = ResultEnum.SUCCESS.getMessage();
            this.code = ResultEnum.SUCCESS.getCode();
        }
    }
}
