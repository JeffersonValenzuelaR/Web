package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Talk;


public interface ITalkService {
	public Integer insert(Talk tl);
	public boolean modificar(Talk talk);
	public Optional<Talk> listarId(int idTalk);
    public void delete(int idTalk);
    List<Talk> list();
    List<Talk> BuscarNombre(String name);
}
