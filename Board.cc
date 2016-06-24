#include <iostream>
using namespace std;
#include "Board.h"

/**
* Initialize a board
*/
Board :: Board ()
{
  // Populate board
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      state[i][j] = '_';
    }
  }
}

/**
* Move
*/
bool Board :: move(int row, int col, char player)
{
  if (state[row][col] == '_') {
    state[row][col] = player;
    return true;
  }
  else {
    return false;
  }
}

/**
* Print the state of the board
*/
void Board :: printState()
{
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        std::cout << state[i][j] << ' ';
      }
      std::cout << std::endl;
  }
}
