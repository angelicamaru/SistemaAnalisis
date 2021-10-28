package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionCuentaCobro {
	private final String url = "jdbc:mysql://localhost:3306/analisisproyecto?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public void conexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "analisis2021");

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

	public Boolean existe(int idProveedor, String mes) {
		conexion();
		Boolean existeC = false;

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT * FROM CuentaCobro WHERE idProveedor= '" + idProveedor + "'AND " + "mes='" + mes+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				existeC = true;			
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return existeC;
	}

	// Traer nombre
	public String nombre(int idProveedor, String mes) {
		conexion();
		String nombre = "";

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT nombre FROM CuentaCobro WHERE idProveedor= '" + idProveedor + "' AND " + "mes='" + mes+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs);
				nombre = rs.getString("nombre");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return nombre;
	}

	// Traer id
	public int id(int idProveedor, String mes) {
		conexion();
		int id = 0;

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT idCuentaCobro FROM CuentaCobro WHERE idProveedor= '" + idProveedor + "' AND " + "mes='" + mes+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs);
				id = rs.getInt("idCuentaCobro");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return id;
	}

	// Añadir nueva cuenta de cobro
	public void nuevaCuentaCobro(int idProveedor, String mes, String nombre) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO CuentaCobro VALUES (null,'" + nombre + "','" + mes + "','" + idProveedor + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

}