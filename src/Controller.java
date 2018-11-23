public class Controller {
    int countMatrix;
    boolean[][] oldMatrix;
    boolean[][] newMatrix;
    // если (1 == 2 == 3) больше чем 10раз (stopGame) то игра останавливается.
    int counterStopGame1 = 0;
    int counterStopGame2 = 0;
    int counterStopGame3 = 0;
    int stopGame = 0;

    public Controller() {
    }

    private int countNeighbors(int x, int y, int countM) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX < 0) {
                    newX = countM - 1;
                } else {
                    newX = newX;
                }
                if (newY < 0) {
                    newY = countM - 1;
                } else {
                    newY = newY;
                }
                if (newX > countM - 1) {
                    newX = 0;
                } else {
                    newX = newX;
                }
                if (newY > countM - 1) {
                    newY = 0;
                } else {
                    newY = newY;
                }

                if (oldMatrix[newX][newY]) {
                    count += 1;
                } else {
                    count += 0;
                }
            }
        }

        if (oldMatrix[x][y]) {
            count--;
        }
        return count;
    }

    public void setCountMatrix(int countMatrix) {
        this.countMatrix = countMatrix;
    }

    private boolean[][] controllCell() {
        newMatrix = new boolean[countMatrix][countMatrix];
        for (int i = 0; i < countMatrix; i++) {
            for (int j = 0; j < countMatrix; j++) {
                int count = countNeighbors(i, j, countMatrix);
                newMatrix[i][j] = oldMatrix[i][j];
                if (count == 3) {
                    newMatrix[i][j] = true;
                } else if (count < 2 || count > 3) {
                    newMatrix[i][j] = false;
                } else {
                    newMatrix[i][j] = newMatrix[i][j];
                }
            }
        }
        for (int i = 0; i < countMatrix; i++) {
            for (int j = 0; j < countMatrix; j++) {
                oldMatrix[i][j] = newMatrix[i][j];
            }
        }

        if (!lefe(oldMatrix)) {
            System.err.println("STOP");
            oldMatrix = null;
            return oldMatrix;
        } else {
            return oldMatrix;
        }
    }

    public boolean[][] getOldMatrix() {
        controllCell();
        return oldMatrix;
    }

    public boolean lefe(boolean[][] oldMatrix) {
        int c = 0;
        counterStopGame3 = counterStopGame2;

        for (int i = 0; i < countMatrix; i++) {
            for (int j = 0; j < countMatrix; j++) {
                if (oldMatrix[i][j]) {
                    c++;
                    counterStopGame1 = c;
                }
            }
        }
        if (counterStopGame1 == counterStopGame2 && counterStopGame3 == counterStopGame2) {
            stopGame++;
            if (stopGame > 50) {
                return false;
            }
            if (c == 0) {
                return false;
            }
            return true;
        } else {
            counterStopGame2 = counterStopGame1;
            return true;
        }
    }


    public void setOldMatrix(boolean[][] oldMatrix) {
        this.oldMatrix = oldMatrix;
    }
}
