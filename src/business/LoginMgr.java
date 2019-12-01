package business;

import exceptions.RecordNotFoundException;
import exceptions.ServiceLoadException;
import exceptions.WrongPasswordException;
import service.Factory;
import service.ILoginSvc;

public class LoginMgr {
	private ILoginSvc loginSvc;
	private void setup() throws ServiceLoadException {
		Factory factory = Factory.getInstance();
		loginSvc = (ILoginSvc) factory.getService(ILoginSvc.NAME);
	}
	
	public boolean login(String username, String password) throws RecordNotFoundException, WrongPasswordException, ServiceLoadException {
		setup();
		return loginSvc.login(username, password);
	}
}
 