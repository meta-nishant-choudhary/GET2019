package Graph.com;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

	/**
	 * test case for is connected
	 * @throws Exception
	 */
	@Test
	public void isConnectedTest() throws Exception{
		GraphImpl graph = new GraphImpl(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(true, graph.isConnected());
	}
	
	/**
	 * test case for find reachable node 
	 * @throws Exception
	 */
	@Test
	public void reachableTest() throws Exception{
		GraphImpl graph = new GraphImpl(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(new ArrayList(Arrays.asList(0,1,2,3,4)),graph.reachable(1));
	}
	
	/**
	 * test case for minimum spanning tree
	 * @throws Exception
	 */
	@Test
	public void mstTest() throws Exception{
		GraphImpl graph = new GraphImpl(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertArrayEquals(new int[]{-1, 0,3,0,3}, graph.mst());
		
	}
	
	/**
	 * test case for shortest path
	 * @throws Exception
	 */
	@Test
	public void shortestPathTest() throws Exception{
		GraphImpl graph = new GraphImpl(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(9, graph.shortestPath(1, 4));
		
	}
	
}