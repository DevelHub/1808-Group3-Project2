package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Subscription;

//@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {

//	List<Subscription> saveCustomerSubscription(int customerId, int companyId, int timeFrame);
}