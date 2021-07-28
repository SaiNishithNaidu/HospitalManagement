package com.example.Project.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.ForgetPasswordModel;
import com.example.Project.Model.RegisterPatientModel;
import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;

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

	public void giveAccess(afterRegisterModel after, String id) {

		String sql = "insert into login values(\""+id+"\",\""+after.getPassword()+"\",\""+after.getSecurity_Question()+"\",\""+after.getAnswer()+"\",\""+after.getContact_Number()+"\");";
		jdbcTemplate.execute(sql);

	}

	public boolean checkIdPresent(String user_Id) {
		String sql = "select * from login where userid =\""+user_Id+"\";";
		List<loginModel> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper(loginModel.class));
		if(user.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean checkResetDetails(ForgetPasswordModel forgetPasswordModel) {
		String sql = "select * from login where Security_Question=\""+forgetPasswordModel.getSecurity_Question()+"\" and Answer=\""
				+forgetPasswordModel.getAnswer()+"\" and Contact_Number=\""+forgetPasswordModel.getContact_Number()+"\";";
		List<afterRegisterModel> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper(afterRegisterModel.class));
		if(user.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public void changePassword(String userid, String password) {
		String sql = "update login SET password =\""+password+"\" where userid=\""+userid+"\";";
		jdbcTemplate.execute(sql);
		
	}



	public List<afterRegisterModel> checkDetailsPresent(ForgetPasswordModel forgetPasswordModel) {
		String sql = "select * from login where Security_Question=\""+forgetPasswordModel.getSecurity_Question()+"\" and Answer=\""
				+forgetPasswordModel.getAnswer()+"\" and Contact_Number=\""+forgetPasswordModel.getContact_Number()+"\";";
		List<afterRegisterModel> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper(afterRegisterModel.class));
		if(user.isEmpty()) {
			return new ArrayList<afterRegisterModel>();
		}else {
			return user;
		}
	}

}
