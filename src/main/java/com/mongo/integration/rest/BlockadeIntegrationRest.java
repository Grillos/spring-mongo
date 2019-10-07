package com.mongo.integration.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.interfaces.Blockade;

public class BlockadeIntegrationRest {
	
	@Autowired
	private Blockade blockade;
	
	public String findById(final String id) {
		return blockade.findById(id);
	}

}
