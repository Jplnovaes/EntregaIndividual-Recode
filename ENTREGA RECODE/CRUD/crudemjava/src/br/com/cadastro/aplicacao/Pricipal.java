package br.com.cadastro.aplicacao;


import br.com.cadastro.dao.cadastroDAO;
import br.com.cavetour.model.Cadastro;

public class Pricipal {

	public static void main(String[] args) {

		Cadastro cadastro = new Cadastro();
		cadastroDAO cadastroDao = new cadastroDAO();

		
		cadastro.setNome("João luiz");
		cadastro.setEmail("jplimanovaes@gmail.com");
		cadastro.setRg("7656870");
		cadastro.setCpf("09678888888");
		cadastro.setTelefone("8134458806");
		cadastro.setEndereco("Rua Japecanga 148 Prado");
		
		//Cadastrar
//		cadastroDao.save(cadastro);
		
		//Atualizar Contato
		Cadastro c1 = new Cadastro(); {
			
//		c1.setNome("Joao Paulo Novaes");
//		c1.setEmail("jplnima@gmail.com");
//		c1.setRg("7555565");
//		c1.setCpf("5465542222");
//		c1.setTelefone("846665522");
//		c1.setEndereco("aSAhiuasdu asoiaa a");
//		c1.setId(2);
		
//		cadastroDao.update(c1);
			
		//DELETAR CADASTRO POR ID
//		cadastroDao.deleteById();
		
	
		
		
		for(Cadastro c : cadastroDao.getCadastro()) {
			System.out.println("Contato : " + c.getNome());
			}
				
		}
		
	}
}

