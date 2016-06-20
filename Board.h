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
  * @var int state
  */
  int state;
public:
  /**
  * Initialize a board
  */
  Board();

  /**
  * Move
  */
  void move();

  /**
  * Get state of board
  */
  int getState();
};

#endif
