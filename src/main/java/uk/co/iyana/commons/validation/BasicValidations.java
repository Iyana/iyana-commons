/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.iyana.commons.validation;

import uk.co.iyana.commons.usererror.UserErrorMessageType;
import uk.co.iyana.commons.usererror.UserErrors;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import uk.co.iyana.commons.usererror.ErrorContext;

/**
 *
 * @author fsg
 */
public class BasicValidations extends UserErrors {
    private final ErrorContext errorContext;

    public BasicValidations(ErrorContext errorContext) {
        this.errorContext = errorContext;
    }
    
    /* 
    * non-null checks
    */
    public  BasicValidations checkNotNull(List valueList, String subContext) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Object value : valueList) {
            this.checkNotNull(value, subContext, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public  BasicValidations checkNotNull(Object value, String subContext) {
        this.checkNotNull(value, subContext, null);
        
        return this;
    }
    
    public  BasicValidations checkNotNull(Object value, String subContext, Integer index) {
        if (value == null) {
            
            this.add( new ErrorContext( this.errorContext, subContext, index), 
                    UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.NULL_NOT_ALLOWED, null);
            return this;
        }
        
        // for strings, an extra check
        if (value instanceof String) {
            if (((String)value).trim().equals("")) {
                
                this.add( new ErrorContext( this.errorContext, subContext, index), 
                    UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.NULL_NOT_ALLOWED, null);
            }
        }
        return this;
    }
    
    /*
     * Validation of byte
     */
    public BasicValidations checkRange(List<Byte> valueList, String subContext, Byte minValue, Byte maxValue) {
        if (valueList == null) return this;

        int iCtr = 0;
        for (Byte value : valueList) {
            this.checkRange(value, subContext, minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Byte value, String subContext, Byte minValue, Byte maxValue) {
        this.checkRange(value, subContext, minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Byte value, String subContext, Byte minValue, Byte maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value < minValue) {
            this.add( new ErrorContext(this.errorContext, subContext, index), UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value > maxValue) {
            this.add( new ErrorContext(this.errorContext, subContext, index), UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Byte> valueList, String subContext, Byte minValue) {
        if (valueList == null) return this;

        int iCtr = 0;
        for (Byte value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Byte value, String subContext, Byte minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Byte value, String subContext, Byte minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index), UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Byte> valueList, String subContext, Byte maxValue) {        
        if (valueList == null) return this;

        int iCtr = 0;
        for (Byte value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Byte value, String subContext, Byte maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Byte value, String subContext, Byte maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value > maxValue) {
            this.add(new ErrorContext( this.errorContext, subContext, index), UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }

    
    /*
     * Validation of short
     */
    public BasicValidations checkRange(List<Short> valueList, String subContext, Short minValue, Short maxValue) {
        if (valueList == null) return this;

        int iCtr = 0;
        for (Short value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Short value, String subContext, Short minValue, Short maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Short value, String subContext, Short minValue, Short maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Short> valueList, String subContext, Short minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Short value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Short value, String subContext, Short minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Short value, String subContext, Short minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Short> valueList, String subContext, Short maxValue) {
        int iCtr = 0;
        for (Short value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Short value, String subContext, Short maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Short value, String subContext, Short maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }
    
    /*
     * Validation of int
     */
    public BasicValidations checkRange(List<Integer> valueList, String subContext, Integer minValue, Integer maxValue) {
        if (valueList == null) return this;

        int iCtr = 0;
        for (Integer value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Integer value, String subContext, Integer minValue, Integer maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Integer value, String subContext, Integer minValue, Integer maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Integer> valueList, String subContext, Integer minValue) {
        if (valueList == null) return this;
        
        
        int iCtr = 0;
        for (Integer value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Integer value, String subContext, Integer minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Integer value, String subContext, Integer minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Integer> valueList, String subContext, Integer maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Integer value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Integer value, String subContext, Integer maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Integer value, String subContext, Integer maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }
        
    /*
     * Validation of float
     */
    public BasicValidations checkRange(List<Float> valueList, String subContext, Float minValue, Float maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Float value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Float value, String subContext, Float minValue, Float maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Float value, String subContext, Float minValue, Float maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Float> valueList, String subContext, Float minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Float value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Float value, String subContext, Float minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Float value, String subContext, Float minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Float> valueList, String subContext, Float maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Float value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Float value, String subContext, Float maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Float value, String subContext, Float maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }
     
    /*
     * Validation of double
     */
    public BasicValidations checkRange(List<Double> valueList, String subContext, Double minValue, Double maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Double value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Double value, String subContext, Double minValue, Double maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Double value, String subContext, Double minValue, Double maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Double> valueList, String subContext, Double minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Double value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Double value, String subContext, Double minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Double value, String subContext, Double minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value < minValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Double> valueList, String subContext, Double maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Double value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Double value, String subContext, Double maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Double value, String subContext, Double maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value > maxValue) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }
    
    /*
     * Validation of Big Integer
     */
    public BasicValidations checkRange(List<BigInteger> valueList, String subContext, BigInteger minValue, BigInteger maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigInteger value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(BigInteger value, String subContext, BigInteger minValue, BigInteger maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(BigInteger value, String subContext, BigInteger minValue, BigInteger maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<BigInteger> valueList, String subContext, BigInteger minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigInteger value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(BigInteger value, String subContext, BigInteger minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(BigInteger value, String subContext, BigInteger minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<BigInteger> valueList, String subContext, BigInteger maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigInteger value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(BigInteger value, String subContext, BigInteger maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(BigInteger value, String subContext, BigInteger maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }

    /*
     * Validation of Big Decimal
     */
    public BasicValidations checkRange(List<BigDecimal> valueList, String subContext, BigDecimal minValue, BigDecimal maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigDecimal value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(BigDecimal value, String subContext, BigDecimal minValue, BigDecimal maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(BigDecimal value, String subContext, BigDecimal minValue, BigDecimal maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<BigDecimal> valueList, String subContext, BigDecimal minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigDecimal value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(BigDecimal value, String subContext, BigDecimal minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(BigDecimal value, String subContext, BigDecimal minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<BigDecimal> valueList, String subContext, BigDecimal maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (BigDecimal value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(BigDecimal value, String subContext, BigDecimal maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(BigDecimal value, String subContext, BigDecimal maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }

/*
     * Validation of Date
     */
    public BasicValidations checkRange(List<Date> valueList, String subContext, Date minValue, Date maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Date value : valueList) {
            this.checkRange(value, subContext,minValue, maxValue, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkRange(Date value, String subContext, Date minValue, Date maxValue) {
        this.checkRange(value, subContext,minValue, maxValue, null);
        return this;
    }

    private BasicValidations checkRange(Date value, String subContext, Date minValue, Date maxValue, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }

        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_BETWEEN, null, minValue, maxValue);
        }
        
        return this;
    }
    
    public BasicValidations checkMinValue(List<Date> valueList, String subContext, Date minValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Date value : valueList) {
            this.checkMinValue( value, subContext,minValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinValue(Date value, String subContext, Date minValue) {
        this.checkMinValue( value, subContext,minValue, null);
        return this;
    }
    
    private BasicValidations checkMinValue(Date value, String subContext, Date minValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(minValue) == -1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_GT, null, minValue);
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(List<Date> valueList, String subContext, Date maxValue) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (Date value : valueList) {
            this.checkMaxValue( value, subContext,maxValue, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxValue(Date value, String subContext, Date maxValue) {
        this.checkMaxValue( value, subContext,maxValue, null);
        return this;
    }
    
    private BasicValidations checkMaxValue(Date value, String subContext, Date maxValue, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.compareTo(maxValue) == 1) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LT, null, maxValue);
        }
        
        return this;
    }

    /*
     * Validation of String
     */
    public BasicValidations checkLengthRange(List<String> valueList, String subContext, int minLength, int maxLength) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (String value : valueList) {
            this.checkLengthRange(value, subContext,minLength, maxLength, iCtr);
            iCtr++;
        }
        return this;
    }

    public BasicValidations checkLengthRange(String value, String subContext, int minLength, int maxLength) {
        this.checkLengthRange(value, subContext,minLength, maxLength, null);
        return this;
    }

    private BasicValidations checkLengthRange(String value, String subContext, int minLength, int maxLength, Integer index) {
        if (value == null) {
            return this;
        }
        
        
        if (value.length() < minLength) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LEN_BETWEEN, null, minLength, maxLength);
        }

        if (value.length() > maxLength) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_LEN_BETWEEN, null, minLength, maxLength);
        }
        
        return this;
    }
    
    public BasicValidations checkMinLength(List<String> valueList, String subContext, int minLength) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (String value : valueList) {
            this.checkMinLength( value, subContext,minLength, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMinLength(String value, String subContext, int minLength) {
        this.checkMinLength( value, subContext,minLength, null);
        return this;
    }
    
    private BasicValidations checkMinLength(String value, String subContext, int minLength, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.length() >= minLength ) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_MIN_LEN, null, minLength);
        }
        
        return this;
    }

    public BasicValidations checkMaxLength(List<String> valueList, String subContext, int maxLength) {
        if (valueList == null) return this;
        
        int iCtr = 0;
        for (String value : valueList) {
            this.checkMaxLength( value, subContext,maxLength, iCtr);
            iCtr++;
        }
        
        return this;
    }

    public BasicValidations checkMaxLength(String value, String subContext, int maxLength) {
        this.checkMaxLength( value, subContext,maxLength, null);
        return this;
    }
    
    private BasicValidations checkMaxLength(String value, String subContext, int maxLength, Integer index) {
        if (value == null) {
            return this;
        }

        
        if (value.length() > maxLength) {
            this.add( new ErrorContext( this.errorContext, subContext, index),  UserErrorMessageType.RESOURCE, StandardValidationErrorResourceNames.MUST_BE_MAX_LEN, null, maxLength);
        }
        
        return this;
    }

}
