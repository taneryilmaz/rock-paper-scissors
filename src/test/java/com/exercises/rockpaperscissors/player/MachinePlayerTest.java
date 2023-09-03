package com.exercises.rockpaperscissors.player;

import com.exercises.rockpaperscissors.game.Move;
import com.exercises.rockpaperscissors.game.PlayerMove;
import com.exercises.rockpaperscissors.game.Status;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachinePlayerTest {
  @Test
  public void playerTypeIsMachine() {
    Supplier<Move> moveSupplier = () -> Move.ROCK;
    MachinePlayer player = new MachinePlayer("Robot", moveSupplier);

    assertEquals(PlayerType.MACHINE, player.getPlayerType());
  }

  @Test
  public void playerMovedRock() {
    Supplier<Move> moveSupplier = () -> Move.ROCK;
    MachinePlayer player = new MachinePlayer("Robot", moveSupplier);
    PlayerMove playerMove = new PlayerMove(player);

    player.move(playerMove);

    assertEquals(Status.PLAY, playerMove.getStatus());
    assertEquals(Move.ROCK, playerMove.getMove());
  }
}
