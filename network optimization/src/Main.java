import java.util.ArrayList;
import java.util.Random;

public class Main{
	public static void main(String[] args){
		Random rand = new Random();
		int[] s = new int[5];
		int[] t = new int[5];
		graph[] rdg1 = new graph[5];
		graph[] rdg2 = new graph[5];
		
		for (int i = 0; i < 5; i++ ){
			rdg1[i] = GraphGenerator.randomGraph1(5000, 6);
			rdg2[i] = GraphGenerator.randomGraph2(5000, 0.2);

		}
	}
}





