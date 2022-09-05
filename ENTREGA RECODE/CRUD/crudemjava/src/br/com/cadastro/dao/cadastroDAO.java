package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.cavetour.factory.ConnectionFactory;
import br.com.cavetour.model.Cadastro;

public class cadastroDAO {

	// CRUD

	public void save(Cadastro cadastro) {

		
		
		
		String sql = "INSERT INTO cadastro(nome, email, telefone, rg, cpf, endereco ) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexõ com banco
			conn = ConnectionFactory.createConnectionToMySQL(); 
			
			//criarmos um pstm para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmail());
			pstm.setString(3, cadastro.getTelefone());
			pstm.setString(4, cadastro.getRg());
			pstm.setString(5, cadastro.getCpf());
			pstm.setString(6, cadastro.getEndereco());
						

			
	
			pstm.execute();
			
			System.out.println("Cadastro realizado com sucesso!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(pstm!=null) {
				conn.close();
			}
							
			}catch (Exception e) {
				e.printStackTrace();
		
			}

		}
	}

	public void update(Cadastro cadastro)
	{
		String sql = "UPDATE cadastro SET nome = ?, email = ?, telefone = ?, rg = ?, cpf= ?, endereco = ?" + "WHERE id = ?";
	
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn =ConnectionFactory.createConnectionToMySQL();
				
				pstm =(PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, cadastro.getNome());
				pstm.setString(2, cadastro.getEmail());
				pstm.setString(3, cadastro.getTelefone());
				pstm.setString(4, cadastro.getRg());
				pstm.setString(5, cadastro.getCpf());
				pstm.setString(6, cadastro.getEndereco());
				pstm.setInt(7, cadastro.getId());
	
				pstm.execute();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM cadastro WHERE id= ?";
		Connection conn =null;
		
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!= null)	{
					pstm.close();
					}
				if(conn != null){
					conn.close();
			}
			
		  }catch (Exception e) {
			  e.printStackTrace();
		}		
		}
	}
	
	public List<Cadastro> getCadastro(){
		
		String sql = "SELECT * FROM cadastro";
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que vai recuperar dados do BD
		ResultSet rset= null;
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Cadastro cadastro = new Cadastro();
				
				cadastro.setCpf(rset.getString("cpf"));				
				cadastro.setNome(rset.getString("nome"));
				cadastro.setEmail(rset.getString("email"));
				cadastro.setRg(rset.getString("rg"));
				cadastro.setEndereco(rset.getString("endereco"));
				cadastro.setTelefone(rset.getString("telefone"));
				
				cadastros.add(cadastro);		
				
			}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {		if(rset!=null) {
					rset.close();
				}
			
				if(pstm!=null) {
					pstm.close();
				}
			
				if(conn!=null) {
					conn.close();
			
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
			return cadastros;
	
		}
}
