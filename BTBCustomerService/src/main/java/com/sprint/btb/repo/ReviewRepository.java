package com.sprint.btb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	List<ReviewEntity> findReviewByTripId(int tripId);

}
