package main.arc.visitor;

/**
 * Interface comum a visitantes que realizam percursos em pre order, in order e
 * post order.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public interface PreInPostVisitorInterface {

	/**
	 * Verifica se o percusso foi concluido.
	 * 
	 * @return true se o percusso foi concluido, false caso contrario
	 */
	public boolean isDone();
	
	/**
	 * Visita um objeto em pre order.
	 * 
	 * @param obj Objeto a ser visitado
	 */
	public void preVisit(Object obj);
	
	/**
	 * Visita um objeto em ordem.
	 * 
	 * @param obj Objeto a ser visitado
	 */
	public void inVisit(Object obj);
	
	/**
	 * Visita um objeto em post order.
	 * 
	 * @param obj Objeto a ser visitado
	 */
	public void postVisit(Object obj);
	
}
