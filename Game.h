#include "Board.h"

#ifndef GAME_H
#define GAME_H

class Game
{
private:
  char first;
  Board board;
  char turn;

public:
  /**
  * Initialize a game
  */
  Game();

  /**
  * Get who goes first
  *
  * @return char
  */
  char getFirstPlayer();

  /**
  * Set who goes first
  */
  void setFirstPlayer();

  /**
  * Get current turn
  *
  * @return char
  */
  char getTurn();

  /**
  * Set turn
  */
  void setTurn();

  /**
  * Print the state of the board
  */
  void printState();

  /**
  * Player moves
  */
  void move(int row, int col, char player);
};

#endif
