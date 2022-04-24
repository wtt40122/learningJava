package com.wt.tmall.repository;

import com.wt.tmall.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/13 9:45
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);
}
