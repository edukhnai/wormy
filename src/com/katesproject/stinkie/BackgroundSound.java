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
/** ласс-сервис, проигрывающий фоновую музыку независимо от других активностей.*/
public class BackgroundSound extends Service {
	/**ѕоле класса CountDownTimer, необходимое дл€ посто€нной проверки корректности работы музыки.*/
    CountDownTimer timer;
/**— его помощью проигрываетс€ музыка*/
    MediaPlayer player;
    /**¬озвращает null, так как пользовател€м не нужно отдельно обращатьс€ к сервису.*/
    public IBinder onBind(Intent arg0) {
        return null;
    }
/**»нициализирует поле player, устанавливает зацикленность музыки, громкость, а также запускает ее.*/
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
/**«апускает музыку*/
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;

    }


    /**¬озвращает канал св€зи*/
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }
    /**ќстанавливает проигрывание музыки и освобождает пам€ть устройства*/
    public void onStop() {
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
        }
    }


    /**ѕри переходе приложени€ в неактивное состо€ние, а также при возникновении ошибки останавливает проигрывание музыки. 
     * ≈сли же player инициализирован, но не работает по каким-то причинам, то запускает музыку. */
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

    /**ќстанавливает проигрывание музыки и освобождает от нее пам€ть*/
    @Override
    public void onDestroy() {
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
        }
    }
    /**≈сли не хватает пам€ти, то останавливает проигрывание музыки и освобождает от нее пам€ть*/
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