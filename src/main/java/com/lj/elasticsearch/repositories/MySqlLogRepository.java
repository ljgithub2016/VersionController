package com.lj.elasticsearch.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lj.elasticsearch.entities.Book;
import com.lj.elasticsearch.entities.GeoInfo;
import com.lj.elasticsearch.entities.MySqlLog;

public interface MySqlLogRepository extends ElasticsearchRepository<MySqlLog,String> {
    
}
