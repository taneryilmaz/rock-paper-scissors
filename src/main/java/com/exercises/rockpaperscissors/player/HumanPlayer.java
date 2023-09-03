package com.exercises.rockpaperscissors.player;

import com.exercises.rockpaperscissors.game.Move;
import com.exercises.rockpaperscissors.game.SettableMove;
import com.exercises.rockpaperscissors.game.Status;

import java.util.function.Supplier;

public class HumanPlayer implements Player {
  private static final String QUIT_CHOICE = "Q";
  private final String name;
  private final Supplier<String> moveSupplier;

  public HumanPlayer(final String name, final Supplier<String> moveSupplier) {
    this.name = name;
    this.moveSupplier = moveSupplier;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public PlayerType getPlayerType() {
    return PlayerType.HUMAN;
  }

  @Override
  public void move(final SettableMove settableMove) {
    while (true) {
      String input = moveSupplier.get().toUpperCase();

      if (input.equalsIgnoreCase(QUIT_CHOICE)) {
        settableMove.setStatus(Status.QUIT);
        return;
      }

      try {
        settableMove.setMove(Move.valueOf(input.toUpperCase()));
        return;
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }
}
