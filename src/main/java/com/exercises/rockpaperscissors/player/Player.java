package com.exercises.rockpaperscissors.player;

import com.exercises.rockpaperscissors.game.SettableMove;

public interface Player {
  String getName();

  PlayerType getPlayerType();

  void move(final SettableMove settableMove);
}
