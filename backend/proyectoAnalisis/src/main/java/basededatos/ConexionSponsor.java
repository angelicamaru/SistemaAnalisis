package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Proveedor;
import com.entidades.Sponsor;

public class ConexionSponsor {
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

	// Añadir nuevo sponsor
	public void nuevoSponsor(Sponsor nuevoSponsor) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Sponsor VALUES (null,'" + nuevoSponsor.getNombre() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

	// Traer nombres
	public ArrayList<String> traerNombres() {
		conexion();

		ArrayList<String> nombres = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT nombre FROM Sponsor")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				System.out.println(nombre);
				nombres.add(nombre);
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(nombres);
		return nombres;

	}

	// Traer id
	public int id(String nombre) {
		conexion();
		int id = 0;

		try (PreparedStatement stmt = con.prepareStatement("SELECT idSponsor FROM Sponsor WHERE nombre= '" + nombre+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs);
			id = rs.getInt("idSponsor");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return id;
	}
	//Modificar sponsor
		public void modS(Sponsor spoMod) {
			conexion();

			try (PreparedStatement stmt = con.prepareStatement(
					"UPDATE sponsor SET nombre = '"+spoMod.getNombre()+"' "
							+ "WHERE idSponsor ='"+spoMod.getIdSponsor()+"'")){
				stmt.executeUpdate();
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

		}
		
		//Eliminar sponsor
		public void eliminarS(Sponsor idS) {
			conexion();

			try (PreparedStatement stmt = con.prepareStatement("DELETE FROM sponsor WHERE idSponsor = '"+idS.getIdSponsor()+"'")){
				stmt.executeUpdate();
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

		}
	

}