package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.biblioteca.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class PublisherDAO {
	@Autowired
	JdbcTemplate dataSource;

	public int save(Publisher publisher){  
		String sql="INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES(?,?,?,?);";  
		return dataSource.update(sql,publisher.getPName(),publisher.getCountrycode(),publisher.getAddress(),publisher.getZC());
	} 

	public int update(Publisher publisher){
		String sql="UPDATE Publisher SET pName=?,countrycode=?,address=?,ZC=?;";
		return dataSource.update(sql,publisher.getPName(),publisher.getCountrycode(),publisher.getAddress(),publisher.getZC());  
	}

	public int delete(int id){  
	    String sql="delete from Publisher where ID=?";  
	    return dataSource.update(sql,id);
	}  

	public Publisher getPublisherByID(int id){
 		String sql="select * from Author where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Publisher>(Publisher.class));  
	}

	public List<Publisher> getAll(){
		return dataSource.query("select id, pName,countrycode,address,ZC from Publisher",new RowMapper<Publisher>(){  
	        public Publisher mapRow(ResultSet rs, int row) throws SQLException {  
	        	Publisher publisher =new Publisher();  
	        	publisher.setID(rs.getInt(1));
	        	publisher.setPName(rs.getString(2));
	        	publisher.setCountrycode(rs.getString(3));
	        	publisher.setAddress(rs.getString(4));
	        	publisher.setZC(rs.getString(5));
	            return publisher;  
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
