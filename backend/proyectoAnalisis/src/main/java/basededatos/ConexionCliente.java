package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Proveedor;
import com.entidades.Solicitud;

public class ConexionCliente {
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

	// Añadir nuevo cliente
	public void nuevoCliente(Cliente nuevoCliente) {
		conexion();
		System.out.println(nuevoCliente.isEmpresa());
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Cliente VALUES (null,'" + nuevoCliente.getNombre() + "','" + nuevoCliente.isEmpresa()
						+ "','" + nuevoCliente.getDireccion() + "','" + nuevoCliente.getTelefono() + "','"
						+ nuevoCliente.getCorreo() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		
		

	}

	// Traer nombres
	public ArrayList<String> traerNombres() {
		conexion();

		ArrayList<String> nombres = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT nombre FROM Cliente")) {
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
        
        // Traer toda la info. de clientes
	public ArrayList<Cliente> traerTodo() {
		conexion();

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Cliente")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String empresa = Boolean.toString(rs.getBoolean("empresa"));
                                String direccion = rs.getString("direccion");
                                String telefono = rs.getString("telefono");
                                String correo = rs.getString("correo");
				clientes.add(new Cliente(nombre, Integer.parseInt(empresa), direccion, telefono, correo));
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(clientes);
		return clientes;

	}

	// Traer id
	public int id(String nombre) {
		conexion();
		int id = 0;
		
		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT idCliente FROM Cliente WHERE nombre='" + nombre+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getInt("idCliente"));
			id = rs.getInt("idCliente");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return id;
	}

	
	//ModCliente
	public void modC(Cliente clienteMod) {
		conexion();

		try (PreparedStatement stmt = con.prepareStatement(
				"UPDATE cliente SET nombre = '"+clienteMod.getNombre()+"', telefono = '"+clienteMod.getTelefono()+"', correo = '"+clienteMod.getCorreo()+"', direccion = '"+clienteMod.getDireccion()+"', empresa = '"+clienteMod.isEmpresa()+" "
						+ "' WHERE idCliente ='"+clienteMod.getIdCliente()+"'")){
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		
		
	}
	
		
		//Eliminar cliente
		public void eliminarC(Cliente nombre) {
			conexion();

			try (PreparedStatement stmt = con.prepareStatement("DELETE FROM cliente WHERE nombre = '"+nombre.getNombre()+"'")){
				stmt.executeUpdate();
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

		}

}