package com.gabysanchez.apiJuego.controllers.players;

import com.gabysanchez.apiJuego.controllers.OperationsRestController;
import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.entities.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlayerRestController implements OperationsRestController<Player,String> {

    static final String path = "/api/juego2D/1.0.0/player";

    @PostMapping(path = path+"/addPlayer", consumes = "application/json", produces = "application/json")
    @Override
    public void add(@RequestBody Player player) {
        DAOFactory.getInstance().getDAOPlayerORM().add(player);
    }


    @PutMapping(path = path+"/updatePlayer",consumes = "application/json", produces = "application/json")
    @Override
    public void update(@RequestBody Player player) {
        DAOFactory.getInstance().getDAOPlayerORM().update(player);
    }


    @DeleteMapping(path = path+"/deletePlayer",consumes = "application/json", produces = "application/json")
    @Override
    public void delete(@RequestBody Player player) {
        DAOFactory.getInstance().getDAOPlayerORM().delete(player);
    }


    @DeleteMapping(path = path+"/deleteAllPlayers", produces = "application/json")
    @Override
    public void clear() {
        DAOFactory.getInstance().getDAOPlayerORM().clear();
    }


    @GetMapping(path = path+"/getAllPlayers", produces = "application/json")
    @Override
    public List<Player> get() {
        List<Player> players = DAOFactory.getInstance().getDAOPlayerORM().get();
        return players;
    }


    @GetMapping (path = path+"/getPagePlayers/{page}", produces = "application/json")
    @Override
    public List<Player> getPaged(@PathVariable int page) {
        List<Player> players = DAOFactory.getInstance().getDAOPlayerORM().getPaged(page);
        return players;
    }


    @GetMapping (path = path+"/getPlayer/{playerId}", produces = "application/json")
    @Override
    public Player get(@PathVariable String playerId) {
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(playerId);
        return player;
    }
}
