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
  setFirstPlayer();
  return;
}

/**
* Set who goes first
*/
void Game :: setFirstPlayer()
{
  srand(time(NULL));
  if(rand() % 2)
    setTurn('X');
  else
    setTurn('O');
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

/**
* Gets current turn
*/
char Game :: currentTurn()
{
  return turn;
}

/**
* Set turn to a player
*
* @param char turn
*/
void Game :: setTurn(char c)
{
  turn = c;
}

/**
* Update turn to other player
*/
void Game :: nextTurn()
{
  if(turn == 'X')
    setTurn('O');
  else
    setTurn('X');
}
