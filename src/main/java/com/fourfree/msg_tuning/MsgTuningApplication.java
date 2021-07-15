package com.fourfree.msg_tuning;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing  // 배치 기능 활성화
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.fourfree")
public class MsgTuningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgTuningApplication.class, args);
	}

}
