package com.katesproject.stinkie;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;

public class NotifyService extends Service {
	  /**Поле, позволяющее пользоваться содержимым синглтона*/
    CharSin cs;
    /**Поле, необходимое для ведение отсчета времени по промежуткам*/
    MyCounter notifTimer;
    /**Контекст данного класса*/
    Context ctxt;
    /**Строка, используемая в уведомлениях*/
    CharSequence s, t, t2, tf, th, tm, tl;

    /**Инициализация полей*/
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        notifTimer = new MyCounter(86400000,1800000);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        s=getString(R.string.s);
        t=getString(R.string.t);
        t2=getString(R.string.t2);
        tf=getString(R.string.tf);
        th=getString(R.string.th);
        tm=getString(R.string.tm);
        tl=getString(R.string.tl);
        super.onCreate();
    }
/**Запуск сервиса и таймера в частности*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        notifTimer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    /**Класс, отвечающий за действия в таймере*/
    private class MyCounter extends CountDownTimer{
/**Конструктор, создающий таймер*/
        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            notifTimer.start();
        }
/**Действия, происходящие по истечении одного установленного промежутка времени.*/
        @Override
        public void onTick(long millisUntilFinished) {
            if(cs.getMood()<=20){makeNotify(tl, tm,getString(R.string.s3), 14);}

            if(cs.getRecordScore()>=200 && !cs.masterlines){
                makeNotify(t, t2,getString(R.string.s4)+s, 1);}
            if(cs.getCclean()>=50 && !cs.chistulya){makeNotify(t, t2,getString(R.string.s5) + s, 2);}
            if(cs.getCclean()>=100 && !cs.masterclean){makeNotify(t, t2,getString(R.string.s6)+s, 3);}
            if(cs.getCclean()>=250 &&!cs.nachumiv){makeNotify(t, t2,getString(R.string.s7)+s, 4);}
            if(cs.getCfood()>=50 && !cs.cock){makeNotify(t, t2,getString(R.string.s8)+s, 5);}
            if(cs.getCfood()>=100&& !cs.gourm){makeNotify(t, t2,getString(R.string.s9)+s, 6);}
            if(cs.getCfood()>=250&& !cs.obedalo){makeNotify(t, t2,getString(R.string.s10)+s, 7);}
            if(cs.getCmood()>=50&& !cs.funny){makeNotify(t, t2,getString(R.string.s11)+s, 8);}
            if(cs.getCmood()>=100&&!cs.youngclown){makeNotify(t, t2,getString(R.string.s12)+s, 9);}
            if(cs.getCmood() >=250&&!cs.masterfun){makeNotify(t, t2,getString(R.string.s13)+s, 10);}
            if(cs.getCwear()>=10 &&!cs.fashioner){makeNotify(t, t2,getString(R.string.s14)+s, 11);}}
        }
    


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        notifTimer.cancel();
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    /**Создание уведомления*/
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void makeNotify(CharSequence title,CharSequence title2, CharSequence message, int num){ Intent notificationIntent = new Intent(ctxt, TimerService.class);
        Intent achivIntent = new Intent(ctxt, AchivListActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(ctxt,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        Resources res = ctxt.getResources();
        Notification.Builder builder = new Notification.Builder(ctxt);
        builder.setSmallIcon(R.drawable.alert_icon)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.alert_icon))
                .setTicker(title)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(title2)
                .setContentIntent(PendingIntent.getActivity(ctxt, 0, achivIntent, PendingIntent.FLAG_CANCEL_CURRENT))
                .setContentText(message);
        Notification notification=null;
        if (android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.JELLY_BEAN) {
                notification=builder.build(); 
            } else if (android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.HONEYCOMB) {
              notification=builder.getNotification();
            }
        notification.defaults = Notification.DEFAULT_SOUND |
                Notification.DEFAULT_VIBRATE| Notification.DEFAULT_LIGHTS;
        NotificationManager notificationManager = (NotificationManager) ctxt
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(num, notification);
        notification.ledARGB = Color.RED;
        notification.ledOffMS = 0;
        notification.ledOnMS = 1;
        notification.flags = notification.flags | Notification.FLAG_SHOW_LIGHTS;
    }
}
