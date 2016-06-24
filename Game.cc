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
* Print the state
*/
void Game :: printState()
{
  board.printState();
}

/**
* Player moves
*/
void Game :: move(int row, int col, char player)
{
  if (!board.move(row, col, player)) {
    std::cout << "Spot taken! Retry..." << std::endl;
  }
  std::cout << "Moved" << std::endl << std::endl;
  printState();
}
