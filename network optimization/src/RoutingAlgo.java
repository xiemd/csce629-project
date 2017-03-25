import java.util.ArrayList;
import java.util.Arrays;

public class RoutingAlgo {
//	Max-Bandwidth-Path from djkstra's algorithm without heap
	public static int algo1(graph g, int s, int t){
//		initial the bandwidth, data and fringe array
		int[] bandwidth = new int[g.vertices + 1];
		int[] dad = new int[g.vertices + 1];
		int[] status = new int[g.vertices + 1];
		
		Arrays.fill(status, 0); //unseen = 0 , fringe = 1, in-tree = 2
		
//		initial the source and fringe
		dad[s] = 0;
		bandwidth[s] = 101;//the maximum weight i set is 100
		status[s] = 2;
		ArrayList<Edge> newfringe = g.adj[s];
		for(Edge e: newfringe){
			int end = e.end;
			if(s == e.end){
				end = e.start;
			}
			status[end] = 1;
			dad[end] = s;
			bandwidth[end] = g.getWeight(s, end);
		}
//		pick the maximum fringe, if the end vertex is unseen, put it in-tree, else update the vertex
		while (status[t] != 2){
			int maxFringe = findMax(bandwidth, status);
			status[maxFringe] = 2;
			ArrayList<Edge> list = g.adj[maxFringe];
			for (Edge e: list){
//				decide the end of the edge which is not the same as maxFringe
				int end = e.end;
				if(maxFringe == e.end){
					end = e.start;
				}
				
				int endWeight = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, end));
				
				if (status[end] == 0){
					status[end] = 1;
					dad[end] = maxFringe;
					bandwidth[end] = endWeight;

				}else if (status[end] == 1 && 
						endWeight > bandwidth[end])
				{
					dad[end] = maxFringe;
					bandwidth[end] = endWeight;
				}
			}
		}
		return bandwidth[t];
	}

	
	//	Max-Bandwidth-Path from djkstra's algorithm with heap
	public static int algo2(graph g, int s, int t){
//		initial the bandwidth, data and fringe array
		int[] bandwidth = new int[g.vertices + 1];
		int[] dad = new int[g.vertices + 1];
		int[] status = new int[g.vertices + 1];
		maxHeap H = new maxHeap(g);

		
//		initial the source and fringe
		dad[s] = 0;
		bandwidth[s] = 101;
		status[s] = 2;
		ArrayList<Edge> newfringe = g.adj[s];
		for(Edge e: newfringe){
//			decide the end of the edge which is not the same as maxFringe
			int end = e.end;
			if(s == end){
				end = e.start;
			}
			status[end] = 1;
			dad[end] = s;
			bandwidth[end] = g.getWeight(s, end);
			H.insert(end, bandwidth[end]);
		}
//		pick the maximum fringe, if the end vertex is unseen, put it in-tree, else update the vertex
		while (status[t] != 2){
			int maxFringe = H.Maximum();
			H.delete(maxFringe);
			status[maxFringe] = 2;
			
			ArrayList<Edge> fringeList = g.adj[maxFringe];
			for (Edge e: fringeList){
				int end = e.end;
				if(maxFringe == e.end){
					end = e.start;
				}
				int endWeight = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, end));
				
				if (status[end] == 0) 
//				the vertex is unseen, just assign the endweight to the bandwidth[end]
				{
					status[end] = 1; 
					bandwidth[end] = endWeight;
					H.insert(end,bandwidth[end]);
					dad[end] = maxFringe;
				}
				else if (status[end] == 1 && 
						endWeight > bandwidth[end])
/* 				the vertex is already fringe and 
				new endweight larger than previous bandwidth*/
				{
					H.delete(end);
					dad[end] = maxFringe;
					bandwidth[end] = endWeight;
					H.insert(end,bandwidth[end]);
				}
			}
		}
		return bandwidth[t];
	}

	
	//	Max-Bandwidth-Path from Kruskal algo
	public static int[] algo3(graph g, int s, int t){
		
	}
	
	private static int findMax(int[] bandwidth, int[] status ){
		int index = 0;
		int max = 0;
		for (int i = 1; i < status.length;i++){
//			if the status is fringe,update the max
			if(status[i] == 1 && bandwidth[i] > max){
				index = i;
				max = bandwidth[i];
			}
		}
		return index;
	}
	private static boolean notInTree(int[] status){
		for (int i : status){
			if (i == 0 || i == 1){
				return true;
			}
		}
		return false;
	}
//	for kruscal algorithm
	private class node{
		private int vertex;
		private int weight;
		
		
	}
}
