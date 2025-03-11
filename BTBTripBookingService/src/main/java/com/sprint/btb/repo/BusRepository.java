package com.sprint.btb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.model.BusModel;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer> {

	List<BusEntity> findByBusType(BusEntity.BusType busType);

}
