import java.util.Scanner;

class Main{

    public static Scanner sc = new Scanner(System.in);
    public static String Player = "X";
    public static String Computer = "O";

    public static String [][] board = {{" "," "," "}, 
                                       {" "," "," "}, 
                                       {" "," "," "}};
    
    public static void main(String[] args) {
        Board();

        while(true){
            playerTurn();
            Board();

            if(checkWinner()){
                System.out.println("Human wins!");
                break;
            }

            if(checkBoardFull()){
                System.out.println("Tie!");
                break;
            }

            computerTurn();
            Board();

            if(checkWinner()){
                System.out.println("Computer wins!");
                break;
            }

            if(checkBoardFull()){
                System.out.println("Tie!");
                break;
            }
        }
    }

    static void Board(){
        System.out.printf(" %s | %s | %s \n", board[0][0], board[0][1], board[0][2]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", board[1][0], board[1][1], board[1][2]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", board[2][0], board[2][1], board[2][2]);
    }

    static void playerTurn(){
        int row, col;

        while(true){
            System.out.print("Enter row (1 - 3): ");
            row = sc.nextInt() - 1;
            System.out.print("Enter column (1 - 3): ");
            col = sc.nextInt() - 1;

            if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].equals(" ")){
                board[row][col] = Player;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    static void computerTurn(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(" ")){
                    board[i][j] = Computer;
                    return;
                }
            }
        }
    }

    static boolean checkWinner(){
        return checkRows() || checkColumns() || checkDiagonals();
    }

    static boolean checkRows(){
        for(int i = 0; i < 3; i++){
            if(board[i][0].equals(Player) && board[i][1].equals(Player) && board[i][2].equals(Player)){
                return true;
            } else if(board[i][0].equals(Computer) && board[i][1].equals(Computer) && board[i][2].equals(Computer)){
                return true;
            }
        }
        return false;
    }

    static boolean checkColumns(){
        for(int i = 0; i < 3; i++){
            if(board[0][i].equals(Player) && board[1][i].equals(Player) && board[2][i].equals(Player)){
                return true;
            } else if(board[0][i].equals(Computer) && board[1][i].equals(Computer) && board[2][i].equals(Computer)){
                return true;
            }
        }
        return false;
    }

    static boolean checkDiagonals(){
        if(board[0][0].equals(Player) && board[1][1].equals(Player) && board[2][2].equals(Player)){
            return true;
        } else if(board[0][2].equals(Player) && board[1][1].equals(Player) && board[2][0].equals(Player)){
            return true;
        } else if(board[0][0].equals(Computer) && board[1][1].equals(Computer) && board[2][2].equals(Computer)){
            return true;
        } else if(board[0][2].equals(Computer) && board[1][1].equals(Computer) && board[2][0].equals(Computer)){
            return true;
        }
        return false;
    }

    static boolean checkBoardFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }
}
