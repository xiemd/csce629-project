import java.util.ArrayList;
import java.util.Random;



public class Graph1 {
	private int degree;
	private final int vertices;
	int edges;
	ArrayList<Edge>[] adj;
	
//  create a graph with the exact vertices and exact degree
	public Graph1(int vertices,int degree) {
		this.degree = degree;
		this.vertices = vertices;
		Random rand = new Random();
		this.adj = (ArrayList<Edge>[])new ArrayList[vertices];
//		initial vertices
		for (int i = 0; i < vertices; i++){
			this.adj[i] = new ArrayList<Edge>();
		}
		
		for (int start = 0; start < vertices; start++ ){
//		randomly add the edge to exactly certain degree for each vertex
			int end;
			while (adj[start].size() < degree){
				end = rand.nextInt(vertices);
				Edge e = new Edge(start, end);
//		make sure start and end are not the same, vertex does not exceed degree, and edge is not duplicate
				if(adj[end].size() < degree && 
				   end != start && 
				   !adj[start].contains(e))
				{
					System.out.println(e);
					adj[start].add(e);
					adj[end].add(e);
					edges++;
				}
			}
		}
	}
	
}
