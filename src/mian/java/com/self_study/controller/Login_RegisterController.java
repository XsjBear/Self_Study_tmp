package com.self_study.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.UserInfoBean;
import com.self_study.service.IUserInfoService;
import com.self_study.util.SendMailUtil;

@RestController
@ResponseBody
@RequestMapping("/initial")
public class Login_RegisterController {
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Autowired
	private IUserInfoService userInfoService;
	
	
	/**
	 * 用户登陆请求
	 * @param session
	 * @param userInfoBean	用户前台的登陆相关信息  
	 * @return
	 */
	@RequestMapping("/Login")
	public int login(HttpSession session , UserInfoBean userInfoBean) {
		System.out.println("ClassPath : " + Thread.currentThread().getContextClassLoader().getResource("/").getPath());
		int result = 0;
		UserInfoBean userInfoBeanCheck = userInfoService.loginCheck(userInfoBean);
		System.out.println("前台传输数据信息：" + userInfoBean);
		System.out.println("后台查询数据信息:" + userInfoBeanCheck);
		if(userInfoBeanCheck != null) {
			//当用户输入的账号密码都正确时，返回1
			session.setAttribute("UserInfo", userInfoBeanCheck); 	//将用户信息存储到session中
			result = 1;
		}else {
			//表示用户账号或者密码输入错误
			result = -1;
		}
		return result;
	}
	
	
	/**
	 * 注册请求
	 * @param session
	 * @param user	用户信息
	 * @param code	用户前台输入的验证码
	 * @return
	 */
	@RequestMapping("/reg")
	public int reg(HttpSession session , UserInfoBean user , String code) {
		System.out.println(user + "    验证码:" + code);
		int result = 0; //表示用户注册的状态， 当result为-2时，表示用户输入的验证码不正确，当result> 0时表示用户注册成功 ， 当 result = -1时表示用户注册失败
		String localCode = (String) session.getAttribute(user.getRealname() + "code");	//获取存储在session中的验证码
		if( !code.equals(localCode)) {
			//表示用户验证码输入错误
			result = -2;
		}else {
//			UserInfoBean userInfoBeanByTel = userInfoService.selectByTel(user);
//			if(userInfoBeanByTel != null) {
//				//表示该电话号码已经被使用
//				result = -3;
//			}else {
				try {
					result = userInfoService.addUser(user);
				}catch (Exception e) {
//					e.printStackTrace();
					System.out.println("错误信息 : \n" + e.getMessage());
				}
//			}
		}
		System.out.println(result + "   localCode  :   " + localCode);
		return result;
	}
	
	/**
	 * 获取验证码请求
	 * @param name	用户真实姓名
	 * @param email		用户注册邮箱
	 * @param session
	 * @return
	 */
	@RequestMapping("/code")
	public int code(String name,String email,HttpSession session){
		int result = -1;
		//不向用户发送code，改为后台打印，测试时使用
//		try {
			String code = "";
			Random rd = new Random();
			while(code.length() < 6 ){
				code += rd.nextInt(10);
			}
//			if(sendMailUtil.sendHtmlMail(email, name, code)){
			System.out.println("此次注册验证码为： " + code);
				session.setAttribute(name + "code", code);
//				//启用一个定时任务，当3分钟后清空这个session中的值
				TimerTask task = new TimerTask(){
					@Override
					public void run() {
						session.removeAttribute(name + "code");
					}
				};
				Timer timer = new Timer();
				timer.schedule(task, 180000);
				result = 1;
//			}else{
//				result = 0;
//			}
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		return result;
	}
	

}
