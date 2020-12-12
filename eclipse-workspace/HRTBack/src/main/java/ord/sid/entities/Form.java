package ord.sid.entities;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

@Entity
public class Form implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String[] questions;
	//@Temporal(TemporalType.DATE)
	//private Date date_envoi;
	private String[] reponses;
    public User user;
	
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Form(String name, String[] questions, String[] reponses, User user
			//, Date date_envoi
			) {
		super();
		this.name = name;
		this.questions = questions;
		this.reponses = reponses;
		this.user = user;
		//this.date_envoi = date_envoi;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public String[] getReponses() {
		return reponses;
	}

	public void setReponses(String[] reponses) {
		this.reponses = reponses;
	}
	
	/*public Date getDate_envoi() {
		return date_envoi;
	}

	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
