package by.rdtc.library.controller.impl.guest;

import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.UserService;

public class Registration implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final int PARAMS_NUMBER=4;
	
	@Override
	public String execute(Map<String,String> params) {
		String login=null;
		String password=null;
		String name=null;
		String surname=null;
		
		String response=null;
		
		if(params.size()!=PARAMS_NUMBER){
			response="Wrong number of parameters";
			return response;
		}
		
		login=params.get(LOGIN);
		password=params.get(PASSWORD);
		name=params.get(NAME);
		surname=params.get(SURNAME);
		
		ServiceFactory service=ServiceFactory.getInstance();
		UserService userService=service.getUserService();
		try {
			userService.register(login,password,name,surname);
			response="Successful registration";
		} catch (ServiceException e) {
			response="Error during registration procedure";
		}
		return response;
	}

}
