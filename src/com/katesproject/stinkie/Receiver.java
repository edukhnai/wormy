package com.katesproject.stinkie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**Класс, позволяющий запускать сервис с таймером, имитирующим жизнедеятельность существа, вместе с запуском мобильного устройства.*/
public class Receiver extends BroadcastReceiver {
/**Запуск сервиса с таймером в нужный момент*/
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, TimerService.class);
        context.startService(serviceIntent);
    }

}