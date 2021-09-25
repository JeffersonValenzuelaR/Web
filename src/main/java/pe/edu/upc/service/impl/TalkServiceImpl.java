package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Talk;
import pe.edu.upc.repository.TalkRepository;

import pe.edu.upc.service.ITalkService;

@Service
public class TalkServiceImpl implements ITalkService{
	
	@Autowired
	private TalkRepository tlr;
	
	@Override
	@Transactional
	public Integer insert(Talk tl) {
		int rpta = tlr.buscarNombreTalk(tl.getRoomName());
		if(rpta == 0) {
			tlr.save(tl);
		}
		return rpta;
	}
	
	@Override
	@Transactional	
	public boolean modificar(Talk talk) {
		boolean flag = false;
		try {
			tlr.save(talk);
			flag = true;
		}
		catch (Exception ex){
			System.out.println("Sucedio un roche");
		}
		return flag;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Talk> listarId(int idTalk){
		return tlr.findById(idTalk);
	}

	@Override
	@Transactional
	public void delete(int idTalk) {
		tlr.deleteById(idTalk);
	}

	@Override
	@Transactional
	public List<Talk> list() {
		return tlr.findAll();
	}
	
	@Override
	@Transactional
	public List<Talk> BuscarNombre(String name) {
		return tlr.buscarcharla(name);
	}
	
}
