package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionEjecucion {
	private final String url = "jdbc:mysql://localhost/vidadeestudiante?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public void conexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "Milonga");

			if (con != null) {
				System.out.println("ConexiÃ³n a base de datos funcionando");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			System.out.println(" Algo fallo");// las mostramos en consola
		}

	}

	// Conectar
	public Connection conectado() {
		return con;
	}

	// Desconectar
	public void desconectar() {
		con = null;
		System.out.println("La conexion la BD se ha cerrado");
	}

	// Metodos sql

	// Validar existencia

	public Boolean existe(String idCliente, String mes) {
		conexion();
		Boolean existeC = true;

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT 1 FROM Ejecucion WHERE idCliente= " + idCliente + "AND" + "mes=" + mes)) {
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			if (rs == null) { // NOTA: Puede no funcionar este rs con null :(
				existeC = false;
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return existeC;
	}

	// Traer descripcion
	public String descripcion(String idCliente, String mes) {
		conexion();
		String descripcion = "";

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT descripcion FROM Ejecucion WHERE idCliente= " + idCliente + "AND" + "mes=" + mes)) {
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			descripcion = rs.getString("descripcion");
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return descripcion;
	}
	
	
	// Traer id
		public String id(String idCliente, String mes) {
			conexion();
			String id = "";

			try (PreparedStatement stmt = con.prepareStatement(
					"SELECT idEjecucion FROM Ejecucion WHERE idCliente= " + idCliente + "AND" + "mes=" + mes)) {
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				id = rs.getString("idEjecucion");
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

			return id;
		}
		
		

	// Añadir nueva ejecucion
	public void nuevaEjecucion(String idCliente, String mes, String descripcion) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Ejecucion VALUES (null,'" + descripcion + "','" + mes + "','" + idCliente + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

}