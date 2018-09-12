package com.katesproject.stinkie;

/**Матрица с шариками для мини-игры "Линии"*/
public class LinesMatrix {

/**Массив с шариками*/
    public int[][] lineGrid;
/**Массив с утверждениями, отмечен ли каждый шарик*/
    public boolean[][] lineMarked;
    /**Одинаковые шарики*/
    public int SamelineBCount;
/**Подсчет по оси OX*/
    public int  XlineCount;
    /**Подсчет по оси Y*/
    public int YlineCount;

    /**Конструктор, записывающий в подсчеты размеров по обеим осям целое число, меньшее или равное по параметру
     * и заполняющий матрицу с шариками.*/
    public LinesMatrix(int pViewWidth, int pViewHeight) {
        XlineCount = (int) Math.floor(pViewWidth
                / LinesConsts.BUBBLE_DIAMETER);
        YlineCount = (int) Math.floor(pViewHeight
                / LinesConsts.BUBBLE_DIAMETER);

        lineGrid = new int[ XlineCount][YlineCount];
        lineMarked = new boolean[ XlineCount][YlineCount];

        clearBubbles();

        fillBBMatrix();
    }
/**Метод, позволяющий заполнять матрицу шариками*/
    public void fillBBMatrix() {
        for (int i = 0; i <  XlineCount; i++) {
            for (int j = 0; j < YlineCount; j++) {
                newBubble(i, j,
                        (int) (Math.random() * LinesConsts.BUBBLE_COLOR));
            }
        }
    }
/**Создание нового шарика*/
    public void newBubble(int x, int y, int pBubbleType) {
        lineGrid[x][y] = pBubbleType;
        lineMarked[x][y] = false;
    }
/**Поиск идентичного шарика*/
    public void findSameBubble(int x, int y) {

        if ((x < 0 || y < 0 || x >=  XlineCount || y >= YlineCount)
                || (lineGrid[x][y] == LinesConsts.NULL_BUBBLE)) {
            return;
        }

        SamelineBCount++;
        lineMarked[x][y] = true;

        int color = lineGrid[x][y];

        if (getColor(x, y + 1) == color && isMarked(x, y + 1) == false) {
            findSameBubble(x, y + 1);
        }
        if (getColor(x, y - 1) == color && isMarked(x, y - 1) == false) {
            findSameBubble(x, y - 1);
        }
        if (getColor(x + 1, y) == color && isMarked(x + 1, y) == false) {
            findSameBubble(x + 1, y);
        }
        if (getColor(x - 1, y) == color && isMarked(x - 1, y) == false) {
            findSameBubble(x - 1, y);
        }
    }
/**Проверка, пустая ли колонка*/
    public boolean isEmptyColumn(int x) {
        return isNullBubble(x, YlineCount - 1);
    }

    /**Удаление помеченных шариков*/
    public void removeMarkedBubbles() {
        for (int y = 0; y < YlineCount; y++) {
            for (int x = 0; x <  XlineCount; x++) {
                if (isMarked(x, y) == true) {
                    removeBubble(x, y);
                    for (int i = y; i > 0; i--) {
                        moveBubble(x, i - 1, x, i);
                    }
                }
            }
        }

        for (int x = 0; x <  XlineCount; x++) {
            if (isEmptyColumn(x) == true) {
                int i = x + 1;
                for (; i <  XlineCount && isEmptyColumn(i) == true; i++) {
                }
                if (i <  XlineCount) {
                    for (int y = 0; y < YlineCount; y++) {
                        moveBubble(i, y, x, y);
                    }
                }
            }
        }
    }
/**Удаление шарика*/
    public void removeBubble(int x, int y) {
        if (isNullBubble(x, y) == false) {
            lineGrid[x][y] = LinesConsts.NULL_BUBBLE;
        }
    }
/**Удаление пометки*/
    public void removeMark() {
        SamelineBCount = 0;

        for (int i = 0; i <  XlineCount; i++) {
            for (int j = 0; j < YlineCount; j++) {
                lineMarked[i][j] = false;
            }
        }
    }
/**"Передвижение" шарика по матрице*/
    public void moveBubble(int x, int y, int toX, int toY) {
        if (x != toX || y != toY) {
            lineGrid[toX][toY] = lineGrid[x][y];
            lineGrid[x][y] = LinesConsts.NULL_BUBBLE;
        }
    }
/**Проверка, не пустой ли шарик*/
    public boolean isNullBubble(int x, int y) {
        if ((x < 0 || y < 0 || x >=  XlineCount || y >= YlineCount)
                || LinesConsts.NULL_BUBBLE == (lineGrid[x][y])) {
            return true;
        }

        return false;
    }
/**Получение цвета шарика*/
    public int getColor(int x, int y) {
        if (isNullBubble(x, y) == true) {
            return LinesConsts.NULL_BUBBLE;
        } else {
            return lineGrid[x][y];
        }
    }
/**Проверка, отмечен ли шарик*/
    public boolean isMarked(int x, int y) {
        if (isNullBubble(x, y) == true) {
            return false;
        } else {
            return lineMarked[x][y];
        }
    }
/**Убирание необходимых шариков*/
    public void clearBubbles() {
        for (int x = 0; x <  XlineCount; x++) {
            for (int y = 0; y < YlineCount; y++) {
                setBubble(x, y, LinesConsts.NULL_BUBBLE);
            }
        }
    }
/**Выставление нужного шарика*/
    public void setBubble(int x, int y, int bubbleIndex) {
        lineGrid[x][y] = bubbleIndex;
    }

    /**Проверка, решабельна ли игра при данной матрице с шариками*/
    public boolean isBBMatrixSolvable() {
        for (int y = YlineCount - 1; y > -1; y--) {
            for (int x = 0; x <  XlineCount; x++) {
                if (isNullBubble(x, y) == false) {
                    if (isNullBubble(x + 1, y) == false
                            && lineGrid[x][y] == lineGrid[x + 1][y]) {
                        return true;
                    }
                    if (isNullBubble(x, y - 1) == false
                            && lineGrid[x][y] == lineGrid[x][y - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
