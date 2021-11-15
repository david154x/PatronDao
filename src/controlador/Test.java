package controlador;

import dao.LibroDAO;
import dto.LibroDTO;

public class Test {
	
	public static void main(String args[]) {
		
		LibroDAO l = new LibroDAO();
		LibroDTO libroNuevo = new LibroDTO("111", "Cien años de soledad", "Gabriel Garcia Marquez");
		//l.create(libroNuevo);
		LibroDTO libroABuscar = l.read("111");
		System.out.println(libroABuscar.getAutor());
		
	}
	
}
