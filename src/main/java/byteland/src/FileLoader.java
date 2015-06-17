package main.java.byteland.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import main.arc.domain.Edge;

public class FileLoader {

	private String path;
	
	public FileLoader(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}
	
	public int readVerticesNumber() {
		int v = 0;
		try {
			Scanner scan = new Scanner(new FileReader(path));
			if(scan.hasNextInt()) {
				v = scan.nextInt();
				scan.close();
				return v;
			}
			System.err.println("Problema na leitura do arquivo \'" 
					+ path + "\'");
			scan.close();
			throw new NoSuchElementException("Estão faltando informações" +
					"sobre as restrinções da rede");
		} catch(FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
		return v;
	}
	
	public int readEdgesNumber() {
		int e = 0;
		try {
			Scanner scan = new Scanner(new FileReader(path));
			if(scan.hasNextInt()) {
				scan.nextInt();
				if(scan.hasNextInt()) {
					e = scan.nextInt();
					scan.close();
					return e;
				}
			}
			System.err.println("Problema na leitura do arquivo \'" 
					+ path + "\'");
			scan.close();
			throw new NoSuchElementException("Estão faltando informações" +
					"sobre as restrinções da rede");
		} catch(FileNotFoundException e1) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
		return e;
	}
	
	public void readEdges(Byteland g, int edges) {
		try {
			Scanner scan = new Scanner(new FileReader(path));
			if(scan.hasNextInt()) {
				scan.nextInt();
				if(scan.hasNextInt()) {
					scan.nextInt();
				}
			}
			for(int i = 0; i < edges; i++) {
				int v1 = scan.nextInt();
				int v2 = scan.nextInt();
				int weight = scan.nextInt();
				Edge e = new Edge(g.getVertex(v1), g.getVertex(v2), i, weight, false);
				g.addEdge(e);
			}
			scan.close();
		} catch(FileNotFoundException e1) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
