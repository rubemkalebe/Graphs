package main.arc.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import main.arc.domain.Edge;
import main.arc.domain.Graph;
import main.arc.domain.GraphAsAdjancencyList;
import main.arc.domain.GraphAsList;
import main.arc.domain.GraphAsMatrix;
import main.arc.domain.Vertex;

public class KruskalAlgorithm {
	
	private static ArrayList<Edge> e;
	
	private static ArrayList<Integer> ant;
	
	public static Graph kruskal(Graph g) {
		if(g instanceof GraphAsList) {
			return kruskal((GraphAsList) g);
		} else if(g instanceof GraphAsMatrix) {
			return kruskal((GraphAsMatrix) g);
		} else {
			return kruskal((GraphAsAdjancencyList) g);
		}
	}
	
	public static Graph kruskal(GraphAsList g) {
		GraphAsList mst = new GraphAsList() {
		};
		for(Vertex v : g.getVertices()) {
			try {
				mst.addVertex(v);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		e = new ArrayList<Edge>(g.getEdgeList());
		Arrays.sort(e.toArray());
		for(int i = 0; i < g.getVerticesNumber(); i++) {
			ant.add(i, i);
		}
		for(int i = 0; i < e.size(); i++) {
			int u = parent(e.get(i).getVertexA().getVertexID());
			int v = parent(e.get(i).getVertexB().getVertexID());
			if(u != v) {
				ant.add(u, v);
				Edge ed = new Edge(e.get(i).getVertexA(), e.get(i).getVertexB(), e.get(i).getEdgeCost(), false);
				try {
					mst.addEdge(ed);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return mst;
	}
	
	public static Graph kruskal(GraphAsMatrix g) {
		return null;
	}
	
	public static Graph kruskal(GraphAsAdjancencyList g) {
		return null;
	}
	
	private static int parent(int a) {
	    if(a == ant.get(a)) {
	        return a;
	    }
	    ant.add(ant.get(a), parent(ant.get(a)));
	    return ant.get(a);
	}
	
}
