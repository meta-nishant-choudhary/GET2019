package Graph.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GraphImpl implements Graph{
	private LinkedList<Node>[] adjNode ;
	private int noOfVertices;
	
	//constructor
	public GraphImpl(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjNode = new LinkedList[noOfVertices];
		
		for(int i = 0; i < noOfVertices; i++) {
			adjNode[i] = new LinkedList<Node>();
		}
	}
	
	/**
	 * to add the edge in the graph
	 * @Param source
	 * @Param destination
	 * @Param weight
	 */
	public void addEdge(Integer source, Integer destination, Integer weight) {
		Node objNodeOfSource = new Node(destination, weight);
		adjNode[source].add(objNodeOfSource);
		
		Node objNodeOfDestination = new Node(source, weight);
		adjNode[destination].add(objNodeOfDestination);
	}
	
	/**
	 * to find the graph is connected or not
	 * return boolean value
	 */
	@Override
	public boolean isConnected() {
		boolean[] visited = new boolean[this.noOfVertices];
		findConnected(0, visited);
		
		for(boolean visit : visited) {
			if(!visit) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To find the graph is connected or not
	 * @param index
	 * @param visited
	 */
	public void findConnected(Integer index, boolean[] visited) {
		visited[index] = true;
		
		for(Node node : adjNode[index]) {
			if(!visited[node.getVertex()]) {
				findConnected(node.getVertex(), visited);
			}
		}
	}
	
	/**
	 * To find the nodes reachable from the input node
	 * @param source: the starting node
	 * return list of node reachable from the source node
	 */
	@Override
	public List<Integer> reachable(Integer source) {
		boolean[] visited = new boolean[noOfVertices];
		List<Integer> reachableNode = new ArrayList<Integer>();
		
		findConnected(source, visited);
		for(int i = 0; i < this.noOfVertices; i++) {
			if(visited[i] == true){
				reachableNode.add(i);
			}
		}
		return reachableNode;
	}


    /**
     * method to return minimum spanning tree
     */
    @Override
    public int[] mst() {
        Boolean[] visited = new Boolean[this.noOfVertices];
        Node[] nodeList = new Node[this.noOfVertices];
        int[] parent = new int[this.noOfVertices];
        PriorityQueue<Node> queue = new PriorityQueue<>(this.noOfVertices,
                new comparator());

        for (int i = 0; i < this.noOfVertices; i++) {
            visited[i] = false;
            nodeList[i] = new Node();
            nodeList[i].setWeight(Integer.MAX_VALUE);
            nodeList[i].setVertex(i);
            parent[i] = -1;
        }
        nodeList[0].setWeight(0);

        for (int i = 0; i < this.noOfVertices; i++)
            queue.add(nodeList[i]);

        // Loops until the PriorityQueue is not empty
        while (!queue.isEmpty()) {
            // Extracts a node with min weight value
            Node node0 = queue.poll();
            // Include that node into mstset
            visited[node0.getVertex()] = true;

            // For all adjacent vertex of the extracted vertex V
            for (Node node : this.adjNode[node0.getVertex()]) {
                // If Vertex is in PriorityQueue
                if (visited[node.getVertex()] == false) {
                    // If the key value of the adjacent vertex is more than the
                    // extracted key
                    // update the key value of adjacent vertex to update first
                    // remove and add the updated vertex
                    if (nodeList[node.getVertex()].getWeight() > node
                            .getWeight()) {
                        queue.remove(nodeList[node.getVertex()]);
                        nodeList[node.getVertex()].setWeight(node.getWeight());
                        queue.add(nodeList[node.getVertex()]);
                        parent[node.getVertex()] = node0.getVertex();
                    }
                }
            }
        }
        return parent;
    }


    /**
     * method to find the shortest path 
     * @param source
     * @param destination
     */
    @Override
    public int shortestPath(int source, int destination) {
        if (source < 0 || source >= this.noOfVertices || destination < 0 || destination >= this.noOfVertices)
            throw new AssertionError("Please enter correct input");

        // distance[i] will hold the shortest distance from src to i
        int distance[] = new int[this.noOfVertices];
        // shortestPath[i] will true if vertex i is included in shortest path
        boolean shortestPath[] = new boolean[this.noOfVertices];

        // Initialise all distances as INFINITE
        for (int i = 0; i < this.noOfVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of source vertex from itself is always 0
        distance[source] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < this.noOfVertices - 2; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // minDistanceVertex is always equal to src in first iteration.
            int minDistanceVertex = getMinKeyVertex(distance, shortestPath);

            // Mark the picked vertex as processed
            shortestPath[minDistanceVertex] = true;

            // Update distance value of the adjacent vertices of the picked vertex.
            for (Node edge : adjNode[minDistanceVertex]) {
                int vertex = edge.getVertex();
                // Update distance[v] only if is not in shortestPath, there is an edge from u to v, and
                // total weight of path from src to v through u is smaller than current value of distance[v]
                if (!shortestPath[vertex]
                        && distance[minDistanceVertex] != Integer.MAX_VALUE
                        && distance[minDistanceVertex] + edge.getWeight() < distance[vertex]) {
                    distance[vertex] = distance[minDistanceVertex]
                            + edge.getWeight();
                }
            }
        }
        return distance[destination];
    }

    private int getMinKeyVertex(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < this.noOfVertices; i++)
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        return minIndex;
    }
	
	public static void main(String[] args) {
		GraphImpl graph = new GraphImpl(8);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 5, 5);
		graph.addEdge(3, 4, 2);
		
		System.out.println(graph.isConnected());
		System.out.println("");
		
		System.out.println(graph.reachable(6));
		System.out.println("");
		
		int[] g = graph.mst();
		for(int i = 0; i < g.length; i++) 
			System.out.println(g[i]);
		
		int g1 = graph.shortestPath(0, 5);
		System.out.println("short: " + g1);
	}
}
