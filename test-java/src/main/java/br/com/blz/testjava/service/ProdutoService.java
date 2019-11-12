package br.com.blz.testjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blz.testjava.model.Produto;
import br.com.blz.testjava.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public String cadastrarProduto(Produto produto) {
		return repository.cadastrarProduto(produto);
	}

	public Produto buscarProdutoPorSku(Integer sku) {
		Produto produto = repository.buscarProdutoPorSku(sku);
		this.calcularInventoryQuantity(produto);		
		this.calcularIsMarketable(produto);
		return produto;
	}

	public void apagarProduto(Integer sku) {
		repository.apagarProduto(sku);		
	}

	public void atualizarProduto(Produto produto) {		
		repository.atualizarProduto(produto);
	}
	
	/**
	 * Toda vez que um produto for recuperado por sku deverá ser calculado a propriedade: isMarketable
	 * @param produto
	 */
	private void calcularIsMarketable(final Produto produto) {		 
		Optional.ofNullable(produto).ifPresent(p -> {
			if (p.getInventory().getQuantity() > 0) {
				p.setIsMarketable(true);	
			} else {
				p.setIsMarketable(false);
			}
		});
	}

	/**
	 * Toda vez que um produto for recuperado por sku deverá ser calculado a propriedade: inventory.quantity
	 * @param produto
	 */
	private void calcularInventoryQuantity(final Produto produto) {
		Optional.ofNullable(produto).ifPresent(p -> {
			final int quantity = p.getInventory().getWarehouses().size();
			p.getInventory().setQuantity(quantity);			
		});
	}
}
