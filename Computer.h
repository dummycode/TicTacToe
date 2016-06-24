#include "Board.h"
#include "Game.h"

#ifndef COMPUTER_H
#define COMPUTER_H

class Computer
{
public:
  /**
  * Initialize a computer
  */
  Computer();

  /**
  * Get computers turn
  *
  * @param char[][]
  */
  void getTurn(char state[][]);
};

#endif
