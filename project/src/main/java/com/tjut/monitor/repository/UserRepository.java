package com.tjut.monitor.repository;

import com.tjut.monitor.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

    @Transactional
    void deleteByUserName(String username);

    Page<User> findAll(Pageable pageable);
}
