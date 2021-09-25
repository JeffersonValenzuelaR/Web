package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.TypeExercise;
import pe.edu.upc.repository.Type_ExerciseRepository;
import pe.edu.upc.service.IType_ExerciseService;

@Service
public class Type_ExerciseServiceImpl implements IType_ExerciseService{
	
	@Autowired
	private Type_ExerciseRepository leR;
	
	@Override
	@Transactional
	public Integer insert(TypeExercise ed) {
		int rpta = 0;
		if(rpta == 0) {
			leR.save(ed);
		}
		return rpta;
	}
	

	@Override
	@Transactional
	public void delete(int idType_Exercise) {
		leR.deleteById(idType_Exercise);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TypeExercise> list() {
		return leR.findAll();
	}
}
