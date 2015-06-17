package main.java.byteland.src;

import main.arc.domain.GraphAsList;

public class Byteland extends GraphAsList {

	public Byteland() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void initializeVertices(int n) {
		for (int i = 0; i < n; i++) {
			Junction j = new Junction(i);
			try {
				this.addVertex(j);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
