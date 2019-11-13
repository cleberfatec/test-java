package br.com.blz.testjava.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.blz.testjava.model.Produto;

@Repository
public class ProdutoRepository {
	
	public static Map<Integer, Produto> repository = new HashMap<>();

	public String cadastrarProduto(Produto produto) {
		repository.put(produto.getSku(), produto);
		return "Cadastrado";
	}

	public Produto buscarProdutoPorSku(Integer sku) {
		return repository.get(sku);
	}

	public void apagarProduto(Integer sku) {
		repository.remove(sku);		
	}

	public void atualizarProduto(Produto produto) {
		Produto prod = repository.get(produto.getSku());
		prod.setName(produto.getName());
		prod.setInventory(produto.getInventory());
		repository.put(produto.getSku(), prod);
	}

}
