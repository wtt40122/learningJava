package com.wt.netty18.service;

import com.wt.netty18.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 12:26
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

    Page<User> findByName(String name, Pageable pageable);
}
