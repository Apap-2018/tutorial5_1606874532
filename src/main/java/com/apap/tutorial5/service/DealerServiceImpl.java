package com.apap.tutorial5.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id){
		return dealerDb.findById(id);
	}

	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
	}
	
	@Override
	public void deleteDealer(DealerModel dealer) {
		dealerDb.delete(dealer);
	}

	@Override
	public void updateDealer(long id, Optional<DealerModel> newDealer) {
		DealerModel dealerUpdated = dealerDb.getOne(id);
		dealerUpdated.setAlamat(newDealer.get().getAlamat());
		dealerUpdated.setNoTelp(newDealer.get().getNoTelp());
		dealerDb.save(dealerUpdated);
	}
	
	@Override
	public DealerDb viewAllDealer() {
		return dealerDb;
	}

}
