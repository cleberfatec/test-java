package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.ALREADY_REPORTED, reason="Produto já existente") 
public class ProdutoExistenteException extends RuntimeException {

	private static final long serialVersionUID = -2070059062141779972L;

}
