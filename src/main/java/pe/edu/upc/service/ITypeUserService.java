package pe.edu.upc.service;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TypeUser;

public interface ITypeUserService {
	public Integer insert(TypeUser tu);
    public void delete(int idTypeUser);
    List<TypeUser> list();
    Optional<TypeUser> Obtener(int idTypeUser);
}
