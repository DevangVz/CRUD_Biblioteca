package org.biblioteca.control;

import java.util.List;

import org.biblioteca.dao.AuthorDAO;
import org.biblioteca.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorDAO authorDAO;
		
	@RequestMapping (value="/")
	public ModelAndView  listing(){
		List<Author> listAuthor= authorDAO.getAll();
		return new ModelAndView("index","list",listAuthor);
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public int save(@ModelAttribute("author") Author author){  
		if(author.getID()==0)
			return authorDAO.save(author); 
		else
			return authorDAO.Update(author); 
    }

	@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
	public ModelAndView edit(@PathVariable int id){  
		 return new ModelAndView("authorForm","command",authorDAO.getAuthorByID(id));  
	}
	
	@RequestMapping(value="/form/register",method = RequestMethod.GET)  
	public ModelAndView edit(){  
		 return new ModelAndView("authorForm","command",new Author());  
	}
}
