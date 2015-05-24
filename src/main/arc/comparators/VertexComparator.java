package main.arc.comparators;

import java.util.Comparator;
import main.arc.domain.Vertex;

public interface VertexComparator extends Comparator<Vertex> {

	public int compare(Vertex v1, Vertex v2);	
}
