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
/**Класс, отвечающий за имитацию жизнедеятельности персонажа - периодическое уменьшение его жизненных харатеристик*/
public class TimerService extends Service{
    /**Поле, позволяющее пользоваться содержимым синглтона*/
    CharSin cs;
    /**Поле, необходимое для ведение отсчета времени по промежуткам*/
    MyCounter mTimer;
    /**Контекст данного класса*/
    Context ctxt;

    /**Инициализация полей*/
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        mTimer = new MyCounter(86400000,120000);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        super.onCreate();
    }
/**Зпуск сервиса и таймера в частности*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        mTimer.start();
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
            mTimer.start();
            cs.ClearMaxEarn();
        }
/**Действия, происходящие по истечении одного установленного промежутка времени.*/
        @Override
        public void onTick(long millisUntilFinished) {
                if(cs.hunger>100) cs.hunger=100;
                if(cs.hunger>0 && cs.hunger<=100)cs.setHunger(-1);
                else cs.hunger=1;
                if(cs.health>100) cs.health=100;
                if(cs.health>0 && cs.health<=100)cs.setHealth(-1);
                else cs.health=1;
                if(cs.mood>100) cs.mood=100;
                if(cs.mood>0 && cs.mood<=100)cs.setMood(-1);
                else cs.mood=1;
        }
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        mTimer.cancel();
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}
