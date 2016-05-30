package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.biblioteca.model.Author;
import org.biblioteca.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class GenreDAO {
	@Autowired
	JdbcTemplate dataSource;

	public int save(Genre genre){  
		String sql="INSERT INTO Genre (genreName,description) VALUES(?,?);";  
		return dataSource.update(sql,genre.getGenreName(),genre.getDescription());
	} 

	public int update(Author author){
		String sql="UPDATE Genre SET genreName=?,description=?;";
		return dataSource.update(sql,author.getAName(),author.getMiddleName(),author.getLastName(),author.getDOB(),author.getNationality(),author.getID());  
	}

	public int delete(int id){  
	    String sql="delete Genre Author where ID=?";  
	    return dataSource.update(sql,id);
	}  

	public Genre getGenreByID(int id){
 		String sql="select * from Genre where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Genre>(Genre.class));  
	}

	public List<Genre> getAll(){
		return dataSource.query("select ID, genreName,description from Genre",new RowMapper<Genre>(){  
	        public Genre mapRow(ResultSet rs, int row) throws SQLException {  
	        	Genre genre=new Genre();
	        	genre.setID(rs.getInt(1));
	        	genre.setGenreName(rs.getString(2));
	        	genre.setDescription(rs.getString(3));
	        	return genre;  
	        }  
	    });  
	}
		
	public JdbcTemplate getDataSource() {
		return dataSource;
	}

	public void setDataSource(JdbcTemplate dataSource) {
		this.dataSource = dataSource;
	}
}
