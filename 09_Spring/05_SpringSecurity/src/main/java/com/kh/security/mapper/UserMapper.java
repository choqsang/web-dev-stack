package com.kh.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.security.model.vo.User;

@Mapper
public interface UserMapper {
	void register(User vo);
	User login(String id);
	List<User> selectAll();
	List<User> select(User vo);
	void update(User vo);
	void delete(List<String> idList);
}
