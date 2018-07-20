package com.zmx.jta.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zmx.jta.domain.Member;
import com.zmx.jta.domain.MemberInfo;
import com.zmx.jta.service.MemberService;

@Controller
@RequestMapping("/test")
public class JTATestController {
	

	private static Logger logger = LogManager.getLogger(JTATestController.class);	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String testRegister(){  
		for (int i = 0; i < 10; i++) {
			
			Member member = new Member();
			member.setId(i);
			member.setUsername("童可可");   
			member.setPassword("12345678");
			member.setStatus(0);
			
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(i);
			memberInfo.setAge(25);
			memberInfo.setNickname("keke");
			memberInfo.setRealname("童可可");
			if(memberService.registerMember(member, memberInfo)){
				logger.info("##用户注册成功");
			}else{
				logger.info("##用户注册失败");
			}
		}
		return "success";
	}       
	
	

}
