package com.lhy.fool.util;

import lombok.Data;

import java.io.Serializable;


@Data
public  class MyNameValuePair  implements  Cloneable, Serializable {

    private  String name;
    private  String value;


	
}