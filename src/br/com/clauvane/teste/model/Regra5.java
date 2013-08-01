package br.com.clauvane.teste.model;

public class Regra5 extends RegraDeImposto{

	@Override
	public double getAliquota() {
		return 0;
	}

	@Override
	public String getOperacao() {
		return "DOACAO";
	}

	@Override
	public String getClassificacao() {
		return "*";
	}

}
