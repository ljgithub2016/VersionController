package com.lj.elasticsearch.service;


import javax.annotation.Resource;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.lj.elasticsearch.entities.Book;
import com.lj.elasticsearch.repositories.SampleBookRepository;

@Service
public class SampleBookRepositoryService {

	@Resource
    private SampleBookRepository repository;

    @Resource
	private ElasticsearchTemplate template;
    
    
    
    public void shouldIndexSingleBookEntity(){
    	System.out.println("shouldIndexSingleBookEntity");
        Book book = new Book();
        book.setId("123455");
        book.setName("Spring Data Elasticsearch");
        book.setVersion(System.currentTimeMillis());
        repository.save(book);
        //lets try to search same record in elasticsearch
        Book indexedBook = repository.findOne(book.getId());
        
        repository.exists("111");
        System.out.println(indexedBook.getId());
    }
}
