package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Editorial;

public interface IEditorialService {
	public Integer insert(Editorial le);
	public boolean modificar(Editorial editorial);
	public Optional<Editorial> listarId(int idEditorial);
    public void delete(int idEditorial);
    List<Editorial> list();
}
