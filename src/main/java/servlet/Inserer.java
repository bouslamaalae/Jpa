package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Person;
import jpa.JpaTest;


@WebServlet(name="inserer",
urlPatterns={"/Inserer"})
public class Inserer extends HttpServlet{
	
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");

PrintWriter out = response.getWriter();
String nom = request.getParameter("name");
String prenom = request.getParameter("firstname");
String email = request.getParameter("email");

EntityManagerFactory factory = Persistence
.createEntityManagerFactory("dev");
EntityManager manager = factory.createEntityManager();
EntityTransaction tx = manager.getTransaction();
tx.begin();
//Person person = new Person(nom,prenom ,email);
//manager.persist(person);
tx.commit();
Query query = manager.createQuery("Select a From Person a where a.nom = nom");
Person per = (Person) query.getSingleResult();
out.println("<HTML>\n<BODY>\n" +
        "<H1>Recapitulatif des informations</H1>\n" +
        "<UL>\n" +            
" <LI>Nom: "
        + per.getName() + "\n" +
        " <LI>Prenom: "
        + per.getPrenom() + "\n" +
        " <LI>Email: "
        + per.getEmail() + "\n" +
        "</UL>\n" +                
"</BODY></HTML>");
out.flush();


manager.close();
factory.close();


}

}
