package org.biblioteca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.biblioteca.model.Author;
import org.biblioteca.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	
	
	JdbcTemplate dataSource;

	public int save(Book book){
		String sql="INSERT INTO Book (title,authorID,published,countrycode,ISBN,genreID,publisherID,pages) VALUES(?,?,?,?,?,?,?,?);";
		return dataSource.update(sql,book.getTitle(),book.getAuthorID(),book.getPublished(),book.getCountrycode(),book.getISBN(),book.getGenreID(),book.getPublisherID(),book.getPages());  
	}
	
	public int update (Book book){
		String sql= "UPDATE Book SET title=?, authorID=?, published=?, countrycode=?, ISBN=?, genreID=?, publisherID=?,pages=?;";
		return dataSource.update(sql,sql,book.getTitle(),book.getAuthorID(),book.getPublished(),book.getCountrycode(),book.getISBN(),book.getGenreID(),book.getPublisherID(),book.getPages());
	}

	public int delete(int id){  
	    String sql="delete from Book where ID=?";  
	    return dataSource.update(sql,id);
	}  
	
	public Author getAuthorByID(int id){
 		String sql="select * from Book where id=?"; 
	    return dataSource.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Author>(Author.class));  
	}
	
	public List<Book> getAll(){
		return dataSource.query("select ID, title,authorID,published,countrycode,ISBN,genreID,publisherID,pages from Book",new RowMapper<Book>(){  
	        public Book mapRow(ResultSet rs, int row) throws SQLException {  
	        	Book book=new Book();  
	        	book.setID(rs.getInt(1));
	        	book.setTitle(rs.getString(2));
//	        	author.setLastName(rs.getString(3));
//	        	author.setDOB(rs.getDate(4));
//	        	author.setNationality(rs.getString(5));
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
