package br.com.camadas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.camadas.interfaces.PadraoDAO;
import br.com.camadas.modelo.Carro;

/*
 * DAO => Data Access Object é um pattern que sugestiona armazenar o CRUD em uma única classe.
 * 
 * C Create
 * R Read
 * U Update
 * D Delete
 */
public class CarroDAO implements PadraoDAO<Carro> {
	// Static no atributo: o valor fica valendo para todos os objetos que forem instanciados
	private static List<Carro> carros = new ArrayList<Carro>();
	
	public String deleteCarro(String modelo) {
		for (Carro objeto : carros) {
			if(objeto.getModelo().equals(modelo)) {
				carros.remove(objeto);
				return "Removido com sucesso";
			}
		}
		return "Modelo não encontrado";
	}
	
	public Carro getCarro(String modelo) {
		
		for (Carro objeto : carros) {
			if (objeto.getModelo().equals(modelo.toUpperCase())) {
				return objeto;
			}
		}
		
		return new Carro();
	}
	
	public boolean gravar(Carro objeto) {
		carros.add(objeto);
		return true;
	}
	
	public String exibirTudo() {
		return carros.toString();
	}
	
	
	
	
}
