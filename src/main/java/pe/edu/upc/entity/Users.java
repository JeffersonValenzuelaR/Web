package pe.edu.upc.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(name="email", nullable=false, length=30)
	private String email;

	@Column(name="username", nullable=false, length=30)
	private String username;
	
	@Column(name="password", nullable=false, length=200)
	private String password;
	
	@Column(name="numphone", nullable=false, length=30)
	private String numphone;
	
	@Column(name="namecity", nullable=false, length=30)
	private String namecity;
	
	@Column(name="namecountry", nullable=false, length=30)
	private String namecountry;
	
	@ManyToOne
    @JoinColumn(name = "idTypeUser")
    private TypeUser typeuser;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumphone() {
		return numphone;
	}

	public void setNumphone(String numphone) {
		this.numphone = numphone;
	}

	public String getNamecity() {
		return namecity;
	}

	public void setNamecity(String namecity) {
		this.namecity = namecity;
	}

	public String getNamecountry() {
		return namecountry;
	}

	public void setNamecountry(String namecountry) {
		this.namecountry = namecountry;
	}

	public TypeUser getTypeuser() {
		return typeuser;
	}

	public void setTypeuser(TypeUser typeuser) {
		this.typeuser = typeuser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
