package br.com.testes;

import br.com.dao.ProdutoDao;
import br.com.model.bean.Categoria;
import br.com.model.bean.Produto;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		ProdutoDao produtoDao = new ProdutoDao();
//		Salvando dodos
		Categoria categoria = new Categoria();
		categoria.setId(4);
		produto.setDescricao("Chocolate");
		produto.setQtd(10);
		produto.setValor(1.50);
		produto.setCategoria(categoria);
		produtoDao.save(produto);
		
//		Removendo Dados
//		produtoDao.remove((long) 2);
		
	
//		Listar por ID
//		Produto produto1 = produtoDao.findById((long) 2);
//		System.out.println("Descrição do produto: "+produto1.getDescricao());
		
//		Listar tudo 
//		for(Produto p: produtoDao.findAll()) {
//			System.out.println("Descricao: "+p.getDescricao());
//			System.out.println("QTD: "+p.getQtd());
//			System.out.println("Valor: "+p.getValor());
//			System.out.println("Categoria: "+p.getCategoria().getDescricao());
//			
//		}
			

	}

}
