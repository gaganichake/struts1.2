package gagan.struts.login;

import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


public class LoginForm extends ActionForm {
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
    
    public ActionErrors validate(ActionMapping mapping,
    		javax.servlet.http.HttpServletRequest request){
    		ActionErrors errors = new ActionErrors();
    		/*
    		System.out.println("Mathod:validate(,)");    		
    		System.out.println("Username:"+username);
    		System.out.println("Password:"+password);
    		*/
    		if(this.username==null || this.username.length() < 1){
    			errors.add(ActionMessages.GLOBAL_MESSAGE , new ActionMessage("UsernameEmpty"));
    		}
    		if(this.password==null || this.password.length() < 1){
    			errors.add(ActionMessages.GLOBAL_MESSAGE , new ActionMessage("PasswordEmpty"));
    		} 
    		
    		return errors;    			
    }


}
