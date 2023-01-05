
import fop.intro.pop.MiniJava;

public class App extends MiniJava {

    public static void outputTiles(boolean[] tiles) {
        StringBuilder sb = new StringBuilder("Open tiles: 1:");
        sb.append(tiles[0]);

        for (int i = 1; i < tiles.length; i++) {
            sb.append(" ").append(i + 1).append(":").append(tiles[i]);
        }
        write(sb.toString());
    }

    public static void main(String[] args) {
        boolean[] mainArray = new boolean[] { true, true, true, true, true, true, true, true, true, true };

        int firstPlayerCredits = 0;
        int secondPlayerCredits = 0;
        int trueBoolCounter = 10;
        int maxCredit = 55;
        for (int i = 1; i <= 10; i++) {

            int randomNum1 = dice();
            int randomNum2 = dice();
            if (i % 2 == 1) {
                System.out.println("Player 1 numbers:");
                System.out.println(randomNum1);
                System.out.println(randomNum2);
            } else {
                System.out.println("Player 2 numbers:");
                System.out.println(randomNum1);
                System.out.println(randomNum2);
            }

            outputTiles(mainArray);
            if (i % 2 == 1) {
                System.out.println("Which tiles to cover by player 1? (0 for no valid combination)");
            } else {
                System.out.println("Which tiles to cover by player 2? (0 for no valid combination)");
            }

            int firstTileNum = readInt("Tile 1:");
            int secondTileNum = readInt("Tile 2:");

            if (randomNum1 + randomNum2 == firstTileNum + secondTileNum && mainArray[firstTileNum - 1]
                    && mainArray[secondTileNum - 1]) {

                mainArray[firstTileNum - 1] = false;
                mainArray[secondTileNum - 1] = false;
                trueBoolCounter -= 2;

                // we are checking if player win under 10 rounds
                if (trueBoolCounter == 0 && i % 2 == 1) {
                    System.out.println("Player 1 shuts all boxes! Player 1 wins!");
                    break;
                } else if (trueBoolCounter == 0 && i % 2 == 0) {
                    System.out.println("Player 2 shuts all boxes!cPlayer 2 wins!");
                    break;
                }

            } else if (firstTileNum == 0 || secondTileNum == 0) {
                if (i % 2 == 1) {
                    firstPlayerCredits += trueBoolCounter;
                } else {
                    secondPlayerCredits += trueBoolCounter;
                }
            } else {
                System.out.println("We ar in else's while");
                while (randomNum1 + randomNum2 != firstTileNum + secondTileNum || !mainArray[firstTileNum - 1]
                        || mainArray[secondTileNum - 1]) {

                    if (i % 2 == 1) {
                        System.out.println("Player 1 numbers:");
                        System.out.println(randomNum1);
                        System.out.println(randomNum2);
                    } else {
                        System.out.println("Player 2 numbers:");
                        System.out.println(randomNum1);
                        System.out.println(randomNum2);
                    }

                    outputTiles(mainArray);
                    if (i % 2 == 1) {
                        System.out.println("Which tiles to cover by player 1? (0 for no valid combination)");
                    } else {
                        System.out.println("Which tiles to cover by player 2? (0 for no valid combination)");
                    }

                    firstTileNum = readInt("Tile 1:");
                    secondTileNum = readInt("Tile 2:");
                    if (firstTileNum == 0 || secondTileNum == 0) {
                        if (i % 2 == 1) {
                            firstPlayerCredits += trueBoolCounter;
                            break;

                        } else {
                            secondPlayerCredits += trueBoolCounter;
                            break;
                        }
                    }

                }

            }

        }
        System.out.println(firstPlayerCredits);
        System.out.println(secondPlayerCredits);
        if (firstPlayerCredits > secondPlayerCredits) {
            System.out.println("Player 2 wins!");
        } else if (firstPlayerCredits < secondPlayerCredits) {
            System.out.println("Player 1 wins!");

        } else {
            System.out.println("draw!");
        }

    }
}
