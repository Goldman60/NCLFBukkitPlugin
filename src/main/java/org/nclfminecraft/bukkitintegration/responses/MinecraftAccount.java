/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nclfminecraft.bukkitintegration.responses;

import java.util.Date;

/**
 *
 * @author AJ
 */
public class MinecraftAccount {
    private final int id;
    private final Date created_at;
    private final Date updated_at;
    private final String mojang_uuid;
    private final String current_name;
    private final Integer user_id;

    public MinecraftAccount(int id, Date created_at, Date updated_at, String mojang_uuid, String current_name, Integer user_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.mojang_uuid = mojang_uuid;
        this.current_name = current_name;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getMojang_uuid() {
        return mojang_uuid;
    }

    public String getCurrent_name() {
        return current_name;
    }

    public Integer getUser_id() {
        return user_id;
    }
    
    
}
