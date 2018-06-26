package br.com.testes;

import br.com.dao.CategoriaDao;
import br.com.model.bean.Categoria;

public class CategoriaTeste {

	public static void main(String[] args) {
		
		CategoriaDao categoriaDao = new CategoriaDao();
		Categoria categoria = new Categoria();
		
//		 Inserindo dados.
		categoria.setDescricao("Carnes");
		categoriaDao.save(categoria);
		
//		Alterando dados.
//		categoria.setDescricao("Petiscos2");
//		categoria.setId(4);
//		categoriaDao.update(categoria);
		
//		Removendo Dados
//		categoriaDao.remove((long) 2);
		
//		Listar por Id
//		Categoria cat = categoriaDao.getById((long) 4);
//		System.out.println("Descrição: " +cat.getDescricao());
		
//		Lista tudo
//		for(Categoria c : categoriaDao.findAll()) {
//			
//			System.out.println("Descrição: " +c.getDescricao());
//		}
		
		
		
		

	}

}
