package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Forum;
import pe.edu.upc.repository.ForumRepository;
import pe.edu.upc.service.IForumService;

@Service
public class ForumServiceImpl implements IForumService {
	@Autowired
	private ForumRepository fr;
	
	@Override
	@Transactional
	public Integer insert(Forum fo) {
		int rpta = fr.buscarNombreForum(fo.getTopic());
		if(rpta == 0) {
			fr.save(fo);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int idForum) {
		fr.deleteById(idForum);
	}

	@Override
	@Transactional
	public List<Forum> list() {
		return fr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Forum> listarId(int idForums) {
		return fr.findById(idForums);
	}
}
