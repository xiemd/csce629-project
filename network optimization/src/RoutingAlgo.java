import java.util.ArrayList;
import java.util.Arrays;

public class RoutingAlgo {
//	Max-Bandwidth-Path from djkstra's algorithm without heap
	public static int[] algo1(graph g, int s, int t){
//		initial the bandwidth, data and fringe array
		int[] bandwidth = new int[g.vertices + 1];
		int[] dad = new int[g.vertices + 1];
		int[] status = new int[g.vertices + 1];

		Arrays.fill(bandwidth, 101); //the maximum weight i set is 100
		Arrays.fill(dad, -1);
		Arrays.fill(status, 0); //unseen = 0 , fringe = 1, in-tree = 2
		
//		initial the source and fringe
		dad[s] = 0;
		bandwidth[s] = 0;
		status[s] = 2;
		ArrayList<Edge> sourceList = g.adj[s];
		for(Edge e: sourceList){
			int end = e.end;
			status[end] = 1;
			dad[end] = s;
			bandwidth[end] = g.getWeight(s, end);
		}
//		pick the maximum fringe, if the end vertex is unseen, put it in-tree, else update the vertex
		while (notInTree(status)){
			int maxFringe = findMax(bandwidth, status);
			status[maxFringe] = 2;
			
			ArrayList<Edge> list = g.adj[maxFringe];
			for (Edge e: list){
				if (status[e.end] == 0){
					status[e.end] = 1;
					dad[e.end] = maxFringe;
//					update the bandwidth with the smaller one of maxFringe and the edge weight
					bandwidth[e.end] = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end));
//					update the bandwidhth if the new bandwidth is larger than the previous one
				}else if (status[e.end] == 1 && 
						Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end)) > bandwidth[e.end]){
					dad[e.end] = maxFringe;
					bandwidth[e.end] = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end));
				}
			}
		}
		return dad;
	}
//	Max-Bandwidth-Path from djkstra's algorithm with heap
	public static int[] algo2(graph g, int s, int t){
		initial the bandwidth, data and fringe array
		int[] bandwidth = new int[g.vertices + 1];
		int[] dad = new int[g.vertices + 1];
		int[] status = new int[g.vertices + 1];

		Arrays.fill(bandwidth, 101); //the maximum weight i set is 100
		Arrays.fill(dad, -1);
		Arrays.fill(status, 0); //unseen = 0 , fringe = 1, in-tree = 2
		
//		initial the source and fringe
		dad[s] = 0;
		bandwidth[s] = 0;
		status[s] = 2;
		ArrayList<Edge> sourceList = g.adj[s];
		for(Edge e: sourceList){
			int end = e.end;
			status[end] = 1;
			dad[end] = s;
			bandwidth[end] = g.getWeight(s, end);
		}
//		pick the maximum fringe, if the end vertex is unseen, put it in-tree, else update the vertex
		while (notInTree(status)){
			int maxFringe = findMax(bandwidth, status);
			status[maxFringe] = 2;
			
			ArrayList<Edge> list = g.adj[maxFringe];
			for (Edge e: list){
				if (status[e.end] == 0){
					status[e.end] = 1;
					dad[e.end] = maxFringe;
//					update the bandwidth with the smaller one of maxFringe and the edge weight
					bandwidth[e.end] = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end));
//					update the bandwidhth if the new bandwidth is larger than the previous one
				}else if (status[e.end] == 1 && 
						Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end)) > bandwidth[e.end]){
					dad[e.end] = maxFringe;
					bandwidth[e.end] = Math.min(bandwidth[maxFringe], g.getWeight(maxFringe, e.end));
				}
			}
		}
		return dad;
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
}
