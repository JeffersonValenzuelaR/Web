package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Exercise;
import pe.edu.upc.repository.ExerciseRepository;
import pe.edu.upc.service.IExercise_Service;

@Service
public class ExerciseServiceImpl implements IExercise_Service{

	@Autowired
	private ExerciseRepository edR;
	
	@Override
	@Transactional
	public Integer insert(Exercise e) {
		int rpta=0;
		if(rpta == 0) {
			edR.save(e);
		}
		return rpta;
	}
	
	@Override
	@Transactional	
	public boolean modificar(Exercise e) {
		boolean flag = false;
		try {
			edR.save(e);
			flag = true;
		}
		catch (Exception ex){
			System.out.println("Sucedio un roche");
		}
		return flag;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Exercise> listarId(int idExercise){
		return edR.findById(idExercise);
	}

	@Override
	@Transactional
	public void delete(int idExercise) {
		edR.deleteById(idExercise);
	}

	@Override
	@Transactional
	public List<Exercise> list() {
		return edR.findAll();
	}
}
