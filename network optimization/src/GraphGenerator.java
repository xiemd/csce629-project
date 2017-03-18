import java.util.Random;

public class GraphGenerator { 
	
	public static graph randomGraph1(int vertices, int degree){
		if(vertices * degree % 2 != 0) throw new IllegalArgumentException("vertices * degree must be even number");
		graph g = new graph(vertices);
//		create a list with degree copies of vertices 
		int [] vertexArray = new int[vertices * degree];
		for(int i = 0; i < vertices; i++){
			for (int j = 0; j < degree; j++){
				vertexArray[i * degree + j] = i;
			}
		}
		boolean flag = false;
		Random rand = new Random();
		int count = 0;
		while (!flag){
			count++;
	// 		shuffle the elements
			for (int k = 0; k < vertexArray.length; k++){
				int temp = vertexArray[k];
				int randIndex = rand.nextInt(vertexArray.length);
				vertexArray[k] = vertexArray[randIndex];
				vertexArray[randIndex] = temp;
			}
	// 		connect pair of vertices in order
			for (int l = 0; l < vertices * degree / 2; l++){
				int start = vertexArray[2 * l];
				int end = vertexArray[2 * l + 1];
				Edge e = new Edge(start, end);
	//			if happen to connect the same edge, re-do the shuffle and connecting part
					g.addEdge(e);
				
			}
			if (g.edge == vertices * degree / 2) {
				flag = true;
			}
		System.out.println(count);
		}
		return g;
	}
	public static graph randomGraph2(int vertices, double percentage){
		Random rand = new Random();
		graph g = new graph(vertices);
		
		for (int start = 0; start < vertices; start++){
			for (int end = start + 1; end < vertices; end++){
				double randProbability = rand.nextDouble();
				if (randProbability <= percentage){
					Edge e = new Edge(start,end);
					int randweight = rand.nextInt(20);
					e.weight = randweight;
					g.addEdge(e);
				}
			}
		}
		return g;
	}
}