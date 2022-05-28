package com.wt.tmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wtt
 * @date: 2022/5/28 20:10
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Long userId;
    private String userName;
    private String sex;
}
