package CAC.example.CircleAndCross;

public class Game {
    static final Character EMPTY = ' ';
    private Character[][] gameBoard = {
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY},
    };
    private Character nextPlayer = 'X';
    private String winner = "NN";

    public void placeMark(int c, int r) {
        isValidPlace(c);
        isValidPlace(r);
        if(isAvaliblePlace(c,r)){
            gameBoard[c-1][r-1] = nextPlayer;
        }

        isTheWinnerKnown();
        changeNextPlayer();
    }

    private void isTheWinnerKnown() {
        for (int iterator = 1; iterator < 4; iterator++)
            if (getMarkSightAt(1, iterator)
                    + getMarkSightAt(2, iterator)
                    + getMarkSightAt(3, iterator)
                    == nextPlayer * 3) {
                winner = String.valueOf(nextPlayer);
                break;
            }
        if (getMarkSightAt(iterator, 1)
                + getMarkSightAt(iterator, 2)
                + getMarkSightAt(iterator, 3)
                == nextPlayer * 3) {
            winner = String.valueOf(nextPlayer);
            break;
        }
    }
    private void changeNextPlayer() {
//        if(nextPlayer == 'X'){
//            nextPlayer = 'O';
//        }else { nextPlayer = 'X';
//    }
    nextPlayer =(nextPlayer == 'X')? 'O':'X';
    }

    private boolean isAvaliblePlace(int c, int r) {
        Character field = gameBoard[c-1][r-1];
        if (field != EMPTY){
            throw  new RuntimeException("Field already occupied");
        }return true;
    }

    private void isValidPlace(int position) {
        if (position < 1 || position > 3) {
            throw new RuntimeException();
        }
    }


    public Character getNextPlayer() {
        return nextPlayer;
    }

    public Character getMarkSightAt(int c, int r) {
      return gameBoard[c-1][r-1];
    }

    public String getWinner() {
        return "The winner is " + winner;
    }
}

