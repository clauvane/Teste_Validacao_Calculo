package br.com.clauvane.teste.control;

import java.util.ArrayList;
import java.util.List;

import br.com.clauvane.teste.model.Entrada;
import br.com.clauvane.teste.model.RegraDeImposto;

public class AppTeste {
	
	public static void main(String[] args) {
		List<Entrada> entradas = getListaDeEntrada();
		imprimir(entradas);
	}

	private static List<Entrada> getListaDeEntrada() {
		Entrada entrada1 = getEntrada1();
		Entrada entrada2 = getEntrada2();
		Entrada entrada3 = getEntrada3();
		Entrada entrada4 = getEntrada4();
		Entrada entrada5 = getEntrada5();
		
		List<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada1);
		entradas.add(entrada2);
		entradas.add(entrada3);
		entradas.add(entrada4);
		entradas.add(entrada5);
		return entradas;
	}

	private static Entrada getEntrada5() {
		Entrada entrada5 = new Entrada();
		entrada5.setNumero(5);
		entrada5.setClassificacao("A");
		entrada5.setOperacao("Venda");
		entrada5.setImposto(216.18);
		entrada5.setValor(1200.98);
		return entrada5;
	}

	private static Entrada getEntrada4() {
		Entrada entrada4 = new Entrada();
		entrada4.setNumero(4);
		entrada4.setClassificacao("B");
		entrada4.setOperacao("Venda");
		entrada4.setImposto(31.42);
		entrada4.setValor(314.15);
		return entrada4;
	}

	private static Entrada getEntrada3() {
		Entrada entrada3 = new Entrada();
		entrada3.setNumero(3);
		entrada3.setClassificacao("B");
		entrada3.setOperacao("Doacao");
		entrada3.setImposto(0);
		entrada3.setValor(500);
		return entrada3;
	}

	private static Entrada getEntrada2() {
		Entrada entrada2 = new Entrada();
		entrada2.setNumero(2);
		entrada2.setClassificacao("A");
		entrada2.setOperacao("Transferencia");
		entrada2.setImposto(360);
		entrada2.setValor(2000);
		return entrada2;
	}

	private static Entrada getEntrada1() {
		Entrada entrada1 = new Entrada();
		entrada1.setNumero(1);
		entrada1.setClassificacao("A");
		entrada1.setOperacao("Venda");
		entrada1.setImposto(180);
		entrada1.setValor(1000);
		return entrada1;
	}
	
	private static void imprimir(List<Entrada> entradas) {
		for(Entrada entrada : entradas){
			imprimir(entrada);
		}
	}

	private static void imprimir(Entrada entrada) {
		RegraDeImposto regra = RegraDeImposto.getInstance(entrada.getOperacao(), entrada.getClassificacao());
		
		String status = regra.isValorDoImpostoValido(entrada.getImposto(), entrada.getValor()) ? "SIM": "NAO";
		
		System.out.print("numero: "+entrada.getNumero()+",");
		System.out.print("Regra: "+regra.getClass().getSimpleName()+",");
		System.out.println("Valido: "+(status));
	}
	
}
