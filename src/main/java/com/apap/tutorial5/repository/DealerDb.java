package com.apap.tutorial5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.DealerModel;

@Repository
public interface DealerDb extends JpaRepository<DealerModel, Long> {
	
}