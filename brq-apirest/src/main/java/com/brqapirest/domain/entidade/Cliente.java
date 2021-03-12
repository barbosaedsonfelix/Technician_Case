package com.brqapirest.domain.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nome", "rg", "cpf","email", "dataNascimento", "profissao", "endereco", "telFixo", "celular", "isCelularZap"})

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@NotBlank
	@NotEmpty
	@Size(max = 60)
	private String nome;
	@NotBlank
	@NotEmpty
	@Size(max = 10)
	private String rg;
	@NotBlank
	@NotEmpty
	@Size(max = 11)
	private String cpf;
	@NotBlank
	@NotEmpty
	@Size(max = 255)
	private String endereco;
	@NotBlank
	@NotEmpty
	@Size(max = 10)
	private String dataNascimento;

	@Size(max = 50)
	private String profissao;
	@Size(max = 20)
	private String telFixo;
	@Size(max = 20)
	private String celular;
    
	private String isCelularZap;

	@NotBlank
	@Email
	@Size(max = 255)
	private String email;

	public Cliente() {  
	}
	
	public Cliente(String nome, String rg, String cpf, String endereco, String dataNascimento, String profissao,
			String telFixo, String celular, String isCelularZap, String email) {

		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.profissao = profissao;
		this.telFixo = telFixo;
		this.celular = celular;
		this.isCelularZap = isCelularZap;
		this.email = email;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("nome")	
	public String getNome() {
		return nome;
	}

	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonProperty("rg")	
	public String getRg() {
		return rg;
	}

	@JsonProperty("rg")
	public void setRg(String rg) {
		this.rg = rg;
	}

	@JsonProperty("cpf")
	public String getCpf() {
		return cpf;
	}

	@JsonProperty("cpf")
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@JsonProperty("endereco")
	public String getEndereco() {
		return endereco;
	}

	@JsonProperty("endereco")
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@JsonProperty("dataNascimento")
	public String getDataNascimento() {
		return dataNascimento;
	}

	@JsonProperty("dataNascimento")
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@JsonProperty("profissao")
	public String getProfissao() {
		return profissao;
	}

	@JsonProperty("profissao")
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@JsonProperty("telFixo")
	public String getTelFixo() {
		return telFixo;
	}

	@JsonProperty("telFixo")
	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	@JsonProperty("celular")
	public String getCelular() {
		return celular;
	}

	@JsonProperty("celular")
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@JsonProperty("isCelularZap")
	public String getIsCelularZap() {
		return isCelularZap;
	}

	@JsonProperty("isCelularZap")
	public void setIsCelularZap(String isCelularZap) {
		this.isCelularZap = isCelularZap;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

}
