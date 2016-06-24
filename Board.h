#ifndef BOARD_H
#define BOARD_H

class Board{
private:
  /**
  * Stores the state of the board in a 9 digit integer
  * 1 represents X and 0 represents O
  * Reading left to right and top to bottom
  * Ex: 101001110 = XOX
  *                 OOX
  *                 XX0
  *
  * @var char[][] state
  */
  char state[3][3];
public:
  /**
  * Initialize a board
  */
  Board();

  /**
  * Player moves, returns true or false based on success
  */
  bool move(int row, int col, char player);

  /**
  * Get state of board
  */
  char** getState();

  /**
  * Print state of board
  */
  void printState();

};

#endif
