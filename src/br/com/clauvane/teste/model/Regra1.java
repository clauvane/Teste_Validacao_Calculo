package br.com.clauvane.teste.model;

public class Regra1 extends RegraDeImposto{

	public double getAliquota() {
		return 18;
	}

	public String getOperacao() {
		return "VENDA";
	}

	public String getClassificacao() {
		return "A";
	}

}
