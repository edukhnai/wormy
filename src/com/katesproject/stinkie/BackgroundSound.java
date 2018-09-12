package com.katesproject.stinkie;


import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.IBinder;

import java.util.List;
/**�����-������, ������������� ������� ������ ���������� �� ������ �����������.*/
public class BackgroundSound extends Service {
	/**���� ������ CountDownTimer, ����������� ��� ���������� �������� ������������ ������ ������.*/
    CountDownTimer timer;
/**� ��� ������� ������������� ������*/
    MediaPlayer player;
    /**���������� null, ��� ��� ������������� �� ����� �������� ���������� � �������.*/
    public IBinder onBind(Intent arg0) {
        return null;
    }
/**�������������� ���� player, ������������� ������������� ������, ���������, � ����� ��������� ��.*/
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.fonmuz);
        player.setLooping(true);
        player.setVolume(50, 50);
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (mp == player) {
                    player.start();
                }
            }
        });
        timer = new CountDownTimer(900000000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {
                autostop();
            }
            @Override
            public void onFinish() {
            }
        };
        timer.start();
    }
/**��������� ������*/
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;

    }


    /**���������� ����� �����*/
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }
    /**������������� ������������ ������ � ����������� ������ ����������*/
    public void onStop() {
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
        }
    }


    /**��� �������� ���������� � ���������� ���������, � ����� ��� ������������� ������ ������������� ������������ ������. 
     * ���� �� player ���������������, �� �� �������� �� �����-�� ��������, �� ��������� ������. */
    private void autostop(){
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName activity = taskInfo.get(0).baseActivity;
            if (!activity.getPackageName().equals(context.getPackageName())) {
                if(player!=null && player.isPlaying()){
                    player.stop();
                }
                else
                if(player!=null && !player.isPlaying()){
                    player.start();
                }
            }
        }
    }

    /**������������� ������������ ������ � ����������� �� ��� ������*/
    @Override
    public void onDestroy() {
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
        }
    }
    /**���� �� ������� ������, �� ������������� ������������ ������ � ����������� �� ��� ������*/
    @Override
    public void onLowMemory() {
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
        }
    }
    
    public void onBackPressed() {
      stopService(new Intent(this, BackgroundSound.class));
    }

}