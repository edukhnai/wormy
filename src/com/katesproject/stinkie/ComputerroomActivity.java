package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**Класс, отвечающий за действия, происходящие в кабинете*/
public class ComputerroomActivity extends Activity {
    /**Изображение персонажа*/
    ImageView stinkieComputerroom;
    /**Текстовое поле, отображающее текущий игровой баланс пользователя*/
    TextView moneyview;
    /**Поле, позволяющее обращаться к содержимому синглтона*/
    CharSin cs;
    /**Изображение индикатора сытости*/
    ProgressBar foodprogbar;
    /**Изображение индикатора состояния здоровья*/
    ProgressBar healthprogbar;
    /**Изображение индикатора настроения*/
    ProgressBar moodprogbar;
    /**Изображение индикатора игровых очков*/
    ProgressBar pointprogbar;
    /**Контекст гардеробной*/
    Context ctxt;
    /**Необходимо для создания таймера, обновляющего индикаторы жизненных параметров персонажа*/
    CountDownTimer timer;
    /**ViewFlipper, содержащий фоны для рабочего стола монитора*/
   ViewFlipper desktopflipper;
    /**Фон для рабочего стола монитора*/
    ImageView dsktp1, dsktp2;
    /**Изображение книг*/
ImageView books;
    /**Текстовое поле, показывающее текущий день*/
    TextView daytoday;
    /**Текстовое поле, показывающее текущий месяц*/
    TextView monthtoday;
/**Текущая дата в виде целого числа*/
    int d; 
    /**Текущая дата в виде строки*/
   String strdate;
   /**Реальный календарь*/
   GregorianCalendar calendar;
    
    /**Инициализация полей, установление правильного изображения для индикатора игровых очков
     * в зависимости от уровня персонажа*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computerroom);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        calendar=new GregorianCalendar();
        d=calendar.get(Calendar.DAY_OF_MONTH);
        strdate=String.valueOf(d);
        stinkieComputerroom =(ImageView)findViewById(R.id.stinkieComputerroom);
        books=(ImageView)findViewById(R.id.books);
        daytoday=(TextView)findViewById(R.id.daytoday);
        daytoday.setText(strdate);
        monthtoday=(TextView)findViewById(R.id.monthtoday);
        switch(calendar.get(Calendar.MONTH)){
            case 0: monthtoday.setText(getResources().getString(R.string.jan));break;
            case 1: monthtoday.setText(getResources().getString(R.string.feb));break;
            case 2: monthtoday.setText(getResources().getString(R.string.mar));break;
            case 3: monthtoday.setText(getResources().getString(R.string.apr));break;
            case 4: monthtoday.setText(getResources().getString(R.string.may));break;
            case 5: monthtoday.setText(getResources().getString(R.string.june));break;
            case 6: monthtoday.setText(getResources().getString(R.string.july));break;
            case 7: monthtoday.setText(getResources().getString(R.string.aug));break;
            case 8: monthtoday.setText(getResources().getString(R.string.sept));break;
            case 9: monthtoday.setText(getResources().getString(R.string.oct));break;
            case 10: monthtoday.setText(getResources().getString(R.string.nov));break;
            case 11: monthtoday.setText(getResources().getString(R.string.dec));break;
        }
        desktopflipper = (ViewFlipper) findViewById(R.id.desktopflipper);
        desktopflipper.setOnClickListener(DesktopListener);
        switch(cs.getDesktopNow()){
        case 0: desktopflipper.setDisplayedChild(0);break;
        case 1:desktopflipper.setDisplayedChild(1);break;
        case 2: desktopflipper.setDisplayedChild(2);break;
        case 3:desktopflipper.setDisplayedChild(3);break;
        case 4: desktopflipper.setDisplayedChild(4);break;
        }
        moneyview = (TextView) findViewById(R.id.moneyview);
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
        cs.setDressingWear(stinkieComputerroom);
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
                    stinkieComputerroom.setImageResource(R.drawable.ill);
                }
            }
            public void onFinish() {
                timer.start();
            }
        };
        timer.start();
        cs.teach(ctxt);
        /**AlertDialog с кратким описанием кабинета для нового игрока*/
        if (cs.getTimes() == 1 && cs.getFirstComputerroom()==false&&cs.getWantTeach())
        { cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s152),
                R.drawable.alert_icon);
            cs.setFirstComputerroom(true);}
    }
    /**Слушатель для смены фона рабочего стола на компьютере*/
    View.OnClickListener DesktopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            desktopflipper.showNext();
            cs.setDesktopNow(desktopflipper.getDisplayedChild());
        }
    };

    /**Переход из кабинета в игровую*/
    public void goleftfromcomputerroom(View V) {
        Intent intent = new Intent(ComputerroomActivity.this, GameroomActivity.class);
        startActivity(intent);

    }
    /**Переход из кабинета в гардеробную*/
    public void gorightfromcomputerroom(View Q) {
        Intent intent1 = new Intent(ComputerroomActivity.this, WeardrobeActivity.class);
        startActivity(intent1);
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
                Intent intent = new Intent(this, MainMenuActivity.class);
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
                stinkieComputerroom.setImageResource(R.drawable.stinkie);
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

