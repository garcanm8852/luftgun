package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MCliente {
	Connection Conexion;
	PreparedStatement ps;
	ResultSet cargaCliente;
	ResultSet cargaID;
	int idCliente;
	String Nombre;
	String Apellido;
	String Email;
	String Contrasena;
	String EstadoCliente;
	int ultimoID;
	boolean estado = false;
	final String URL = "jdbc:postgresql://ns3034756.ip-91-121-81.eu/a20-mgarde";
	final String USER = "a20-mgarde";
	final String PASSW = "a20-mgarde";

	public void establecerConexion() {
		try {
			Conexion = DriverManager.getConnection(URL, USER, PASSW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			Conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DatosInicioSesion(String pEmail, String pContrasena) {
		try {
			establecerConexion();
			ps = Conexion.prepareStatement("SELECT * FROM luftgun.datosclientesesion(?,?)");
			ps.setString(1, pEmail);
			ps.setString(2, pContrasena);
			cargaCliente = ps.executeQuery();
			cargaCliente.next();
			cerrarConexion();
		} catch (Exception e) {
		}
	}

	public boolean ExisteCliente(String pEmail) {
		try {
			establecerConexion();
			ps = Conexion.prepareStatement("SELECT * FROM luftgun.cliente where email = ?");
			ps.setString(1, pEmail);
			cargaCliente = ps.executeQuery();
			cargaCliente.next();
			cerrarConexion();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public int nextID() {
		ultimoID = 0;
		cargaID = null;
		try {
			establecerConexion();
			ps = Conexion.prepareStatement("SELECT MAX(idcliente) FROM luftgun.cliente");
			cargaID = ps.executeQuery();
			cargaID.next();
			cerrarConexion();

			ultimoID = cargaID.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ultimoID;
	}

	public void insertarCliente(int pIdcliente, String pnombre, String pApellido, String pEmail, String pContrasena) {
		try {
			establecerConexion();
			ps = Conexion.prepareStatement(
					"INSERT INTO luftgun.cliente(idcliente, nombre, apellido, email, contrasena, estado) VALUES (?, ?, ?, ?, ?, ?); ");
			ps.setInt(1, pIdcliente);
			ps.setString(2, pnombre);
			ps.setString(3, pApellido);
			ps.setString(4, pEmail);
			ps.setString(5, pContrasena);
			ps.setString(6, "No Operativo");
			ps.execute();
			cerrarConexion();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CambiarEstado(int pIdcliente, String pEstado) {

		try {
			establecerConexion();
			ps = Conexion.prepareStatement("UPDATE luftgun.cliente SET estado=?	WHERE idcliente =?");
			ps.setString(1, pEstado);
			ps.setInt(2, pIdcliente);
			ps.execute();
			cerrarConexion();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getIdcliente() {
		idCliente = 0;
		try {
			idCliente = cargaCliente.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return idCliente;
	}

	public String getNombre() {
		Nombre = "";
		try {
			Nombre = cargaCliente.getString(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Nombre;
	}

	public String getApellido() {
		Apellido = "";
		try {
			Apellido = cargaCliente.getString(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Apellido;
	}

	public String getEmail() {
		Email = "";
		try {
			Email = cargaCliente.getString(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return Email;
	}

	public String getContrasena() {
		Contrasena = "";
		try {
			Contrasena = cargaCliente.getString(5);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return Contrasena;
	}
	
	public String getEstadoCliente() {
		EstadoCliente = "";
		try {
			EstadoCliente = cargaCliente.getString(6);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return EstadoCliente;
	}




}
