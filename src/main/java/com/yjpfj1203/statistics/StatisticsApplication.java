package com.yjpfj1203.statistics;

import com.yjpfj1203.statistics.util.AppContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StatisticsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(StatisticsApplication.class, args);
		AppContextUtil.setApplicationContext(ctx);
	}
}
