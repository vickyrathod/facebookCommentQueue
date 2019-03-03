package com.kapture.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kapture.utils.ServiceConstants;

@RestController
@RequestMapping("/")
public class MainController {
	
	private static Logger log = LogManager.getLogger(MainController.class);
	
	 @PostMapping("facebook")
	 ResponseEntity<String> addData( @RequestBody String data){
		 log.info("got data of reuest : {}", data);
		 
		 
		 return ResponseEntity.ok().body(null);
	 }
	 
	 @GetMapping("facebook")
	 ResponseEntity<String> verifyService( @RequestParam(ServiceConstants.FACEBOOK_VERIFICATION_PARAM) String code){
		
		 return ResponseEntity.ok().body(code);
	 }
}
