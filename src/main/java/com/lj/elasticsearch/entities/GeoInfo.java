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
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Document(indexName="geo-info",type="geo_point", shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class GeoInfo {

	@Id
	private String id;
	
	private String name;
	
	@Field(type=FieldType.Date)
	private Date createDate;

	@GeoPointField
	private String location;

	@Field(type=FieldType.String)
	private String city;
	
	@Field(type=FieldType.String)
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	
}
