package pe.edu.upc.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.DetailsForum;
import pe.edu.upc.repository.DetailsForumRepository;
import pe.edu.upc.service.IDetailsForumService;

@Service
public class DetailsForumServiceImpl implements IDetailsForumService{

	
	@Autowired
	private DetailsForumRepository dfR;
	
	@Override
	@Transactional
	public Integer insert(DetailsForum df) {
		int rpta=0;
		if(rpta == 0) {
			dfR.save(df);
		}
		return rpta;
	}

	@Override
	@Transactional
	public boolean modificar(DetailsForum detailsforum) {
		boolean flag = false;
		try {
			dfR.save(detailsforum);
			flag = true;
		}
		catch (Exception ex){
			System.out.println("Sucedio un roche");
		}
		return flag;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetailsForum> listarId(int idDetails) {
		return dfR.findById(idDetails);
	}

	@Override
	@Transactional
	public void delete(int idDetails) {
		dfR.deleteById(idDetails);
	}

	@Override
	@Transactional
	public List<DetailsForum> list() {
		return dfR.findAll();
	}

	@Override
	@Transactional
	public DetailsForum BuscarDetalledeForo(String question) {
		
		return dfR.BuscarPregunta(question);
	}

	@Override
	public Optional<DetailsForum> listarIdxIdForo(int idForo) {
		
		return dfR.BuscardetallexidForo(idForo);
	}

}
