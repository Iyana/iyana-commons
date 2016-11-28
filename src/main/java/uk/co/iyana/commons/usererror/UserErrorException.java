/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.usererror;

/**
 *
 * @author fsg
 */
public class UserErrorException extends RuntimeException {
    private final UserErrors userErrors;
    
    public UserErrorException() {
        this.userErrors = new UserErrors();
    }
    
    public UserErrorException(UserErrors userErrors) {
        this.userErrors = userErrors;
    }
    
    
    
    public UserErrorException( 
        ErrorContext context,
        UserErrorMessageType type,
        String errorMessageKey,
        String errorMessageText,
        Object... param) {
        
        this.userErrors = new UserErrors();
        this.userErrors.add(context, type, errorMessageKey, errorMessageText, param); 
    }
//    
//    public UserErrorException( 
//            String context,
//            UserErrorMessageType type,
//            String errorMessageKey,
//            String errorMessageText,
//            Object... param) {
//        
//        this(context, type, errorMessageKey, errorMessageText, param); 
//    }
//    
//    
//    
    public UserErrors getUserErrors() {
        return this.userErrors;
    }
    
}
