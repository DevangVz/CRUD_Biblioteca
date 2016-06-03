package org.biblioteca.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.biblioteca.dao.AuthorDAO;
import org.biblioteca.dao.BookDAO;
import org.biblioteca.dao.GenreDAO;
import org.biblioteca.dao.PublisherDAO;
import org.biblioteca.model.Author;
import org.biblioteca.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Component
@RestController
@RequestMapping("/books")
public class BookController {
	
	 Client client;
	  
	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	PublisherDAO publisherDAO;
	
	@Autowired
	AuthorDAO authorDAO;
	
	@Autowired
	GenreDAO genreDAO;

	@RequestMapping (value="/")
	public ModelAndView  listing(){
		List<Book> listBook= bookDAO.getAll();
		return new ModelAndView("index","list",listBook);
	}
	
	@RequestMapping(value="/form/register",method = RequestMethod.GET)  
	public ModelAndView edit(Model model, HttpServletRequest res) throws Exception{
		model.addAttribute("PublisherList",publisherDAO.getAll());
		model.addAttribute("GenreList",genreDAO.getAll());
		model.addAttribute("AuthorList",authorDAO.getAll());
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("MEX");
		countries.add("USA");
		countries.add("COL");
		countries.add("PER");
		model.addAttribute("Countries",countries);
		return new ModelAndView("bookForm","command",new Book());
		
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public int save(@ModelAttribute("book") Book book, @RequestParam Map
			<String,String> map, HttpServletRequest request ){
		//Book book, int publisher, int author, Date published, int numEdition
	ArrayList<String> authors=new ArrayList<String>();
	Collections.addAll(authors, request.getParameterValues("authors"));
			return bookDAO.save(book,
					Integer.valueOf(map.get("publisherID")),
					authors,
					Date.valueOf(map.get("publishedDate")),
					Integer.valueOf(map.get("numEdition")));
					
	
	}

	//	@RequestMapping("/CountryCode")
	//	public String countryCode(Model model ) throws Exception{
	//	Theres a rule about connections in the company, so, we cannot connect to Web Services
	//		WebService.setUserName("DevangVz"); // add your username here
	//		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
	//		searchCriteria.setQ("zurich");
	//		ToponymSearchResult searchResult = WebService.search(searchCriteria);
	//		for (Toponym toponym : searchResult.getToponyms()) {
	//			System.out.println(toponym.getName()+" "+ toponym.getCountryCode());
	//			
	//		}
	//		return toponym.getCountryCode();
	//https://restcountries.eu/rest/v1/all
	//		 String callResult = client
	//		         .target("https://restcountries.eu")
	//		         .path("/rest/v1/all")
	//		         .request(MediaType.APPLICATION_XML)
	//		         .post(Entity.text(null),	
	//		            String.class);
	//		RestTemplate sd= new RestTemplate();
	//		String sde= sd.getForObject("https://restcountries.eu/rest/v1/all",String.class);
	//		WebTarget a = client.target("http://api.geonames.org")
	//        .path("/postalCodeCountryInfo?username=demo")
	//        .request(MediaType.APPLICATION_XML)
	//		return sde;
	//	}

}
