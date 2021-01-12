package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RedbinService {
//	public void method1(final String message) {
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		}).start();
//	}

//	static ExecutorService executorService = Executors.newFixedThreadPool(10);
//	
//	public void method1(final String message) {
//		executorService.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO 작
//			}
//		});
//	}

//	@Async
//	public void method1(String message) {
//		// do something
//	}

//	@Async("threadPoolTaskExecutor")
//	public Future<Integer> method1(int message) throws Exception {
//		// do something
//		Logger logger = LoggerFactory.getLogger(RedbinService.class);
//		Thread.sleep(1000L);
//			logger.info(message+"");
//		return new AsyncResult<Integer>(message);
//	}
	private static final Logger logger = LoggerFactory.getLogger(RedbinService.class);
	
	@Async
	public void method1(int i) throws Exception {
		// do something
		Thread.sleep(1000L);
		logger.info("i = " + i);
	}
}
