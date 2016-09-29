package com.lj.gps.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import com.lj.elasticsearch.entities.VersionInfo;
import com.lj.elasticsearch.repositories.VersionInfoRepository;
import com.lj.gps.enties.GpsEntity;
import com.lj.gps.repositories.GpsRepository;
import com.lj.web.vo.VersionVo;

@Service
public class GpsService {

	@Resource
	private GpsRepository versionInfoRepository;
	
	public void saveVersion(VersionVo vo){
		GpsEntity info = new GpsEntity();
		info.setId(String.valueOf(System.currentTimeMillis()));
		info.setVersion(1L);
		info.setCreateDate(new Date());
		info.setGeoPoint(new GeoPoint(39.1111, 117.246));
		versionInfoRepository.save(info);
	}
}
