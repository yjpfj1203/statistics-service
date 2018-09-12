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
@Document(collection = "opt_log")
public class OptLogMG implements Serializable {
    @Id
    private String id;
    /**
     * 用户id
     */
    private Long userid;
    /**
     * 用户唯一标识
     */
    private String useruniquecode;
    /**
     * 用户名
     */
    private String username;
    /**
     * 操作类型
     */
    private String operatetype;
    /**
     * 操作时间
     */
    private String operatetime;
    /**
     * 操作备注
     */
    private String operatenote;
    /**
     * 对象类型
     */
    private String domaintype;
    /**
     * 对象id
     */
    private String domainid;
    /**
     * 请求表单
     */
    private String requestmodel;

    private Date createddate;
}