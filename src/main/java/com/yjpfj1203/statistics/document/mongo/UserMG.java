package com.yjpfj1203.statistics.document.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * optLog mongoDB
 * @author yjpfj1203
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "user")
public class UserMG implements Serializable {
    @Id
    private String id;
    /**
     * 用户唯一标识
     */
    private String useruniquecode;
    /**
     * 用户名
     */
    private String username;
}