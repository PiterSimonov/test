<<<<<<< HEAD
package com.codenvy.testtask.qname;
=======
package main.java.com.codenvy.testtask.qname;
>>>>>>> 1e01a236f7c36a898b87878c772293e9cb314c04

public class QName {
    private String prefix;
    private String localName;

    public QName() {
    }

    public QName(String prefix, String localName) {
        this.prefix = prefix;
        this.localName = localName;
    }

    public String getPrefix() {
        return prefix;
    }


    public String getLocalName() {

        return localName;
    }

    public String getAsString() {
        return prefix != null ? prefix + ":" + localName : localName;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
