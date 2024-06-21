package persistencia;

import java.util.List;

public interface Dao<T> {
	public abstract void insert(T obj);
	public abstract void delete(int id);
	public abstract void update(T obj);
	public abstract List<T> list(int limit, int offset);
	public abstract T get(int id);
}
