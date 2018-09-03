package com.yjpfj1203.statistics.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词
 * 说明：
 * indexName：可类比于mysql的数据库
 * type：类比与mysql的表
 * shards：分片
 * replicas：副本
 * refreshInterval:
 * createIndex: 是否创建索引
 *
 *
 * @author yjpfj1203
 */
@Document(indexName = "book", type = "book", shards = 5,replicas = 1, refreshInterval = "-1", createIndex = true)
public class Book {
    @Id
    String id;
    String name;
    String message;
    String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}