package com.lj.gps.enties;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Document(indexName = "gps",type = "gps" , shards = 5, replicas = 0, indexStoreType = "fs", refreshInterval = "-1")
public class GpsEntity {

	@Id
    private String id;
	
	@Version
	private Long version;
	
	@Field(type = FieldType.Nested)
	private Map<Integer, Collection<String>> buckets = new HashMap();
	
	
	public Map<Integer, Collection<String>> getBuckets() {
		return buckets;
	}

	public void setBuckets(Map<Integer, Collection<String>> buckets) {
		this.buckets = buckets;
	}
	
	@GeoPointField
	private org.springframework.data.elasticsearch.core.geo.GeoPoint geoPoint;
		
	
	private Date createDate;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}


	public org.springframework.data.elasticsearch.core.geo.GeoPoint getGeoPoint() {
		return geoPoint;
	}


	public void setGeoPoint(org.springframework.data.elasticsearch.core.geo.GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	 
}
