package KeyboardsGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
}
