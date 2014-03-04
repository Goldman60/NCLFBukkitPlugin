/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nclfminecraft.bukkitintegration;

/**
 *
 * @author AJ
 */
public class ErrorResponse {
    private final String message;
    private final int code;
    
    ErrorResponse(String Message, int Code) {
        this.message = Message;
        this.code = Code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
