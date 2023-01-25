package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.*;

class Teste {
	Controle controle = new Controle();

	@Test
	void testValidaCPF(){
		assertTrue(controle.checkCpf("05522646101")); // cpf valido
		assertFalse(controle.checkCpf("a5522646101")); // cpf invalido
		assertFalse(controle.checkCpf("666"));	// cpf invalido
		assertTrue(controle.checkCpf("78763545055"));	// cpf invalido
	}
	
	@Test
	void testCpfIsCadastrado(){
		controle.usuario(null, "03780718154");
		controle.usuario(null, "28124715068");

		assertTrue(controle.cpfIsCadastrado("03780718154"));
		assertFalse(controle.cpfIsCadastrado("32613684038"));
		assertFalse(controle.cpfIsCadastrado("12146675039"));
		assertTrue(controle.cpfIsCadastrado("28124715068"));
	}
}
