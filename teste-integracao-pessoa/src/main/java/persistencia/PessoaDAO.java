package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO extends DaoJdbc<Pessoa>{
	
	public PessoaDAO(Connection con) {
		super(con);
	}
	public PessoaDAO() {
		super();
	}
	//@Override
	public void insert(Pessoa obj) {
		if(obj.getId() != null)
			throw new RuntimeException("Nao pode inserir objeto que ja existe no bd");
		
		String consulta = "INSERT INTO \"Pessoa\" (\"nome\",\"dataNascimento\") "
		+ "VALUES (?,?) RETURNING \"id\"";
		
		try {
			PreparedStatement pstm = this.getCon().prepareStatement(consulta);
			pstm.setString(1, obj.getNome());
			pstm.setObject(2, obj.getDataNascimento());
			ResultSet rs = pstm.executeQuery();
			rs.next();
			obj.setId(rs.getInt("id"));
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	@Override
	public void update(Pessoa p) {
		if(p.getId() == null)
			throw new RuntimeException("Nao pode alterar objeto que nao existe no bd");
		
		String sql = "UPDATE \"Pessoa\" SET nome=?, \"dataNascimento\"=?"
				+ "WHERE id =?";
		try{
			PreparedStatement pstm = this.getCon().prepareStatement(sql);
			pstm.setString(1, p.getNome());
			pstm.setObject(2, p.getDataNascimento());
			pstm.setInt(3, p.getId());
			pstm.execute();
			pstm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void save(Pessoa p) {
		if(p.getId()==null) this.insert(p);
		else this.update(p);
	}
	
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM \"Pessoa\" WHERE id=?";
		try{
			PreparedStatement pstm = this.getCon().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Pessoa> list(int limit, int offset) {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		String sql = "SELECT id, nome, \"dataNascimento\" FROM \"Pessoa\" LIMIT ? OFFSET ?";
		try {
			PreparedStatement pstm = this.getCon().prepareStatement(sql);
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) lista.add(montaObj(rs));
			
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}

	private Pessoa montaObj(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String nome = rs.getString("nome");
		LocalDate dataNasc = rs.getObject("datanascimento", LocalDate.class);
		return new Pessoa(id, nome, dataNasc);
	}
	
	@Override
	public Pessoa get(int id) {
		Pessoa ret;
		String sql = "SELECT id, nome, \"dataNascimento\" FROM \"Pessoa\" WHERE id=?";
		try {
			PreparedStatement pstm = this.getCon().prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if( rs.next())	ret = montaObj(rs);
			else ret=null;
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return ret;
	}
}
