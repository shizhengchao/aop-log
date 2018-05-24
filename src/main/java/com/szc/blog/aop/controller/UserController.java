package com.szc.blog.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.szc.blog.aop.annotation.SystemControllerLog;
import com.szc.blog.aop.message.Message;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@SystemControllerLog(description = "删除用户")
	public Message del() {
		return Message.ok("delete success").build();
	}

}
