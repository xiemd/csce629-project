import java.util.Arrays;
import java.util.Random;

public class GraphGenerator { 
	
	public static graph randomGraph1(int vertices, int degree){
		if(vertices * degree % 2 != 0) throw new IllegalArgumentException("vertices * degree must be even number");	

		graph g = new graph(vertices);
		int[] d = new int[vertices + 1];
		Random rand = new Random();
		while(g.edge < vertices * degree / 2 ){
			g = new graph(vertices);
			d = new int[vertices + 1];
			for (int i = 1; i < g.vertices; i++){
//				record each vertex's adding count
				int j = 0;
				while(d[i] < degree){
//					if the count exceed a certain time, then break
					if (j++ == 3 * 6 * g.vertices){
						break;
					}
					int end = rand.nextInt(vertices - i) + i +1;
					if (d[i] < degree && d[end] < degree ){
						Edge e = new Edge(i, end);
						if (!g.adj[i].contains(e)){
							g.addEdge(i, end, rand.nextInt(100));
//							System.out.println(e);
							d[i]++;
							d[end]++;
						}
					}
				}
			}
		}
		System.out.println(g.edge);
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
		System.out.println(g.edge);
		return g;
	}
}
