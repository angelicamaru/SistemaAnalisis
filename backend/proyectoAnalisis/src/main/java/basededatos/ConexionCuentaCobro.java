package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionCuentaCobro {
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

	public Boolean existe(String idProveedor, String mes) {
		conexion();
		Boolean existeC = true;

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT 1 FROM CuentaCobro WHERE idProveedor= " + idProveedor + "AND" + "mes=" + mes)) {
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

	// Traer nombre
	public String nombre(String idProveedor, String mes) {
		conexion();
		String nombre = "";

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT nombre FROM CuentaCobro WHERE idProveedor= " + idProveedor + "AND" + "mes=" + mes)) {
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			nombre = rs.getString("nombre");
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return nombre;
	}
	
	
	// Traer id
		public String id(String idProveedor, String mes) {
			conexion();
			String id = "";

			try (PreparedStatement stmt = con.prepareStatement(
					"SELECT idCuentaCobro FROM CuentaCobro WHERE idProveedor= " + idProveedor + "AND" + "mes=" + mes)) {
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				id = rs.getString("idCuentaCobro");
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

			return id;
		}
		
		

	// Añadir nueva cuenta de cobro
	public void nuevaCuentaCobro(String idProveedor, String mes, String nombre) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO CuentaCobro VALUES (null,'" + idProveedor + "','" + nombre + "','" + mes + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

}