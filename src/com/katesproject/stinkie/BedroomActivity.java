package com.katesproject.stinkie;


import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
/**Класс, отвечающий за действия в спальне*/
public class BedroomActivity extends Activity {
	/**Изображение персонажа*/
	ImageView stinkieBedroom;
	/**Изображение картины на стене*/
	ImageView paintbedroom;
	/**Текстовое поле с балансом игрока*/
	TextView moneyview;
	/**Поле, с помощью которого можно получать данные из синглтона*/
	CharSin cs;
	/**Необходимо для создания таймера, обновляющего индикаторы жизненных параметров персонажа*/
	CountDownTimer timer;
	/**Изображение индикатора сытости*/
	ProgressBar foodprogbar;
	/**Изображение индикатора состояния здоровья*/
	ProgressBar healthprogbar;
	/**Изображение индикатора настроения*/
	ProgressBar moodprogbar;
	/**Изображение индикатора игровых очков*/
	ProgressBar pointprogbar;
	/**Контекст данного класса*/
	Context ctxt;
	/**Счетчик количества нажатий на картину*/
	int hack;

	/**Инициализация полей, установление правильного изображения для индикатора игровых очков
	 * в зависимости от уровня персонажа*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bedroom);
        cs=CharSin.getInstance(getApplicationContext());
		ctxt=this;
		hack=0;
		stinkieBedroom = (ImageView)findViewById(R.id.stinkieBedroom);
		moneyview=(TextView)findViewById(R.id.moneyview);
		paintbedroom=(ImageView)findViewById(R.id.paintbedroom);
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
		cs.setDressingWear(stinkieBedroom);
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
		timer = new CountDownTimer(900000000, 1000) {
			public void onTick(long millisUntilFinished) {
				LevelProgressDialog();
				foodprogbar.setProgress(cs.getHunger());
				healthprogbar.setProgress(cs.getHealth());
				moodprogbar.setProgress(cs.getMood());
				pointprogbar.setProgress(cs.getWorpoints());
				if (cs.getHunger() < 20 && cs.getHealth()< 20 && cs.getMood() < 20) {
					stinkieBedroom.setImageResource(R.drawable.ill);
				}
			}
			public void onFinish() {
				timer.start();
			}
		};
		timer.start();
		cs.teach(ctxt);
		/**AlertDialog с кратким описанием данной комнаты для нового игрока*/
		if (cs.getTimes() == 1 && cs.getFirstBedroom()==false && cs.getWantTeach())
		{ cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s79), R.drawable.alert_icon);
			cs.setFirstBedroom(true);}
	}
/**Перемещение из спальни в ванную*/
	public void goleftfrombedroom(View V){
        Intent intent4 = new Intent(BedroomActivity.this, BathroomActivity.class);
        startActivity(intent4); 
}
	/**Перемещение из спальни в игровую*/
	public void gorightfrombedroom(View A){
        Intent intent5 = new Intent(BedroomActivity.this, GameroomActivity.class);
        startActivity(intent5); 
    }
	/**Персонаж отправляется "спать": включается соответствующий аудиотрек,
	 *  улучшается состояние здоровья существа, добавляется произвольное число игровых очков,
	 *  а при неисчерпанном лимите заработка на день
	 *   также начисляется игровая валюта*/
	public void tosleep(View v)
	{cs.setHealth(20);
		cs.setCclean(1);
		healthprogbar.setProgress(cs.getHealth());
		cs.setWorpoints((int) (Math.random() * 10));
		pointprogbar.setProgress(cs.getWorpoints());
		if(cs.getMaxEarn()+10<=100){cs.setMoney(10);
			cs.setMaxEarn(10);
		moneyview.setText(cs.getStrMoney());}
		cs.makeMusic(this, R.raw.chrap);}

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
/**При каждом вызове этого метода переменная-счетчик увеличивается на единицу. Как только она становится равна 10,
 * появляется AlertDialog с полем для ввода текста. Если ввести правильную комбиницию символов, то на счет игрока
 * начисляется по 500 единиц игровых очков и валюты. Если текстовое поле игрок оставляет пустым или вводит
 * неверный код, то появляется toast с ободряющим содержанием.*/
	public void hackSafe(View v){
	if(hack<10){
			hack++;}
	else if(hack==10){
			AlertDialog.Builder builder = new AlertDialog.Builder(
					BedroomActivity.this);
			final Context context = this;
			LayoutInflater inflater = LayoutInflater.from(this);
			View dialogview = inflater.inflate(R.layout.hack_dialog, null);
			builder.setView(dialogview)
					.setTitle(getString(R.string.safe))
					.setMessage(getString(R.string.s80))
					.setCancelable(false)
					.setIcon(R.drawable.alert_icon)
					.setPositiveButton(getString(R.string.ready),
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									AlertDialog alertDialog = (AlertDialog) dialog;
									EditText edittexthack = (EditText) alertDialog.findViewById(R.id.edittexthack);
									String s= edittexthack.getText().toString();
									if (s.equals(String.valueOf(cs.secretcode))) {
										SuperToast.create(ctxt, getString(R.string.s81),
												SuperToast.Duration.VERY_SHORT, 
		                                	    Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
										cs.setMoney(500);
										cs.setWorpoints(500);
										moneyview.setText(cs.getStrMoney());
									} 
									else if (s.isEmpty()){SuperToast.create(ctxt, getString(R.string.s82),
											SuperToast.Duration.VERY_SHORT, 
	                                	    Style.getStyle(Style.WHITE, SuperToast.Animations.FLYIN)).show();}
									else SuperToast.create(ctxt, getString(R.string.s83),
											SuperToast.Duration.VERY_SHORT, 
	                                	    Style.getStyle(Style.ORANGE, SuperToast.Animations.FLYIN)).show();
									dialog.dismiss();
								}
							})

					.show();
	}

	}
	@Override
	protected void onPause() {
		super.onPause();
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

	@Override
	protected void onResume() {
		super.onResume();
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
                stinkieBedroom.setImageResource(R.drawable.stinkie);
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
	/**Не позволяет пользователю использовать кнопку Back*/
	 @Override
	    public void onBackPressed(){}


}
