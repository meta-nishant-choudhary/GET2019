package Graph.com;

public class Node {
	Integer vertex;
	Integer weight;
	
	public Node(){}
	
	public Node(Integer vertex, Integer weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	//getter
	public Integer getVertex() {
		return this.vertex;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
	
	//setter
	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
