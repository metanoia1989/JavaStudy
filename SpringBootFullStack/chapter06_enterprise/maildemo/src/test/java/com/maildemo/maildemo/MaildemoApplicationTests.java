package com.maildemo.maildemo;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
class MaildemoApplicationTests {
	@Autowired
	MailService mailService;

	@Autowired
	TemplateEngine templateEngine;

	@Test
	public void testSendMail() {
		mailService.sendSimpleMail(
			"m15171641694@163.com", 
			"2636854812@qq.com", 
			"2636854812@qq.com", 
			"测试邮件主题", 
			"测试邮件内容");
	}

	@Test
	public void sendAttachFileMail() {
		mailService.sendAttachFileMail(
			"m15171641694@163.com", 
			"2636854812@qq.com", 
			"测试文件邮件主题", "测试文件邮件内容", 
			new File("E:/WorkSpace/我的图片/聊天趣事/佛祖保佑-永无BUG.png"));	
	}
	
	@Test
	public void sendMailWithImg() {
		mailService.sendMailWithImg(
			"m15171641694@163.com", 
			"2636854812@qq.com", 
			"测试图片邮件主题", 
			"<div>hello，葫芦娃，金刚葫芦娃：" +
			"<div><img src='cid:p01' /></div>" +
			"<div><img src='cid:p02' /></div>" +
			"</div>", 
			new String[]{ 
				"E:/WorkSpace/我的图片/聊天趣事/佛祖保佑-永无BUG.png",
				"E:/WorkSpace/我的图片/聊天趣事/paper.jpg",
			}, 
			new String[]{ "p01", "p02" }
		);
	}
	
	@Test
	public void sendHtmlMailThymeleaf() {
		Context ctx = new Context();	
		ctx.setVariable("username", "Adam Smith");
		ctx.setVariable("gender", "男");
		String mail = templateEngine.process("mailtemplate.html", ctx);
		mailService.sendHtmlMail(
			"m15171641694@163.com", 
			"2636854812@qq.com", 
			"测试HTML模板邮件", 
			mail);
	}
}
