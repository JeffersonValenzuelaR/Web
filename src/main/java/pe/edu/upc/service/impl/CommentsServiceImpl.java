package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Comments;
import pe.edu.upc.repository.CommentsRepository;
import pe.edu.upc.service.ICommentsService;

@Service
public class CommentsServiceImpl implements ICommentsService{

	@Autowired
	private CommentsRepository cmR;

	@Override
	@Transactional
	public Integer insert(Comments cm) {
		int rpta=0;
		if(rpta == 0) {
			cmR.save(cm);
		}
		return rpta;
	}

	@Override
	@Transactional
	public List<Comments> list() {
		return cmR.findAll();
	}
}
