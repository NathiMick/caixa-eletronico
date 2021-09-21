package com.caixaEletronico.model;

public class CaixaEletronico {
	public int dois;
	public int cinco;
	public int dez;
	public int cinquenta;
	
	public final int CINQUENTA = 50;
	public final int DEZ = 10;
	public final int CINCO = 5;
	public final int DOIS = 2;
	
	/**
	 * @param dois
	 * @param cinco
	 * @param dez
	 * @param cinquenta
	 */
	public CaixaEletronico() {
		this.dois = 200;
		this.cinco = 200;
		this.dez = 200;
		this.cinquenta = 200;
	}
	
	public void carregarCedulas() {
		this.dois += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 2,00."));

		this.cinco += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 5,00."));


		this.dez += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 10,00."));


		this.cinquenta += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 50,00."));
	}
	
	public String sacar (int valor) {
		int dois = 0, cinco = 0, dez = 0, cinquenta = 0, aux = 0;
		
		String retorno = "";
		
		cinquenta = extrairCedulas(valor, cinquenta);
		
		retorno = cinquenta + " de R$ 50,00/n"
				+ dez + " de R$ 10,00/n"
				+ cinco + " de R$ 5,00/n"
				+ dois + " de R$ 2,00/n";
		
		return retorno;
	}

	public int extrairCedulas(int valor, int nota) {
		int aux, qtd;
		if (valor >= nota) {
			aux = valor % nota;
			qtd = (valor - aux) / nota;
			valor = aux;
			if (this.cinquenta > 0) {
				if (this.cinquenta < qtd) {
					valor += (qtd - this.cinquenta) * nota;
					qtd = this.cinquenta;
				}
			}
		}
		return cinquenta;
	}
		
		
	private String ler(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
	


