/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.usererror;

import java.util.Arrays;

/**
 *
 * @author fgyara
 */
public class ErrorContext {
    private final String contextName;
    private Integer index;

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o.getClass().equals(this.getClass()))) return false;
 
        ErrorContext obj = (ErrorContext)o;
        
        if (this.contextName == null) {
            if (obj.contextName != null) return false;
        } else {
            if (!this.contextName.equals(obj.contextName)) return false;
        }
        
        if (this.index == null) {
            if (obj.index != null) return false;
        } else {
            if (!this.index.equals(obj.index)) return false;
        }
        
        return true;
    }
    
    public ErrorContext(String contextName, Integer index) {
        if ((contextName == null)||(contextName.trim().isEmpty())) {
            throw new IllegalArgumentException("contextName cannot be null or empty");
        }
        
        this.contextName = contextName;
        this.index = index;
    }

    public ErrorContext(String contextName) {
        this(contextName, null);
    }
    
    public ErrorContext(ErrorContext originalContext, String incrementalName, Integer incrementalIndex) {
        if (originalContext == null) {
            throw new IllegalArgumentException("originalContext cannot be null or empty");
        }

        if ((incrementalName==null)||(incrementalName.trim().isEmpty())) {
            this.contextName = originalContext.getContextName();
        } else {
            this.contextName = originalContext.getContextName() + "." +  incrementalName;
        }
        
        if (incrementalIndex == null) {
            this.index = originalContext.index;
        } else {
            this.index = incrementalIndex;
        }
    }
    
    public ErrorContext(ErrorContext originalContext, String incrementalContextName) {
        this(originalContext, incrementalContextName, null);
    }
    
    /**
     * @return the contextName
     */
    public String getContextName() {
        return contextName;
    }

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    @Override
    public String toString() {
        String toRet = "";
        
        if (this.contextName == null) {
            toRet += "Undefined";
        } else {
            toRet = this.contextName;
        }
        
        if (this.index != null) {
            toRet += "[" + this.index + "]";
        }
        
        return toRet;
    }
    

}
