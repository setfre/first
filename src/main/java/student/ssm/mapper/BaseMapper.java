package student.ssm.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

	public void create(T bean);
	
	public void delete(T bean);
	
	public void update(T bean);
	
	public List<T> retrieveAll();
	
	public List<T> retrieveById(T bean);
	
	public List<T> retrieveByManyKey(T bean);
	
	public List<T> pagination(Map<String, Integer> map);
}
