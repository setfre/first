package student.ssm.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import student.ssm.pojo.Cuser;

public interface UserResourceService {

	Cuser login(ModelMap model, Cuser cuser);

	String regist(Cuser cuser);
 
	String update(Cuser cuser);

	List<Cuser> retrieveAllUser();

	String delete(Cuser cuser);


}
