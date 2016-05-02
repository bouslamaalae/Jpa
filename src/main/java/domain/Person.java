package domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Person  {
	
	@Id
	@GeneratedValue
	private long id ;
	private String name;
	private String prenom;
    
    private String email;
	@OneToMany(mappedBy = "proprio", cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	private List<Home> residences ;
	public Person(){
		this.name="";
		this.prenom ="";
		this.email="";
		this.residences=new ArrayList<Home>();
	
	}
	
	public Person(String name,String prenom,String email, ArrayList<Home>L){
		this.name=name;
		this.prenom = prenom;
		this.email = email;
		this.residences=L;
	}
	
	public Person(String name,String prenom,String email){
		this.name=name;
		this.prenom = prenom;
		this.email = email;
		
	}
	
	
	public long getId() {
		return id;
	}
	
	
	public List<Home> getResidences() {
		return residences;
	}
	public void setResidences(ArrayList<Home> residences) {
		this.residences = residences;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	 public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addhome(Home h){
		 this.residences.add(h);
		 
	 }

}
