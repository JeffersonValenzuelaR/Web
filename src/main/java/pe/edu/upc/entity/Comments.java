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
@Table(name="comments")
public class Comments implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComments;
	
	@Column(name="text", nullable=false, length=60)
	private String text;
	@ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

	@ManyToOne
    @JoinColumn(name = "idDetails")
    private DetailsForum detailsForum;
	
	public int getIdComments() {
		return idComments;
	}

	public void setIdComments(int idComments) {
		this.idComments = idComments;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public DetailsForum getDetailsForum() {
		return detailsForum;
	}

	public void setDetailsForum(DetailsForum detailsForum) {
		this.detailsForum = detailsForum;
	}
}
