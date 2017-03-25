import java.util.ArrayList;

public class graph {
	int vertices;
	int edge;
	ArrayList<Edge>[] adj;
	
	public graph(int vertices){
		this.vertices = vertices;
		this.edge = 0;
		adj = new ArrayList[vertices + 1];
		for (int i = 1; i <= vertices; i++ ){
			adj[i] = new ArrayList<Edge>();
		}
	}
	public void addEdge(int start, int end, int weight){
		Edge e = new Edge(start, end);
		e.weight = weight;
		if (!this.adj[start].contains(e)){
			this.adj[start].add(e);
			this.adj[end].add(e);
			edge++;
		}
	}
	
	public int getWeight(int start, int end){
		int result = 0;
		ArrayList<Edge> list = adj[start];
		for (Edge e : list){
//			if the edge's end is equal to the parameter start, then compare the start with parameter end
			if (e.end == start){
				if (e.start == end){
					result = e.weight;
					break;
				}
			}else
//			means the edge's start is the parameter start;
			{
				if (e.end == end){
					result = e.weight;
					break;
				}
			}

		}
		return result;
	}
}
	
