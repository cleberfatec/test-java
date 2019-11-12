package br.com.blz.testjava.endpoint;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blz.testjava.exception.ProdutoExistenteException;
import br.com.blz.testjava.exception.ProdutoInexistenteException;
import br.com.blz.testjava.model.Produto;
import br.com.blz.testjava.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoEndpoint {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarProduto(@RequestBody Produto produto) {
		final Produto prod = service.buscarProdutoPorSku(produto.getSku());
		if (prod != null) {
			throw new ProdutoExistenteException();
		}
		service.cadastrarProduto(produto);
	}
	
	@GetMapping(value = "/{sku}", produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Produto buscarProdutoPorSku(@PathVariable(value = "sku") Integer sku) {
		Produto prod = service.buscarProdutoPorSku(sku);
		if (prod == null) {
			throw new ProdutoInexistenteException();			
		}
		return prod;
	}
	
	@DeleteMapping(value = "/{sku}")
	@ResponseStatus(HttpStatus.CREATED)
	public void apagarProduto(@PathVariable(value = "sku") Integer sku) {
		service.apagarProduto(sku);
	}
	
	@PutMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
	public void atualizarProduto(@RequestBody Produto produto) {
		service.atualizarProduto(produto);
	}
	


	

}
