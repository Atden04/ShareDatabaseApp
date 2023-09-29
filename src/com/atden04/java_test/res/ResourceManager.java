package com.atden04.java_test.res;

import java.net.URL;

public class ResourceManager {

    public static URL getFxml(String name) {
        var url = ResourceManager.class.getResource(name);
        if(url == null) {
            throw new RuntimeException("Resource not found: "+name);
        }
        return url;
    }

    public static URL getCss(String name) {
        var url = ResourceManager.class.getResource(name);
        if(url == null) {
            throw new RuntimeException("Resource not found: "+name);
        }
        return url;
    }
}
