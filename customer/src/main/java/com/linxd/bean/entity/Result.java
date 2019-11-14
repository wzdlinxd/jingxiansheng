package com.linxd.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 16:05
 * Description: 存储返回结果
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    private String msg;
}
