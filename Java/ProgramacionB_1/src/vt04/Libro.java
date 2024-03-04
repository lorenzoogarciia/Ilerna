package vt04;
import java.util.Scanner;

public class Libro {
	//Definicion de atributos
	private String isbn;
	private String autor;
	private String titulo;
	private int publi;
	private String editorial;
	private int numPag;
	
	
	//Definicion de metodos get y set
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	
	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	
	public int getPubli() {return publi;}
	public void setPubli(int publi) {this.publi = publi;}
	
	public String getEditorial() {return editorial;}
	public void setEditorial(String editorial) {this.editorial = editorial;}
	
	public int getNumPag() {return numPag;}
	public void setNumPag(int numPag) {this.numPag = numPag;}
	
	//Definicion de constructores
	
	//Constructor con parametros
	public Libro(String isbn, String autor, String titulo, int publi, String editorial, int numPag) {
		this.isbn=isbn;
		this.autor=autor;
		this.titulo=titulo;
		this.publi=publi;
		this.editorial=editorial;
		this.numPag=numPag;
	}
	
	
	//Definicion de métodos
	public void mostrarDatos(Libro l) {
		System.out.println("ISBN: " + l.getIsbn());
		System.out.println("Autor: " + l.getAutor());
		System.out.println("Titulo: " + l.getTitulo());
		System.out.println("Año de Publicación: " + l.getPubli());
		System.out.println("Editorial:" + l.getEditorial());
		System.out.println("Número de Páginas: " + l.getNumPag());
	}
	
	
	
}	

