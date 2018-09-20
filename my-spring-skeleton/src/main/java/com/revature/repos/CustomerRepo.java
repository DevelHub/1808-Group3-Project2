package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByUsernameAndPassword(String username, String password);

//	List<Customer> findByUsernameAndPassword(String username, String password);
//	BasicCustomerProjection findPasswordByUsername(String username);

//	List<BasicUserProjection> findAllProjectedBy();

}
