package com.lj.elasticsearch.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="versioninfo",type="versiontype", shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class VersionInfo {

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
	
	private String versionName;
	
	private String author;
	
	private Date createDate;
	
	private Date testDate;
	
	private Date workDate;
	
	private String dbInfo;
	
	private String menuInfo;


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

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getDbInfo() {
		return dbInfo;
	}

	public void setDbInfo(String dbInfo) {
		this.dbInfo = dbInfo;
	}

	public String getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	
	
}
