/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.validator;

/**
 *
 * @author QbeePC
 */
public enum ValidatorEnum {
    USERNAME("[a-zA-z]{2,}", "err_code", "The text should contain a minimum of 3 characters"),
    PASSWORD("[a-zA-z0-9]{5,}", "err_code", "The Text should contain a minimum of 6 characters"),
    EMAIL("\"^[A-Z0-9._%+-]+@[A-Z0-9.]+\\\\.[A-Z]{2,6}$\"", "err_code", "Email format required");
    
    private String pattern;
    private String errCode;
    private String errMessage;
    
    private ValidatorEnum(String pattern, String errCode, String errMessage){
        this.pattern=pattern;
        this.errCode=errCode;
        this.errMessage=errMessage;    
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
    
    
    
}
