package com.exercises.rockpaperscissors.game;

import com.exercises.rockpaperscissors.player.Player;

public class Game {
  private final PlayerMove playerMove1;
  private final PlayerMove playerMove2;

  public Game(final Player player1, final Player player2) {
    this.playerMove1 = new PlayerMove(player1);
    this.playerMove2 = new PlayerMove(player2);
  }

  public PlayerMove getPlayerMove1() {
    return playerMove1;
  }

  public PlayerMove getPlayerMove2() {
    return playerMove2;
  }

  /**
   * Plays the players and returns status.
   *
   * @return {@code Status} of game.
   */
  public Status play() {
    if ((playerMove1.play() == Status.QUIT) || (playerMove2.play() == Status.QUIT)) {
      return Status.QUIT;
    }

    return Status.PLAY;
  }

  /**
   * Calculate move results of players.
   */
  public void calculateMoveResults() {
    playerMove1.setResult(compare(playerMove1.getMove(), playerMove2.getMove()));
    playerMove2.setResult(compare(playerMove2.getMove(), playerMove1.getMove()));
  }

  public void printMoves() {
    System.out.println(
      playerMove1.getPlayer().getName() + " made move " + playerMove1.getMove() + " [" + playerMove1.getResult() + "] <==> "
        + playerMove2.getPlayer().getName() + " made move " + playerMove2.getMove() + " [" + playerMove2.getResult() + "]\n"
    );
  }

  /**
   * Prints players' move results and latest score.
   */
  public void printScore() {
    System.out.println("Overall statistics and game score is: ");

    System.out.println(
      String.format("%10s", playerMove1.getPlayer().getName())
        + ": Win " + playerMove1.getCount(Result.WIN)
        + ", Lost " + playerMove1.getCount(Result.LOST)
        + ", Tie " + playerMove1.getCount(Result.TIE)
        + " --> Result " + playerMove1.getGameResult() + "\n"
        + String.format("%10s", playerMove2.getPlayer().getName())
        + ": Win " + playerMove2.getCount(Result.WIN)
        + ", Lost " + playerMove2.getCount(Result.LOST)
        + ", Tie " + playerMove2.getCount(Result.TIE)
        + " --> Result " + playerMove2.getGameResult() + "\n");
  }

  /**
   * Compares moves and returns {@code Result}.
   *
   * @param move1  {@code Move} of lhs.
   * @param move2  {@code Move} of rhs.
   * @return {@code Result} of moves.
   */
  private Result compare(final Move move1, final Move move2) {
    if (move1 == move2) {
      return Result.TIE;
    }

    return switch (move1) {
      case ROCK -> (move2 == Move.PAPER) ? Result.LOST : Result.WIN;
      case PAPER -> (move2 == Move.SCISSORS) ? Result.LOST : Result.WIN;
      case SCISSORS -> (move2 == Move.ROCK) ? Result.LOST : Result.WIN;
    };
  }
}
