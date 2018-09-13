package com.revature.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Customer;
import com.revature.projections.BasicCustomerProjection;
import com.revature.services.CustomerService;
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService cs;

	// /users
//	@GetMapping
//	public List<BasicUserProjection> findAll() {
//		System.out.println("finding all users");
//		return us.findAll();
//	}

	// /users/:id
//	@Transactional
//	@GetMapping("{id}")
//	public AppUser findById(@PathVariable int id) {
//		AppUser user = us.findOne(id);
//		user.setRole("Admin!!!");
//		return user;
//	}

//	@PostMapping
//	public ResponseEntity<AppUser> save(@RequestBody AppUser u) {
//		u.setId(1);
//		ResponseEntity<AppUser> re = new ResponseEntity<AppUser>(u, HttpStatus.CREATED);
//		return re;
//	}

	@PostMapping("login")
	public List<Customer> findByUsernameAndPassword(@RequestBody Customer u) {

		return cs.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	@PostMapping("forgot")
	public BasicCustomerProjection findPasswordByUsername(@RequestBody Customer u) {
//		ResponseEntity<Customer> re = new ResponseEntity<Customer>(u, HttpStatus.CREATED);
		return cs.findPasswordByUsername(u.getUsername());
	}

//	@GetMapping("movies/{id}")
//	public List<AppUser> usersThatLikeMovieWithId(@PathVariable int id) {
//		return us.findByMoviesId(id);
//	}

}
