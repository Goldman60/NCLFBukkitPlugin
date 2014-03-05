/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nclfminecraft.bukkitintegration.responses;

import java.util.Date;
import javax.json.JsonObject;

/**
 *
 * @author AJ
 */
public class AccountResponse {
    private final ErrorResponse error;
    private final String uuid;
    private final MinecraftAccount data;

    public AccountResponse(JsonObject obj) {
        
        this.uuid = obj.getString("uuid");
        
        if(obj.isNull("data")) {
            this.data = null;
            
            JsonObject err = obj.getJsonObject("error");
            
            this.error = new ErrorResponse(err.getString("message"),err.getInt("code"));
        } else {
            this.error = null;
            
            JsonObject dat = obj.getJsonObject("data");
            
            Integer userid;
            if(dat.isNull("user_id")) {
                userid = null;
            } else {
                userid = dat.getInt("user_id");
            }
            
            this.data = new MinecraftAccount(Integer.parseInt(dat.getString("id")), new Date(), new Date(), dat.getString("mojang_uuid"), dat.getString("current_name"), userid);
        }
    }

    public ErrorResponse getError() {
        return error;
    }

    public String getUuid() {
        return uuid;
    }

    public MinecraftAccount getData() {
        return data;
    }
    
    
}
