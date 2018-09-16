package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.ItemReviews;

@Repository
public interface ItemReviewsRepo extends JpaRepository<ItemReviews, Integer>{

	List<ItemReviews> findByItemId(int itemId);
}
