##report

####1. Random Graph Generation.

The first part is to create two kinds of random graph with 5000 vertices. 

The first one is to create an undirected graph with certain number of vertices and exact 6 degree for each vertex. The solution immediately comes to mind is that looping through all the vertices. By recording each vertices's degree, we keep trying random vertices for each vertex and add the edge to each vertex. However, this method did not work because there is a high probability that the graph will form a stable stutas before reaching to the last vertex. 


The second one is to create an undirected graph with 20 percent probability that it will connect to all other vertices. Thus, I used a list of arraylist containing edge to represent the graph. The vertices are represented from 0 to 4999.