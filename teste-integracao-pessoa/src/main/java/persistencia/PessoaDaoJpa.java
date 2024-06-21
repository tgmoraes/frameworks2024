package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaDaoJpa implements Dao<Pessoa>{
	private static EntityManagerFactory factory;
	private EntityManager manager;
	public PessoaDaoJpa() {
		this.factory = Persistence.createEntityManagerFactory("PUPostgreSQL");
		this.manager = factory.createEntityManager();
	}
	@Override
	public void insert(Pessoa obj) {
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(this.get(id));
		manager.getTransaction().commit();
		
	}

	@Override
	public void update(Pessoa obj) {
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();		
	}

	@Override
	public List<Pessoa> list(int limit, int offset) {
		Query sql = manager.createNativeQuery("SELECT * FROM Pessoas_ as p LIMIT :lim OFFSET :off ",Pessoa.class);
		sql.setParameter("lim", limit);
		sql.setParameter("off", offset);
		
//		Query sql = manager.createQuery("SELECT p FROM Pessoa as p",Pessoa.class);
//		sql.setFirstResult(offset).setMaxResults(limit);
//		
		List<Pessoa> lista = sql.getResultList();
		return lista;
	}

	@Override
	public Pessoa get(int id) {
		return manager.find(Pessoa.class, id);
	}

}
