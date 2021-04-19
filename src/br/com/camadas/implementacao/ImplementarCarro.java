package br.com.camadas.implementacao;

import javax.swing.JOptionPane;

import br.com.camadas.bo.CarroBO;
import br.com.camadas.excecao.MinhaExcecao;
import br.com.camadas.lib.Magica;
import br.com.camadas.modelo.Carro;

public class ImplementarCarro {

	/*
	 * MVC:
	 * Model => tudo menos a controller
	 * View => tela pro usuario - endpoint
	 * Controller => porta de saída do back-end (onde tem o main() - no standalone)
	 */
	
	
	public static void main(String[] args) {
		
	try {
		while (JOptionPane.showInputDialog("Digite S").toUpperCase().equals("S")) {
			Carro carro = new Carro();
			carro.setAll(
					Magica.s("Modelo"),
					Magica.f("Valor"),
					Magica.s("Cor"),
					Magica.i("Ano")
					);
			System.out.println(CarroBO.novo(carro));
		}
		
		System.out.println(CarroBO.exibirCarros());
		
		String modelo = JOptionPane.showInputDialog("Digite o modelo").toUpperCase();
		Carro resposta = CarroBO.pesquisarModelo(modelo);
		System.out.println("Resposta: " + resposta.toString());
		
		System.out.println(CarroBO.apagarCarro(modelo));
		System.out.println("Após apagar:\n" + CarroBO.exibirCarros());
	}catch(Exception e) {
		System.out.println(MinhaExcecao.tratar(e));
	}

	}

}
