import java.util.ArrayList;

public class graph {
	int vertices;
	int edge;
	ArrayList<Edge>[] adj;
	
	public graph(int vertices){
		this.vertices = vertices;
		adj = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++ ){
			adj[i] = new ArrayList<Edge>();
		}
	}
	public void addEdge(Edge e){
		validate(e.start, vertices);
		validate(e.end, vertices);
		this.adj[e.start].add(e);
		this.adj[e.end].add(e);
		edge++;
	}
	private void validate(int start, int vertices){
		if (start < 0 || start >= vertices) throw new IllegalArgumentException("the starting node is not in the right range");
				
	}
}
