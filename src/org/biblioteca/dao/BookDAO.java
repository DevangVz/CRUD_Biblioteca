package org.biblioteca.dao;

import java.util.HashMap;
import java.util.Map;

import org.biblioteca.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	
	
	JdbcTemplate dataSource;

	public int save(Book book){
		String sql="INSERT INTO Book (title,authorID,published,countrycode,ISBN,genreID,publisherID,pages) VALUES(:title,:authorID,:published,:countrycode,:ISBN,:genreID,:publisherID,:pages);";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", book.getID());
		parameters.put("authorID", book.getAuthorID());
		parameters.put("published", book.getPublished());
		parameters.put("countrycode", book.getCountrycode());
		parameters.put("ISBN", book.getISBN());
		parameters.put("genreID", book.getGenreID());
		parameters.put("publisherID", book.getPublisherID());
		parameters.put("pages", book.getPages());
		return dataSource.update(sql,parameters);  
	}

	public JdbcTemplate getTemplate() {
		return dataSource;
	}

	public void setDataSource(JdbcTemplate template) {
		this.dataSource = template;
	}
}
