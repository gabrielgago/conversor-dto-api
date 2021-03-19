package br.com.gabriel.conversor.test;

import java.util.Calendar;
import java.util.List;

import br.com.gabriel.conversor.exemplos.domains.Qualquer;
import br.com.gabriel.conversor.exemplos.domains.QualquerDTO;

public class Test {

	public static void main(String[] args) {

		Qualquer qualquer = new Qualquer();
		qualquer.setQualquerString("qualquer coisa");
		qualquer.setQualquerIntegerWrap(1536);
		qualquer.setQualquerIntegerPrimitive(1545);
		
		qualquer.setDadoTipoInteiroQueNaoTeraNoDTO(0);
		
		qualquer.setQualquerDoublePrimitive(156.36);
		qualquer.setQualquerDoubleWrap(187.99);
		qualquer.setQualquerCalendar(Calendar.getInstance());
		qualquer.setQualquerLista(List.of("Teste", "Teste 2"));
		
		qualquer.setDadoTipoTextoQueNaoTeraNoDTO("qualquer coisa");
		
		qualquer.setDadoTipoCalendarQueNaoTeraNoDTO(Calendar.getInstance());
		
		QualquerDTO qualquerDTO = new QualquerDTO().from(qualquer);
		System.out.println(qualquerDTO);
	}
	
}
