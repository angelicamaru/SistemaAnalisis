package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Solicitud;

public class ConexionSolicitud {
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

	// Añadir solicitud nueva

	public void solicitudNueva(Solicitud solicitud) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO solicitud VALUES (null,'" + solicitud.getNombre() + "','" + solicitud.getCantidad() + "','"
						+ solicitud.getFecha() + "','" + solicitud.getIdEntregable() + "','"
						+ solicitud.getIdEjecucion() + "','" + solicitud.getIdSponsor() + "','"
						+ solicitud.getIdService() + "','" + solicitud.getIdCuentaCobro() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
	}

	// Solicitudes

	public ArrayList<Solicitud> solicitudes(int idCuentaCobro) {

		conexion();

		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();

		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT idSolicitud, nombre, idEntregable,idEjecucion, idSponsor, idServicio, cantidad, fecha FROM Solicitud WHERE idCuentaCobro = "
						+ idCuentaCobro)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Solicitud soli = new Solicitud(rs.getInt("idSolicitud"), rs.getString("nombre"), rs.getInt("cantidad"),
						rs.getString("fecha"), rs.getInt("idEntregable"), rs.getInt("idEjecucion"),
						rs.getInt("idSponsor"), rs.getInt("idServicio"), idCuentaCobro);
				solicitudes.add(soli);
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(solicitudes);
		return solicitudes;
	}
}