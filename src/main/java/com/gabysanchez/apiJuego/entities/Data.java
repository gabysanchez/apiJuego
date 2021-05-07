package com.gabysanchez.apiJuego.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "tokens")
    @JacksonXmlProperty(localName = "userToken")
    private List<UserToken> userTokens;

    public Data(){}

    public Data(List<UserToken> userTokens) {
        if(userTokens != null) {
            this.userTokens = userTokens;
        }
        else this.userTokens = new ArrayList<>();
    }

    public List<UserToken> getUserTokens() {
        return userTokens;
    }

    public void setUserTikets(List<UserToken> userTokens) {
        this.userTokens = userTokens;
    }
}
