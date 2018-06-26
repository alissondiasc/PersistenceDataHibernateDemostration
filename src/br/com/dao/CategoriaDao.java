package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Categoria;

public class CategoriaDao {

	public Categoria getById(final Long id) {

		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = null;

		try {
			categoria = em.find(Categoria.class, id);

		} catch (Exception e) {
			System.err.println("Causa do erro" + e);

		} finally {
			em.close();
		}

		return categoria;
	}

	public Categoria save(Categoria categoria) {

		EntityManager em = new ConnectionFactory().getConnection();

		try {

			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
			System.out.println("Descrição: " + categoria.getDescricao());
			System.out.println("Id: " + categoria.getId() + "\n");
			System.out.println("Dados gravados com sucesso!");

		} catch (Exception e) {
			System.err.println("Causa do erro" + e);
			em.getTransaction().rollback();

		} finally {
			em.close();
		}

		return categoria;

	}

	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {

		EntityManager em = new ConnectionFactory().getConnection();
		List<Categoria> categorias = null;

		try {
			categorias = em.createQuery("FROM Categoria c").getResultList();

		} catch (Exception e) {
			System.err.println("Erro ocorrido" + e);

		} finally {
			em.close();
		}
		return categorias;
	}

	public Categoria update(Categoria categoria) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(categoria);
			em.getTransaction().commit();

		} catch (Exception ex) {
			System.err.println("Causa do erro" + ex);
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
		return categoria;

	}

	public void remove(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			Categoria categoria = em.find(Categoria.class, id);
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();

		} catch (Exception ex) {
			System.err.println("Causa do erro" + ex);
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

}
