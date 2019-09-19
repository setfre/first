package student.ssm.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pagination<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<T> bean;			//分页显示的数据
	
	private Integer currentIndex;	//当前页下标
	
	private Integer recordShowSize;	//页面显示最大数量
	
	private Integer recordSize;		//数据库记录总数量
	
	private Integer pageSize;		//页数
	
	private String message;			//分页情况消息
	
	private Map<String, Integer> index = new HashMap<String, Integer>();

	public List<T> getBean() {
		return bean;
	}

	public void setBean(List<T> bean) {
		this.bean = bean;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Integer getRecordShowSize() {
		return recordShowSize;
	}

	public void setRecordShowSize(Integer recordShowSize) {
		this.recordShowSize = recordShowSize;
	}

	public Integer getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(Integer recordSize) {
		this.recordSize = recordSize;
	} 
 
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Integer> getIndex() {
		int t1 = recordSize % recordShowSize;
		int t2 = recordSize / recordShowSize;
		pageSize = t1==0?t2:t2+1;
		index.put("start", (currentIndex - 1) * recordShowSize);
		index.put("end", currentIndex * recordShowSize);
		return index;
	}

	public void setIndex(Map<String, Integer> index) {
		
		this.index = index;
	}
	
}
