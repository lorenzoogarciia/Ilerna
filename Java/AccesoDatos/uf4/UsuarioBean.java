package uf4;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioBean {
	public List<Usuarito> getUsuarios() throws SQLException;
	public void insertUsuario(Usuarito usuarito) throws SQLException;
}
