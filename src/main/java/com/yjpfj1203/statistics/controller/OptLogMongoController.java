package com.yjpfj1203.statistics.controller;


import com.yjpfj1203.statistics.service.OptLogMongoService;
import com.yjpfj1203.statistics.document.mongo.OptLogMG;
import com.yjpfj1203.statistics.entity.es.OptLog;
import com.yjpfj1203.statistics.document.mongo.repository.OptLogMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * mongoDB，optLog控制器
 */
@RestController
@RequestMapping("/mongo/logs")
@EnableSwagger2
public class OptLogMongoController {
    @Autowired
    private OptLogMongoRepository optLogRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private OptLogMongoService optLogMongoService;

    @GetMapping
    public List<OptLogMG> findAll() {
//        return optLogMongoService.findByParams();
        //下面等价
        return mongoTemplate.findAll(OptLogMG.class);
        //下面这个等价
//        return optLogRepository.findAll();
    }

    /**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public OptLogMG findById(@PathVariable String id) {
        return mongoTemplate.findById(id, OptLogMG.class);
        //下面这个等价
//        return optLogRepository.findById(id).orElse(null);
    }

    /**
     * 3、查   +++：分页、分数、分域（结果一个也不少）
     * @param page
     * @param size
     * @param q
     * @return
     * @return
     */
    @GetMapping("/{page}/{size}/{q}")
    public List<OptLog> searchCity(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {

        // 分页参数
//        Pageable pageable = new PageRequest(page, size);
//
//        // 分数，并自动按分排序
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q)),
//                        ScoreFunctionBuilders.weightFactorFunction(1000)) // 权重：name 1000分
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
//                        ScoreFunctionBuilders.weightFactorFunction(100)); // 权重：message 100分
//
//        // 分数、分页
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//
//        Page<OptLog> searchPageResults = bookRepository.search(searchQuery);
//        return searchPageResults.getContent();
        return null;
    }

    /**
     * 4、增
     * @param optLog
     * @return
     */
    @PostMapping
    public OptLogMG insert(@RequestBody OptLogMG optLog) {
        optLogRepository.save(optLog);
        return optLog;
    }

    /**
     * 5、删 id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public OptLogMG delete(@PathVariable String id) {

        OptLogMG optLog = optLogRepository.findById(id).orElse(null);
        mongoTemplate.remove(optLog);
//        optLogRepository.deleteById(id);
        return optLog;
    }

    /**
     * 6、改
     * @param optLog
     * @return
     */
    @PutMapping("{id}")
    public OptLogMG update(OptLogMG optLog) {
        //optLogService.update(optLog);
        optLogRepository.save(optLog);
        return optLog;
    }
}
