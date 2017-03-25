import java.util.Arrays;
import java.util.Random;

public class GraphGenerator { 
	
	public static graph randomGraph1(int vertices, int degree){
		if(vertices * degree % 2 != 0) throw new IllegalArgumentException("vertices * degree must be even number");
		graph g = new graph(vertices);

//		record the degree of each vertex
		int[] d = new int[vertices + 1];
		Arrays.fill(d, 0);
		Random rand = new Random();
		int start = 0;
		int end = 0;
		
		while (g.edge < (degree * vertices / 2)){
			end = rand.nextInt(vertices) + 1;
			start = rand.nextInt(vertices) + 1;
			
			if (d[start] < 6 && d[end] < 6 && start != end){
				Edge e = new Edge(start, end);
				if (!g.adj[start].contains(e)){
					g.addEdge(start, end, rand.nextInt(100));
					System.out.println(e);
					d[start]++;
					d[end]++;
				}
			}
		}
		return g;
	}
	
// 	random graph 2
	public static graph randomGraph2(int vertices, double percentage){
		Random rand = new Random();
		graph g = new graph(vertices);
		
		for (int start = 1; start <= vertices; start++){
			for (int end = start + 1; end <= vertices; end++){
				double randProbability = rand.nextDouble();
				if (randProbability <= percentage){
					g.addEdge(start, end, rand.nextInt(100));
				}
			}
		}
		return g;
	}
}
