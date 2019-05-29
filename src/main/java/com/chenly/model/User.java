package com.chenly.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private String email;
}
