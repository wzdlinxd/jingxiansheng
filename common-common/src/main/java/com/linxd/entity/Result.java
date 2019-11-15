package com.linxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/15 4:03
 * Description: No Description
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    private String msg;
}
