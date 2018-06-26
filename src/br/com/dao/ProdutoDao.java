package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Produto;

public class ProdutoDao {

	EntityManager em = new ConnectionFactory().getConnection();

	public Produto save(Produto produto) {

		try {
			this.em.getTransaction().begin();
			this.em.persist(produto);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println("Causa do erro" + e);
			this.em.getTransaction().rollback();

		} finally {
			this.em.close();

		}

		return null;
	}

	public Produto update(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(produto);
			em.getTransaction().commit();

		} catch (Exception ex) {
			System.err.println("Causa do erro" + ex);
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
		return produto;

	}

	public Produto findById(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;

		try {

			produto = em.find(Produto.class, id);

		} catch (Exception e) {
			System.err.println("Causa do erro " + e);
		} finally {
			em.close();
		}

		return produto;

	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;

		try {
			produtos = em.createQuery("FROM Produto ").getResultList();

		} catch (Exception e) {
			System.err.println("Causa do erro" + e);

		} finally {
			em.close();
		}

		return produtos;

	}

	public void remove(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			Produto produto = em.find(Produto.class, id);
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Causa do erro:" + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}
