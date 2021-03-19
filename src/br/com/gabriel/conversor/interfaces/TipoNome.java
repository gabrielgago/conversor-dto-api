package br.com.gabriel.conversor.interfaces;

enum TipoNome {

	GET(new RemovedorPrefixoGet()), SET(new RemovedorPrefixoSet());

	private RemovedorPrefixo removedor;

	private TipoNome(RemovedorPrefixo removedor) {
		this.removedor = removedor;
	}

	public String remover(String nome) {
		return removedor.remover(nome);
	}

}