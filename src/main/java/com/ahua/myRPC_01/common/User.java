package com.ahua.myRPC_01.common;

import java.io.Serializable;

/**
 * @author AAAAAAQQQQQ
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