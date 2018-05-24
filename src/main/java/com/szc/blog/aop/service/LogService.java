package com.szc.blog.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.szc.blog.aop.domain.Log;

@Service
public class LogService {

	// 本地异常日志记录对象
	private static final Logger logger = LoggerFactory.getLogger(LogService.class);

	public void add(Log log) {
		logger.info(log.toString());
	}
}
