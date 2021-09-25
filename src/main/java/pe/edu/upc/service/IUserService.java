package pe.edu.upc.service;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Users;
public interface IUserService {
	public Integer insert(Users u);
	public boolean modificar(Users user);
	public Optional<Users> listarId(int idUser);
    public void delete(int idUser);
    List<Users> list();
    
    public Users getAccount(String username);
}
