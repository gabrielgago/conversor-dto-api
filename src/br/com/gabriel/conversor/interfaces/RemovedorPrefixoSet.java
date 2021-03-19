package br.com.gabriel.conversor.interfaces;

import br.com.gabriel.conversor.interfaces.exceptions.NamedNotContainsPrefix;

public class RemovedorPrefixoSet implements RemovedorPrefixo {

	@Override
	public String remover(String nome) {
		if (!nome.startsWith(SET)) {
			throw new NamedNotContainsPrefix(SET);
		}
		return nome.split(SET)[1];
	}

}

