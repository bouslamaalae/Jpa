package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class ElectronicDevice implements java.io.Serializable {
	
	public ElectronicDevice(){
		this.cosomation=0;
		this.refrence="";
		
	}


	private Home homelec;
	private int idE;
	private String refrence;
	private int cosomation;


@Id
@GeneratedValue
public int getIdE() {
	return idE;
}
public void setIdE(int idE) {
	this.idE = idE;
}
@ManyToOne
public Home getHomelec() {
	return homelec;
}
public void setHomelec(Home homelec) {
	this.homelec = homelec;
}
}
