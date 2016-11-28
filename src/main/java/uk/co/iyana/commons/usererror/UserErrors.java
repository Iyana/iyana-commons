/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.usererror;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fsg
 */
public class UserErrors {

    private final List<UserErrorMessage> errorList = new ArrayList();
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o.getClass().equals(this.getClass()))) return false;
 
        UserErrors obj = (UserErrors)o;

        return errorList.equals(obj.errorList);
    }
    
    public UserErrors() {
    }
    
    public UserErrors(UserErrorMessage mesg) {
        this.add(mesg);
    }

    public void add(UserErrorException e) {
        this.add(e.getUserErrors());
    }
    
    public void add(UserErrors userErrors) {
        this.errorList.addAll( userErrors.getErrorList());
    }
    
    public void add( 
        ErrorContext context,
        UserErrorMessageType type,
        String errorMessageKey,
        String errorMessageText,
        Object... param) {
    
        this.add(new UserErrorMessage(context, type, errorMessageKey, errorMessageText, param));
    }

    public void add( UserErrorMessage message) {
        this.errorList.add(message);
    }
    
    public List<UserErrorMessage> getErrorList() {
        return this.errorList;
    }
    
    public boolean isEmpty() {
        return this.errorList.isEmpty();
    }
    
    public boolean isNotEmpty() {
        return !isEmpty();
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "No errors";
        }
        
        String toRet = "";
        
        for (UserErrorMessage mesg : this.errorList) {
            toRet += "[" + mesg.toString() + "] ";
        }
        
        return toRet;
    }

}
