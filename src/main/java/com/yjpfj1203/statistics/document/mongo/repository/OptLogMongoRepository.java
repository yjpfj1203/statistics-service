package com.yjpfj1203.statistics.document.mongo.repository;

import com.yjpfj1203.statistics.document.mongo.OptLogMG;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 注意：mongoRepository支持queryDSL，类common-service，多表聚合查询可使用queryDSL
 * 参考文档：https://www.baeldung.com/queries-in-spring-data-mongodb
 */
@Repository
public interface OptLogMongoRepository extends MongoRepository<OptLogMG, String>, OptLogMongoRepositoryCustom, QuerydslPredicateExecutor{
}