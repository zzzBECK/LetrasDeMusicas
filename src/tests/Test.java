package tests;

import static org.junit.jupiter.api.Assertions.*;

import model.Artista;
import org.junit.jupiter.api.Test;


import controller.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para realizaçao de testes de metodos
 */
class Teste {
	Controle controle = new Controle();

	/**
	 * teste para verificação de cpf
	 */
	@Test
	void testCheckCpf(){
		assertTrue(controle.checkCpf("05522646101")); // cpf valido
		assertFalse(controle.checkCpf("a5522646101")); // cpf invalido
		assertFalse(controle.checkCpf("666"));	// cpf invalido
		assertTrue(controle.checkCpf("78763545055"));	// cpf invalido
		assertFalse(controle.checkCpf("aisbdasb"));
		assertFalse(controle.checkCpf("ajsd asdiasdbsaudaid sad ia"));
	}

	/**
	 * Teste para verificação de cpf cadastrados para evitar dados duplicados
	 */
	@Test
	void testCpfIsCadastrado(){
		controle.usuario(null, "03780718154");
		controle.usuario(null, "28124715068");

		assertTrue(controle.cpfIsCadastrado("03780718154"));
		assertFalse(controle.cpfIsCadastrado("32613684038"));
		assertFalse(controle.cpfIsCadastrado("12146675039"));
		assertTrue(controle.cpfIsCadastrado("28124715068"));
	}

	@Test
	void testAlbumIsCadastrado(){
		List<Artista> list = new ArrayList<>();
		list.add(new Artista("teste", "03780718154", 8, "teste"));

		controle.album("Master Of Puppets", null, list);
		controle.album("Veigh", null, list);


		assertTrue(controle.albumIsCadastrado("Master Of Puppets"));
		assertTrue(controle.albumIsCadastrado("master of puppets"));
		assertFalse(controle.albumIsCadastrado("MasterOfPuppets"));
		assertTrue(controle.albumIsCadastrado("veigh"));
		assertFalse(controle.albumIsCadastrado("veigh master"));


	}
}
