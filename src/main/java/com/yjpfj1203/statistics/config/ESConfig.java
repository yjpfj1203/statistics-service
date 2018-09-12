package com.yjpfj1203.statistics.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ESConfig {
    @Bean
    public TransportClient client() throws UnknownHostException {
        //es集群连接
        TransportAddress master = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );
        TransportAddress esSlave01 = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),
                9301
        );
        TransportAddress esSlave02 = new InetSocketTransportAddress(
                InetAddress.getByName("127.0.0.1"),
                9302
        );

        //es集群配置（自定义配置） 连接自己安装的集群名称
        Settings settings = Settings.builder()
                .put("cluster.name","liuhan")
                .build();

        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);

        client.addTransportAddress(master);
        client.addTransportAddress(esSlave01);
        client.addTransportAddress(esSlave02);

        return client;
    }
}
