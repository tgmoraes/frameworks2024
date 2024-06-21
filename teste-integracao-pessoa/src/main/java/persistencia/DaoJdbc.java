package persistencia;

import java.sql.Connection;
import java.util.List;

public abstract class DaoJdbc<T> implements Dao<T>{
	private Connection con;
	public DaoJdbc() {
		this.con = FabricaConexao.getConexao();
	}
	public DaoJdbc(Connection con) {
		this.con = con;
	}
	public Connection getCon() {
		return this.con;
	}
	
}
