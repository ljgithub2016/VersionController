package com.lj.gps.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lj.gps.enties.GpsEntity;

public interface GpsRepository extends ElasticsearchRepository<GpsEntity,String> {
    
}
