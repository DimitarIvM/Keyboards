package KeyboardsGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Bowl {

    private Collection<String> bowl;

    public Bowl() {
        this.bowl = new ArrayList<>();
    }

    public void addPlayerWords(String playerWords) {

        bowl.add(playerWords);
    }

    public Collection<String> getBowl() {
        return bowl;
    }

    public int randomize (int bowSize){


        Random random = new Random();

        return random.nextInt(bowSize);

    }


}
