package com.codenvy.testtask.qname;

public class QName {
    private String prefix;
    private String localName;

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
