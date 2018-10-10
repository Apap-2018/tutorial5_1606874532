package com.apap.tutorial5.repository;

import java.util.List;

import com.apap.tutorial5.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDb extends JpaRepository<CarModel, Long> {
	CarModel findByType(String type);
	
	List<CarModel> findByDealerIdOrderByPriceDesc(long dealer_id);

	List<CarModel> findByDealerIdOrderByPriceAsc(long dealerId);
}

