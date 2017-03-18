import java.lang.Math;

public class maxHeap {
	private int[] vertices; //record the vertices
	private int[] values; // record the vertices' value
	int size = 0;
	
	public maxHeap(graph g) {
		vertices = new int[g.vertices + 1];
		values = new int[g.vertices + 1];
		for (int i = 1; i <=g.vertices; i++){ 
			vertices[i] = 0; 
			values[i] = i;
		}
	}
//	return the vertex with maximum value
	public int Maximum(){
		return vertices[1];
	}
	
	public void insert(int vertex){
		vertices[this.size + 1] = vertex;
		size++;
		heapify(size);
		
	}
	public void delete(int vertex){
		int position = 0;
//		find the vertex's position, swap it with the last vertex, and delete the last vertex;
		for (int i = 1; i < size + 1; i++){
			if (vertices[i] == vertex){
				position = i;
				swap(position, size);
				vertices[size] = 0;
				size--;
				break;
			}
		}
//		heapify the vertex in this position
		heapify(position);
	}
	
	private void heapify(int position){
//		move the vertex up or down to the right position

		int currentVal = values[vertices[position]];
//		go up if position is not 1 and value is larger than father
		if (position > 1 && currentVal >= values[vertices[position / 2]]){
			int fatherVal = values[vertices[position / 2]];
			int h = position;
			while (h > 1 && currentVal >= fatherVal){
				swap(h, h / 2);
				h = h / 2;
			}
//			go down if position is not leaf and value is smaller than maximum child
		}else if(position * 2 <= size && values[vertices[position]] < Math.max(values[vertices[position * 2]], values[vertices[position * 2 + 1]])){
			int h = position;
			int sonVal1 = values[vertices[position * 2]];
			int sonVal2 = values[vertices[position * 2 + 1]];
			
			while (h * 2 <= size && currentVal < Math.max(sonVal2, sonVal1)){
				if (sonVal1 >= sonVal2){
					swap(h, h * 2);
					h = h * 2;
				}else{
					swap(h, h * 2 + 1);
					h = h * 2 + 1;
				}
			}
		}else{ 
			return;
		}
	}
	
	private void swap (int position1,int position2){
		int temp = vertices[position1];
		vertices[position1] = vertices[position2];
		vertices[position2] = temp;
	}
}
	
