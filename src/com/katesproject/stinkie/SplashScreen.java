package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
/**Класс. отвечающий за действия на сплэш-заставке*/
public class SplashScreen extends Activity {
/**Текстово поле с процентами, показывающими прогресс загрузки игры*/
    TextView percent;
    /**Индикаор прогресса загрузки игры*/
    ProgressBar pbView;
/**Изображение пятнышка от краски*/
    ImageView redpoint, yellowpoint, greenpoint, bluepoint, purplepoint,
            message;
    /**Поле, позволяющее обращаться к сожержимому синглтона*/
    CharSin cs;

    /**Инициализация полей, запуск сервиса с таймером*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            setContentView(R.layout.splash_layout);
            cs=CharSin.getInstance(getApplicationContext());
            cs.loadParameters(getApplicationContext());
            cs.setTimes(1);
            percent = (TextView) findViewById(R.id.percent);
            pbView = (ProgressBar) findViewById(R.id.pbView);
            redpoint = (ImageView) findViewById(R.id.redpoint);
            yellowpoint = (ImageView) findViewById(R.id.yellowpoint);
            greenpoint = (ImageView) findViewById(R.id.greenpoint);
            bluepoint = (ImageView) findViewById(R.id.bluepoint);
            purplepoint = (ImageView) findViewById(R.id.purplepoint);
            message = (ImageView) findViewById(R.id.message);
            Intent svc = new Intent(this, BackgroundSound.class);
            getApplicationContext().startService(svc);
            Intent ts = new Intent(this, TimerService.class);
            getApplicationContext().startService(ts);
        }
    }
/**Запуск AsyncTask-а, при этом облако с текстом о продолжении игры исчезает*/
    public void onPbButton(View v) {
        new MyAsyncTask().execute();
        message.setVisibility(View.INVISIBLE);

    }
/**Класс, позволяющий имитировать загрузку программы*/
    class MyAsyncTask extends AsyncTask<Void, Integer, View> {

    /**Процент, стоящий в текстовом поле для прогресса загрузки игры*/
        private int pbValue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
/**Установка текста, содержащего процент загрузки приложения, показ пятнышек
 * краски при достижении процентом загрузки определенной границы*/
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pbView.setProgress(values[0]);
            percent.setText(values[0] + "%");
            if (pbValue == 10)
                redpoint.setVisibility(View.VISIBLE);
            if (pbValue == 30)
                yellowpoint.setVisibility(View.VISIBLE);
            if (pbValue == 50)
                greenpoint.setVisibility(View.VISIBLE);
            if (pbValue == 70)
                bluepoint.setVisibility(View.VISIBLE);
            if (pbValue == 90)
                purplepoint.setVisibility(View.VISIBLE);

        }
/**Наращивание процента загруженности приложения*/
        @Override
        protected View doInBackground(Void... params) {

           for (int i=0;i < 100; i++) {
                pbValue++;
                publishProgress(pbValue);
                SystemClock.sleep(50);
            }
            return null;
        }
/**По окончании "загрузки" приложения - переход в главное меню*/
        @Override
        protected void onPostExecute(View a) {
Intent intent2 = new Intent(SplashScreen.this,
                    MainMenuActivity.class);
            startActivity(intent2);
            super.onPostExecute(a);
            finish();
        }

    }
    @Override
    public void onBackPressed(){}
}
