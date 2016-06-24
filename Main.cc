#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "Game.h"
#include "Computer.h"

int main(int argc, char *argv[])
{
    std::cout << "Play me in Tic Tac Toe! I'm X..." << std::endl;

    Game game;

    std::cout << game.currentTurn() << " goes first!" << std::endl;

    game.move(1, 2, game.currentTurn());
    game.nextTurn();
    game.move(0, 0, game.currentTurn());

    Computer computer;
    computer.getTurn(game.getBoard().getState());

    return 0;
}
