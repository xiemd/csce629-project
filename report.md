##Report 

####1. Random Graph Generation.


The first part is to create two kinds of random graph with 5000 vertices.Before constructing the random graph, I create two basic class graph and Edge.  

The first one is to create an undirected graph with certain number of vertices and exact 6 degree for each vertex. The solution immediately comes to mind is that looping through all the vertices. By recording each vertices's degree, we keep generating random vertices for  and add the edge to each vertex if the degree of both vertices are not exceeding the degree. However, this method did not work because there is a high probability that the graph will form a stable stutas before reaching to the last vertex. Thus, we need to regenerate it when the looping time exceed certain times. I choose that if the random generation of vertex exceed 6 times of the total of expected edges' number, then the entire graph is generated again. The following are the major adding conditions and the re-generate conditions. Then randomly generate the positive edge weigth between 0 and 100 and assign it to these edges.
	
	while(d[i] < degree)
		if (j++ == 3 * 6 * g.vertices) break;
		...
		if (d[i] < degree && d[end] < degree )
			...
			if (!g.adj[i].contains(e))
			...

The second one is to create an undirected graph with 20 percent probability that it will connect to all other vertices. Thus, I loop through all the vertex. For each vertex, connect it with all the other vertex determined by generating a float number which is between 0 and 1. If the number is smaller or equal to the percentage 0.2, add an edge between these two vertices. Then randomly generate the positive edge weigth between 0 and 100 and assign it to these edges.

####2. Algorithm
There are three algorithm to be implemented in this part.The first one is the Dijkstra Alogorithm without using heap data-structure. 
