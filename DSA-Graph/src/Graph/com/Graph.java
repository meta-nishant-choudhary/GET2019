package Graph.com;

import java.util.List;

public interface Graph {
	boolean isConnected();
	
	List<Integer> reachable(Integer source);
	
	int[] mst();
	
	int shortestPath(int source, int destination);
}
