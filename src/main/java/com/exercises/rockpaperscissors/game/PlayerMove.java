package com.exercises.rockpaperscissors.game;

import com.exercises.rockpaperscissors.player.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerMove implements SettableMove {
  private final Player player;
  private Move move;
  private Result result;
  private Status status = Status.PLAY;
  private final Map<Result, Integer> resultCounts = new HashMap<>();

  public PlayerMove(final Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

  public Move getMove() {
    return move;
  }

  @Override
  public void setMove(final Move move) {
    this.move = move;
  }

  public Result getResult() {
    return result;
  }

  public void setResult(final Result result) {
    this.result = result;

    // update result counts
    resultCounts.putIfAbsent(result, 0);
    resultCounts.put(result, resultCounts.get(result) + 1);
  }

  public Status getStatus() {
    return status;
  }

  @Override
  public void setStatus(final Status status) {
    this.status = status;
  }

  public Status play() {
    player.move(this);

    return status;
  }

  public int getCount(final Result result) {
    return resultCounts.getOrDefault(result, 0);
  }

  public Result getGameResult() {
    if (resultCounts.getOrDefault(Result.WIN, 0) > resultCounts.getOrDefault(Result.LOST, 0)) {
      return Result.WIN;
    }

    if (resultCounts.getOrDefault(Result.WIN, 0) < resultCounts.getOrDefault(Result.LOST, 0)) {
      return Result.LOST;
    }

    return Result.TIE;
  }
}
