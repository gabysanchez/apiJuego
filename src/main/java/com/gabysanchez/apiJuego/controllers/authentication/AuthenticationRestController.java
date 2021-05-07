package com.gabysanchez.apiJuego.controllers.authentication;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.entities.Player;
import com.gabysanchez.apiJuego.entities.UserToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthenticationRestController {
    static final String path = "/api/juego2D/1.0.0/authentication";

    @GetMapping(path = path+"/login/{alias}/{password}", produces = "application/json")
    public void login(@PathVariable String alias, @PathVariable String password){
        List<String> aliasAllDB = new ArrayList<>();
        for (Player playerDB:DAOFactory.getInstance().getDAOPlayerORM().get()) {
            aliasAllDB.add(playerDB.getAlias());
        }
        if (aliasAllDB.contains(alias)){
            Player playerDB = DAOFactory.getInstance().getDAOPlayerORM().get(alias);
            if (password.equalsIgnoreCase(playerDB.getPassword())){
                System.out.println("Dentro");
                DAOFactory.getInstance().getDAOUserToken().create(playerDB);
            }else {
                System.out.println("Contraseña Incorrecta");
            }
        }else {
            System.out.println("NO exixte el Jugador");
        }
    }

    @GetMapping (path = path+"/getAllUsersToken", produces = "application/json")
    public List<UserToken> getAllUsersToken(){
        List<UserToken> userTokens = DAOFactory.getInstance().getDAOUserToken().get();
        return userTokens;
    }
}
