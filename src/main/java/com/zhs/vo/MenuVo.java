package com.zhs.vo;

import com.zhs.bean.MenuBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo extends MenuBean {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
