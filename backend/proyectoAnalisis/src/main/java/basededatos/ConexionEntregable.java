package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Entregable;
import com.entidades.Proveedor;
import com.entidades.Solicitud;

public class ConexionEntregable {
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

	// Añadir nuevo Entregable
	public void nuevoEntregable(Entregable nuevoEntregable) {
		conexion();
		
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Entregable VALUES (null,'" + nuevoEntregable.getEntregable() + "','" + nuevoEntregable.getPrecioProveedor()
						+ "','" + nuevoEntregable.getPrecioCliente() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		
		

	}

	// Traer nombres
	public ArrayList<String> traerNombres() {
		conexion();

		ArrayList<String> nombres = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT entregable FROM Entregable")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("entregable");
				
				nombres.add(nombre);
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(nombres);
		return nombres;

	}
        
        // Traer entregable
	public ArrayList<Entregable> traerTodo() {
		conexion();

		ArrayList<Entregable> entregables = new ArrayList<Entregable>();

		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Entregable")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("entregable");
                                double precioProveedor = rs.getDouble("precioProveedor");
                                double precioCliente = rs.getDouble("precioCliente");
                                int id = rs.getInt("idEntregable");
				entregables.add(new Entregable(id,nombre, precioProveedor, precioCliente));
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		System.out.println(entregables);
		return entregables;

	}

	// Traer id
	public int id(String nombre) {
		conexion();
		int id = 0;
		
		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT idEntregable FROM Entregable WHERE entregable='" + nombre+"'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			
			id = rs.getInt("idEntregable");
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		return id;
	}

	
	//ModCliente
	public void modE(Entregable entregableMod) {
		conexion();

		try (PreparedStatement stmt = con.prepareStatement(
				"UPDATE entregable SET entregable = '"+entregableMod.getEntregable()+"', precioProveedor = '"+entregableMod.getPrecioProveedor()+"', precioCliente = '"+entregableMod.getPrecioProveedor()+ "' WHERE idEntregable ='"+entregableMod.getIdEntregable()+"'")){
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}

		
		
	}
	
		
        //Eliminar cliente
        public void eliminarE(Entregable nombre) {
                conexion();

                System.out.println(nombre.getEntregable());
                try (PreparedStatement stmt = con.prepareStatement("DELETE FROM Entregable WHERE entregable = '"+nombre.getEntregable()+"'")){
                        stmt.executeUpdate();
                } catch (SQLException sqle) {
                        System.out.println("Error en la ejecuciÃƒÂ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
                }

        }

}