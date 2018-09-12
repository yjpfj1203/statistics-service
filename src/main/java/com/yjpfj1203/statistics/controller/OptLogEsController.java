package com.yjpfj1203.statistics.controller;


import com.yjpfj1203.statistics.util.CollectionUtil;
import com.yjpfj1203.statistics.entity.es.OptLog;
import com.yjpfj1203.statistics.entity.es.esrepository.OptLogESRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/es/logs")
@EnableSwagger2
public class OptLogEsController {
    @Autowired
    private OptLogESRepository optLogRepository;

    @GetMapping
    public List<OptLog> findAll() {
        return CollectionUtil.iterableToCollectionJava8(optLogRepository.findAll());
    }

    /**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public OptLog findById(@PathVariable String id) {
        return optLogRepository.findById(id).orElse(null);
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<OptLog> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<OptLog> searchResult = optLogRepository.search(builder);
        Iterator<OptLog> iterator = searchResult.iterator();
        List<OptLog> list = new ArrayList<OptLog>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
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
    public List<OptLog> findList(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {

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
    public OptLog insert(@RequestBody OptLog optLog) {
        optLogRepository.save(optLog);
        return optLog;
    }

    /**
     * 5、删 id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public OptLog delete(@PathVariable String id) {
        OptLog optLog = optLogRepository.findById(id).orElse(null);
        optLogRepository.deleteById(id);
        return optLog;
    }

    /**
     * 6、改
     * @param optLog
     * @return
     */
    @PutMapping("{id}")
    public OptLog update(OptLog optLog) {
        optLogRepository.save(optLog);
        return optLog;
    }
}
