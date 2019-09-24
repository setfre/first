package student.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import student.ssm.mapper.CuserMapper;
import student.ssm.pojo.Cuser;
import student.ssm.service.UserResourceService;

@Service
public class UserResourceServiceImpl implements UserResourceService{

	@Autowired
	private CuserMapper cuserMapper;
	
	@Override
	public Cuser login(ModelMap model,Cuser cuser) {
		// TODO Auto-generated method stub
		Cuser user = cuserMapper.retrieveByUsercode(cuser);
		if(user == null) {
			
		}
		if(!user.getPassword().equals(cuser.getPassword())) {
			
		}
		
		return user;
	}

	@Override
	public String regist(Cuser cuser) {
		// TODO Auto-generated method stub
		cuserMapper.create(cuser);
		return "jsp/personInfo";
	}

	@Override
	public String update(Cuser cuser) {
		cuserMapper.update(cuser);
		return "jsp/personInfo";
	}

	@Override
	public List<Cuser> retrieveAllUser() {
		// TODO Auto-generated method stub
		return cuserMapper.retrieveAll();
	}

	@Override
	public String delete(Cuser cuser) {
		// TODO Auto-generated method stub
		cuserMapper.delete(cuser);
		return "jsp/show";
	}

}
