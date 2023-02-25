package KeyboardsGame;

import java.util.ArrayList;
import java.util.Collection;

public class Team {

    private String name;



    private Collection<Player> players;


    public Team(String name) {
     setName(name);
        this.players= new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {

        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException("Team name cannot be null or blank.Please select a valid name.");
        }

        this.name=name;
    }



    public void addPlayer(Player player){

        players.add(player);
    }

    public boolean removePlayer(Player playerToRemove) {
        return players.remove(playerToRemove);

    }

    public Collection<Player> getPlayers() {
        return players;
    }
}
