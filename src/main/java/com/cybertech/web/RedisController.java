package com.cybertech.web;

import com.cybertech.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/11. 10:08 AM
 */

@RestController
@RequestMapping(value="/redis")
public class RedisController {

	@Autowired
	RedisUtil redisUtil;

	@RequestMapping(value="/getValue")
	public Object getValue(){

		String value = redisUtil.get("teststring");
		return value;
	}

	@RequestMapping(value="/setValue")
	public Object setValue(){

		String info = "";
		try{
			redisUtil.lLeftPush("test","teststring","ajjj");
			info = "success";
		}catch (Exception e){
			e.printStackTrace();
			info = "error";
		}
		return info;
	}
}
