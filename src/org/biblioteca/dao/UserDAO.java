package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.biblioteca.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate dataSource;

	public int save(User user){  
		String sql="INSERT INTO User (cName,lastname,OCR) VALUES(?,?,?);";  
		return dataSource.update(sql, user.getCName(),user.getLastName(),user.getOCR());
	} 

	public int update(User User){
		String sql="UPDATE User SET cName=?,lastname=?,OCR=?;";
		return dataSource.update(sql);  
	}

	public int delete(int id){  
	    String sql="delete from User where ID=?";  
	    return dataSource.update(sql,id);
	}  

	public User getUserByID(int id){
 		String sql="select * from User where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));  
	}

	public List<User> getAll(){
		return dataSource.query("select cName,lastname,OCR from User",new RowMapper<User>(){  
	        public User mapRow(ResultSet rs, int row) throws SQLException {  
	        	User user =new User();  
	        	user.setID(rs.getInt(1));
	        	user.setLastName(rs.getString(2));
	        	user.setOCR(rs.getString(3));
	            return user;  
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
