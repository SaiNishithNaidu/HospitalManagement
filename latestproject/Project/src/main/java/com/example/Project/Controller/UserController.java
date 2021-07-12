package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping(path = "/getusernames")
	public List<String> getAllUserNames() {
		return userRepository.getAllUserNames();
	}

	@GetMapping(path = "/games")
	public void games() {
		String sql = "insert into login values(\"something\",\"something\")";
		jdbcTemplate.execute(sql);

	}

//	@GetMapping(path="/users")
//	public ResponseEntity<List<loginModel>> getAllUsers(){
//		
//		List<loginModel> users= jdbcTemplate.query("select * from login", new BeanPropertyRowMapper(loginModel.class));
//		
//		
//		return new ResponseEntity<>(null,HttpStatus.OK);
//	}
}
