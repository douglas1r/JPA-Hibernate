package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitException;

public class TesteAtualizar {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		Empresa empresa = new Empresa(1,"ALOU",
				 Calendar.getInstance(),
				Status.ATIVO, "123.654.321/001-89");
		
		
		try {
			dao.atualizar(empresa);
			dao.commit();
			System.out.println("Atualizado com sucesso !!! ");
			
		} catch (CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao atualizar ");
		}
		
		fabrica.close();
		em.close();
		
	}

}
