package com.katesproject.stinkie;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**Класс, с помощью которого формируется игровое поле с шариками*/
public class LinesView extends View {

/**Состояние игры*/
    public int LMode = LinesConsts.RUNNING;
    /**Состояние игры для других классов*/
    public static int pubMode;
    /**Поле, позволяющее рисовать*/
    public final Paint LPaint = new Paint();
    /**Bitmap, на котором отображается изображение*/
    public Bitmap LBitmap;
     /**Канва, позволяющая использовать Bitmap*/
    public Canvas LCanvas;
    /**Матрица с шариками*/
    public LinesMatrix LineMatrix;
    /**Массив*/
    public static Bitmap[] LArray;
    /**Смещение по оси ОХ*/
    public static int mXOffset;
    /**Смещение по оси OY*/
    public static int mYOffset;
    /**Ширина изображения с шариками*/
    public static int LVWidth;
    /**Высота изображения с шариками*/
    public static int LVHeight;
    /**Количество набранных очков*/
    public static int linesScore;
    /**Инициализация поля, позволяющего исполизовать содержимое синглтона*/
    CharSin cs=CharSin.getInstance(getContext());
    /**Конструктор, инициализирующий матрицу шариков*/
    public LinesView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initLinesView();
    }
    /**Конструктор, инициализирующий матрицу шариков*/
    public LinesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLinesView();
    }
    /**Метод, загружающий константы шариков*/
    public void initLinesView() {
        setFocusable(true);
        
        Resources r = this.getContext().getResources();

        resetBubbles(LinesConsts.BUBBLE_COLOR);

        loadBubble(LinesConsts.BLUE_BUBBLE,
                r.getDrawable(R.drawable.bubble_blue));
        loadBubble(LinesConsts.CYAN_BUBBLE,
                r.getDrawable(R.drawable.bubble_cuan));
        loadBubble(LinesConsts.GREEN_BUBBLE,
                r.getDrawable(R.drawable.bubble_green));
        loadBubble(LinesConsts.MAGENTA_BUBBLE,
                r.getDrawable(R.drawable.bubble_magenta));
        loadBubble(LinesConsts.RED_BUBBLE, r.getDrawable(R.drawable.bubble_red));
        loadBubble(LinesConsts.YELLOW_BUBBLE,
                r.getDrawable(R.drawable.bubble_yellow));
    }
/**Метод установления состояния игры*/
    public void setMode(int newMode) {
        int lastMode = LMode;
        LMode = newMode;
        pubMode=newMode;

        if (newMode == LinesConsts.RUNNING & lastMode != LinesConsts.RUNNING) {
            this.invalidate();
            return;
        }
        if (newMode == LinesConsts.LOSE) {
            pubMode=newMode;
            cs.setCurrentScore(linesScore);
            if(linesScore>cs.getRecordScore()){
            cs.setRecordScore(linesScore);}
            if (System.currentTimeMillis() == 5000) {
                setMode(LinesConsts.RUNNING);
            }
        }


    }
/**Создание новой игры*/
    public void newGame() {
        linesScore = 0;

        LineMatrix = new LinesMatrix(LVWidth, LVHeight);

        mXOffset = 1;
        mYOffset = 1;

        refreshPlayground(this);
    }
/**Загрузка одного шарика*/
    public void loadBubble(int key, Drawable bubble) {
        Bitmap bitmap = Bitmap.createBitmap(LinesConsts.BUBBLE_DIAMETER,
                LinesConsts.BUBBLE_DIAMETER, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        bubble.setBounds(0, 0, LinesConsts.BUBBLE_DIAMETER,
                LinesConsts.BUBBLE_DIAMETER);
        bubble.draw(canvas);

       LArray[key] = bitmap;
    }
/**Смена размеров высоты и ширины матрицы с шариками*/
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        LVWidth = LBitmap != null ? LBitmap.getWidth() : 0;
        LVHeight = LBitmap != null ? LBitmap.getHeight() : 0;
        if (LVWidth >= w && LVHeight >= h) {
            return;
        }

        if (LVWidth < w) {
            LVWidth = w;
        }
        if (LVHeight < h) {
            LVHeight = h;
        }

        newGame();
    }

    /**Обработка нажатий по матрице с шариками*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (action != MotionEvent.ACTION_UP || LMode != LinesConsts.RUNNING) {
            return true;
        }

        int curX = (int) Math.floor(event.getX());
        int curY = (int) Math.floor(event.getY());

        int bubbleX = (curX - mXOffset) / LinesConsts.BUBBLE_DIAMETER;
        int bubbleY = (curY - mYOffset) / LinesConsts.BUBBLE_DIAMETER;

        LineMatrix.findSameBubble(bubbleX, bubbleY);

        if (LineMatrix.SamelineBCount > 1) {
            linesScore += calculateScore(LineMatrix.SamelineBCount);

            LineMatrix.removeMarkedBubbles();

            refreshPlayground(this);

            LineMatrix.removeMark();

            this.invalidate();
        }

       if (LineMatrix.isBBMatrixSolvable() == false) {
            setMode(LinesConsts.LOSE);

        }
        return true;     
    }
    /**Заполнение матрицы изображениями шариков*/
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (LinesConsts.RUNNING == LMode && LBitmap != null) {
            canvas.drawBitmap(LBitmap, 0, 0, null);
        }
    }
/**Смена матрицы с шариками*/
    public void refreshPlayground(View v) {
        LBitmap = Bitmap.createBitmap(LVWidth, LVHeight,
                Bitmap.Config.ARGB_8888);
        LCanvas = new Canvas();
        LCanvas.setBitmap(LBitmap);
        if (LBitmap != null) {
            LCanvas.drawBitmap(LBitmap, 0, 0, null);
        }
        for (int i = 0; i < LineMatrix.XlineCount; i++) {
            for (int j = 0; j < LineMatrix.YlineCount; j++) {
                if (LineMatrix.lineGrid[i][j] != LinesConsts.NULL_BUBBLE) {
                    LCanvas.drawBitmap(
                            LArray[LineMatrix.lineGrid[i][j]], mXOffset
                                    + i * LinesConsts.BUBBLE_DIAMETER, mYOffset
                                    + j * LinesConsts.BUBBLE_DIAMETER, LPaint);

                }
            }
        }
    }

/**Расчет набранных очков*/
    public int calculateScore(int SLineCount) {
        int result = 1;

        if (SLineCount <= 1) {
            return 0;
        }

        for (int i = 2; i <= SLineCount; i++) {
            result += i;
        }
        return result;
    }
/**Смена расположения шариков из-за другого их порядка в новом массиве*/
    public static void resetBubbles(int pBubbleCount) {
        LArray = new Bitmap[pBubbleCount];
    }


}

