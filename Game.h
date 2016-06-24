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
  * Set who goes first
  */
  void setFirstPlayer();

  /**
  * Get current turn
  *
  * @return char
  */
  char currentTurn();

  /**
  * Set turn
  */
  void setTurn(char c);

  /**
  * Update turn to other player
  */
  void nextTurn();

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
