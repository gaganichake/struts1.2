package gagan.struts.login;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import gagan.struts.login.LoginForm;

public class Login extends Action implements Serializable{
	static final long serialVersionUID = 0;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private DataSource datasource = null;
	
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
    	
    	LoginForm loginform = (LoginForm)form;
    	/*
    	System.out.println("Mathod:execute(,,,)");   	
    	System.out.println("Username:"+loginform.getUsername());
    	System.out.println("Password:"+loginform.getPassword());    	
    	*/
    	if(isValidLogin(request,loginform.getUsername(), loginform.getPassword())){
    		HttpSession session  = request.getSession();
    		session.setAttribute("UID",loginform.getUsername()); 
    		Contacts contactsArr[]  = getContacts(request, loginform.getUsername());
    		request.setAttribute("contacts",contactsArr);
    		return mapping.findForward("success");
    	}else{
    		return mapping.findForward("failure");
    	}
/*      System.out.println("Username:"+(String)((DynaActionForm)form).get("username"));
    	System.out.println("Password:"+(String)((DynaActionForm)form).get("password"));  */          
        }
    
    protected void removeFormBean(
            ActionMapping mapping,
            HttpServletRequest request) {
                
            // Remove the obsolete form bean
            if (mapping.getAttribute() != null) {
                if ("request".equals(mapping.getScope())) {
                    request.removeAttribute(mapping.getAttribute());
                } else {
                    HttpSession session = request.getSession();
                    session.removeAttribute(mapping.getAttribute());
                }
            } 
        }
    
    protected boolean isValidLogin(HttpServletRequest request, String username, String password)
	{
		//System.out.println("Mathod:isValidLogin(,,)"); 
		String SQL;
		boolean valid = false;
	    try{
	    	datasource = getDataSource(request);
	    	conn = datasource.getConnection();
	    	stmt = conn.createStatement();	    	
	    	SQL = "select * from login where username = '"+username+"' and password = '"+password+"'"; 
	    	rs = stmt.executeQuery(SQL);
	    	
	    	if(rs.next())
	    	{
	    		valid =  true;
	    	}else{
	    		valid = false;
	    	}	    	 
	    }
	    catch(SQLException sqle){
	    	System.err.println(sqle.getMessage());
	    	return valid;
	    }
	    finally{
	    	if(rs != null){
	    		try{
	    			rs.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		rs = null;
	    	}
	    	if(stmt != null){
	    		try{
	    			stmt.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		stmt = null;
	    	}
	    	if(conn != null){
	    		try{
	    			conn.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		conn = null;
	    	}	    	
	    }
	    return valid;
	}    
    protected Contacts[] getContacts(HttpServletRequest request, String username)
	{
		//System.out.println("Mathod:getContacts(,)"); 
		String SQL;	
		Contacts contactsArr[] = null;
	    try{
	    	datasource = getDataSource(request);
	    	conn = datasource.getConnection();
	    	stmt = conn.createStatement();	    	
	    	SQL = "select * from contacts where username = '"+username+"'"; 
	    	rs = stmt.executeQuery(SQL);
	    	
	    	Vector v = new Vector();
	    	while(rs.next())
	    	{
	    		Contacts contacts = new Contacts(); 
	    		contacts.setUsername(rs.getString("username"));
	    		contacts.setEmail(rs.getString("email"));
	    		
	    		v.addElement(contacts);
	    	}
	    	
	    	contactsArr = new Contacts[v.size()];
			for(int i = 0; i < v.size(); ++i)
			{
				contactsArr[i] = (Contacts)v.elementAt(i);
			}	    	
	    	
	    }
	    catch(SQLException sqle){
	    	System.err.println(sqle.getMessage());
	    	return contactsArr;
	    }
	    finally{
	    	if(rs != null){
	    		try{
	    			rs.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		rs = null;
	    	}
	    	if(stmt != null){
	    		try{
	    			stmt.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		stmt = null;
	    	}
	    	if(conn != null){
	    		try{
	    			conn.close();
	    		}
	    		catch(SQLException sqle){
	    			System.err.println(sqle.getMessage());
	    		}
	    		conn = null;
	    	}	    	
	    }
	    return contactsArr;
	} 
}
