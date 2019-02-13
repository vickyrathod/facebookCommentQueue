package com.kapture.scheduled;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kapture.dao.MRepository;
import com.kapture.model.RequstData;

@Component
public class ScheduledTasks {

	@Autowired
	MRepository mRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${listener.url}")
	public String url; 
	
    @Scheduled(fixedRate = 10000)
    public void uploadToKapture() {
    	
    	ResponseEntity<Integer> timeStampResponse;
    	
    	Integer timestamp;
    	
    	List<RequstData> dataList = mRepository.findAll();
    	
    	//getting timestamp
    	
    	timeStampResponse = restTemplate.getForEntity(url + "/gettime",Integer.class);
    	
    	if(HttpStatus.OK.equals(timeStampResponse.getStatusCode())) {
    		timestamp = timeStampResponse.getBody().intValue();
    	} else {
    		timestamp = null;
    	}
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	
    	HttpEntity<List<RequstData>> data = new HttpEntity<>(dataList, headers);
    	ResponseEntity<String> rs = restTemplate.exchange(url + "/postdata", HttpMethod.POST , data, String.class);
    	
    	if(rs.getStatusCode().equals(HttpStatus.OK)) {
    		mRepository.deleteAll(dataList);
    	}
    }
}