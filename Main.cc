#include <iostream>
using namespace std;
#include <stdlib.h>
#include <time.h>
#include "Game.h"

int main(int argc, char *argv[])
{
    std::cout << "Play me in Tic Tac Toe! I'm X..." << std::endl;

    Game game;
    game.setFirstPlayer();

    std::cout << game.getFirstPlayer() << " goes first!" << std::endl;

    game.move(1, 2, 'X');
    game.move(0, 0, 'O');

    return 0;
}
