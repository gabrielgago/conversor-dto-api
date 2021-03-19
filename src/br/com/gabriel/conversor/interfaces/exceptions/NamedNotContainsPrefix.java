package br.com.gabriel.conversor.interfaces.exceptions;

public class NamedNotContainsPrefix extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7644851232243898926L;
	private static final String MENSAGEM = "Prefixo '{}' inválido.";

	public NamedNotContainsPrefix(String prefix) {
		super(MENSAGEM.replace("{}", prefix));
	}

	public NamedNotContainsPrefix(String prefix, Throwable ex) {
		super(MENSAGEM.replace("{}", prefix), ex);
	}
}