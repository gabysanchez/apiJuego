package com.gabysanchez.apiJuego.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import io.swagger.annotations.ApiModelProperty;

@DatabaseTable(tableName = "Personajes")
public class Character {

    @ApiModelProperty(position = 0)
    @DatabaseField(id = true)
    private String nombre;

    @ApiModelProperty(position = 1)
    @DatabaseField
    private String color;

    @ApiModelProperty(position = 2)
    @DatabaseField
    private int salud;

    public Character(){}

    public Character(String nombre, String color, int salud) {
        this.nombre = nombre;
        this.color = color;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getSalud() {
        return salud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
}
