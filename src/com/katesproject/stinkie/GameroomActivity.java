package com.katesproject.stinkie;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

/**�����, ��������������� ������� �������*/
public class GameroomActivity extends Activity  {
    /**����, � ������� �������� ����� �������� ������ �� ���������*/
    CharSin cs;
    /**����������� ���������� �������*/
    ProgressBar foodprogbar;
    /**����������� ���������� ��������� ��������*/
    ProgressBar healthprogbar;
    /**����������� ���������� ����������*/
    ProgressBar moodprogbar;
    /**����������� ���������� ������� �����*/
    ProgressBar pointprogbar;
    /**�������� �������*/
    Context ctxt;
    /**����������� �������� � �������*/
    ImageView car, ball, bear, polka;
    /**����������� ���������*/
    ImageView stinkieGameroom;
    /**��������� ����, ������������ ������� ������ ������������*/
    TextView moneyview;
    /**����� ��� ���������*/
    private WaxboardView waxboardView;
    /**������ � ���� ����������, ������ �� �����.*/
    boolean cleanelly;
    /**��������� �������� �������*/
    SensorEventListener mylistener;
    /**��������� �������������*/
    private float mAccel;
    /**������� ��������� �������������*/
    private float mAccelCurrent;
    /**��������� ��������� �������������*/
    private float mAccelLast;
    /**�������� ��������*/
    private SensorManager sensorManager;
    /**���������� ��� �������� �������, ������������ ���������� ��������� ���������� ���������*/
    CountDownTimer timer;
    /**������ �� �����*/
    Bitmap btmp;

    /**������������� �����, ������������ ����������� ����������� ��� ���������� ������� �����
     * � ����������� �� ������ ���������*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameroom);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        ball = (ImageView) findViewById(R.id.ball);
        bear = (ImageView) findViewById(R.id.bear);
        car = (ImageView) findViewById(R.id.car);
        polka=(ImageView)findViewById(R.id.polka);
        stinkieGameroom=(ImageView)findViewById(R.id.stinkieGameroom);
        moneyview=(TextView)findViewById(R.id.moneyview);
        waxboardView=(WaxboardView)findViewById(R.id.doodleView);
        mAccel = 0.00f;
        bear.setOnClickListener(viewClickListener);
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
        mylistener = new CleanSensorEventListener();
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
        cs.setDressingWear(stinkieGameroom);
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
        timer = new CountDownTimer(900000000, 2000) {
            public void onTick(long millisUntilFinished) {
                LevelProgressDialog();
                foodprogbar.setProgress(cs.getHunger());
                healthprogbar.setProgress(cs.getHealth());
                moodprogbar.setProgress(cs.getMood());
                pointprogbar.setProgress(cs.getWorpoints());
                if (cs.getHunger() < 20 && cs.getHealth()< 20 && cs.getMood() < 20) {
                    stinkieGameroom.setImageResource(R.drawable.ill);
                }
            }
            public void onFinish() {
                timer.start();
            }
        };
        timer.start();
        cs.teach(ctxt);
        enableAccelerometerListening();
        /**AlertDialog � ������� ��������� ������ ������� ��� ������ ������*/
        if (cs.getTimes() == 1 && cs.getFirstGameroom()==false&&cs.getWantTeach())
        { cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s104),
        R.drawable.alert_icon);
            cs.setFirstGameroom(true);}
    }

/**��������� ��� ������ PopupMenu � ������� ����� ���� ��� ���������*/
    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };
/**����� ��� ������ PopupMenu � ����� � ����� ����.*/
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.color_popup);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.col01:
                                waxboardView.paintLine.setColor(Color.BLACK);
                                waxboardView.paintLine.setStrokeWidth(12);
                                return true;
                            case R.id.col0:
                            	waxboardView.paintLine.setColor(Color.WHITE);
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col1:
                            	waxboardView.paintLine.setColor(Color.RED);
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col2:
                            	waxboardView.paintLine.setColor(getResources().getColor(R.color.seaColor));
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col3:
                            	waxboardView.paintLine.setColor(Color.YELLOW);
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col4:
                            	waxboardView.paintLine.setColor(getResources().getColor(R.color.ruColor));
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col5:
                            	waxboardView.paintLine.setColor(getResources().getColor(R.color.skyBlue));
                            	waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col6:
                                waxboardView.paintLine.setColor(getResources().getColor(R.color.richTxtColor));
                                waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            case R.id.col7:
                                waxboardView.paintLine.setColor(getResources().getColor(R.color.seaTxtColor));
                                waxboardView.paintLine.setStrokeWidth(5);
                                if(cleanelly) {cleanelly=false;}
                                return true;
                            default:
                                return false;
                        }
                    }
                });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {

            @Override
            public void onDismiss(PopupMenu menu) {

            }
        });
        popupMenu.show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        disableAccelerometerListening();
    }
/**��������� ��������� �������������*/
    private void enableAccelerometerListening(){
        sensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(mylistener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**���������� ��������� �������������*/
    private void disableAccelerometerListening(){
        if (sensorManager != null)
        {
            sensorManager.unregisterListener(
                    mylistener,
                    sensorManager.getDefaultSensor(
                            SensorManager.SENSOR_ACCELEROMETER));
            sensorManager = null;
        }
    }

/**������ ������ ������ ���������� � ����� - �������� ����������������� �������������*/
    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (s == null)
        	SuperToast.create(this,getString(R.string.s105), SuperToast.Duration.VERY_SHORT, 
            	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
        ((SensorManager) getSystemService(SENSOR_SERVICE)).registerListener(
                mylistener, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**�����, ����������� ������� �����*/
    class CleanSensorEventListener implements SensorEventListener {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
/**�����, ����������� ������� �����*/
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;

            if (!cleanelly && mAccel * mAccel > 100) {
                waxboardView.clear();
                cleanelly = true;
                mAccelLast = mAccelCurrent = mAccel = 0;

            }
        }

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
    /**������� �� ������� � �������*/
    public void goleftfromgameroom(View V) {
        Intent intent6 = new Intent(GameroomActivity.this, BedroomActivity.class);
        startActivity(intent6);
   }
/**������� �� ������� � �������*/
    public void gorightfromgameroom(View V) {
        Intent intent7 = new Intent(GameroomActivity.this, ComputerroomActivity.class);
        startActivity(intent7);
  }

    /**�������� "������ � �������": ���������� ��������������� ���������,
     *  ���������� ���������� ��������, ����������� ������������ ����� ������� �����,
     *  � ��� ������������� ������ ��������� �� ����
     *   ����� ����������� ������� ������*/
    public void carstup(View v) {
        cs.setMood(15);
        cs.setCmood(1);
        moodprogbar.setProgress(cs.getMood());
        cs.setWorpoints((int) (Math.random() * 10));
        pointprogbar.setProgress(cs.getWorpoints());
        if(cs.getMaxEarn()+10<=100){cs.setMoney(10);
            cs.setMaxEarn(10);
            moneyview.setText(cs.getStrMoney());}
        cs.makeMusic(this, R.raw.stupid);
    }

    /**����������� ����-���� "�����": ������������ ������ � ����, �������� ��� ����; �����
     *  ���������� ���������� ��������, ����������� ������������ ����� ������� �����,
     *  � ��� ������������� ������ ��������� �� ����
     *   ����� ����������� ������� ������*/
    public void playLines(View v) {
        cs.setMood(25);
        cs.setCmood(1);
        moodprogbar.setProgress(cs.getMood());
        cs.setWorpoints((int) (Math.random() * 10));
        pointprogbar.setProgress(cs.getWorpoints());
        if(cs.getMaxEarn()+30<=100){ cs.setMoney(30);
            cs.setMaxEarn(30);
            moneyview.setText(cs.getStrMoney());}
        Intent intent=new Intent(GameroomActivity.this, LinesActivityMain.class);
        startActivity(intent);

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
    /**������ ����� ��������� �������� ������� ��� ���������� ����� ������������
     * ������� �����������, ��������� ������������� �������� ���������*/
    public void setpb(int d, int m){
        pointprogbar.setProgressDrawable(getResources().getDrawable(d));
        pointprogbar.setMax(m);
        pointprogbar.setProgress(cs.getWorpoints());
    }
    /**�����, ��������� �� ����� ������������ AlertDialog � ����������� � ���, ��� �� ������� ��
     * ��������� ������� �������, ��� ���� ���������� ������� ��� ����������, ����������� �� ������� ����, � �����
     * ����������� ������� � ���� ������������� ���������� ������� ������ � �����*/
    public void LevelProgressDialog(){
        switch(cs.getLevel()){
            case 1: if(cs.worpoints >=200){
                cs.CongratsAlertDialog(ctxt, getString(R.string.newlevel), getString(R.string.twolevel),
                        R.drawable.happy2, getString(R.string.getcongrats), 200, 150);
                setpb(R.drawable.point2lvl, 1000);
                moneyview.setText(cs.getStrMoney());
                cs.setNowWearing(-1);
                stinkieGameroom.setImageResource(R.drawable.stinkie);
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

