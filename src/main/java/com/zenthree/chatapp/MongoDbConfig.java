package com.zenthree.chatapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "chatapp";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "com.zenthree.chatapp";
	}
	
	

}
