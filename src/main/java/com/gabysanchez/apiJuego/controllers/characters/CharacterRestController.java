package com.gabysanchez.apiJuego.controllers.characters;

import com.gabysanchez.apiJuego.controllers.OperationsRestController;
import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.dao.characters.DAOCharactersORM;
import com.gabysanchez.apiJuego.entities.Character;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterRestController implements OperationsRestController<Character,String> {

    static final String path = "/character";

    @PostMapping(path = path+"/addCharacter", consumes = "application/json", produces = "application/json")
    @Override
    public void add(@RequestBody Character character) {
        DAOFactory.getInstance().getDaoCharactersORM().add(character);
    }

    @PutMapping(path = path+"/updateCharacter",consumes = "application/json", produces = "application/json")
    @Override
    public void update(@RequestBody Character character) {
        DAOFactory.getInstance().getDaoCharactersORM().update(character);
    }

    @DeleteMapping(path = path+"/deleteCharacter",consumes = "application/json", produces = "application/json")
    @Override
    public void delete(@RequestBody Character character) {
        DAOFactory.getInstance().getDaoCharactersORM().delete(character);
    }

    @DeleteMapping(path = path+"/deleteAllCharacters", produces = "application/json")
    @Override
    public void clear() {
        DAOFactory.getInstance().getDaoCharactersORM().clear();
    }

    @GetMapping (path = path+"/getAllCharacters", produces = "application/json")
    @Override
    public List<Character> get() {
        List<Character> characters = DAOFactory.getInstance().getDaoCharactersORM().get();
        return characters;
    }

    @GetMapping (path = path+"/getPageCharacters", produces = "application/json")
    @Override
    public List<Character> getPaged(@RequestBody int page) {
        List<Character> characters = DAOFactory.getInstance().getDaoCharactersORM().getPaged(page);
        return characters;
    }

    @GetMapping (path = path+"/getCharacter", produces = "application/json")
    @Override
    public Character get(@RequestBody String s) {
        Character characters = DAOFactory.getInstance().getDaoCharactersORM().get(s);
        return characters;
    }
}
