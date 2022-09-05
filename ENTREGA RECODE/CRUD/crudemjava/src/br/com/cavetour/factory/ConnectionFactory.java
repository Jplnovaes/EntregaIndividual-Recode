package br.com.cavetour.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usuario do mysql
		private static final String USERNAME = "root";
		
	//Senha do BD
		private static final String PASSWORD = "" ;
		
		//Camnhinho do  BD
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro";
		
		//CONEXAO COM BANCO DE DADOS
		
		public static Connection createConnectionToMySQL() throws Exception {
			//Faz com que a classe seja carregada pela JVM 
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			return connection;
		}
		
		
		public static void main(String[] args) throws Exception {
			
			//Recuperar conexão com o BD
			Connection con = createConnectionToMySQL();
			
			
			if(con!=null) {
				System.out.println("Conexão obetida com sucesso!");
				con.close();
			}
			
		}
	
}
		
