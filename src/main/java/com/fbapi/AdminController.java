package com.fbapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbapi.model.User;
import com.fbapi.service.UserService;


@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	/*
	 * @Autowired private UserRepository userRepository;
	 */
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@GetMapping
	public List<User> getUsers() {
		return userService.getAll();
	}
	@GetMapping("/search")
	public List<User> search(@RequestParam int user_id,@RequestParam String userName) {

		return null;
	}
	
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		
		String pwd=user.getPassword();
		String encryptedPwd=passwordEncoder.encode(pwd);
		//byte[] encryptedPwd = Base64.encodeBase64(pwd.getBytes());
		user.setPassword(encryptedPwd);
		userService.add(user);
		return"user added successfully.....";
	}
		
		@GetMapping("/{user_id}")
		public ResponseEntity<?> getUserById(@PathVariable int user_id) {
			User user = userService.getUserById(user_id);
			if(user  == null) {
				return new ResponseEntity<>("Requested  User Not available",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		
		@PostMapping("/addUser")
		public ResponseEntity<?> addUser(@RequestBody User userDetails) {
			User user = userService.add(userDetails);
			ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.CREATED);
			return response;
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable int id) {
			User  user = userService.getUserById(id);
			if(user  == null) {
				return new ResponseEntity<>("Requested  User Not available",HttpStatus.NOT_FOUND);
			}

			userService.delete(id);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		

			
}
