package br.com.gabriel.conversor.interfaces;

import br.com.gabriel.conversor.interfaces.exceptions.NamedNotContainsPrefix;

public class RemovedorPrefixoGet implements RemovedorPrefixo {

	@Override
	public String remover(String nome) {
		if (!nome.startsWith(GET)) {
			throw new NamedNotContainsPrefix(GET);
		}
		return nome.split(GET)[1];
	}

}
