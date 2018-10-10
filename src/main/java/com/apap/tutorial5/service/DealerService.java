package com.apap.tutorial5.service;

import java.util.Optional;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);

	void addDealer(DealerModel dealer);
	
	void deleteDealer(DealerModel dealer);
	
	void updateDealer(long id, Optional<DealerModel> dealer);
	
	DealerDb viewAllDealer();

}