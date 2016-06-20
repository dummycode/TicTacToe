#include <iostream>
using namespace std;
#include "Board.h"

/**
* Initialize a board
*/
Board :: Board ()
{
  state = 123;
  return;
}

/**
* Move
*/
void Board :: move()
{
  printf("Moving...%i", state);
}

/**
* Get state of board
*/
int Board :: getState()
{
  return state;
}
