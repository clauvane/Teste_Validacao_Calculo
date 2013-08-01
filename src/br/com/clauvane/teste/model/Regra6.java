package br.com.clauvane.teste.model;

public class Regra6 extends RegraDeImposto{

	@Override
	public double getAliquota() {
		return 1.5;
	}

	@Override
	public String getOperacao() {
		return "*";
	}

	@Override
	public String getClassificacao() {
		return "D";
	}

}
