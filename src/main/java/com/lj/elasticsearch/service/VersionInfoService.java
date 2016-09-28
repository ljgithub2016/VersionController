package com.lj.elasticsearch.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.elasticsearch.entities.VersionInfo;
import com.lj.elasticsearch.repositories.VersionInfoRepository;
import com.lj.web.vo.VersionVo;

@Service
public class VersionInfoService {

	@Resource
	private VersionInfoRepository versionInfoRepository;
	
	public void saveVersion(VersionVo vo){
		VersionInfo info = new VersionInfo();
		info.setId(String.valueOf(System.currentTimeMillis()));
		info.setVersion(1L);
		info.setVersionName(vo.getVersionName());
		info.setAuthor(vo.getAuthor());
		info.setCreateDate(vo.getCreateDate());
		info.setTestDate(vo.getTestDate());
		info.setWorkDate(vo.getWorkDate());
		info.setDbInfo(vo.getDbInfo());
		info.setMenuInfo(vo.getMenuInfo());
		versionInfoRepository.save(info);
	}
}
