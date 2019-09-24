package student.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import student.ssm.pojo.Cuser;
import student.ssm.service.UserResourceService;

@Controller
@RequestMapping("userResourse")
public class UserResourseController {
	
	@Autowired
	private UserResourceService userResourceService;
	
	@RequestMapping("login") 
	public String login(ModelMap model,HttpSession session,Cuser cuser) {
		Cuser user = userResourceService.login(model,cuser);
		session.setAttribute("user", user);
		List<Cuser> users = userResourceService.retrieveAllUser();
		session.setAttribute("users", users);
		return "jsp/show";
	} 
	
	@RequestMapping("regist")
	public String regist(Cuser cuser) {
		System.out.print(cuser);
		return userResourceService.regist(cuser);
	}
	@RequestMapping("delete")
	public String delete(Cuser cuser) {
		return userResourceService.delete(cuser);
	}
	
	@RequestMapping("doUpdateUserInfo")
	public String doUpdateUserInfo(Cuser cuser) {
		return userResourceService.update(cuser);
	}
	
	public String doRetrieveAllUser(ModelMap model) {
		List<Cuser> users = userResourceService.retrieveAllUser();
		model.addAttribute("users", users);
		return "jsp/show";
	}
	
}
