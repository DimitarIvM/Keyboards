package KeyboardsGame;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import java.util.Timer;
import java.util.logging.ConsoleHandler;
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


        introducePlayers();

        System.out.println();

        System.out.println("Now let's write your words. Each player will take turns to write his words in the respective category.");
        System.out.println("You get 2 words per category!");


        playersWriteWords();

        fillTheBolw();



        System.out.println("The game will now start when you press Enter");
        String input ="";
        if(input.equals("" +
                "")){
            Thread.sleep(2500);

            while (!bowl.getBowl().isEmpty()) {

                System.out.println(bowl.randomize(bowl.getBowl().size()));



            }
        }






    }

    private void introducePlayers() {
        System.out.println("Players created:");
        for (Team team :
                teams) {
            System.out.println("In team " + team.getName() + ":");
            for (Player player :
                    team.getPlayers()) {

                System.out.println(player.getName());
            }

        }
    }

    private void createPlayers() {
        for (Team team :
                teams) {
            System.out.printf("How many players will there be in %s?%n", team.getName());
            int playersInTeam = Integer.parseInt(scanner.nextLine());
            Player player = null;
            for (int i = 0; i < playersInTeam; i++) {
                System.out.println("Please write one player name then hit Enter");

                String playerName = scanner.nextLine();
                player = new Player(playerName);


                players.add(player);

                team.addPlayer(player);

            }

        }
    }

    private void createTeams(int teamsCount) {
        for (int i = 0; i <= teamsCount - 1; i++) {
            System.out.println("Please select team name");
            String teamName = scanner.nextLine();
            try {
                Team team = new Team(teamName);
                teams.add(team);
            }catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            }

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

    private void playersWriteWords() throws InterruptedException {

        String[] categoriesArr = {"Animals", "Place", "Object", "Celebrity", "Movies/Series"};

        for (Team team :
                teams) {

            for (Player player : team.getPlayers()) {
                for (int category = 0; category < categoriesArr.length; category++) {
                    System.out.printf("Category is: %s%n", categoriesArr[category]);
                    for (int i = 0; i < 2; i++) {

                        System.out.println("Please write your word and press Enter");
                        String wordToAdd = scanner.nextLine();
                        player.addWordToList(wordToAdd);
                    }
                }


                System.out.println(player);
                System.out.printf("%s, are you ready to proceed with the next player?%n", player.getName());

                String input = scanner.nextLine();

                while (!input.equals("done")) {
                String commandType = scanner.nextLine();


                    if ("Remove word".equals(commandType)) {
                        String wordToRemove = scanner.nextLine();

                        player.removeWordFromList(wordToRemove);

                        System.out.println("What word will replace it?");
                        String wordToReplace = scanner.nextLine();
                        player.addWordToList(wordToReplace);
                    }
                    input=scanner.nextLine();
                }
                System.out.println(player);

                Thread.sleep(3000);

                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());
                System.out.println(System.lineSeparator());

            }

            }
        }

    }


