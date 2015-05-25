package main.arc.persistence;

import main.arc.domain.Graph;

public interface GraphLoader {

	public Graph loadFile(String path);
	
}
