package br.com.blz.testjava.repository.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.blz.testjava.model.Inventory;
import br.com.blz.testjava.model.Produto;
import br.com.blz.testjava.model.Warehouse;
import br.com.blz.testjava.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
public class ProdutoRepositoryTest {

	ProdutoRepository repo;
	
	@Before
	public void setUp() throws Exception {
		repo = new ProdutoRepository();		
	}


	@Test
	public void cadastrarProdutoTest() {		
		String retorno1 = repo.cadastrarProduto(criarProduto(110, "produto1"));
		String retorno2 = repo.cadastrarProduto(criarProduto(120, "produto2"));
		String retorno3 = repo.cadastrarProduto(criarProduto(130, "produto3"));
		assertEquals("Cadastro efetuado com sucesso.", "Cadastrado", retorno1);
		assertEquals("Cadastro efetuado com sucesso.", "Cadastrado", retorno2);
		assertEquals("Cadastro efetuado com sucesso.", "Cadastrado", retorno3);
		
		repo.apagarProduto(110);
		repo.apagarProduto(120);
		repo.apagarProduto(130);
		
	}

	@Test
	public void buscarProdutoPorSkuTest() {
		Produto produto = criarProduto(200, "produto");
		String retorno1 = repo.cadastrarProduto(produto);
		assertEquals("Cadastrado", retorno1);
		
		Produto prod = repo.buscarProdutoPorSku(200);		
		assertEquals("Busca efetuada com sucesso.", produto, prod);
		
		repo.apagarProduto(200);
	}

	@Test
	public void apagarProdutoTest() {
		criarProduto(300, "produto3");		
		repo.apagarProduto(300);
		Produto produto = repo.buscarProdutoPorSku(300);
		assertNull("Produto apagado com sucesso.", produto);
	}

	@Test
	public void atualizarProdutoTest() {
		Produto produto = criarProduto(400, "Produto4");
		repo.cadastrarProduto(produto);
		
		produto.setName("Produto4_alterado");
		produto.getInventory().setQuantity(5);		
		repo.atualizarProduto(produto);
		
		Produto prod = repo.buscarProdutoPorSku(400);
		
		assertEquals(produto.getName(), prod.getName());
		assertEquals(produto.getInventory().getQuantity(), prod.getInventory().getQuantity());
	}
	
	private Produto criarProduto(int sku, String nome) {
		
		Warehouse warehouse1 = new Warehouse();
		warehouse1.setLocality("Local_" + sku);
		warehouse1.setQuantity(1);
		warehouse1.setType("Type_" + sku);
		
		Warehouse warehouse2 = new Warehouse();
		warehouse1.setLocality("Local_" + sku);
		warehouse1.setQuantity(1);
		warehouse1.setType("Type_" + sku);
		
		Inventory inventory = new Inventory();		
		List<Warehouse> warehouses = Arrays.asList(warehouse1, warehouse2);		
		inventory.setWarehouses(warehouses);
		
		Produto produto = new Produto();
		produto.setInventory(inventory);
		produto.setName(nome);
		produto.setSku(sku);
		return produto;
	}
}
