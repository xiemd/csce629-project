import java.util.Random;

public class test {
	public static void main(String[] args){
		graph g = GraphGenerator.randomGraph2(50, 0.2);
		maxHeap H = new maxHeap(g);

		for(int i = 1; i <= 10; i++){
			H.insert(i);
		}
		H.delete(8);
		H.delete(9);
		H.delete(4);
		H.delete(2);
		H.delete(1);
		
		System.out.println(H.Maximum());
		System.out.println(H.size);
	}
}
