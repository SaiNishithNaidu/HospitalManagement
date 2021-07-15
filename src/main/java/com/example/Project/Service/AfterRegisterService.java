package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.afterRegisterModel;

@Service
public class AfterRegisterService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean comparePassword(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean giveAccess(afterRegisterModel after, String id) {

		String sql = "insert into login values(" + "\"" + id + "\"" + "," + "\"" + after.getPassword() + "\"" + ");";
		jdbcTemplate.execute(sql);

		return true;
	}

}
