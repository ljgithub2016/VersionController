package com.lj.elasticsearch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName="mysql_log",type="logs", shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class MySqlLog {

	@Id
	private String id;
	
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
