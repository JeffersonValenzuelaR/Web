package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="talk")


public class Talk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTalk;
	
	@Column(name="RoomName", nullable=false, length=30)
	private String RoomName;
	
	private int Capacity;
	
	@Column(name="enlace", nullable=false, length=100)
	private String enlace;
	
	private int Vacancies;

	public Talk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Talk(int idTalk, String roomName, int capacity, String enlace, int vacancies) {
		super();
		this.idTalk = idTalk;
		RoomName = roomName;
		Capacity = capacity;
		this.enlace = enlace;
		Vacancies = vacancies;
	}

	public int getIdTalk() {
		return idTalk;
	}

	public void setIdTalk(int idTalk) {
		this.idTalk = idTalk;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public int getVacancies() {
		return Vacancies;
	}

	public void setVacancies(int vacancies) {
		Vacancies = vacancies;
	}


	
	
}
