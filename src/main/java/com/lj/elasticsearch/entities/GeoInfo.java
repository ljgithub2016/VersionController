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

@Document(indexName="geo-info",type="geo_point", shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class GeoInfo {

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
	
	///////////////////////////////////////////////
	private GeoPoint geopoint;

	@Field(type=FieldType.Date)
	private Date createDate;

	

	public GeoPoint getGeopoint() {
		return geopoint;
	}

	public void setGeopoint(GeoPoint geopoint) {
		this.geopoint = geopoint;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
