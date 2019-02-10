package com.kapture.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapture.dao.MRepository;
import com.kapture.model.RequstData;

@Service
public class MongoService {
	
	@Autowired
	MRepository mRepository;
	
	public void saveData(RequstData requstData) {
		mRepository.save(requstData);
	}

	public List<RequstData>  getData(int a) {
		
		return mRepository.findAll();
	}

}
