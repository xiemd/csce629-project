import java.util.ArrayList;
import java.util.Random;

public class Main{
	public static void main(String[] args){
		
		Random rand = new Random();
		graph[] rdg1 = new graph[5];
		graph[] rdg2 = new graph[5];
	
		for (int i = 0; i < 5; i++ ){
//			while(s[i] == t[i]){
//				s[i] = rand.nextInt(5000);
//				t[i] = rand.nextInt(5000);
//			}
//			generate the graph and add path from s to t to go through all other vertices.
			rdg1[i] = GraphGenerator.randomGraph1(5000, 6);
			rdg2[i] = GraphGenerator.randomGraph2(5000, 0.2);
		}
		System.out.println("the graph generation is done!");
		
//		main testing part

		System.out.println("");
		System.out.println("Start the test:");
		for (int i = 0; i < 5; i++ ){
			System.out.println(i + 1 + " graphs");
			for (int j = 0; j < 5; j++){
				System.out.println(j + 1  + " pair of (s,t) of graph pair" + (i+1));
				int s = rand.nextInt(5000);
				int t = rand.nextInt(5000);
				rdg1[i].addAllPath(s, t);
				rdg2[i].addAllPath(s, t);
				
				System.out.println("");
				long start1 = System.currentTimeMillis();
				RoutingAlgo.algo1(rdg1[i], s, t);
				long end1   = System.currentTimeMillis();
				long total1 = end1 - start1;
				System.out.println("rdg1 time on algorithm 1 is: " + total1 + "ms");
				
				long start2 = System.currentTimeMillis();
				RoutingAlgo.algo2(rdg1[i], s, t);
				long end2   = System.currentTimeMillis();
				long total2 = end2 - start2;
				System.out.println("rdg1 time on algorithm 2 is: " + total2+ "ms");
				
				long start3 = System.currentTimeMillis();
				RoutingAlgo.algo3(rdg1[i], s, t);
				long end3   = System.currentTimeMillis();
				long total3 = end3 - start3;
				System.out.println("rdg1 time on algorithm 3 is: " + total3+ "ms");

				
				System.out.println("");
				long start4 = System.currentTimeMillis();
				RoutingAlgo.algo1(rdg2[i], s, t);
				long end4   = System.currentTimeMillis();
				long total4 = end4 - start4;
				System.out.println("rdg2 time on algorithm 1 is: " + total4+ "ms");
				
				long start5 = System.currentTimeMillis();
				RoutingAlgo.algo2(rdg2[i], s, t);
				long end5   = System.currentTimeMillis();
				long total5 = end5 - start5;
				System.out.println("rdg2 time on algorithm 2 is: " + total5+ "ms");

				
				long start6 = System.currentTimeMillis();
				RoutingAlgo.algo3(rdg2[i], s, t);
				long end6   = System.currentTimeMillis();
				long total6 = end6 - start6;
				System.out.println("rdg2 time on algorithm 3 is:" +total6+ "ms");
			}
		}
	}
}




