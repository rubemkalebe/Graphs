package main.arc.iterator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import main.arc.domain.Graph;
import main.arc.domain.Vertex;

public class BreadthFirstIterator implements Iterator {

	private Set<Vertex> visited;
	private Queue<Vertex> queue;
	private Graph graph;
	
	public BreadthFirstIterator(Graph g, Vertex v) {
		// TODO Auto-generated constructor stub
		this.visited = new HashSet<Vertex>();
		this.queue = new LinkedList<Vertex>();
		this.graph = g;
		this.queue.add(v);
		this.visited.add(v);		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !this.queue.isEmpty();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Vertex next = queue.remove();
		try {
			for(Vertex neighbor : this.graph.getNeighbors(next)) {
				if(!this.visited.contains(neighbor)) {
					this.queue.add(neighbor);
					this.visited.add(neighbor);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return next;
	}

}
