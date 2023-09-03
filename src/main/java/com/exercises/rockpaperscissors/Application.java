package com.exercises.rockpaperscissors;

import com.exercises.rockpaperscissors.game.Game;
import com.exercises.rockpaperscissors.game.Move;
import com.exercises.rockpaperscissors.game.Status;
import com.exercises.rockpaperscissors.player.HumanPlayer;
import com.exercises.rockpaperscissors.player.MachinePlayer;
import com.exercises.rockpaperscissors.player.Player;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {
  private static final String HUMAN_USER_NAME = "HumanUser";
  private static final String MACHINE_USER_NAME = "Computer";
  private static final Random randomGenerator = new SecureRandom();

  public static void main(String[] args) {
    printBanner();

    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    Application application = new Application();
    String input;

    Supplier<String> humanMoveSupplier =  () -> {
      System.out.print("Select move " + Arrays.toString(Move.values()) + " or q/Q to quit: ");
      return scanner.nextLine().trim();
    };

    Supplier<Move> machineMoveSupplier =  () -> Move.values()[randomGenerator.nextInt(Move.values().length)];

    Player humanPlayer = new HumanPlayer(getHumanName(scanner), humanMoveSupplier);
    Player machinePlayer = new MachinePlayer(MACHINE_USER_NAME, machineMoveSupplier);

    do {
      application.run(humanPlayer, machinePlayer);

      System.out.print("\nDo you want to play a new game? y/N ");
      input = scanner.nextLine().trim();
    } while (input.equalsIgnoreCase("y"));

    System.out.println("\n================  PROGRAM TERMINATED ================\n\n");
  }

  private void run(final Player player1, final Player player2) {
    Game game = new Game(player1, player2);

    System.out.println("\n=================== GAME STARTED ====================");

    while (game.play() == Status.PLAY) {
      game.calculateMoveResults();
      game.printMoves();
    }

    game.printScore();

    System.out.println("===================== GAME OVER =====================");
  }

  private static String getHumanName(final Scanner scanner) {
    System.out.print("Please enter your name or press enter to use name '" + HUMAN_USER_NAME + "': ");

    String input = scanner.nextLine().trim();
    if (!input.isEmpty()) {
      return input;
    }

    return HUMAN_USER_NAME;
  }

  private static void printBanner() {
    System.out.println("\n=================================================================");
    System.out.println("              ROCK-PAPER-SCISSORS GAME");
    System.out.println("Rock-Paper-Scissors is a game for two players.");
    System.out.println("The winner is determined by the following schema:");
    System.out.println("• Paper beats (wraps) rock");
    System.out.println("• Rock beats (blunts) scissors");
    System.out.println("• Scissors beats (cuts) paper.");
    System.out.println("\n=================================================================\n\n");
  }
}
