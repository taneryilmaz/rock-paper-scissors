package com.exercises.rockpaperscissors.player;

import com.exercises.rockpaperscissors.game.Move;
import com.exercises.rockpaperscissors.game.SettableMove;

import java.util.function.Supplier;

public class MachinePlayer implements Player {
  private final String name;
  private final Supplier<Move> machineMoveSupplier;

  public MachinePlayer(final String name, final Supplier<Move> machineMoveSupplier) {
    this.name = name;
    this.machineMoveSupplier = machineMoveSupplier;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public PlayerType getPlayerType() {
    return PlayerType.MACHINE;
  }

  @Override
  public void move(final SettableMove settableMove) {
    settableMove.setMove(machineMoveSupplier.get());
  }
}
