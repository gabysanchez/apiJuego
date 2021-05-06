package com.gabysanchez.apiJuego.entities;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import io.swagger.annotations.ApiModelProperty;

enum Sex {
    hombre,
    mujer,
    otro
}
@DatabaseTable(tableName = "Jugadores")
public class Player {

    @ApiModelProperty(position = 0)
    @DatabaseField(id = true)
    private String alias;

    @ApiModelProperty(position = 1)
    @DatabaseField
    private String password;

    @ApiModelProperty(position = 2)
    @DatabaseField
    private Sex sexo;


    @ApiModelProperty(position = 3)
    @DatabaseField
    private String pais;

    @ApiModelProperty(position = 4)
    @DatabaseField
    private int edad;

    @ApiModelProperty(position = 5)
    @DatabaseField(foreign = true, columnName = "personaje")
    private Character personaje;

    public Player() { }

    public Player(String alias, String password, String sexo, String pais, int edad, Character personaje) {
        this.alias = alias;
        this.password = password;
        this.sexo = Sex.valueOf(sexo);
        this.pais = pais;
        this.edad = edad;
        this.personaje = personaje;
    }

    public String getAlias() {
        return alias;
    }

    public Sex getSexo() {
        return sexo;
    }

    public String getPais() {
        return pais;
    }

    public int getEdad() {
        return edad;
    }

    public Character getPersonaje() {
        return personaje;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setSexo(Sex sexo) {
        this.sexo = sexo;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPersonaje(Character personaje) {
        this.personaje = personaje;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

