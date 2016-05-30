package org.biblioteca.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.biblioteca.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	
	@Autowired
	JdbcTemplate dataSource;

	public int save(Book book, int publisher, int author, Date published, int numEdition){
		String sql="INSERT INTO Book (title,countrycode,ISBN,genreID,pages) VALUES(?,?,?,?,?);"
				+ "INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(?,?,?,?)"
				+ "INSERT INTO AuthorBook (bookID, authorID) VALUES (?,?); ";
		//Falta numero de edición y fecha de publicacion 
		return dataSource.update(sql,book.getTitle(),book.getCountrycode(),book.getISBN(),book.getGenreID(),book.getPages(),
				book.getID(), publisher,published, numEdition,
				book.getID(), author);  
	}
	
	public int update (Book book){
		String sql= "UPDATE Book SET title=?,  countrycode=?, ISBN=?, genreID=?, pages=?;";
		return dataSource.update(sql,book.getTitle(),book.getCountrycode(),book.getISBN(),book.getGenreID(),book.getPages());
	}

	public int delete(int id){  
	    String sql="delete from Book where ID=?";  
	    return dataSource.update(sql,id);
	}  
	
	public Book getBookByID(int id){
 		String sql="select * from Book where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Book>(Book.class));  
	}
	
	public List<Book> getAll(){
		return dataSource.query("select ID, title,countrycode,ISBN,genreID,pages from Book",new RowMapper<Book>(){  
	        public Book mapRow(ResultSet rs, int row) throws SQLException {  
	        	Book book=new Book();  
	        	book.setID(rs.getInt(1));
	        	book.setTitle(rs.getString(2));
	           	book.setCountrycode(rs.getString(3));
	        	book.setISBN(rs.getString(rs.getString(4)));
	        	book.setGenreID(rs.getInt(5));
	           	book.setPages(rs.getInt(6));
	            return book;  
	        }  
	    });  
	}
	public JdbcTemplate getTemplate() {
		return dataSource;
	}

	public void setDataSource(JdbcTemplate template) {
		this.dataSource = template;
	}
}
