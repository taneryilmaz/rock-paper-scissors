package com.exercises.rockpaperscissors.game;

import com.exercises.rockpaperscissors.player.HumanPlayer;
import com.exercises.rockpaperscissors.player.MachinePlayer;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
  @Test
  public void humanWins() {
    Supplier<String> humanMoveSupplier = () -> "paper";
    HumanPlayer humanPlayer = new HumanPlayer("Alex", humanMoveSupplier);

    Supplier<Move> machineMoveSupplier = () -> Move.ROCK;
    MachinePlayer machinePlayer = new MachinePlayer("Robot", machineMoveSupplier);

    Game game = new Game(humanPlayer, machinePlayer);
    game.play();
    game.calculateMoveResults();

    assertEquals(Result.WIN, game.getPlayerMove1().getGameResult());
    assertEquals(Result.LOST, game.getPlayerMove2().getGameResult());
  }

  @Test
  public void gameIsTie() {
    Supplier<String> humanMoveSupplier = () -> "rock";
    HumanPlayer humanPlayer = new HumanPlayer("Alex", humanMoveSupplier);

    Supplier<Move> machineMoveSupplier = () -> Move.ROCK;
    MachinePlayer machinePlayer = new MachinePlayer("Robot", machineMoveSupplier);

    Game game = new Game(humanPlayer, machinePlayer);
    game.play();
    game.calculateMoveResults();

    assertEquals(Result.TIE, game.getPlayerMove1().getGameResult());
    assertEquals(Result.TIE, game.getPlayerMove2().getGameResult());
  }
}
