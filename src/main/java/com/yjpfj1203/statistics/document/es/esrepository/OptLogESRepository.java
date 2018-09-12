package com.yjpfj1203.statistics.entity.es.esrepository;

import com.yjpfj1203.statistics.entity.es.OptLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptLogESRepository extends ElasticsearchRepository<OptLog, String>{
}