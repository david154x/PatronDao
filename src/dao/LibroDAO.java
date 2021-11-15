package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import dto.LibroDTO;
import interfaces.Obligacion;

public class LibroDAO implements Obligacion<LibroDTO>{
	
	private static final String SQL_INSERT = "INSERT INTO libros (isbn, nombre, autor) VALUES (?, ?, ?) ";
	private static final String SQL_DELETE = "DELETE FROM libros WHERE isbn = ?";
	private static final String SQL_UPDATE = "UPDATE libros SET nombre = ?, autor = ? WHERE isbn = ?";
	private static final String SQL_READ = "SELECT * FROM libros WHERE isbn = ? ";
	private static final String SQL_READALL = "SELECT * FROM libros";
	
	private static final Conexion cnn = Conexion.saberEstado();

	@Override
	public boolean create(LibroDTO c) {
		PreparedStatement pstm;
		try {
			pstm = cnn.getCnn().prepareStatement(SQL_INSERT);
			pstm.setString(1, c.getIsbn());
			pstm.setString(2, c.getNombre());
			pstm.setString(3, c.getAutor());
			
			if(pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cnn.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean delete(Object key) {
		PreparedStatement pstm;
		try {
			pstm = cnn.getCnn().prepareStatement(SQL_DELETE);
			pstm.setString(1, key.toString());
			if(pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cnn.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean update(LibroDTO c) {
		PreparedStatement pstm;
		try {
			pstm = cnn.getCnn().prepareStatement(SQL_UPDATE);
			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getAutor());
			pstm.setString(3, c.getIsbn());
			if(pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cnn.cerrarConexion();
		}
		return false;
	}

	@Override
	public LibroDTO read(Object key) {
		PreparedStatement pstm;
		ResultSet rs;
		LibroDTO l = null;
		try {
			pstm = cnn.getCnn().prepareStatement(SQL_READ);
			pstm.setString(1, key.toString());
			rs = pstm.executeQuery();
			while(rs.next()) {
				l = new LibroDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.cerrarConexion();
		}
		return l;
	}

	@Override
	public List<LibroDTO> readAll() {
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<LibroDTO> libros = new ArrayList<>();
		try {
			pstm = cnn.getCnn().prepareStatement(SQL_READALL);
			rs = pstm.executeQuery();
			while(rs.next()) {
				libros.add(new LibroDTO(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.cerrarConexion();
		}
		return libros;
	}
	
}
