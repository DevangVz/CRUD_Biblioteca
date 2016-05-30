package org.biblioteca.control;

import java.util.List;
import java.util.Map;

import org.biblioteca.dao.BookDAO;
import org.biblioteca.dao.PublisherDAO;
import org.biblioteca.model.Author;
import org.biblioteca.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Component
@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	PublisherDAO publisherDAO;

	@RequestMapping (value="/")
	public ModelAndView  listing(){
		List<Book> listBook= bookDAO.getAll();
		return new ModelAndView("index","list",listBook);
	}
	
//	@RequestMapping(value="/save",method = RequestMethod.POST)  
//	public int save(@ModelAttribute("book") Book book, @RequestParam("map") Map<String,Integer> map ){  
//		if(book.getID()==0)
//			return bookDAO.save(book); 
//		else
//			return bookDAO.update(book); 
//	}

	@RequestMapping(value="/form/register",method = RequestMethod.GET)  
	public ModelAndView edit(Model model ){
		model.addAttribute("PublisherList",publisherDAO.getAll());
		
		return new ModelAndView("bookForm","command",new Book());
	}
}
