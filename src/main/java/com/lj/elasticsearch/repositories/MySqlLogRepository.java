package com.lj.elasticsearch.repositories;



import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lj.elasticsearch.entities.MySqlLog;

public interface MySqlLogRepository extends ElasticsearchRepository<MySqlLog,String> {
    
}
