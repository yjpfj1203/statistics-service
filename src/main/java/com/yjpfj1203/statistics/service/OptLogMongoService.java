package com.yjpfj1203.statistics.service;

import com.querydsl.core.types.Predicate;
import com.yjpfj1203.statistics.util.CollectionUtil;
import com.yjpfj1203.statistics.document.mongo.OptLogMG;
import com.yjpfj1203.statistics.document.mongo.QOptLogMG;
import com.yjpfj1203.statistics.document.mongo.repository.OptLogMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OptLogMongoService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private OptLogMongoRepository optLogMongoRepository;

    public void update(OptLogMG optLog){
        Query query=new Query(Criteria.where("id").is(optLog.getId()));
        Update update= new Update().set("domainid", optLog.getDomainid()).set("userid", optLog.getUserid());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, OptLogMG.class,"opt_log");//参数1：条件；参数2：更新内容；参数3：对象类型；参数4：cellectionName。参数3、4两个为可选项
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,Student.class);

    }

    public List<OptLogMG> findByParams(){
        QOptLogMG optLogMG = QOptLogMG.optLogMG;
        Predicate query = optLogMG.domaintype.ne("123");
        return CollectionUtil.iterableToCollectionJava8(optLogMongoRepository.findActive(null));
    }
}
