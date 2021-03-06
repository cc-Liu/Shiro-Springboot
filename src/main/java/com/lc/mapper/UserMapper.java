package com.lc.mapper;

import com.lc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User selectName(@Param("name") String name);

    List<String> getUserRole(@Param("username") String username,@Param("password") String password);
}
