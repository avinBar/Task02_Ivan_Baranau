package by.rdtc.library.controller.impl;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.LibraryService;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;

public class AddBook implements Command{
	private final String paramDelimeter=" ";
	@Override
	public String execute(String request) {
		String title=null;
		String author=null;
		String response=null;
		String[] param=request.split(paramDelimeter);
		title=param[1];
		author=param[2];
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		Book book=new Book(title,author);
		try {
			libraryService.addNewBook(book);
			response="Book was added";
		} catch (ServiceException e) {
			response="Error during adding book procedure";
		}
		
		return response;
	}
	
}
