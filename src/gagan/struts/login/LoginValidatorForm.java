package gagan.struts.login;

import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;


public class LoginValidatorForm extends ValidatorForm{
	static final long serialVersionUID = 0;
	private String username = null;
	private String password = null;
	
    public String getUsername() {
    		return username;
        }

    public void setUsername(String username) {
            this.username = username;
        }
    
    public String getPassword() {
    		return password;
        }

    public void setPassword(String password) {
            this.password = password;
        }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        	this.username=null;
        	this.password=null;        
        }  
}
