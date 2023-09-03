package com.exercises.rockpaperscissors.player;

import com.exercises.rockpaperscissors.game.Move;
import com.exercises.rockpaperscissors.game.PlayerMove;
import com.exercises.rockpaperscissors.game.Status;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanPlayerTest {
  @Test
  public void playerTypeIsHuman() {
    Supplier<String> moveSupplier = () -> "paper";
    HumanPlayer player = new HumanPlayer("Alex", moveSupplier);

    assertEquals(PlayerType.HUMAN, player.getPlayerType());
  }

  @Test
  public void playerMovedRock() {
    Supplier<String> moveSupplier = () -> "rock";
    HumanPlayer player = new HumanPlayer("Alex", moveSupplier);
    PlayerMove playerMove = new PlayerMove(player);

    player.move(playerMove);

    assertEquals(Status.PLAY, playerMove.getStatus());
    assertEquals(Move.ROCK, playerMove.getMove());
  }

  @Test
  public void playerSelectedQuit() {
    Supplier<String> moveSupplier = () -> "q";
    HumanPlayer player = new HumanPlayer("Alex", moveSupplier);
    PlayerMove playerMove = new PlayerMove(player);

    player.move(playerMove);

    assertEquals(Status.QUIT, playerMove.getStatus());
  }
}
