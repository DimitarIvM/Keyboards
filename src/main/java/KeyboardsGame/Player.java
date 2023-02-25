package KeyboardsGame;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Player {
    private String name;

    private Collection<String> words;

    public Player(String name) {
        setName(name);
        this.words = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException("Name of a player cannot be null or blank.Please select a valid name.");
        }

        for (char letter :
                name.toCharArray()) {
            if (!Character.isLetter(letter)){
                throw new IllegalArgumentException("Player name can contain only letters from the alphabet!Please select a valid name.");
            }
        }

        this.name=name;
    }

    public Collection<String> getWords() {
        return this.words;
    }



    public void addWordToList(String wordToPutInBolw) {
        words.add(wordToPutInBolw);

    }

    public boolean removeWordFromList(String wordToRemove) {
    return words.remove(wordToRemove);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hello, %s!", getName()));
        sb.append(System.lineSeparator());
        sb.append("Your words are:");
        sb.append(System.lineSeparator());
        sb.append(String.join(", ", words));



        return sb.toString();
    }
}
