package com.brqapirest.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brqapirest.domain.entidade.Cliente;
import com.brqapirest.domain.exception.NegocioException;
import com.brqapirest.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	public Cliente salvarCliente(Cliente cliente) {

		Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());

		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe cleinte cadastrado com este CPF");
		}

		return clienteRepository.save(cliente);
	} 
	
	
	/** 
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	public ResponseEntity<Cliente> alterarCliente(Long clientId, Cliente cliente) {

		if (!clienteRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());

		if (clienteExistente != null && !clienteExistente.getId().equals(clientId)) {
			throw new NegocioException("Já existe cleinte cadastrado com este CPF");
		}
		cliente.setId(clientId);
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	/**
	 * 
	 * @param clientId
	 */
	public ResponseEntity<Cliente> buscarClienteId(Long clientId) {

		Optional<Cliente> cliente = clienteRepository.findById(clientId);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * 
	 * @param clientId
	 */
	public ResponseEntity<Void> excluirCliente(Long clientId) {
		if (!clienteRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(clientId);

		return ResponseEntity.noContent().build();
	}

	public static final String CLIENT_THIS_NOT_EXIST = "Client this not exist";
	
	public static final String CLIENT_NOT_FOUND = "NOT_FOUND";
	
	public static final String CLIENT_FOUND = "OK";
	
	public static final String CLIENT_THIS_ALREADY_EXIST = "Já existe cleinte cadastrado com este CPF";


}
