package com.mongo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongo.interfaces.Blockade;

@Controller
@RequestMapping("/mongo-integration-blockades")
public class BlockadeController {
	
	@Autowired 
	private Blockade blockade;
	
	@GetMapping("/{id}")
	public ResponseEntity<String>findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(blockade.findById(id),HttpStatus.OK);
}

}
