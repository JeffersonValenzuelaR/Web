package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Users;
import pe.edu.upc.repository.UserRepository;
import pe.edu.upc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository usR;
	
	@Override
	@Transactional
	public Integer insert(Users u) {
		int rpta=0;
		if(rpta == 0) {
			usR.save(u);
		}
		return rpta;
	}

	@Override
	@Transactional	
	public boolean modificar(Users user) {
		boolean flag = false;
		try {
			usR.save(user);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void delete(int idUser) {
		usR.deleteById(idUser);
	}

	@Override
	@Transactional
	public List<Users> list() {
		return usR.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Users> listarId(int idUser) {
		// TODO Auto-generated method stub
		return usR.findById(idUser);
	}

	@Override
	public Users getAccount(String username) {
		
		return usR.findByUserAccount(username);
	}

}
