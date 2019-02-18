package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class CadastroTeste {

	public static void main(String[] args) {
		
		//Criar um gerenciador de entidades?
		//Primeiro cria = fábrica:
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o cliente 
		Cliente cliente = new Cliente("Marcos", new GregorianCalendar(2000, Calendar.MARCH, 1),
				"123.132.123-99", Genero.MASCULINO, null, true);
		

		//Cadastrar o cliente
		em.persist(cliente);
		
		//Abre uma transação e finaliza com commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		

	}

}
