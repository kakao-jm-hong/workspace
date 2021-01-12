package com.example.demo.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

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

	@Async("threadPoolTaskExecutor")
	public Future<String> method1(String message) throws Exception {
		// do something
		return new AsyncResult<String>("Success");
	
	}
}
