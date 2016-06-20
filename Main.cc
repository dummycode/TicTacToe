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
    printf("%i", game.getState());

    std::cout << game.getFirstPlayer() << " goes first!" << std::endl;
    return 0;
}
