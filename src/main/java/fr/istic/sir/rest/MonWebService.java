package fr.istic.sir.rest;



import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Person;

@Path("/Person")
public class MonWebService {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("dev");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			
	
	@POST
    //@Path("/Ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person inserer(Person per){
		
		tx.begin();
		System.out.println(per);
	//	per = new Person("Alae222","Bouslama222","aaa@aaaa.com");
		manager.persist(per);
		tx.commit();
		//manager.close();
		//factory.close();
		return per;
	}
	 @GET
	/// @Path("/Lister")
	 @Produces({MediaType.APPLICATION_JSON})
	 public List<Person> list(){
		 tx.begin();
		 Query query = manager.createQuery("Select p From Person p ");
		 List<Person> rList =  query.getResultList();
		 manager.close();
			factory.close();
		 return  rList;
	 }
	
}
