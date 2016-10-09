package com.lj.elasticsearch.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
