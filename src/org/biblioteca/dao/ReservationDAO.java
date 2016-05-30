package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.biblioteca.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ReservationDAO {
	@Autowired
	JdbcTemplate dataSource;

	public int save(Reservation reservation){  
		String sql="INSERT INTO Reservation (clientID,bookID,borrowedDate,returnDate) VALUES(?,?,?,?);";  
		return dataSource.update(sql,reservation.getClientID(),reservation.getBookID(),reservation.getBorrowedDate(),reservation.getReturnDate());
	} 

	public int update(Reservation reservation){
		String sql="UPDATE Reservation SET clientID=?, bookID=?,borrowedDate=?,returnDate=? where id =?;";
		return dataSource.update(sql,reservation.getClientID(),reservation.getBookID(),reservation.getBorrowedDate(),reservation.getReturnDate());  
	}

	public int delete(int id){  
	    String sql="delete from Reservation where ID=?";  
	    return dataSource.update(sql,id);
	}  

	public Reservation getReservationByID(int id){
 		String sql="select * from Reservation where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Reservation>(Reservation.class));  
	}

	public List<Reservation> getAll(){
		return dataSource.query("select ID, clientID, bookID, borrowedDate, returnDate",new RowMapper<Reservation>(){  
	        public Reservation mapRow(ResultSet rs, int row) throws SQLException {  
	        	Reservation reservation=new Reservation();  
	        	reservation.setID(rs.getInt(1));
	        	reservation.setClientID(rs.getInt(2));
	        	reservation.setBookID(rs.getInt(3));
	        	reservation.setBorrowedDate(rs.getDate(5));
	        	reservation.setReturnDate(rs.getDate(6));
	            return reservation;  
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
