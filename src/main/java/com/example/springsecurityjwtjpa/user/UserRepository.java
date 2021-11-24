package com.example.springsecurityjwtjpa.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);
}
