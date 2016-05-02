package domain;

import java.util.ArrayList;
import java.util.List;

import javax.management.MXBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;
@Entity
@XmlRootElement
public class Home implements java.io.Serializable{
	@Id
	@GeneratedValue
	private long idh ;
	private int nombrePieces;
	private String Adresse;
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person proprio;
@OneToMany(mappedBy = "homelec", cascade = CascadeType.PERSIST)
	private List<ElectronicDevice>elecd;

	public Home(){
		this.nombrePieces=0;
	this.Adresse = "";
		this.elecd=new ArrayList<ElectronicDevice>();
		
	}
	public Home(Person p,int nbr,String adresse,ArrayList<ElectronicDevice>E){
		this.proprio=p;
		this.nombrePieces=nbr;
		this.Adresse = adresse;
		this.elecd=E;
	}
	public Home (int nbr,String adresse,ArrayList<ElectronicDevice>E){
		this.nombrePieces=nbr;
		this.Adresse = adresse;
		this.elecd=E;
	}
	
	
	
	
	
	public long getIdh() {
		return idh;
	}
	public List<ElectronicDevice> getElecd() {
		return elecd;
	}
	public void setElecd(ArrayList<ElectronicDevice> elecd) {
		this.elecd = elecd;
	}
	
	
	public void setIdh(long id) {
		this.idh = id;
	}
	public int getNombrePieces() {
		return nombrePieces;
	}
	public void setNombrePieces(int nombrePieces) {
		this.nombrePieces = nombrePieces;
	}

	
	
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public Person getProprio() {
		return proprio;
	}
	public void setProprio(Person proprio) {
		this.proprio = proprio;
	}
	public void addelec(ElectronicDevice e){
		this.elecd.add(e);
	}

}
