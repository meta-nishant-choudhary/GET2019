package quest1.com.meta;

import java.util.List;

public interface Dictionary {

	public boolean add(String key, String value) throws Exception;
	
	public boolean delete(String key) throws Exception;
	
	public String getValue(String key);
	
	public List<Value> getAll();
	
	public List<Value> getBetween(String key1,String key2);
	
}
