package pe.edu.upc.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeuser")
public class TypeUser implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeUser;
	
	@Column(name="typeuserName", nullable=false, length=30)
	private String typeuserName;

	public int getIdTypeUser() {
		return idTypeUser;
	}

	public void setIdTypeUser(int idTypeUser) {
		this.idTypeUser = idTypeUser;
	}

	public String getTypeuserName() {
		return typeuserName;
	}

	public void setTypeuserName(String typeuserName) {
		this.typeuserName = typeuserName;
	}

	
}
