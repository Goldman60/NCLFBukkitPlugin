/*
 *  Copyright 2014 A.J. Fite
 *  Please see the license file for more information.
 */
package org.nclfminecraft.bukkitintegration;

import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AJ
 */
public class NCLFRestRequest {
    private final SSLContext ssl;
    private final WebTarget target;

    NCLFRestRequest() throws NoSuchAlgorithmException {
        this.ssl = SSLContext.getDefault();

        Client client = ClientBuilder.newBuilder().sslContext(ssl).build();

        this.target = client.target("https://testing.nclfminecraft.org/api/minecraft");
    }
    
    /**
     * Builds a Webtarget for the user Minecraft API
     * @param UUID
     * @return 
     */
    private WebTarget UserRequest(String UUID) {
        WebTarget res = this.target.path("user");
        return res.path(UUID);
    }
    
    /**
     * Gets a JsonObject at the requested target
     * @param target
     * @return 
     */
    private JsonObject GetJSON(WebTarget target) {
        Invocation.Builder invocBuild = target.request(MediaType.APPLICATION_JSON_TYPE);
        String data = invocBuild.get().readEntity(String.class);
        
        JsonReader jr = Json.createReader(new StringReader(data));
        return jr.readObject();
    }

    public AccountResponse getAccount(String UUID) {
        WebTarget reqtarget = UserRequest(UUID);
        JsonObject object = GetJSON(reqtarget);
        
        AccountResponse account = new AccountResponse(object);
        
        return account;
    }

    //TODO: putAccount
    //TODO: getVerify
    //TODO: putVerify
    //TODO: deleteVerify
    //TODO: Class to hold response objects, account etc.
}
