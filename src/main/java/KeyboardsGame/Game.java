package KeyboardsGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Game {

    private Collection<Player> players;

    private Collection<Team> teams;

    private Bowl bowl;
    private Scanner scanner;

    public Game() {
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.bowl = new Bowl();
        scanner = new Scanner(System.in);
    }


    public void startGame() throws InterruptedException {

        System.out.println("Please select how many teams will play in the game and press Enter:");
        int teamsCount = Integer.parseInt(scanner.nextLine());

        createTeams(teamsCount);

        String teamsNames = String.join(", ", teams.stream().map(Team::getName).collect(Collectors.toList()));

        System.out.printf("Teams created %d. Teams names: %s%n", teamsCount, teamsNames);


        createPlayers();



        System.out.println("Players created:");
        for (Team team :
                teams) {
            System.out.println("In team "+team.getName()+":");
            for (Player player :
                    team.getPlayers()) {

                System.out.println(player.getName());
            }

        }

        System.out.println();

        System.out.println("Now let's write your words. Each player will take turns to write his words in the respective category.");
        System.out.println("You get 2 words per category!");



        playersWriteWords();

        fillTheBolw();

    }

    private void createPlayers() {
        for (Team team :
                teams) {
            System.out.printf("How many players will there be in %s?%n",team.getName());
            int playersInTeam = Integer.parseInt(scanner.nextLine());
            Player player=null;
            for (int i = 0; i < playersInTeam; i++) {
                System.out.println("Please write one player name then hit Enter");

                String playerName = scanner.nextLine();

                 player =new Player(playerName);

                players.add(player);

//                team.addPlayer(player);

            }

        }
    }

    private void createTeams(int teamsCount) {
        for (int i = 0; i <= teamsCount - 1; i++) {
            System.out.println("Please select team name");
            String teamName = scanner.nextLine();
            Team team = new Team(teamName);

            teams.add(team);
        }
    }

    private void fillTheBolw() {
        for (Team team :
                teams) {
            for (Player player :
                    team.getPlayers()) {
                for (String word :
                        player.getWords()) {
                    bowl.addPlayerWords(word);
                }
            }
        }
    }

    private void playersWriteWords() {


        for (Team team :
                teams) {

            for (Player player : team.getPlayers()) {
                String wordToAdd = scanner.nextLine();
                player.addWordToList(wordToAdd);

            }
        }

    }

}
