package com.katesproject.stinkie;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**Класс, отвечающий за действия во дворе персонажа*/
public class StreetActivity extends Activity {
	/**Изображение персонажа*/
	ImageView stinkieStreet;
	/**Изображение лягушки*/
	ImageView frog;
	/**Изображение дерева*/
	ImageView tree1;
	/**Изображение белки*/
	ImageView squirrel;
	/**Текстовое поле, отображающее текущий игровой баланс пользователя*/
	TextView moneyview;
	/**Поле, с помощью которого можно получать данные из синглтона*/
	CharSin cs;
	/**Изображение индикатора сытости*/
	ProgressBar foodprogbar;
	/**Изображение индикатора состояния здоровья*/
	ProgressBar healthprogbar;
	/**Изображение индикатора настроения*/
	ProgressBar moodprogbar;
	/**Изображение индикатора игровых очков*/
	ProgressBar pointprogbar;
	/**Изображение яблока*/
	ImageView apple;
	/**Текстовое облако с информацией про висящее яблоко*/
	ImageView wordsrr1;
	/**Анимация - падающее и шатающееся яблоко*/
	Animation appleAnim;
	/**Анимация - скачущая лягушка*/
	Animation frogAnim;
	/**Анимация - прыгающая белка*/
	Animation squirAnim;
	/**Булевое значение, упало ли яблоко*/
	boolean AlreadyDown;
	/**Слушатель показаний сенсора*/
	SensorEventListener sampleListener;
	/**Показания акселероматра*/
	private float mAccel;
	/**Текущие показания акселерометра*/
	private float mAccelCurrent;
	/**Последние показания акселерометра*/
	private float mAccelLast;
	/**Контекст двора*/
	Context ctxt;
	/**Необходимо для создания таймера, обновляющего индикаторы жизненных параметров персонажа*/
	CountDownTimer timer;

	/**Инициализация полей, установление правильного изображения для индикатора игровых очков
	 * в зависимости от уровня персонажа*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.street);
		cs=CharSin.getInstance(getApplicationContext());
		ctxt=this;
		stinkieStreet=(ImageView)findViewById(R.id.stinkieStreet);
		moneyview=(TextView)findViewById(R.id.moneyview);
		wordsrr1=(ImageView)findViewById(R.id.wordsrr1);
		apple=(ImageView)findViewById(R.id.apple);
		apple.setClickable(false);
		squirrel=(ImageView)findViewById(R.id.squirrel);
		foodprogbar = (ProgressBar) findViewById(R.id.foodprogbar);
		foodprogbar.setProgress(cs.getHunger());
		healthprogbar = (ProgressBar) findViewById(R.id.healthprogbar);
		healthprogbar.setProgress(cs.getHealth());
		moodprogbar = (ProgressBar) findViewById(R.id.moodprogbar);
		moodprogbar.setProgress(cs.getMood());
		pointprogbar = (ProgressBar) findViewById(R.id.pointprogbar);
		pointprogbar.setProgress(cs.getWorpoints());
		foodprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.foodprogbar));
		foodprogbar.setMax(100);
		healthprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.healthprogbar));
		healthprogbar.setMax(100);
		moodprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.moodprogbar));
		moodprogbar.setMax(100);
		cs.setDressingWear(stinkieStreet);
		switch (cs.getLevel()){
			case 1:setpb(R.drawable.pointprogbarx, 200);break;
			case 2: setpb(R.drawable.point2lvl, 1000);break;
			case 3: setpb(R.drawable.point3lvl, 1750);break;
			case 4:setpb(R.drawable.point4lvl, 3000);break;
			case 5:setpb(R.drawable.point5lvl, 5000);break;
			case 6:setpb(R.drawable.point6lvl, 7500);break;
			case 7:setpb(R.drawable.point7lvl, 10000);break;
			case 8:setpb(R.drawable.point8lvl, 15000);break;
			case 9:setpb(R.drawable.point9lvl, 20000);break;
			case 10:setpb(R.drawable.point10lvl, 25000);break;}
		moneyview.setText(cs.getStrMoney());
		timer = new CountDownTimer(900000000, 100) {
			public void onTick(long millisUntilFinished) {
				LevelProgressDialog();
                foodprogbar.setProgress(cs.getHunger());
				healthprogbar.setProgress(cs.getHealth());
				moodprogbar.setProgress(cs.getMood());
				pointprogbar.setProgress(cs.getWorpoints());
				if (cs.getHunger() < 20 && cs.getHealth()< 20 && cs.getMood() < 20) {
					stinkieStreet.setImageResource(R.drawable.ill);
				}
			}
			public void onFinish() {
				timer.start();
			}
		};
		timer.start();
		cs.teach(ctxt);
		if (cs.getTimes() == 1 && cs.getFirstStreet()==false&&cs.getWantTeach())
		{ cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s142),
			 R.drawable.alert_icon);
			cs.setFirstStreet(true);}

		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
		mAccelLast = SensorManager.GRAVITY_EARTH;
		sampleListener = new SampleSensorEventListener();
		appleAnim = AnimationUtils.loadAnimation(this, R.anim.apple_anim);
	    squirAnim=AnimationUtils.loadAnimation(this, R.anim.squir_anim);
		tree1=(ImageView)findViewById(R.id.tree1);
        frog = (ImageView)findViewById(R.id.frog);
        frogAnim = AnimationUtils.loadAnimation(this,
                R.anim.froganimx);
        Display display = getWindowManager().getDefaultDisplay();
		
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);}

/**Включение аудиотрека "ветер"*/
	public void fallingleaves(View v){
		cs.makeMusic(this, R.raw.veter);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rightpoints_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.gotomain:
				Intent intent= new Intent(this, MainMenuActivity.class);
				startActivity(intent);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}


/**Запуск анимации с белкой*/
public void gosquir(View v){
	{cs.setCmood(1);
		squirrel.startAnimation(squirAnim);
	squirrel.setY(squirrel.getY() - 200);
	SystemClock.sleep(5);
	squirrel.setY(squirrel.getY() + 200);}
	if(cs.getMaxEarn()+10<=100){cs.setMoney(10);
		cs.setMaxEarn(10);
		moneyview.setText(cs.getStrMoney());}
	cs.makeMusic(this, R.raw.squir);
}
	/**Переход с улицы в прихожую*/
	public void godownfromstreet(View V){
		Intent intent = new Intent(StreetActivity.this, LobbyActivity.class);
		startActivity(intent);
	}
/**Запуск анимации с лягушкой*/
	public void startFrog(View v){
		cs.setCmood(1);
		frog.startAnimation(frogAnim);
		cs.makeMusic(this, R.raw.qua);
		if(cs.getMaxEarn()+10<=100){cs.setMoney(10);
			cs.setMaxEarn(10);
		moneyview.setText(cs.getStrMoney());}

	}
	@Override
	protected void onPause() {
		super.onPause();
		((SensorManager) getSystemService(SENSOR_SERVICE))
				.unregisterListener(sampleListener);
	}
	/**Помимо снятия работы активности с паузы - проверка работоспособности акселерометра*/
	@Override
	protected void onResume() {
		super.onResume();
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if (s == null)
			SuperToast.create(this,getString(R.string.s105), SuperToast.Duration.VERY_SHORT, 
            	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
		((SensorManager) getSystemService(SENSOR_SERVICE)).registerListener(
				sampleListener, s, SensorManager.SENSOR_DELAY_NORMAL);
	}
	/**Персонаж съедает яблоко - изображение плода исчезает, а у существа повышается сытость, воспроизводится
	 * нужный аудиотрек, добавляются игровые очки*/
public void eatfallapple(View v){
	cs.setCfood(1);
	 cs.setHunger(10);
	 foodprogbar.setProgress(cs.getHunger());
	         cs.setWorpoints((int) (Math.random() * 10));
	         cs.makeMusic(this, R.raw.yabloko);
	         apple.setVisibility(View.INVISIBLE);
}
	/**Класс-слушатель акселерометра*/
	class SampleSensorEventListener implements SensorEventListener {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			mAccelLast = mAccelCurrent;
			mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
			float delta = mAccelCurrent - mAccelLast;
			mAccel = mAccel * 0.9f + delta;
			
			if (!AlreadyDown && mAccel * mAccel > 150 && mAccel * mAccel < 250) {
				wordsrr1.setImageResource(R.drawable.wordsrr2);
				apple.startAnimation(appleAnim);
				mAccelLast=mAccelCurrent =mAccel=0;
			}
			if (!AlreadyDown && mAccel * mAccel > 280) {
				apple.setY(apple.getY()+200);
				apple.invalidate();
				AlreadyDown=true;
				apple.setClickable(true);
				wordsrr1.setVisibility(View.INVISIBLE);
				mAccelLast=mAccelCurrent =mAccel=0;
			}
			}
		}



	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
		timer.cancel();
	}
	/**Данный метод позволяет изменять внешний вид индикатора путем установления
	 * другого изображения, изменение максимального значения прогресса*/
	public void setpb(int d, int m){
		pointprogbar.setProgressDrawable(getResources().getDrawable(d));
		pointprogbar.setMax(m);
		pointprogbar.setProgress(cs.getWorpoints());
	}
	 /**Метод, выводящий на экран пользователя AlertDialog с информацией о том, что он перешел на
     * следующий игровой уровень, при этом изменяется внешний вид индикатора, отвечающего за игровые очки, а также
     * начисляется награда в виде определенного количества игровой валюты и очков*/
    public void LevelProgressDialog(){
        switch(cs.getLevel()){
            case 1: if(cs.worpoints >=200){
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.twolevel),
                        R.drawable.happy2, getString(R.string.getcongrats), 200, 150);
                setpb(R.drawable.point2lvl, 1000);
                moneyview.setText(cs.getStrMoney());
                cs.setNowWearing(-1);
                stinkieStreet.setImageResource(R.drawable.stinkie);
                cs.setLevel(2);}break;
            case 2: if (cs.worpoints >= 1000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.threelevel),
                        R.drawable.happy3, getString(R.string.getcongrats), 250, 200);
                setpb(R.drawable.point3lvl, 1750);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(3);}break;
            case 3: if (cs.worpoints >= 1750) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.fourlevel),
                        R.drawable.happy4, getString(R.string.getcongrats), 300, 250);
                setpb(R.drawable.point4lvl, 3000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(4);}break;
            case 4:if (cs.worpoints >= 3000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.fivelevel),
                        R.drawable.happy5, getString(R.string.getcongrats), 350, 300);
                setpb(R.drawable.point5lvl, 5000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(5);}break;
            case 5: if (cs.worpoints >= 5000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel),getString(R.string.sixlevel),
                        R.drawable.happy6, getString(R.string.getcongrats), 400, 350);
                setpb(R.drawable.point6lvl, 7500);
                cs.setLevel(6);}break;
            case 6:if (cs.worpoints >= 7500) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.sevenlevel),
                        R.drawable.happy7, getString(R.string.getcongrats), 450, 400);
                setpb(R.drawable.point7lvl, 10000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(7);}break;
            case 7:if (cs.worpoints >= 10000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.eightlevel),
                        R.drawable.happy8, getString(R.string.getcongrats), 500, 450);
                setpb(R.drawable.point8lvl, 15000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(8);}break;
            case 8: if (cs.worpoints >= 15000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.ninelevel),
                        R.drawable.happy9, getString(R.string.getcongrats), 550, 500);
                setpb(R.drawable.point9lvl, 20000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(9);}break;
            case 9: if (cs.worpoints>= 20000) {
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.tenlevel),
                        R.drawable.happy10, getString(R.string.getcongrats), 600, 550);
                setpb(R.drawable.point10lvl, 25000);
                moneyview.setText(cs.getStrMoney());
                cs.setLevel(10);}break;
        }

    }

	 @Override
	    public void onBackPressed(){}
}


	

        