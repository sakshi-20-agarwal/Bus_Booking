package com.sprint.btb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprint.btb.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
