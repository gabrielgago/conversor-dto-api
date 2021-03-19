package br.com.gabriel.conversor.exemplos.domains;

import java.util.Calendar;
import java.util.List;

public class Qualquer {

	private String qualquerString;
	private Integer qualquerIntegerWrap;
	private int qualquerIntegerPrimitive;
	private Integer dadoTipoInteiroQueNaoTeraNoDTO;
	private double qualquerDoublePrimitive;
	private Double qualquerDoubleWrap;
	private Calendar qualquerCalendar;
	private Calendar dadoTipoCalendarQueNaoTeraNoDTO;
	private List<String> qualquerLista;
	private String dadoTipoTextoQueNaoTeraNoDTO;

	public String getQualquerString() {
		return qualquerString;
	}

	public void setQualquerString(String qualquerString) {
		this.qualquerString = qualquerString;
	}

	public Integer getQualquerIntegerWrap() {
		return qualquerIntegerWrap;
	}

	public void setQualquerIntegerWrap(Integer qualquerIntegerWrap) {
		this.qualquerIntegerWrap = qualquerIntegerWrap;
	}

	public int getQualquerIntegerPrimitive() {
		return qualquerIntegerPrimitive;
	}

	public void setQualquerIntegerPrimitive(int qualquerIntegerPrimitive) {
		this.qualquerIntegerPrimitive = qualquerIntegerPrimitive;
	}

	public double getQualquerDoublePrimitive() {
		return qualquerDoublePrimitive;
	}

	public void setQualquerDoublePrimitive(double qualquerDoublePrimitive) {
		this.qualquerDoublePrimitive = qualquerDoublePrimitive;
	}

	public Double getQualquerDoubleWrap() {
		return qualquerDoubleWrap;
	}

	public void setQualquerDoubleWrap(Double qualquerDoubleWrap) {
		this.qualquerDoubleWrap = qualquerDoubleWrap;
	}

	public Calendar getQualquerCalendar() {
		return qualquerCalendar;
	}

	public void setQualquerCalendar(Calendar qualquerCalendar) {
		this.qualquerCalendar = qualquerCalendar;
	}

	public List<String> getQualquerLista() {
		return qualquerLista;
	}

	public void setQualquerLista(List<String> qualquerLista) {
		this.qualquerLista = qualquerLista;
	}

	public Integer getDadoTipoInteiroQueNaoTeraNoDTO() {
		return dadoTipoInteiroQueNaoTeraNoDTO;
	}

	public void setDadoTipoInteiroQueNaoTeraNoDTO(Integer dadoTipoInteiroQueNaoTeraNoDTO) {
		this.dadoTipoInteiroQueNaoTeraNoDTO = dadoTipoInteiroQueNaoTeraNoDTO;
	}

	public Calendar getDadoTipoCalendarQueNaoTeraNoDTO() {
		return dadoTipoCalendarQueNaoTeraNoDTO;
	}

	public void setDadoTipoCalendarQueNaoTeraNoDTO(Calendar dadoTipoCalendarQueNaoTeraNoDTO) {
		this.dadoTipoCalendarQueNaoTeraNoDTO = dadoTipoCalendarQueNaoTeraNoDTO;
	}

	public String getDadoTipoTextoQueNaoTeraNoDTO() {
		return dadoTipoTextoQueNaoTeraNoDTO;
	}

	public void setDadoTipoTextoQueNaoTeraNoDTO(String dadoTipoTextoQueNaoTeraNoDTO) {
		this.dadoTipoTextoQueNaoTeraNoDTO = dadoTipoTextoQueNaoTeraNoDTO;
	}

	
	
}
