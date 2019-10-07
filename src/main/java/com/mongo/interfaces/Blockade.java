package com.mongo.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "blockade", path = "/blockades")
public interface Blockade {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String findById(@PathVariable("id") String id);
	

}
