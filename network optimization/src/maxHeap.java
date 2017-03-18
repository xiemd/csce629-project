import java.beans.DefaultPersistenceDelegate;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class maxHeap {
	private int[] vertices; //record the vertices
	private int[] values; // record the vertices' value
	private int size = 0;
	
	public maxHeap(graph g) {
		vertices = new int[g.vertices + 1];
		values = new int[g.vertices + 1];
		for (int i = 1; i <= g.vertices; i++){ 
			vertices[i] = 0; 
			values[i] = 0;
		}
	}
	public int Maximum(){
		return vertices[1];
	}
	
	public void insert(int vertex){
		vertices[this.size + 1] = vertex;
		heapify(vertex);
		size++;
	}
	public void delete(int vertex){
		int position = 0;
//		find the vertex's position, swap it with the last vertex, and delete the last vertex;
		for (int i = 1; i < size + 1; i++){
			if (vertices[i] == vertex){
				position = i;
				vertices[position] = vertices[size];
				vertices[size] = 0; 
				size--;
				break;
			}
		}
//		heapify the vertex in this position
		heapify(vertices[position]);
	}
	
	public void heapify(int vertex){
//		move the vertex up or down to the right position
		
	}
	
}
	
