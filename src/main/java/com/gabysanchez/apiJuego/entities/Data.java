package com.gabysanchez.apiJuego.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "tikets")
    @JacksonXmlProperty(localName = "userTiket")
    private List<UserTiket> userTikets;

    public Data(){}

    public Data(List<UserTiket> userTikets) {
        if(userTikets != null) {
            this.userTikets = userTikets;
        }
        else this.userTikets = new ArrayList<>();
    }

    public List<UserTiket> getUserTikets() {
        return userTikets;
    }

    public void setUserTikets(List<UserTiket> userTikets) {
        this.userTikets = userTikets;
    }
}
