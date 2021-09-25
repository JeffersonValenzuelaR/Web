package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBook;

	@Column(name = "name_Book", nullable = false, length = 30)
	private String name_Book;
	
	@Column(name = "numberpages_Book", nullable = false, length = 30)
	private String numberpages_Book;
	
	@ManyToOne
    @JoinColumn(name = "idEditorial")
    private Editorial editorial;
	
	@Column(name="enlace", nullable=false, length=100)
	private String enlace;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int idBook, String name_Book, String numberpages_Book, Editorial editorial, String enlace) {
		super();
		this.idBook = idBook;
		this.name_Book = name_Book;
		this.numberpages_Book = numberpages_Book;
		this.editorial = editorial;
		this.enlace = enlace;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getName_Book() {
		return name_Book;
	}

	public void setName_Book(String name_Book) {
		this.name_Book = name_Book;
	}

	public String getNumberpages_Book() {
		return numberpages_Book;
	}

	public void setNumberpages_Book(String numberpages_Book) {
		this.numberpages_Book = numberpages_Book;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	
	
	
	
	
	
	
	
	

}
