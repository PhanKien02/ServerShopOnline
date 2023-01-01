package com.BackendShop.message;

import lombok.Data;

@Data
public class Message {
    private Keys key;

    private String content;

    

    @Override
    public String toString() {
        return  content;
    }

    public enum Keys{
        M0001,
        M0002,
        M0003,
        M0004
    }
    
}
