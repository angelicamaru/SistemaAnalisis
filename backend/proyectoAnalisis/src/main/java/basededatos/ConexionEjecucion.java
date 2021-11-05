package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionEjecucion {
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

	public Boolean existe(int idCliente, String mes) {
		conexion();
		Boolean existeC = false;

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT * FROM Ejecucion WHERE idCliente= '" + idCliente + "' AND " + "mes='" + mes+"'")) {
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				existeC = true;			
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return existeC;
	}

	// Traer descripcion
	public String descripcion(int idCliente, String mes) {
		conexion();
		String descripcion = "";

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT descripcion FROM Ejecucion WHERE idCliente= '" + idCliente + "' AND " + "mes='" + mes+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs);
			descripcion = rs.getString("descripcion");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return descripcion;
	}
	
	
	// Traer id
		public int id(int idCliente, String mes) {
			conexion();
			int id = 0;

			try (PreparedStatement stmt = con.prepareStatement(
					"SELECT idEjecucion FROM Ejecucion WHERE idCliente= '" + idCliente + "' AND " + "mes='" + mes+"'")) {
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				while (rs.next()) {
				id = rs.getInt("idEjecucion");
				}
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

			return id;
		}
		
		

	// Añadir nueva ejecucion
	public void nuevaEjecucion(int idCliente, String mes, String descripcion) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Ejecucion VALUES (null,'" + descripcion + "','" + mes + "','" + idCliente + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

	
	//Precio total de las solicitudes
	public double total(int id) {
		double t=0;
		System.out.println("SELECT SUM(entregable.precioCliente*solicitud.cantidad) as total from entregable inner join solicitud on Entregable.idEntregable "
				+ " = solicitud.idEntregable where solicitud.idEjecucion = "+id+")"); 
			
		try (PreparedStatement stmt = con.prepareStatement("SELECT SUM(entregable.precioCliente*solicitud.cantidad) as total from entregable inner join solicitud on Entregable.idEntregable "
				+ " = solicitud.idEntregable where solicitud.idEjecucion = "+id)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs);
				t = rs.getDouble("total");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		
		return t;
	}
	
	//Total por solicitud
	public double totalSolicitud(int id) {
		double t=0;
		System.out.println("SELECT SUM(entregable.precioCliente*solicitud.cantidad) as total from entregable inner join solicitud on Entregable.idEntregable "
				+ " = solicitud.idEntregable where solicitud.idEjecucion = "+id+")"); 
			
		try (PreparedStatement stmt = con.prepareStatement("SELECT SUM(entregable.precioCliente*solicitud.cantidad) as total from entregable inner join solicitud on Entregable.idEntregable "
				+ " = solicitud.idEntregable where solicitud.idEjecucion = "+id)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs);
				t = rs.getDouble("total");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		
		return t;
	}
	
	
	
		

}