package com.exercises.rockpaperscissors.game;

import com.exercises.rockpaperscissors.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMoveTest {
  @Test
  public void playerWins() {
    Supplier<String> moveSupplier = () -> "q";
    HumanPlayer player = new HumanPlayer("Alex", moveSupplier);
    PlayerMove playerMove = new PlayerMove(player);

    playerMove.handle(Result.WIN);
    playerMove.handle(Result.TIE);
    playerMove.handle(Result.LOST);
    playerMove.handle(Result.WIN);

    assertEquals(2, playerMove.getCount(Result.WIN));
    assertEquals(1, playerMove.getCount(Result.TIE));
    assertEquals(1, playerMove.getCount(Result.LOST));
    assertEquals(Result.WIN, playerMove.getGameResult());
  }
}
