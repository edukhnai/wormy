package com.katesproject.stinkie;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;

/**Класс, соответствующий доске в игровой комнате*/
public class WaxboardView extends View {

    /**Чувствительность к прикосновениям к экрану*/
   private static final float TOUCH_TOLERANCE = 7;
    /**Битмап*/
   static Bitmap bitmap;
    /**Канва, с помощью которой можно рисовать на Битмапе*/
   static Canvas bitmapCanvas;
    /**Экран для рисования*/
   Paint paintScreen;
    /**Линия, имитируюшая рисование мелом*/
   Paint paintLine;
    /**HashMap с путем нарисованных точек*/
   HashMap<Integer, Path> pathMap;
    /**HashMap с уже нарисованными точками*/
   HashMap<Integer, Point> previousPointMap;

/**Конструктор, инициализирующий все необходимые для рисования поля*/
   public WaxboardView(Context context, AttributeSet attrs)
   {
      super(context, attrs);
      paintScreen = new Paint();
      paintLine = new Paint();
      paintLine.setAntiAlias(true);
      paintLine.setColor(Color.WHITE);
      paintLine.setStyle(Paint.Style.STROKE);
      paintLine.setStrokeWidth(5);
      paintLine.setStrokeCap(Paint.Cap.ROUND);
      pathMap = new HashMap<Integer, Path>();
      previousPointMap = new HashMap<Integer, Point>();

   }

/**Инициализация Битмапа, установка фона*/
   @Override
   public void onSizeChanged(int w, int h, int oldW, int oldH){
	   bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
              Bitmap.Config.ARGB_8888);
      bitmapCanvas = new Canvas(bitmap);
      bitmap.eraseColor(Color.BLACK);
   }
/**Метод для очистки доски от рисунка*/
   public void clear()
   {
      pathMap.clear();
      previousPointMap.clear();
      bitmap.eraseColor(Color.BLACK);
      invalidate();
   }
/**Метод, позволяющий рисовать на доске*/
   @Override
   protected void onDraw(Canvas canvas)
   {
      canvas.drawBitmap(bitmap, 0, 0, paintScreen);

      for (Integer key : pathMap.keySet())
         canvas.drawPath(pathMap.get(key), paintLine);
   }
/**Метод, обрабатывающий прикосновения к экрану*/
   @Override
   public boolean onTouchEvent(MotionEvent event)
   {
      int action = event.getActionMasked();
      int actionIndex = event.getActionIndex();

      if (action == MotionEvent.ACTION_DOWN ||
              action == MotionEvent.ACTION_POINTER_DOWN)
      {
         touchStarted(event.getX(actionIndex), event.getY(actionIndex),
                 event.getPointerId(actionIndex));
      }
      else if (action == MotionEvent.ACTION_UP ||
              action == MotionEvent.ACTION_POINTER_UP)
      {
         touchEnded(event.getPointerId(actionIndex));
      }
      else
      {
         touchMoved(event);
      }

      invalidate();
      return true;
   }
/**Метод, необходимый при начале прикосновения к экрану*/
   private void touchStarted(float x, float y, int lineID)
   {
      Path path;
      Point point;
      if (pathMap.containsKey(lineID))
      {
         path = pathMap.get(lineID);
         path.reset();
         point = previousPointMap.get(lineID);
      }
      else
      {
         path = new Path();
         pathMap.put(lineID, path);
         point = new Point();
         previousPointMap.put(lineID, point);
      }

      path.moveTo(x, y);
      point.x = (int) x;
      point.y = (int) y;
   }
/**Метод, необходимый при перемещении пальца по экрану*/
   private void touchMoved(MotionEvent event)
   {

      for (int i = 0; i < event.getPointerCount(); i++)
      {

         int pointerID = event.getPointerId(i);
         int pointerIndex = event.findPointerIndex(pointerID);

         if (pathMap.containsKey(pointerID))
         {
            float newX = event.getX(pointerIndex);
            float newY = event.getY(pointerIndex);
            Path path = pathMap.get(pointerID);
            Point point = previousPointMap.get(pointerID);
            float deltaX = Math.abs(newX - point.x);
            float deltaY = Math.abs(newY - point.y);
            if (deltaX >= TOUCH_TOLERANCE || deltaY >= TOUCH_TOLERANCE)
            {
               path.quadTo(point.x, point.y, (newX + point.x) / 2,
                       (newY + point.y) / 2);

               point.x = (int) newX;
               point.y = (int) newY;
            }
         }
      }
   }
/**Метод, используемый при окончании прикосновения к экрану*/
   private void touchEnded(int lineID)
   {
      Path path = pathMap.get(lineID);
      bitmapCanvas.drawPath(path, paintLine);
      path.reset();
   }

}
