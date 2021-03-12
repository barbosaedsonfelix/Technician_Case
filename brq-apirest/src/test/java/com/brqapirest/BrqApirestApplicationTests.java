package com.brqapirest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.brqapirest.domain.entidade.Cliente;
import com.brqapirest.domain.exception.NegocioException;
import com.brqapirest.domain.service.CadastroClienteService;

@SpringBootTest
class BrqApirestApplicationTests {

	@Autowired
	private CadastroClienteService cadastroClienteService;


	@Test
	void contextLoads() {
	}

	/**
	 * Teste Cliente Inexistente
	 */
	@Test
	public void getClientNoneExistentTest() {

		ResponseEntity<Cliente> cliente = cadastroClienteService.buscarClienteId(0L);

		Assertions.assertTrue(cadastroClienteService.CLIENT_NOT_FOUND.equals(cliente.getStatusCode().name()));
	}

	/**
	 * Teste Cliente Existente
	 * 
	 */
	@Test
	public void getClienteExistentTest() {
		/**
		 * Insere um cliente
		 */
		Cliente cliente = new Cliente("Maria Nunes", "123456", "36945685298",
				"Reua Fernando Pinto, praca de repulblica cep 87654-389 N° 33 bairro Liberdade", "26/09/1945",
				"Pedreiro", "113456788", "72998764563", "1", "maria.nunes@brq.com.br");
		cliente = cadastroClienteService.salvarCliente(cliente);

		/**
		 * Obtem o cliente pelo CPF cadatrado
		 */

		ResponseEntity<Cliente> clienteCadastrado = cadastroClienteService.buscarClienteId(cliente.getId());

		/**
		 * Limpa a base pra não deixar sujeira
		 * 
		 */
		cadastroClienteService.excluirCliente(cliente.getId());

		Assertions.assertTrue(cadastroClienteService.CLIENT_FOUND.equals(clienteCadastrado.getStatusCode().name()));
	}

	/**
	 * Validacao de inserção de Clientes com o mesmo CPF
	 * 
	 */
	@Test
	public void getClienteSameCPFExistentTest() {
		/**
		 * Insere um cliente
		 */
		Cliente cliente1 = new Cliente("Maria Nunes", "123456", "36945685298",
				"Reua Fernando Pinto, praca de repulblica cep 87654-389 N° 33 bairro Liberdade", "26/09/1945",
				"Pedreiro", "113456788", "72998764563", "1", "maria.nunes@brq.com.br");

		Cliente cliente2 = new Cliente("Leandro Alves Nunens", "123456", "36945685298",
				"Reua Fernando Pinto, praca de repulblica cep 87654-389 N° 33 bairro Liberdade", "26/09/1945",
				"Pedreiro", "113456788", "72998764563", "1", "leandro.nunes@brq.com.br");

		try {

			cliente1 = cadastroClienteService.salvarCliente(cliente1);

			cliente2 = cadastroClienteService.salvarCliente(cliente2);
			
			cadastroClienteService.excluirCliente(cliente1.getId());
			
			cadastroClienteService.excluirCliente(cliente2.getId());
			
			Assertions.assertTrue(false);

		} catch (NegocioException e) {

			/**
			 * Limpa a base pra não deixar sujeira
			 * 
			 */
			cadastroClienteService.excluirCliente(cliente1.getId());

			Assertions.assertEquals(cadastroClienteService.CLIENT_THIS_ALREADY_EXIST, e.getMessage());
		}
	}
	
	/**
	 * Validacao de exclusão de um cliente inexistente
	 * 
	 */
	@Test
	public void deleteClienteNonneExistentTest() {
		ResponseEntity<Void> cliente = cadastroClienteService.excluirCliente(0L);

		Assertions.assertTrue(cadastroClienteService.CLIENT_NOT_FOUND.equals(cliente.getStatusCode().name()));
	}	

}
