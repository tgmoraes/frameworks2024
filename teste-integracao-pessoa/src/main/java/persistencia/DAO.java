package persistencia;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
	private Connection con;
	public DAO() {
		this.con = FabricaConexao.getConexao();
	}
	public DAO(Connection con) {
		this.con = con;
	}
	public Connection getCon() {
		return this.con;
	}
	public abstract void insert(T obj);
	public abstract void delete(int id);
	public abstract void update(T obj);
	public abstract List<T> list(int limit, int offset);
	public abstract T get(int id);
}
