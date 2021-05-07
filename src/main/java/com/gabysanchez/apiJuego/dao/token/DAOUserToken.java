package com.gabysanchez.apiJuego.dao.token;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gabysanchez.apiJuego.entities.Data;
import com.gabysanchez.apiJuego.entities.Player;
import com.gabysanchez.apiJuego.entities.UserToken;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class DAOUserToken implements UserTokenOperations<UserToken,Integer, Player> {

    private final String file = "users.xml";

    @Override
    public void create(Player player) {
        UserToken userToken = new UserToken(1,player.getAlias());
        if (player.getPersonaje() != null){
            userToken.add(player.getPersonaje());
        }
        add(userToken);
    }

    @Override
    public void add(UserToken userToken) {
        List<UserToken> userTokens = get();
/*
        UserToken previous = new UserToken(1,"prueba");
        userTokens.add(previous);
*/
        int lastId = userTokens.get(userTokens.size()-1).get_id(); // tomo el último
        UserToken.nextId = lastId + 1;
        userToken.set_id(UserToken.nextId);
        userTokens.add(userToken);
        save(userTokens);
        userToken.startTime();
        //return UserTiket.nextId;
    }

    @Override
    public void delete(UserToken userToken) {
        List<UserToken> userTokens = get();
        for (int i = 0; i < userTokens.size(); i++) {
            UserToken userT = userTokens.get(i);
            if (userT.get_id()== userToken.get_id()){
                userTokens.remove(userT);
            }
        }
        save(userTokens);
    }

    @Override
    public void clear() {

    }

    @Override
    public List<UserToken> get() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getUserTokens();
    }

    @Override
    public UserToken get(Integer integer) {
        List<UserToken> users = get();
        Optional<UserToken> posibleUser = users.stream().filter(user->{
            return user.get_id() == integer;
        }).findFirst();
        return posibleUser.orElse(null);
    }

    @Override
    public void save(List<UserToken> userTokens) {
        Data dataContainer = new Data(userTokens);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
