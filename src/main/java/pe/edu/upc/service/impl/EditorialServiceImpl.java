package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Editorial;
import pe.edu.upc.repository.EditorialRepository;
import pe.edu.upc.service.IEditorialService;


@Service
public class EditorialServiceImpl implements IEditorialService{

	@Autowired
	private EditorialRepository edR;
	
	@Override
	@Transactional
	public Integer insert(Editorial ed) {
		int rpta = edR.buscarNombreEditorial(ed.getName_Editorial());
		if(rpta == 0) {
			edR.save(ed);
		}
		return rpta;
	}
//---------------------------------------------
	@Override
	@Transactional	
	public boolean modificar(Editorial editorial) {
		boolean flag = false;
		try {
			edR.save(editorial);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Editorial> listarId(int idEditorial) {
		return edR.findById(idEditorial);		
	}
//-----------------------------------------------
	@Override
	@Transactional
	public void delete(int idEditorial) {
		edR.deleteById(idEditorial);
	}

	@Override
	@Transactional
	public List<Editorial> list() {
		return edR.findAll();
	}
}
