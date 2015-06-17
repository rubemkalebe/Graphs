package main.java.byteland;

import main.arc.algorithms.KruskalAlgorithm;
import main.arc.domain.Edge;
import main.arc.domain.GraphAsList;
import main.arc.iterator.Iterator;

public class Main {

	public static void main(String[] args) {
		
		Byteland graph = new Byteland();
		FileLoader loader = new FileLoader(args[0]);
		int verticesNumber = loader.readVerticesNumber();
		int edgesNumber = loader.readEdgesNumber();
		graph.initializeVertices(verticesNumber);
		loader.readEdges(graph, edgesNumber);
		GraphAsList mst = (GraphAsList) KruskalAlgorithm.kruskal(graph);
		
		Iterator mstIT = mst.createEdgeIterator();
		Iterator bytelandIT = graph.createEdgeIterator();
		int totalCost = 0, mstCost = 0;
		
		while(bytelandIT.hasNext()) {
			Edge e = (Edge) bytelandIT.next();
			totalCost += e.getEdgeCost();
		}
		
		while(mstIT.hasNext()) {
			Edge e = (Edge) mstIT.next();
			mstCost += e.getEdgeCost();
		}
		
		System.out.println(totalCost - mstCost);
		
	}
	
}
