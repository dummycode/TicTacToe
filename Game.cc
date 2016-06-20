#include <iostream>
using namespace std;
#include <stdlib.h>
#include <time.h>
#include "Game.h"
#include "Board.h"

/**
* Initialize a game
*/
Game :: Game()
{
  return;
}

/**
* Get who goes first
*
* @return char
*/
char Game :: getFirstPlayer()
{
  return first;
}

/**
* Set who goes first
*/
void Game :: setFirstPlayer()
{
  srand(time(NULL));
  if(rand() % 2)
    first = 'X';
  else
    first = 'O';
}

/**
* Get state of game
*/
int Game :: getState()
{
  return board.getState();
}
