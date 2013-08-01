package br.com.clauvane.teste.model;

public class Regra4 extends RegraDeImposto{

	@Override
	public double getAliquota() {
		return 15;
	}

	@Override
	public String getOperacao() {
		return "TRANSFERENCIA";
	}

	@Override
	public String getClassificacao() {
		return "*";
	}

}
