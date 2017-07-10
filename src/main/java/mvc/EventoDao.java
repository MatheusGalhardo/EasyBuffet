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

	public static void alterar(String matricula, String nome) {
	}

	public static void excluir(String matricula) {
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