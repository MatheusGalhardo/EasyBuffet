package mvc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.Interface abstrata que interage com o BD.
 */
public class EventoDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos"); // Esse método gera as tabelas que foram geradas no Persistence.xml .

	//Esta funcao recebe um objeto Evento preenchido e com os campos ja verificados e realiza a persistencia no banco.
	public static void inclui(Evento e) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); // begin() método para abrir uma transação;
		// Grava o objeto no banco de dados.
		em.persist(e);// persist() armazena as informações do objeto no BD.
		em.getTransaction().commit(); // método commit() sincroniza os dados com o BD.
		em.close();
	}

	//Esta funcao recebe o objeto alterado da tela de edicao e realiza o merge do mesmo usando seu id como chave.
	public static void alterar(Evento e) {
		
            EntityManager em = emf.createEntityManager();//  EntityManager faz a manipulação das entidades.
            em.getTransaction().begin();

            Evento event = em.find(Evento.class, e.getId());// find() recupera os dados desejados imediatamente.
            if(event.getId() != null && event.getId().equals(e.getId())){
            event=e;
           }
            em.merge(event);
            em.getTransaction().commit();  
	}

	//Funcao responsavel por excluir um evento utilizando seu id
	public static void excluir(Long idEvento) {
		
	        EntityManager em  = emf.createEntityManager(); 
	        em.getTransaction().begin(); 
	        em.remove(em.getReference(Evento.class,idEvento));  //remove() remove um registro correspondente a um objeto.
	        em.getTransaction().commit();
	        em.close();

	}

	//Esta funcao exibe todos os eventos criados
	public static List<Evento> listar() {
		EntityManager em = emf.createEntityManager();
		String jpql = "from Evento"; // JPQL linguagem de uso para BDs diferentes.
		TypedQuery<Evento> query = em.createQuery(jpql, Evento.class);  // Método createQuery() cria uma consulta, a função devolve uma lista de EVENTOS.
		List<Evento> result = query.getResultList(); // List() listar todos os registros do array.
		em.close();
		return result;
	}
}
