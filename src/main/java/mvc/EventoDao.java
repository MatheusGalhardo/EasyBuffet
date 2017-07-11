package mvc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.
 */
public class EventoDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");

	public static void inclui(Evento e) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Grava o objeto no banco de dados.
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	public static void alterar(Evento e) {
		
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Evento event = em.find(Evento.class, e.getId());
            if(event.getId() != null && event.getId().equals(e.getId())){
            event=e;
           }
            em.merge(event);
            em.getTransaction().commit();  
	}

	public static void excluir(Long idEvento) {
		
	        EntityManager em  = emf.createEntityManager();
	        em.getTransaction().begin(); 
	        em.remove(em.getReference(Evento.class,idEvento));
	        em.getTransaction().commit();
	        em.close();

	}

	public static List<Evento> listar() {
		EntityManager em = emf.createEntityManager();
		String jpql = "from Evento";
		TypedQuery<Evento> query = em.createQuery(jpql, Evento.class);
		List<Evento> result = query.getResultList();
		em.close();
		return result;
	}
}