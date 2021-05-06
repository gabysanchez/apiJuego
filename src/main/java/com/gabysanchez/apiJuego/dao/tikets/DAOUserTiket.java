package com.gabysanchez.apiJuego.dao.tikets;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gabysanchez.apiJuego.entities.Data;
import com.gabysanchez.apiJuego.entities.Player;
import com.gabysanchez.apiJuego.entities.UserTiket;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class DAOUserTiket implements UserTiketOperations<UserTiket,Integer, Player>{

    private final String file = "users.xml";

    @Override
    public void create(Player player) {
        UserTiket userTiket = new UserTiket(1,player.getAlias());
        add(userTiket);
    }

    @Override
    public void add(UserTiket userTiket) {
        List<UserTiket> userTikets = get();
        /*
        UserTiket previous = new UserTiket(1,"prueba");
        previous.add(new Character("hola"));
        userTikets.add(previous);
         */
        int lastId = userTikets.get(userTikets.size()-1).get_id(); // tomo el último
        UserTiket.nextId = lastId + 1;
        userTiket.set_id(UserTiket.nextId);
        userTikets.add(userTiket);
        save(userTikets);
        userTiket.startTime();
        //return UserTiket.nextId;
    }

    @Override
    public void delete(UserTiket userTiket) {
        List<UserTiket> userTikets = get();
        for (int i = 0; i < userTikets.size(); i++) {
            UserTiket userT = userTikets.get(i);
            if (userT.get_id()==userTiket.get_id()){
                userTikets.remove(userT);
            }
        }
        save(userTikets);
    }

    @Override
    public void clear() {

    }

    @Override
    public List<UserTiket> get() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getUserTikets();
    }

    @Override
    public UserTiket get(Integer integer) {
        List<UserTiket> users = get();
        Optional<UserTiket> posibleUser = users.stream().filter(user->{
            return user.get_id() == integer;
        }).findFirst();
        return posibleUser.orElse(null);
    }

    @Override
    public void save(List<UserTiket> userTikets) {
        Data dataContainer = new Data(userTikets);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
