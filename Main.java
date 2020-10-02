package Tic_Tac_Toe;

import java.io.IOException;
import java.util.*;

import static CodeChef.CookOff.COOK98.q2.j;

public class Main {
    static char ch;
    static char user;
    static char pc;
    static char[][] xo = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    static List<Integer> rand = new ArrayList<>(Arrays.asList(0, 1, 2));
    static int noofmoves = 2, flag = 0, draw = 0, winlose = 0, level;

    static void print() throws IOException, InterruptedException // prints the tic-tac-toe maze
    {
        int i, j, cnt = 1;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n\n\nUSE THE FOLLOWING NUMBERS TO PLAY YOUR MOVE IN THE RESPECTIVE POSITION\n---------------");
        for (i = 0; i < 3; i++) {
            System.out.println();
            for (j = 0; j < 3; j++) {
                System.out.print(" " + cnt);
                cnt++;
            }
            System.out.print("\n---------------");
        }
        System.out.print("\n\n\n---------------");
        for (i = 0; i < 3; i++) {
            System.out.println();
            for (j = 0; j < 3; j++)
                System.out.print("   " + xo[i][j]);
            System.out.print("\n---------------");
        }
        System.out.println();
        System.out.println();
    }

    public static void winner(char w) // checks whether the player or the computer has won the game
    {
        if (w == user)
            System.out.println("Congratulations !!! You Win !!!");
        else if (w == pc)
            System.out.println("Computer Wins !!!");
    }

    static void check() // checks if there is a winner of the game at a particular instance
    {
        int i;
        for (i = 0; i < 3; i++) {
            if (xo[i][0] == xo[i][1] && xo[i][1] == xo[i][2]) {
                if (xo[i][0] == '-')
                    return;
                winner(xo[i][0]);
                winlose = 1;
            } else if (xo[0][i] == xo[1][i] && xo[1][i] == xo[2][i]) {
                if (xo[0][i] == '-')
                    return;
                winner(xo[0][i]);
                winlose = 1;
            } else if ((xo[0][0] == xo[1][1] && xo[1][1] == xo[2][2]) || (xo[0][2] == xo[1][1] && xo[1][1] == xo[2][0])) {
                if (xo[1][1] == '-')
                    return;
                winner(xo[1][1]);
                winlose = 1;
            }
            if (winlose == 1)
                return;
        }
    }

    static void checktostop() // computer's move so as to stop the player from winning
    {
        int i;
        if (xo[1][1] == '-') {
            xo[1][1] = pc;
            flag = 1;
            return;
        }
        for (i = 0; i < 3; i++) {
            if (xo[i][0] == xo[i][1] || xo[i][1] == xo[i][2] || xo[i][0] == xo[i][2]) {
                if (xo[i][0] == '-' && xo[i][1] == user && xo[i][2] == user) {
                    xo[i][0] = pc;
                    flag = 1;
                    return;
                }
                if (xo[i][1] == '-' && xo[i][0] == user && xo[i][2] == user) {
                    xo[i][1] = pc;
                    flag = 1;
                    return;
                }
                if (xo[i][2] == '-' && xo[i][0] == user && xo[i][1] == user) {
                    xo[i][2] = pc;
                    flag = 1;
                    return;
                }
            }
            if (xo[0][i] == xo[1][i] || xo[1][i] == xo[2][i] || xo[0][i] == xo[2][i]) {
                if (xo[0][i] == '-' && xo[1][i] == user && xo[2][i] == user) {
                    xo[0][i] = pc;
                    flag = 1;
                    return;
                }
                if (xo[1][i] == '-' && xo[0][i] == user && xo[2][i] == user) {
                    xo[1][i] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][i] == '-' && xo[0][i] == user && xo[1][i] == user) {
                    xo[2][i] = pc;
                    flag = 1;
                    return;
                }
            }
            if ((xo[0][0] == xo[1][1] || xo[1][1] == xo[2][2] || xo[0][0] == xo[2][2]) || (xo[0][2] == xo[1][1] || xo[1][1] == xo[2][0] || xo[0][2] == xo[2][0])) {
                if (xo[0][0] == '-' && xo[1][1] == user && xo[2][2] == user) {
                    xo[0][0] = pc;
                    flag = 1;
                    return;
                }
                if (xo[1][1] == '-' && ((xo[0][0] == user && xo[2][2] == user) || (xo[0][2] == user && xo[2][0] == user))) {
                    xo[1][1] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][2] == '-' && xo[0][0] == user && xo[1][1] == user) {
                    xo[2][2] = pc;
                    flag = 1;
                    return;
                }
                if (xo[0][2] == '-' && xo[1][1] == user && xo[2][0] == user) {
                    xo[0][2] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][0] == '-' && xo[1][1] == user && xo[0][2] == user) {
                    xo[2][0] = pc;
                    flag = 1;
                    return;
                }
            }
        }
        if (xo[2][1] != '-')
            return;
        else if (xo[1][1] != '-' && xo[0][0] != '-' && xo[2][2] != '-') {
            xo[2][1] = pc;
            flag = 1;
            return;
        } else if (xo[0][1] != '-')
            return;
        else if (xo[0][2] != '-' && xo[1][1] != '-' && xo[2][0] != '-') {
            xo[0][1] = pc;
            flag = 1;
            return;
        }
    }

    static void checktowin() // computer's move so as to win the game itself if the player's not winning
    {
        int i;
        if (level == 2) {
            checktostop();
            if (flag != 1)
                random();
            return;
        }
        for (i = 0; i < 3; i++) {
            if (xo[i][0] == xo[i][1] || xo[i][1] == xo[i][2] || xo[i][0] == xo[i][2]) {
                if (xo[i][0] == '-' && xo[i][1] == pc && xo[i][2] == pc) {
                    xo[i][0] = pc;
                    flag = 1;
                    return;
                }
                if (xo[i][1] == '-' && xo[i][0] == pc && xo[i][2] == pc) {
                    xo[i][1] = pc;
                    flag = 1;
                    return;
                }
                if (xo[i][2] == '-' && xo[i][0] == pc && xo[i][1] == pc) {
                    xo[i][2] = pc;
                    flag = 1;
                    return;
                }
            }
            if (xo[0][i] == xo[1][i] || xo[1][i] == xo[2][i] || xo[0][i] == xo[2][i]) {
                if (xo[0][i] == '-' && xo[1][i] == pc && xo[2][i] == pc) {
                    xo[0][i] = pc;
                    flag = 1;
                    return;
                }
                if (xo[1][i] == '-' && xo[0][i] == pc && xo[2][i] == pc) {
                    xo[1][i] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][i] == '-' && xo[0][i] == pc && xo[1][i] == pc) {
                    xo[2][i] = pc;
                    flag = 1;
                    return;
                }
            }
            if ((xo[0][0] == xo[1][1] || xo[1][1] == xo[2][2] || xo[0][0] == xo[2][2]) || (xo[0][2] == xo[1][1] || xo[1][1] == xo[2][0] || xo[0][2] == xo[2][0])) {
                if (xo[0][0] == '-' && xo[1][1] == pc && xo[2][2] == pc) {
                    xo[0][0] = pc;
                    flag = 1;
                    return;
                }
                if (xo[1][1] == '-' && ((xo[0][0] == pc && xo[2][2] == pc) || (xo[0][2] == pc && xo[2][0] == pc))) {
                    xo[1][1] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][2] == '-' && xo[0][0] == pc && xo[1][1] == pc) {
                    xo[2][2] = pc;
                    flag = 1;
                    return;
                }
                if (xo[0][2] == '-' && xo[1][1] == pc && xo[2][0] == pc) {
                    xo[0][2] = pc;
                    flag = 1;
                    return;
                }
                if (xo[2][0] == '-' && xo[1][1] == pc && xo[0][2] == pc) {
                    xo[2][0] = pc;
                    flag = 1;
                    return;
                }
            }
        }
        checktostop();
        if (flag != 1)
            random();
    }

    static void computer() // Decides the computer's moves
    {
        Integer i = -1, j = -1;
        flag = 0;
        if (level == 1) {
            random();
            return;
        }
        if (noofmoves > 9) {
            draw = 1;
            return;
        }
        checktowin();
        if (flag == 1)
            return;

    }

    public static void random() {
        int i = 5, j = 6;
        do {
            Collections.shuffle(rand);
            i = rand.get(0) % 3;
            Collections.shuffle(rand);
            j = rand.get(0) % 3;
            System.out.println(i + " " + j);
        } while (xo[i][j] != '-');
        xo[i][j] = pc;
    }

    static void player() throws IOException, InterruptedException // player's move
    {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, ch;
        do {
            System.out.print("\nEnter your desired place: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    x = 0;
                    y = 0;
                    break;
                case 2:
                    x = 0;
                    y = 1;
                    break;
                case 3:
                    x = 0;
                    y = 2;
                    break;
                case 4:
                    x = 1;
                    y = 0;
                    break;
                case 5:
                    x = 1;
                    y = 1;
                    break;
                case 6:
                    x = 1;
                    y = 2;
                    break;
                case 7:
                    x = 2;
                    y = 0;
                    break;
                case 8:
                    x = 2;
                    y = 1;
                    break;
                case 9:
                    x = 2;
                    y = 2;
                    break;
                default:
                    System.out.print("\nPlease Enter Valid Values !!!");
            }
        } while ((ch < 1 || ch > 9) || xo[x][y] != '-');
        xo[x][y] = user;
        print();
        check();
        if (draw == 1 || winlose == 1)
            return;
        computer();
        print();
        check();
    }

    public static void main(String... args) throws IOException, InterruptedException // drives the program through a menu and makes all function calls as and when needed
    {
        int i = 0, j = 0, cnt = 1;
        Scanner sc = new Scanner(System.in);
        char ch;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.print("------------------WELCOME TO THE GAME OF TIC-TAC-TOE------------------");
        System.out.print("\n\n\nUSE THE FOLLOWING NUMBERS TO PLAY YOUR MOVE IN THE RESPECTIVE POSITION\n\n---------------");
        for (i = 0; i < 3; i++) {
            System.out.println();
            for (j = 0; j < 3; j++) {
                System.out.print(" " + cnt);
                cnt++;
            }
            System.out.print("\n---------------");
        }
        System.out.print("\n\nSelect Difficulty Level");
        System.out.print("\n\n1. Easy");
        System.out.print("\n2. Medium");
        System.out.print("\n3. Hard");
        System.out.print("\n\nEnter Difficulty Level: ");
        level();
        again();
    }

    public static void again() throws IOException, InterruptedException {
        char ch;
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        System.out.println("\n\nDo you want to play again? (Y/N): ");
        ch = sc.next().charAt(0);
        switch (ch) {
            case 'y':
            case 'Y':
                noofmoves = 2;
                flag = 0;
                draw = 0;
                cnt = 0;
                winlose = 0;
                xo[0][0] = '-';
                xo[0][1] = '-';
                xo[0][2] = '-';
                xo[1][0] = '-';
                xo[1][1] = '-';
                xo[1][2] = '-';
                xo[2][0] = '-';
                xo[2][1] = '-';
                xo[2][2] = '-';
                main();
            case 'n':
            case 'N':
                System.out.print("\n\nThank You for Playing !!!\n\n");
                System.out.println("\n\n\nTHE GAME IS EXITING\n");
                for (int i = 0; i < 50; i++) {
                    for (j = 0; j < 10000000; j++) ;
                    System.out.print(".");
                }
                System.out.println();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.exit(0);
            default:
                System.out.println("\nPlease enter a valid choice !!!");
                again();
        }
    }

    public static void level() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        level = sc.nextInt();
        if (level > 3 || level < 1) {
            System.out.print("\n\nPlease Enter a Valid Choice !!! : ");
            level();
        }
        System.out.print("\nSelect Your Mark (X or O): ");
        ch = sc.next().charAt(0);
        switch (ch) {
            case 'o':
            case 'O':
            case '0':
                user = 'O';
                pc = 'X';
                break;
            case 'x':
            case 'X':
                user = 'X';
                pc = 'O';
                break;
            default:
                System.out.print("\n\nPlease Enter a Valid Choice !!!\n");
                for (int i = 0; i < 10; i++)
                    for (j = 0; j < 10000000; j++) ;
                main("calling");
        }
        System.out.print("\n\n\nLoading Maze\n");
        for (int i = 0; i < 50; i++) {
            for (j = 0; j < 10000000; j++) ;
            System.out.print(".");
        }
        print();
        for (; ; ) {
            player();
            if (draw == 1) {
                System.out.println("GAME DRAW !!!");
                break;
            } else if (winlose == 1)
                break;
            noofmoves += 2;
        }
        //again:
        System.out.println("\n\nDo you want to play again? (Y/N): ");
        ch = sc.next().charAt(0);
        switch (ch) {
            case 'y':
            case 'Y':
                noofmoves = 2;
                flag = 0;
                draw = 0;
                winlose = 0;
                xo[0][0] = '-';
                xo[0][1] = '-';
                xo[0][2] = '-';
                xo[1][0] = '-';
                xo[1][1] = '-';
                xo[1][2] = '-';
                xo[2][0] = '-';
                xo[2][1] = '-';
                xo[2][2] = '-';
                main();
            case 'n':
            case 'N':
                System.out.print("\n\nThank You for Playing !!!\n\n");
                System.out.println("\n\n\nTHE GAME IS EXITING\n");
                for (int i = 0; i < 50; i++) {
                    for (j = 0; j < 10000000; j++) ;
                    System.out.print(".");
                }
                System.out.println();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.exit(0);
            default:
                System.out.println("\nPlease enter a valid choice !!!");
                again();
        }
    }
}
