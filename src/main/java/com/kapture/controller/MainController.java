package com.kapture.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kapture.model.RequstData;
import com.kapture.services.MongoService;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	MongoService mongoService;

	@GetMapping("hello/{id}")
	public String helloMethod(@PathParam("id") String id) {
		return id;
	}
	
	@PostMapping("gello")
	public ResponseEntity<RequstData> dikhtanahi(@RequestBody RequstData requstData) {
		mongoService.saveData(requstData);
		
		return ResponseEntity.ok().body(requstData);
	}
}
