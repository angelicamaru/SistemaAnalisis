package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Proveedor;

public class ConexionProveedor {
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

	// Añadir nuevo proveedor
	public void nuevoProveedor(Proveedor nuevoProveedor) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Proveedor VALUES (null,'" + nuevoProveedor.getNombre() + "','"
						+ nuevoProveedor.getTelefono() + "','" + nuevoProveedor.getCorreo() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}

	// Traer nombres
	public ArrayList<String> traerNombres() {
		conexion();

		ArrayList<String> nombres = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT nombre FROM Proveedor")) {
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
        
        // Traer todo
	public ArrayList<Proveedor> traerTodo() {
		conexion();

		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Proveedor")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
                                String telefono = rs.getString("telefono");
                                String correo = rs.getString("correo");
				System.out.println(nombre);
				proveedores.add(new Proveedor(nombre, telefono, correo));
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(proveedores);
		return proveedores;

	}

	// Traer id
	public int id(String nombre) {
		conexion();
		int id = 0;

		try (PreparedStatement stmt = con
				.prepareStatement("SELECT idProveedor FROM Proveedor WHERE nombre= '" + nombre + "'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs);
				id = rs.getInt("idProveedor");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return id;
	}

	
	//Modificar proveedor
	public void modP(Proveedor provMod) {
		conexion();

		try (PreparedStatement stmt = con.prepareStatement(
				"UPDATE proveedor SET nombre = '"+provMod.getNombre()+"', telefono = '"+provMod.getTelefono()+"', correo = '"+provMod.getCorreo()+"' "
						+ "WHERE idProveedor ='"+provMod.getIdProveedor()+"'")){
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}
	
	//Eliminar proveedor
	public void eliminarP(Proveedor nombre) {
		conexion();

		try (PreparedStatement stmt = con.prepareStatement("DELETE FROM proveedor WHERE nombre = '"+nombre.getNombre()+"'")){
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

	}
}