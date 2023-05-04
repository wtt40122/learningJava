package com.wt.netty18.service;

import com.wt.netty18.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 12:26
 */
public interface UserService {

    void save(User user);

    void deleteById(String id);

    User queryUserById(String id);

    Iterable<User> queryAll();

    Page<User> findByName(String name, PageRequest request);

}
