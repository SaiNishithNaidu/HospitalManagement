package com.example.Project.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<String> getAllUserNames() {
		List<String> userNameList = new ArrayList<>();
		userNameList.addAll(jdbcTemplate.queryForList("select username from login;", String.class));
		return userNameList;
	}

}
