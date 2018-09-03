package com.yjpfj1203.statistics.entity.repository;

import com.yjpfj1203.statistics.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String>{
}