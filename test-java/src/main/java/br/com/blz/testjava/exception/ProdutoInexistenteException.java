package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Produto inexistente") 
public class ProdutoInexistenteException extends RuntimeException {

	private static final long serialVersionUID = -7294080099002348370L;


}
