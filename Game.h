#include "Board.h"

#ifndef GAME_H
#define GAME_H

class Game
{
private:
  char first;
  Board board;

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
  * Get state of game
  */
  int getState();
};

#endif
