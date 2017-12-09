package com.system.mandatory2.domain;

import javax.persistence.*;

/**
 * Created by gerli on 23/11/2017.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "role_id")
    private int id;
    private String roleName;


    public Role(String roleName){
        this.roleName = roleName;

    }
    public Role(){}

    public int getId() {
        return id;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }


}
