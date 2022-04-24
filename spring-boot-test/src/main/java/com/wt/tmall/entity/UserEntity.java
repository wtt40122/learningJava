package com.wt.tmall.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/13 9:42
 */
@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }
}
