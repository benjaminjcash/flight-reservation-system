package service;

import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import exceptions.WrongPasswordException;

public interface ILoginSvc extends IService {
	
	public final String NAME = "ILoginSvc";
	
	public boolean login(String username, String password) throws  RecordNotFoundException, WrongPasswordException, ServiceLoadException;
}
