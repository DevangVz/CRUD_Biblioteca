package org.biblioteca.control;

import org.biblioteca.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class BookController {
	
	@Autowired
	BookDAO bookDAO;

}
