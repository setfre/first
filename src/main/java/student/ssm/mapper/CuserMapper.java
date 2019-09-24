package student.ssm.mapper;

import java.util.List;

import student.ssm.pojo.Cuser;

public interface CuserMapper {

	Cuser retrieveByUsercode(Cuser cuser);

	void create(Cuser cuser);

	void update(Cuser cuser);

	List<Cuser> retrieveAll();

	void delete(Cuser cuser);

}
