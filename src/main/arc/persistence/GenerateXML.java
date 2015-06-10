package main.arc.persistence;

import java.util.ArrayList;

import main.arc.domain.Edge;
import main.arc.domain.Graph;
import main.arc.domain.GraphAsAdjancencyList;
import main.arc.domain.GraphAsList;
import main.arc.domain.GraphAsMatrix;
import main.arc.domain.Vertex;

/**
 * Classe responsável por gerar o XML do grafo.
 * 
 * 
 * @author Rubem Kalebe 
 * @author Pedro Coelho
 * @version 6.06.2015
 */


public class GenerateXML {
	private StringBuffer arquivo = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n<graph>");
	
	public GenerateXML(Graph g){
		if(g instanceof GraphAsList)
			this.GenXML((GraphAsList)g);
		else if(g instanceof GraphAsMatrix)
			this.GenXML((GraphAsMatrix)g);
		else
			this.GenXML((GraphAsAdjancencyList)g);
	}
	

	private void GenXML(GraphAsList gl){
//		Gera o xml dos vértices
		for(int i =0; i < gl.getVertices().size(); i++){
			this.genVertex(gl.getVertices().get(i));
		}
//		Gera o xml das arestas
		for(int i=0; i < gl.getEdgeList().size(); i++){
			this.genEdges(gl.getEdgeList().get(i));
		}
		this.closeXML();
	}
	
	private void GenXML(GraphAsMatrix gm){
//		Gera o xml dos vértices
		for(int i =0; i< gm.getVertices().size(); i++){
			this.genVertex(gm.getVertices().get(i));
		}
//		Gera o xml das arestas
		int c = 0;
		int[][] aux = gm.getMatrix();
		for(int i =0; i < gm.getVertices().size(); i++){
			for(int j =0; j < gm.getVertices().size(); j++){
				if(gm.isEdge(i, j)){
					this.genEdges(new Edge(gm.getVertices().get(i), gm.getVertices().get(j), c, 0, false));
					c++;
				}
			}	
		}
	}
	
	private void GenXML(GraphAsAdjancencyList gAL){
//		Gera o xml dos vértices
		for(int i =0; i < gAL.getVertices().size(); i++){
			this.genVertex(gAL.getVertices().get(i));
		}
//		Gera o XML das arestas
		
	}
	
	
	
	public void genVertex(Vertex v1){
		this.arquivo.append("\n\t<vertex id=\"").append(v1.getVertexID()).append("\">");
	}
	
	public void genEdges(Edge e){
		this.arquivo.append("\n\t<edge id=\"").append(e.getEdgeID()).append("\" source=\"").
		append(e.getVertexA().getVertexID()).
		append("\" target=\"").append(e.getVertexB().getVertexID()).append("\">");
	}
	
	public void closeXML(){
		this.arquivo.append("\n</graph>");	
	}
	
	public StringBuffer getXML(){
		return this.arquivo;
	}
	
}
