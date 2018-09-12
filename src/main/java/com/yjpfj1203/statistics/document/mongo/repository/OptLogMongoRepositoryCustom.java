package com.yjpfj1203.statistics.document.mongo.repository;

import com.yjpfj1203.statistics.document.mongo.OptLogMG;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OptLogMongoRepositoryCustom {
    public List<OptLogMG> findActive(Pageable pageable);
}
