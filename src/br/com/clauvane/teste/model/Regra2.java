package br.com.clauvane.teste.model;

public class Regra2 extends RegraDeImposto{

	@Override
	public double getAliquota() {
		return 10;
	}

	@Override
	public String getOperacao() {
		return "VENDA";
	}

	@Override
	public String getClassificacao() {
		return "B";
	}

}
