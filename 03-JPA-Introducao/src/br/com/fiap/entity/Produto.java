package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto", sequenceName="SQ_T_PRODUTO")
public class Produto {
	
	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto", nullable = false, length=50)
	private String nome;
	
	@Column(name="qt_produto", nullable = false)
	private int quantidade;
	
	@Column(name="ds_estado")
	private Estado Estado;
	
	@Column(name="dt_validade")
	private Calendar dataValidade;
	
	@Column(name="dt_fabricacao")
	private Calendar dataFabricacao;
	
	@Column(updatable=false)
	@CreationTimestamp//cria autom�ticamente a data do cadastro
	private Calendar dataCadastro;
	
	@Column(name="vl_produto", nullable = false)
	private float preco;
	
	@Transient // n�o ser� coluna na base de dados 
	private int idade;

}
