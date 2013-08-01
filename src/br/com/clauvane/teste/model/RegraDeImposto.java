package br.com.clauvane.teste.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class RegraDeImposto {
	
	public boolean isValorDoImpostoValido(double valorDoImposto, double valor){
		return valorDoImposto == calculaValorDoImposto(valor);
	}
	
	public double calculaValorDoImposto(double valor){
		
		BigDecimal valorDoImposto =  (
				new BigDecimal(valor)
				.multiply(new BigDecimal(getAliquota()))
				)
				.divide(new BigDecimal(100), BigDecimal.ROUND_HALF_UP);
		return valorDoImposto.doubleValue();
	}
	
	public static RegraDeImposto getInstance(String operacao, String classificacao){
		
		RegraDeImposto excecao = getExcecoes(operacao, classificacao);
		if (excecao != null) {
			return excecao;
		}
		for (RegraDeImposto regra : getTodas()) {
			if (regra.getOperacao().equalsIgnoreCase(operacao)
					&&regra.getClassificacao().equalsIgnoreCase(classificacao)) {
				return regra;
			}
		}
		
		throw new NullPointerException("Regra não encontrada!");
	}

	private static RegraDeImposto getExcecoes(String operacao, String classificacao) {
		
		if (operacao.equalsIgnoreCase("TRANSFERENCIA")) {
			return new Regra4();
		}
		if (operacao.equalsIgnoreCase("DOACAO")) {
			return new Regra5();
		}
		if (classificacao.equalsIgnoreCase("D")) {
			return new Regra6();
		}
		
		return null;
	}
	public static List<RegraDeImposto> getTodas(){
		Regra1 regra1 = new Regra1();
		Regra2 regra2 = new Regra2();
		Regra3 regra3 = new Regra3();
		Regra4 regra4 = new Regra4();
		Regra5 regra5 = new Regra5();
		Regra6 regra6 = new Regra6();
		
		List<RegraDeImposto> regras = new ArrayList<RegraDeImposto>();
		regras.add(regra1);
		regras.add(regra2);
		regras.add(regra3);
		regras.add(regra4);
		regras.add(regra5);
		regras.add(regra6);
		return regras;
	}
	
	public abstract double getAliquota();
	public abstract String getOperacao();
	public abstract String getClassificacao();
	
}
