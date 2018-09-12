package com.yjpfj1203.statistics.document.mongo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.yjpfj1203.statistics.document.mongo.OptLogMG;
import com.yjpfj1203.statistics.document.mongo.QOptLogMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OptLogMongoRepositoryImpl implements OptLogMongoRepositoryCustom{
    @Autowired
    private OptLogMongoRepository optLogMongoRepository;

    @Override
    public List<OptLogMG> findActive(Pageable pageable) {
        QOptLogMG optLog = QOptLogMG.optLogMG;
        BooleanExpression where = optLog.domaintype.ne("123");
        List<OptLogMG> list = (List<OptLogMG>)optLogMongoRepository.findAll(where);
        return list;
//        return CollectionUtil.iterableToCollectionJava8(list);
    }
}
