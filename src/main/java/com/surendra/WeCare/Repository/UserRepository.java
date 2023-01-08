package com.surendra.WeCare.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.surendra.WeCare.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, String>{
        public Optional<UserEntity> findByUserId(String userId);
}
