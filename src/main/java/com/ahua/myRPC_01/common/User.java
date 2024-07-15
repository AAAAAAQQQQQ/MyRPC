package com.ahua.myRPC_01.common;

import java.io.Serializable;

/**
 * @author 86188
 */
public class User implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}