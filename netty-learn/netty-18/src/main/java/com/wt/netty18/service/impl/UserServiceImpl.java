package com.wt.netty18.service.impl;

import com.wt.netty18.domain.User;
import com.wt.netty18.service.UserRepository;
import com.wt.netty18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 12:27
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository dataRepository;

    @Autowired
    public void setDataRepository(UserRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void save(User user) {
        dataRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        dataRepository.deleteById(id);
    }

    @Override
    public User queryUserById(String id) {
        Optional<User> optionalUser = dataRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public Iterable<User> queryAll() {
        return dataRepository.findAll();
    }

    @Override
    public Page<User> findByName(String name, PageRequest request) {
        return dataRepository.findByName(name, request);
    }

}
