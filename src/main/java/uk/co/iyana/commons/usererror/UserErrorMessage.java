/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.usererror;

import java.util.Arrays;

/**
 *
 * @author fsg
 */
public class UserErrorMessage {

    private final ErrorContext errorContext;
    private final String errorMessageKey;
    private final String errorMessageText;
    private final UserErrorMessageType type;
    private final Object[] errorMessageParameters;
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o.getClass().equals(this.getClass()))) return false;
 
        UserErrorMessage obj = (UserErrorMessage)o;
        
        if (this.errorContext == null) {
            if (obj.errorContext != null) return false;
        } else {
            if (!this.errorContext.equals(obj.errorContext)) return false;
        }    

        if (this.errorMessageText == null) {
            if (obj.errorMessageText != null) return false;
        } else {
            if (!this.errorMessageText.equals(obj.errorMessageText)) return false;
        }    
        
        if (this.type == null) {
            if (obj.type != null) return false;
        } else {
            if (!this.type.equals(obj.type)) return false;
        }    
        
        
        return (Arrays.equals(this.errorMessageParameters, obj.errorMessageParameters));
        
    }
    
    public UserErrorMessage( 
            ErrorContext errorContext,
            UserErrorMessageType type,
            String errorMessageKey,
            String errorMessageText,
            Object... param)  {
        
        this.errorContext = errorContext;
        
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        } else {
            this.type = type;
        }
        
        switch(type) {
            case RESOURCE:
                if (errorMessageKey == null) {
                    throw new IllegalArgumentException("errorMessageKey cannot be null when type is RESOURCE");
                }
            
                if (errorMessageText != null) {
                    throw new IllegalArgumentException("errorMessageText must be null when type is RESOURCE");
                }
                this.errorMessageKey = errorMessageKey;
                this.errorMessageText = null;
                break;
                
            case TEXT:
                if (errorMessageKey != null) {
                    throw new IllegalArgumentException("errorMessageKey must be null when type is TEXT");
                }
            
                if (errorMessageText == null) {
                    throw new IllegalArgumentException("errorMessageText must not be null when type is TEXT");
                }
                
                this.errorMessageText = errorMessageText;
                this.errorMessageKey = null;
                break;
                
            default:
                throw new IllegalArgumentException("type not supported");
        }
        
        this.errorMessageParameters = param;
    }
    
    /**
     * @return the context
     */
    public ErrorContext getErrorContext() {
        return errorContext;
    }

    /**
     * @return the errorMessageKey
     */
    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    /**
     * @return the errorMessageParameters
     */
    public Object[] getErrorMessageParameters() {
        return errorMessageParameters;
    }
    
    public boolean hasParameters() {
        return (this.errorMessageParameters !=null);
    }
    
    @Override
    public String toString() {
        String toRet = "Context (undefined):";
        
        if (this.errorContext != null) {
            toRet = "Context:" + this.errorContext.toString();
        }
        
        toRet += ", type:" + this.type;
        
        if (this.type.equals(UserErrorMessageType.RESOURCE)) {
            toRet += ", key:" + this.errorMessageKey;
        } else {
            toRet += ", text:" + this.errorMessageText;
        }
        
        if (this.errorMessageParameters != null) {
            toRet += ", params: [ ";
            if (this.errorMessageParameters != null) {
                for (Object o: this.errorMessageParameters) {
                    toRet += o.toString() + ",";
                }
            }            
            toRet = toRet.substring(0, toRet.length()-1) + "]";
        }
        
        return toRet;
    }
    
    public static UserErrorMessage getUnhandledExceptionMessage(Throwable t) {
        return new UserErrorMessage(null, UserErrorMessageType.RESOURCE, StandardErrorResourceNames.UNCAUGHT_THROWABLE, null);
    }
    
    public static UserErrorMessage getInvalidParameterMessage(Throwable t) {
        return new UserErrorMessage(null, UserErrorMessageType.RESOURCE, StandardErrorResourceNames.INVALID_PARAMETERS, null);
    }
}
