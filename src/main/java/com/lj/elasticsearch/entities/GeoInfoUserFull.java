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
public class GeoInfoUserFull {

	@Id
	private String id;
	private String name;

	@GeoPointField
	private String locationAsString;

	@GeoPointField
	private double[] locationAsArray;

	@GeoPointField()
	private String locationWithPrefixAsDistance;

	@GeoPointField()
	private String locationWithPrefixAsLengthOfGeoHash;

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

	public String getLocationAsString() {
		return locationAsString;
	}

	public void setLocationAsString(String locationAsString) {
		this.locationAsString = locationAsString;
	}

	public double[] getLocationAsArray() {
		return locationAsArray;
	}

	public void setLocationAsArray(double[] locationAsArray) {
		this.locationAsArray = locationAsArray;
	}

	public String getLocationWithPrefixAsDistance() {
		return locationWithPrefixAsDistance;
	}

	public void setLocationWithPrefixAsDistance(String locationWithPrefixAsDistance) {
		this.locationWithPrefixAsDistance = locationWithPrefixAsDistance;
	}

	public String getLocationWithPrefixAsLengthOfGeoHash() {
		return locationWithPrefixAsLengthOfGeoHash;
	}

	public void setLocationWithPrefixAsLengthOfGeoHash(String locationWithPrefixAsLengthOfGeoHash) {
		this.locationWithPrefixAsLengthOfGeoHash = locationWithPrefixAsLengthOfGeoHash;
	}
	
	
}
