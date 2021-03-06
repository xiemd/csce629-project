import java.lang.Math;
import java.util.Arrays;

public class maxHeap {
	

	int[] vertices; //record the vertices name of the heap
	int[] values; // record the vertices'value
	int[] pos;//record the vertices' position
	int size = 0;
	
//	constructor for testing
	public maxHeap(int number) {
		vertices = new int[number + 1];
		values = new int[number + 1];
		pos = new int[number + 1];
		for (int i = 1; i <= number; i++){ 
			vertices[i] = 0; // i is the position of the heap, value is the vertex's name
			values[i] = 0; // i is the vertex's name, return the value of the vertex
			pos[i] = 0;//i is the vertex's name, return the position on the heap
		}
	}
	
	public maxHeap(graph g) {
		vertices = new int[g.vertices + 1];
		values = new int[g.vertices + 1];
		pos = new int[g.vertices + 1];
		for (int i = 1; i <=g.vertices; i++){ 
			vertices[i] = 0; // i is the position of the heap, value is the vertex's name
			values[i] = 0; // i is the vertex's name, return the value of the vertex
			pos[i] = 0;//i is the vertex's name, return the position on the heap
		}
	}
//	return the vertex with maximum value
	public int Maximum(){
		return vertices[1];
	}
	
	public void insert(int vertex, int value){
		size++;
		vertices[size] = vertex;
		pos[vertex] = size; 
		values[vertex] = value;
		heapify(size);
	}
	public void delete(int vertex){
		int position = pos[vertex];
//		find the vertex's position, swap it with the last vertex, and delete the last vertex;
		swap(position, size);
		vertices[size] = 0;
		pos[vertex] = 0;
		size--;
		heapify(position);
	}
	
	private void heapify(int position){
		
		int father = position / 2;
		int lson = 2 * position;
		int rson = 2 * position + 1;
		int vertex = vertices[position];
//		go up if position is not 1 and value is larger than father
		
		if (position > 1 && values[vertex] >= values[vertices[father]]){
			swap(position, father);
			heapify(father);
		}
//		if the position has one child and smaller than it then swap with it 
		else if (lson == size && values[vertex] < values[vertices[lson]]){
			swap(position, lson);
			return;
		}
//		if the position has two child and smaller than its max child, swap with the larger one
		else if (rson <= size && values[vertex] < Math.max(values[vertices[lson]], values[vertices[rson]])){
			if(values[vertices[lson]] >= values[vertices[rson]]){
				swap(position, lson );
				heapify(lson);
			}else{
				swap(position, rson);
				heapify(rson);
			}
		}
		else return;
	}
	
	public String getValues(){
		return  Arrays.toString(values);
	}
	
	public String getVertices(){
		return  Arrays.toString(vertices);
	}


	private void swap (int position1,int position2){
		int vertex1 = vertices[position1];
		int vertex2 = vertices[position2];
		
//		update the vertex position in verteices[]
		int temp = vertex1;
		vertices[position1] = vertex2;
		vertices[position2] = temp;
		
//		update the pos[] index of those vertices
		int tempPos = pos[vertex1];
		pos[vertex1] = pos[vertex2];
		pos[vertex2] = tempPos;
		
	}
}

	
