package dto;

public class LibroDTO {
	
	private String isbn;
	private String nombre;
	private String autor;
	
	public LibroDTO() {
		super();
	}

	public LibroDTO(String isbn) {
		super();
		this.isbn = isbn;
	}

	public LibroDTO(String isbn, String nombre, String autor) {
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
