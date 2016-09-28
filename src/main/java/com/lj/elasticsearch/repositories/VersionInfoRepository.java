package com.lj.elasticsearch.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lj.elasticsearch.entities.VersionInfo;

public interface VersionInfoRepository extends ElasticsearchRepository<VersionInfo, String>{

	Page<VersionInfo> findByVersionName(String versionName, Pageable pageable);
}
