package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
/**Класс, отвечающий за действия ванной комнате*/
public class BathroomActivity extends Activity {
	/**Изображение порсонажа*/
	ImageView stinkieBathroom;
	/**Текстовое поле, отображающее игровой баланс пользователя*/
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
    /**Контекст ванной*/
    Context ctxt;

    /**Инициализация полей, установление правильного изображения для индикатора игровых очков
     * в зависимости от уровня персонажа*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.bathroom);
            cs=CharSin.getInstance(getApplicationContext());
            ctxt=this;
            stinkieBathroom=(ImageView)findViewById(R.id.stinkieBathroom);
            moneyview=(TextView)findViewById(R.id.moneyview);
            foodprogbar=(ProgressBar)findViewById(R.id.foodprogbar);
            foodprogbar.setProgress(cs.getHunger());
            healthprogbar=(ProgressBar)findViewById(R.id.healthprogbar);
            healthprogbar.setProgress(cs.getHealth());
            moodprogbar=(ProgressBar)findViewById(R.id.moodprogbar);
            moodprogbar.setProgress(cs.getMood());
            pointprogbar=(ProgressBar)findViewById(R.id.pointprogbar);
            pointprogbar.setProgress(cs.getWorpoints());
            foodprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.foodprogbar));
            foodprogbar.setMax(100);
            healthprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.healthprogbar));
            healthprogbar.setMax(100);
            moodprogbar.setProgressDrawable(getResources().getDrawable(R.drawable.moodprogbar));
            moodprogbar.setMax(100);
             cs.teach(ctxt);
        cs.setDressingWear(stinkieBathroom);
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
            timer = new CountDownTimer(86400000, 1000) {
                public void onTick(long millisUntilFinished) {
                    LevelProgressDialog();
                    foodprogbar.setProgress(cs.getHunger());
                    healthprogbar.setProgress(cs.getHealth());
                    moodprogbar.setProgress(cs.getMood());
                    pointprogbar.setProgress(cs.getWorpoints());
                    if (cs.getHunger() < 20 && cs.getHealth()< 20 && cs.getMood() < 20) {
                        stinkieBathroom.setImageResource(R.drawable.ill);
                    }
                }
   		     public void onFinish() {
   		         timer.start();
   		     }
   		  };
        timer.start();
        /**AlertDialog с кратким описанием данной комнаты для нового игрока*/
        if (cs.getTimes() == 1 && cs.getFirstBathroom()==false &&cs.getWantTeach())
        { cs.TeachAlertDialog(ctxt, getString(R.string.obuchenie), getString(R.string.s78),
            R.drawable.alert_icon);
            cs.setFirstBathroom(true);}
    }
    /**Перемещение из ванной в прихожую*/
	public void goleftfrombathroom(View V){
        Intent intent2 = new Intent( BathroomActivity.this, LobbyActivity.class);
        startActivity(intent2);}

	/**Перемещение из ванной в спальню*/
	public void gorightfrombathroom(View V){
        Intent intent3 = new Intent(BathroomActivity.this, BedroomActivity.class);
        startActivity(intent3); 
    }
	/**Осуществляется "чистка зубов" персонажа: включается соответствующий аудиотрек,
	 *  улучшается состояние здоровья существа, добавляется произвольное число игровых очков,
	 *  а при неисчерпанном лимите заработка на день
	 *   также начисляется игровая валюта*/
    public void brushtooth(View v) {
        cs.setHealth(10);
        cs.setCclean(1);
        healthprogbar.setProgress(cs.getHealth());
        cs.setWorpoints((int) (Math.random() * 10));
        pointprogbar.setProgress(cs.getWorpoints());
        if (cs.getMaxEarn()+10<=100){cs.setMoney(10);
            cs.setMaxEarn(10);
        moneyview.setText(cs.getStrMoney());}
        cs.makeMusic(this, R.raw.toothbrush);}

    /**Осуществляется "поход в туалет" персонажа: включается соответствующий аудиотрек,
	 *  улучшается состояние здоровья существа, добавляется произвольное число игровых очков,
	 *  а при неисчерпанном лимите заработка на день
	 *   также начисляется игровая валюта*/
    public void gotoilet(View v)
    {
        cs.setHealth(10);
        cs.setCclean(1);
        healthprogbar.setProgress(cs.getHealth());
        cs.setWorpoints((int) (Math.random() * 10));
        pointprogbar.setProgress(cs.getWorpoints());
        if (cs.getMaxEarn()+10<=100){cs.setMoney(10);
            cs.setMaxEarn(10);
        moneyview.setText(cs.getStrMoney());}
        cs.makeMusic(this, R.raw.toilet);}

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
                stinkieBathroom.setImageResource(R.drawable.stinkie);
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