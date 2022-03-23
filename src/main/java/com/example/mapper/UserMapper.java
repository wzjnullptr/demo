package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
       List<User> findAll();
}
