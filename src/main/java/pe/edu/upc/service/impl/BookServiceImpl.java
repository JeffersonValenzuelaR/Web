package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Book;
import pe.edu.upc.repository.BookRepository;
import pe.edu.upc.service.IBook_Service;

@Service
public class BookServiceImpl implements IBook_Service{

	@Autowired
	private BookRepository edR;
	
	@Override
	@Transactional
	public Integer insert(Book b) {
		int rpta=0;
		if(rpta == 0) {
			edR.save(b);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int idBook) {
		edR.deleteById(idBook);
	}

	@Override
	@Transactional
	public List<Book> list() {
		return edR.findAll();
	}
	
	@Override
	@Transactional
	public List<Book> BuscarNombre(String name) {
		return edR.buscarlibro(name);
	}
}
