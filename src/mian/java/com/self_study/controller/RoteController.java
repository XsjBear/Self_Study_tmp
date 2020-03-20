package com.self_study.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self_study.bean.ExperienceBean;
import com.self_study.bean.FriendInfoBean;
import com.self_study.bean.FriendShipBean;
import com.self_study.bean.ShareExperienceArticleBean;
import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.StudyFriendInfoBean;
import com.self_study.bean.TargetBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IExperienceService;
import com.self_study.service.IFriendShipService;
import com.self_study.service.IShareExperienceService;
import com.self_study.service.IStudyFriendService;
import com.self_study.service.ITargetService;
import com.self_study.service.IUserInfoService;

/**
 * 路由控制器，用以访问WEB-INF目录下的页面
 * @author Xsj
 *
 */
@Controller
public class RoteController {
	
	@Autowired
	private IStudyFriendService studyFriendService;
	
	@Autowired
	private ITargetService targetService;
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IShareExperienceService shareExperienceService;
	
	@Autowired
	private IExperienceService experienceService;
	
	@Autowired
	private IFriendShipService friendShipService;
	
	
	@RequestMapping("/HomePage")
	public String HomePage(HttpSession session ,ModelMap model) {
		//好友推荐
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		//查询出当前用户的所有的好友关系
		ArrayList<FriendShipBean> friendlist = studyFriendService.selectAll(userInfo);
		ArrayList<Integer> frienduserid = new ArrayList<>();
		//将自己的id添加进去防止后面sql查询时将自己当作好友查询出来
		frienduserid.add(userInfo.getUserid());
		//便利查询出来的好友关系，然后甄别出当前登陆用户的好友id
		for (FriendShipBean friendInfo : friendlist) {
			//首页推荐好友只推荐六个，如果超出六个其余的则不添加
			if(frienduserid.size() > 6) {
				break;
			}else {
				if((String.valueOf(userInfo.getUserid())).equals(friendInfo.getSelfuserid())) {
					//如果selfuserid为当前登陆的用户的id的话，则添加frienduserid
					frienduserid.add(Integer.valueOf(friendInfo.getFrienduserid()));
				}else {
					//如果selfuserid不等于当前登陆的用户的id的话，则添加selfuserid
					frienduserid.add(Integer.valueOf(friendInfo.getSelfuserid()));
				}
			}
		}
		//查找出不是好友的用户信息
		ArrayList<StudyFriendInfoBean> list  = studyFriendService.selectNotFriendByList(frienduserid);
		model.addAttribute("friendNum", list.size());//将小伙伴的数量添加进去，如果为0则说明所有小伙伴都是你的好友了
		model.addAttribute("AllFriendInfo", list);
		
		//获取除去当前用户发表的分享之外的优秀分享
		ArrayList<ShareExperienceBean> excellenceShareList = shareExperienceService.selectExceptSelf(userInfo);
		model.addAttribute("OutherNum", excellenceShareList.size());
		model.addAttribute("ExcellenceShare", excellenceShareList);
		return "HomePage";
	}
	
	
	@RequestMapping("/AddFreind")
	public String AddFreind(HttpSession session ,ModelMap model , String userid , HttpServletRequest request , HttpServletResponse response) {
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		FriendShipBean friendShip = new FriendShipBean();
		friendShip.setSelfuserid(String.valueOf(userInfo.getUserid()));
		friendShip.setFrienduserid(userid);
		friendShip.setBuildrelationtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		friendShip.setRelationshipstate("1");
		int result = friendShipService.addOne(friendShip);
		if(result > 0) {
			//说明添加成功,调用MyFriend方法，跳转到MyFriend页面
//			MyFriend(session , model);
			model.addAttribute("isSuccess", 1);
			try {
				request.getRequestDispatcher("MyFriend").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//说明添加失败,增加一个变量值,跳转回原页面
			model.addAttribute("isFault", 1);
		}
		return "SearchFriend";
	}
	
	
	
	@RequestMapping("/MyFriend")
	public String MyFriend(HttpSession session ,ModelMap model) {
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		//查询出当前用户的所有的好友关系
		ArrayList<FriendShipBean> friendlist = studyFriendService.selectAll(userInfo);
		//用以存放好友的userid
		ArrayList<Integer> frienduserid = new ArrayList<>();
		//便利查询出来的好友关系，然后甄别出当前登陆用户的好友id
		for (FriendShipBean friendInfo : friendlist) {
			if((String.valueOf(userInfo.getUserid())).equals(friendInfo.getSelfuserid())) {
				//如果selfuserid为当前登陆的用户的id的话，则添加frienduserid
				frienduserid.add(Integer.valueOf(friendInfo.getFrienduserid()));
			}else {
				//如果selfuserid不等于当前登陆的用户的id的话，则添加selfuserid
				frienduserid.add(Integer.valueOf(friendInfo.getSelfuserid()));
			}
		}
		ArrayList<StudyFriendInfoBean> list  = studyFriendService.selectByList(frienduserid);
		model.addAttribute("selfFriendNum", list.size());//将小伙伴的数量添加进去，如果为0则说明所有小伙伴都是你的好友了
		model.addAttribute("selfFriendList", list);
		return "MyFriend";
	}
	
	@RequestMapping("/ExcellenceShare")
	public String ExcellenceShare(HttpSession session ,ModelMap model) {
		//查询出当前登陆用户的相关信息
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		//获取除去当前用户发表的分享之外的优秀分享
		ArrayList<ShareExperienceBean> excellenceShareList = shareExperienceService.selectExceptSelf(userInfo);
		model.addAttribute("OutherNum", excellenceShareList.size());
		model.addAttribute("ExcellenceShare", excellenceShareList);
		return "ExcellenceShare";
	}
	
	
	
	@RequestMapping("/ReadArticle")
	public String ReadArticle(String shareid , ModelMap model) {
		ShareExperienceArticleBean shareExperienceArticle = shareExperienceService.selectByShareId(shareid);
		model.addAttribute("ShareExperienceArticle", shareExperienceArticle);
		return "ReadArticle";
	}
	
	
	@RequestMapping("/Share")
	public String Share( ModelMap model) {
		ArrayList<ExperienceBean> experienceList = experienceService.selectAll();
		model.addAttribute("ExperienceList", experienceList);
		return "Share";
	}
	
	
	
	@RequestMapping("/MyShare")
	public String MyShare(HttpSession session , ModelMap model) {
		
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		ArrayList<ShareExperienceBean> shareExperienceList = shareExperienceService.selectByUserId(userInfo);
		if(shareExperienceList.size() == 0) {
			//表示没有查询出任何的分享文章
			model.addAttribute("MyShareNum", 0);
		}else {
			model.addAttribute("MyShareNum", shareExperienceList.size());
			model.addAttribute("MyShare", shareExperienceList);
		}
		return "MyShare";
	}
	
	
	@RequestMapping("/AboutSelf")
	public String AboutSelf(String userid ,HttpSession session , ModelMap model) {
		UserInfoBean userInfo = null;
		//如果前台没有传userid过来，说明访问的是自己的主页，从session中获取个人信息，如果前台传了userid过来，说明访问的是别人的主页，则根据传输过来的useri查询出对应的信息
		if(userid == null) {
			//说明是自己访问自己的个人主页
			model.addAttribute("isSelf", "true");
			userInfo = (UserInfoBean)session.getAttribute("UserInfo");	//从session中获取用户信息
		}else {
			//说明不是访问自己的主页，查询对应id的信息并且不提供修改个人信息按钮
			model.addAttribute("isSelf", "false");
			userInfo = new UserInfoBean();
			userInfo.setUserid(Integer.valueOf(userid));
			userInfo = userInfoService.selectAllByUserId(userInfo);
		}
		//查询出对应的学习小伙伴的信息
		FriendInfoBean friendInfo = studyFriendService.selectByUserId(userInfo);
		//如果用户未完善学习小伙伴的相关信息，则创建一个身份展示其他信息为空的对象
		if(friendInfo == null) {
			friendInfo = new FriendInfoBean("","","","1","");
		}
		ArrayList<TargetBean> targetList = targetService.selectAll();
		model.addAttribute("targetList", targetList);
		model.addAttribute("FriendInfo", friendInfo);
		model.addAttribute("UserInfo", userInfo);
		return "AboutSelf";
	}
	
	
	@RequestMapping("/SearchFriend")
	public String SearchFriend(HttpSession session , ModelMap model) {
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		//查询出当前用户的所有的好友关系
		ArrayList<FriendShipBean> friendlist = studyFriendService.selectAll(userInfo);
		ArrayList<Integer> frienduserid = new ArrayList<>();
		//将自己的id添加进去防止后面sql查询时将自己当作好友查询出来
		frienduserid.add(userInfo.getUserid());
		//便利查询出来的好友关系，然后甄别出当前登陆用户的好友id
		for (FriendShipBean friendInfo : friendlist) {
			if((String.valueOf(userInfo.getUserid())).equals(friendInfo.getSelfuserid())) {
				//如果selfuserid为当前登陆的用户的id的话，则添加frienduserid
				frienduserid.add(Integer.valueOf(friendInfo.getFrienduserid()));
			}else {
				//如果selfuserid不等于当前登陆的用户的id的话，则添加selfuserid
				frienduserid.add(Integer.valueOf(friendInfo.getSelfuserid()));
			}
		}
		//查找出不是好友的用户信息
		ArrayList<StudyFriendInfoBean> list  = studyFriendService.selectNotFriendByList(frienduserid);
		model.addAttribute("friendNum", list.size());//将小伙伴的数量添加进去，如果为0则说明所有小伙伴都是你的好友了
		model.addAttribute("AllFriendInfo", list);
		return "SearchFriend";
	}
	
	
	/**
	 * 页面一加载时就发送此请求来加载表单中用户的个人信息
	 */
	@RequestMapping("/PageLoad")
	public String loadRequest(HttpSession session , Model model) {
		ArrayList<TargetBean> targetList = targetService.selectAll();
		model.addAttribute("targetList", targetList);
		return "FriendInfo";
	}
	
	
	@RequestMapping("/StudyFriend")
	public String StudyFriend() {
		return "StudyFriend";
	}
	
	
	@RequestMapping("/SelfInfo")
	public String SelfInfo() {
		return "SelfInfo";
	}
	
	@RequestMapping("/FriendInfo")
	public String FriendInfo() {
		return "FriendInfo";
	}

}
