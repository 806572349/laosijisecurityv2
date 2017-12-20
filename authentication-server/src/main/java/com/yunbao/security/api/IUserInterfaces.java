package com.yunbao.security.api;

import com.yunbao.security.model.LaosijiUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserInterfaces extends MongoRepository<LaosijiUser,String> {
    List<LaosijiUser> findByUsername(String username);
}
