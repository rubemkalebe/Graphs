package main.arc.comparators;

import java.util.Comparator;
import main.arc.domain.Edge;

public interface EdgeComparator extends Comparator<Edge> {

	public int compare(Edge e1, Edge e2);
	
}
