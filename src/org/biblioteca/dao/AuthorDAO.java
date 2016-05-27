package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.biblioteca.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class AuthorDAO {
	@Autowired
	JdbcTemplate dataSource;

	public int save(Author p){  
		String sql="INSERT INTO Author (AName,lastName,DOB,nationality) VALUES (?,?,?,?)";  
		return dataSource.update(sql,p.getAName(),p.getLastName(),p.getDOB(),p.getNationality());
	} 

	public int update(Author author){
		String sql="UPDATE Author SET AName=?,lastName=?,DOB=?,nationality=? where id =?;";
		return dataSource.update(sql,author.getAName(),author.getLastName(),author.getDOB(),author.getNationality(),author.getID());  
	}

	public int delete(int id){  
	    String sql="delete from Author where ID=?";  
	    return dataSource.update(sql,id);
	}  
	
	public Author getAuthorByID(int id){
 		String sql="select * from Author where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Author>(Author.class));  
	}
	
	public List<Author> getAll(){
		return dataSource.query("select ID, AName,lastName,DOB,nationality from Author",new RowMapper<Author>(){  
	        public Author mapRow(ResultSet rs, int row) throws SQLException {  
	        	Author author=new Author();  
	        	author.setID(rs.getInt(1));
	        	author.setAName(rs.getString(2));
	        	author.setLastName(rs.getString(3));
	        	author.setDOB(rs.getDate(4));
	        	author.setNationality(rs.getString(5));
	            return author;  
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
