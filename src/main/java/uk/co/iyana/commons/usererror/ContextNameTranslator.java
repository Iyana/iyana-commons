/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.usererror;

/**
 *
 * @author fgyara
 */
public abstract class ContextNameTranslator {

    public abstract String xlatColumnNameToFieldName(String columnName);

    public abstract String xlatParentKeyNameToFieldName(String constraintName);

    public abstract String[] xlatUniqueKeyNameToFieldNames(String constraintName);
    
    public String xlatUniqueKeyNameToFieldName(String constraintName) {
        String[] fieldNames = this.xlatUniqueKeyNameToFieldNames(constraintName);
        if ((fieldNames != null)&&(fieldNames.length == 1)) {
            return fieldNames[0];
        } else {
            return null;
        }
    }        
    
}
