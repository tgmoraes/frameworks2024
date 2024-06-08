package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Ideia;
import model.Pessoa;

public class IdeiaDAO extends DAO<Ideia> {
	public IdeiaDAO(Connection con) {
		super(con);
	}
	public IdeiaDAO() {
		super();
	}
	@Override
	public void insert(Ideia obj) {
		if(obj.getId() != null)
			throw new RuntimeException("Nao pode inserir objeto que ja existe no bd");
		
		String consulta = "INSERT INTO \"Ideia\" (\"descricao\",\"idAutor\") "
		+ "VALUES (?,?) RETURNING \"id\"";
		
		try {
			PreparedStatement pstm = this.getCon().prepareStatement(consulta);
			pstm.setString(1, obj.getDescricao());
			pstm.setInt(2, obj.getAutor().getId());
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
	public void delete(int id) {
		String sql = "DELETE FROM \"Ideia\" WHERE id=?";
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
	public void update(Ideia obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ideia> list(int limit, int offset) {
		List<Ideia> lista = new ArrayList<Ideia>();
		String sql = "SELECT id, descricao, \"idAutor\", p.nome, p.\"datanascimento\" "
				+ "FROM + \"Pessoa\" p LEFT JOIN  \"Ideia\" i ON p.id = i.\"idAutor\" "
				+ "LIMIT ? OFFSET ?";
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

	private Ideia montaObj(ResultSet rs) throws SQLException {
		String descricao = rs.getString("descricao");
		int idIdeia = rs.getInt("id");
		int idPessoa = rs.getInt("idAutor");
		LocalDate dataNasc = rs.getObject("dataNascimento", LocalDate.class);
		String nome = rs.getString("nome");
		
		Pessoa autor = new Pessoa(idPessoa, nome, dataNasc);
		
		return new Ideia(idIdeia, descricao, autor);
	}
	@Override
	public Ideia get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
