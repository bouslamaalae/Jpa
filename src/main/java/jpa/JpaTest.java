package jpa;

import java.sql.Array;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.hql.internal.ast.util.SyntheticAndFactory;
import org.hibernate.mapping.List;

import domain.ElectronicDevice;
import domain.Home;
import domain.Person;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		try {
			ArrayList<ElectronicDevice> D = new ArrayList<ElectronicDevice>();

			Home h = new Home (4,"aaaaa",D);
		manager.persist(h);
		
			ArrayList<Home> homes = new ArrayList<Home>();
			homes.add(h);
			homes.add(new Home());
			
		Person p = new Person("eloufir","med","aaa@aaa",homes);
			manager.persist(p);
			Person p2 = new Person("BOUSLAMA","aLAE","aaa@aaa",homes);
			manager.persist(p2);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Person as e where e.name=:name";
		
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "eloufir"); 
	ArrayList<Person> res = (ArrayList<Person>) q.getResultList();

	
	System.err.println(res.size());
	System.err.println(res.get(0).getResidences().get(0).getNombrePieces());
	for(Person next :res){
		System.out.println(next.getResidences());
		
	}
	
		
		manager.close();
		factory.close();
	}

}
