package com.katesproject.stinkie;


import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

/**�����, ���������� �� �������� �� �����*/
public class KitchenActivity extends Activity {
    /**����������� ���������*/
    ImageView stinkieKitchen;
    /**���������� ��������, �������� �� ����*/
    ImageView phone;
    /**����������� ���� ��� ViewFlipper-� � �����*/
    ImageView ffb2;
    /**����������� ��������*/
    ImageView aboveflip0, aboveflip1, aboveflip2, aboveflip3, aboveflip4, aboveflip5, aboveflip6, aboveflip7,
            aboveflip8, aboveflip9, aboveflip10, aboveflip11, aboveflip12, aboveflip13, aboveflip14, aboveflip15,
            aboveflip16, aboveflip17, aboveflip18, aboveflip19, aboveflip20, aboveflip21, aboveflip22, aboveflip23,
            aboveflip24, aboveflip25, aboveflip26, aboveflip27, aboveflip28, aboveflip29, aboveflip30, aboveflip31,
            aboveflip32, aboveflip33, aboveflip34, aboveflip35, aboveflip36, aboveflip37, aboveflip38, aboveflip39;
    /**������, ����������� ������������� ������ ���*/
    Button leftff, rightff;
    /**��������� ����, ������������ ������� ������ ������������*/
    TextView moneyview;
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
    /**�������� �����*/
    Context ctxt;
    /**ViewFlipper � ����� ��� ���������*/
    private ViewFlipper foodflip;
    /**�������� �����*/
    RelativeLayout kitchen;
    /**��������, ������������ � ���������*/
    Animation phoneAnim;
    /**���������� ��� �������� �������, ������������ ���������� ��������� ���������� ���������*/
    CountDownTimer timer;
    /**����, ����������� �������� ��������*/
    Vibrator vib;

    /**������������� �����, ������������ ����������� ����������� ��� ���������� ������� �����
     * � ����������� �� ������ ���������, ���������� ViewFlipper-�*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen);
        cs = CharSin.getInstance(getApplicationContext());
        ctxt = this;
        stinkieKitchen = (ImageView) findViewById(R.id.stinkieKitchen);
        cs.setDressingWear(stinkieKitchen);
        kitchen = (RelativeLayout) findViewById(R.id.kitchen);
        phone=(ImageView)findViewById(R.id.phone);
        phone.setOnClickListener(new phoneMusic());
        phoneAnim = AnimationUtils.loadAnimation(this, R.anim.phone_anim);
        ffb2 = (ImageView) findViewById(R.id.ffb2);
        leftff = (Button) findViewById(R.id.leftff);
        rightff = (Button) findViewById(R.id.rightff);
        foodflip = (ViewFlipper) findViewById(R.id.foodflip);
        foodflip.setOnTouchListener(new myListenerf());
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        aboveflip0 = (ImageView) findViewById(R.id.aboveflip0);
        aboveflip1 = (ImageView) findViewById(R.id.aboveflip1);
        aboveflip2 = (ImageView) findViewById(R.id.aboveflip2);
        aboveflip3 = (ImageView) findViewById(R.id.aboveflip3);
        aboveflip4 = (ImageView) findViewById(R.id.aboveflip4);
        aboveflip5 = (ImageView) findViewById(R.id.aboveflip5);
        aboveflip6 = (ImageView) findViewById(R.id.aboveflip6);
        aboveflip7 = (ImageView) findViewById(R.id.aboveflip7);
        aboveflip8 = (ImageView) findViewById(R.id.aboveflip8);
        aboveflip9 = (ImageView) findViewById(R.id.aboveflip9);
        aboveflip10 = (ImageView) findViewById(R.id.aboveflip10);
        aboveflip11 = (ImageView) findViewById(R.id.aboveflip11);
        aboveflip12 = (ImageView) findViewById(R.id.aboveflip12);
        aboveflip13 = (ImageView) findViewById(R.id.aboveflip13);
        aboveflip14 = (ImageView) findViewById(R.id.aboveflip14);
        aboveflip15 = (ImageView) findViewById(R.id.aboveflip15);
        aboveflip16 = (ImageView) findViewById(R.id.aboveflip16);
        aboveflip17 = (ImageView) findViewById(R.id.aboveflip17);
        aboveflip18 = (ImageView) findViewById(R.id.aboveflip18);
        aboveflip19 = (ImageView) findViewById(R.id.aboveflip19);
        aboveflip20 = (ImageView) findViewById(R.id.aboveflip20);
        aboveflip21 = (ImageView) findViewById(R.id.aboveflip21);
        aboveflip22 = (ImageView) findViewById(R.id.aboveflip22);
        aboveflip23 = (ImageView) findViewById(R.id.aboveflip23);
        aboveflip24 = (ImageView) findViewById(R.id.aboveflip24);
        aboveflip25 = (ImageView) findViewById(R.id.aboveflip25);
        aboveflip26 = (ImageView) findViewById(R.id.aboveflip26);
        aboveflip27 = (ImageView) findViewById(R.id.aboveflip27);
        aboveflip28 = (ImageView) findViewById(R.id.aboveflip28);
        aboveflip29 = (ImageView) findViewById(R.id.aboveflip29);
        aboveflip30 = (ImageView) findViewById(R.id.aboveflip30);
        aboveflip31 = (ImageView) findViewById(R.id.aboveflip31);
        aboveflip32 = (ImageView) findViewById(R.id.aboveflip32);
        aboveflip33 = (ImageView) findViewById(R.id.aboveflip33);
        aboveflip34 = (ImageView) findViewById(R.id.aboveflip34);
        aboveflip35 = (ImageView) findViewById(R.id.aboveflip35);
        aboveflip36 = (ImageView) findViewById(R.id.aboveflip36);
        aboveflip37 = (ImageView) findViewById(R.id.aboveflip37);
        aboveflip38 = (ImageView) findViewById(R.id.aboveflip38);
        aboveflip39 = (ImageView) findViewById(R.id.aboveflip39);
        ImageView k[] = {aboveflip0, aboveflip1, aboveflip2, aboveflip3, aboveflip4, aboveflip5,
                aboveflip6, aboveflip7, aboveflip8, aboveflip9, aboveflip10, aboveflip11, aboveflip12,
                aboveflip13, aboveflip14, aboveflip15, aboveflip16, aboveflip17, aboveflip18, aboveflip19, aboveflip20, aboveflip21, aboveflip22,
                aboveflip23, aboveflip24, aboveflip25, aboveflip26, aboveflip27, aboveflip28, aboveflip29, aboveflip30, aboveflip31, aboveflip32,
                aboveflip33, aboveflip34, aboveflip35, aboveflip36, aboveflip37, aboveflip38, aboveflip39};
        for (int i = 0; i < k.length; i++) {
            k[i].setOnTouchListener(new myListenerf());
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
        foodflip.setDisplayedChild(0);
        timer = new CountDownTimer(900000000, 100) {
            public void onTick(long millisUntilFinished) {
                LevelProgressDialog();
                foodprogbar.setProgress(cs.getHunger());
                healthprogbar.setProgress(cs.getHealth());
                moodprogbar.setProgress(cs.getMood());
                pointprogbar.setProgress(cs.getWorpoints());
                if (cs.getHunger() < 20 && cs.getHealth() < 20 && cs.getMood() < 20) {
                    stinkieKitchen.setImageResource(R.drawable.ill);
                }
            }

            public void onFinish() {
                this.start();
            }
        };
        timer.start();
        cs.teach(ctxt);
        /**AlertDialog � ������� ��������� ������ ������� ��� ������ ������*/
        if (cs.getTimes() == 1 && cs.getFirstKitchen()==false&&cs.getWantTeach())
        { cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s106), R.drawable.alert_icon);
            cs.setFirstKitchen(true);}
    }
/**����� � ������� ViewFlipper-� � �����*/
    public void wanttoeat(View v) {
        if (foodflip.getVisibility() == View.INVISIBLE) {
            ffb2.setVisibility(View.VISIBLE);
            foodflip.setVisibility(View.VISIBLE);
            leftff.setVisibility(View.VISIBLE);
            rightff.setVisibility(View.VISIBLE);
        } else {
            foodflip.setVisibility(View.INVISIBLE);
            ffb2.setVisibility(View.INVISIBLE);
            leftff.setVisibility(View.INVISIBLE);
            rightff.setVisibility(View.INVISIBLE);
        }
    }

    /**�����-���������, ����������� ������������ �� �������� ������ ��������, ��� ���� ������� ��������������� ���������,
     * ������� ���������� ��������,� ��� ������������� ������ ������������� �� ���� -
     * ����� ��������� ������� ������ � �������� �������*/
    private final class phoneMusic implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            phone.startAnimation(phoneAnim);
            long milliseconds = 1500;
            vib.vibrate(milliseconds);
            cs.setMood(15);
            cs.setCmood(1);
            moodprogbar.setProgress(cs.getMood());
            cs.setWorpoints((int) (Math.random() * 10));
            pointprogbar.setProgress(cs.getWorpoints());
            if(cs.getMaxEarn()+10<=100){cs.setMoney(10);
                cs.setMaxEarn(10);
                moneyview.setText(cs.getStrMoney());}
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.telephone);
            mp.setLooping(false);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }
    /**�����-��������� �������, ����������� ������������� ���� �������, � ����� ������� ���������
     *  � �������� ��������������� ��������*/
    private final class myListenerf implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.VISIBLE);
                }

                case MotionEvent.ACTION_UP:
                    int a = foodflip.getDisplayedChild();
                    switch (a) {
                        case 0:
                            feeding(25, 15, R.raw.yum);
                            break;
                        case 1:
                            feeding(25, 15, R.raw.yum);
                            break;
                        case 2:
                            feeding(25, 15, R.raw.yum);
                            break;
                        case 3:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 4:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 5:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 6:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 7:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 8:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 9:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 10:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 11:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 12:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 13:
                            feeding(30, 40, R.raw.yum);
                            break;
                        case 14:
                            feeding(25, 30, R.raw.yum);
                            break;
                        case 15:
                            feeding(15, 15, R.raw.yum);
                            break;
                        case 16:
                            feeding(20, 20, R.raw.drinkwater);
                            break;
                        case 17:
                            feeding(15, 15, R.raw.drinkwater);
                            break;
                        case 18:
                            feeding(20, 20, R.raw.yum);
                            break;
                        case 19:
                            feeding(20, 20, R.raw.yum);break;
                        case 20:
                            feeding(20, 20, R.raw.trub);break;
                        case 21:
                            feeding(20, 20, R.raw.trub);break;
                        case 22:
                            feeding(20, 20, R.raw.trub);break;
                        case 23:
                            feeding(25, 15, R.raw.yum);break;
                        case 24:
                            feeding(25, 15, R.raw.yum);break;
                        case 25:
                            feeding(25, 15, R.raw.yum);break;
                        case 26:
                            feeding(25, 15, R.raw.yum);break;
                        case 27:
                            feeding(25, 15, R.raw.yum);break;
                        case 28:
                            feeding(25, 15, R.raw.yum);break;
                        case 29:
                            feeding(25, 15, R.raw.yum);break;
                        case 30:
                            feeding(25, 15, R.raw.yum);break;
                        case 31:
                            feeding(25, 15, R.raw.yum);break;
                        case 32:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 33:
                            feeding(25, 20, R.raw.yum);
                            break;
                        case 34:
                            feeding(25, 20, R.raw.yum);
                            break;
                        case 35:
                            feeding(25, 20, R.raw.yum);
                            break;
                        case 36:
                            feeding(20, 20, R.raw.yum);
                            break;
                        case 37:
                            feeding(10, 10, R.raw.drinkwater);
                            break;
                        case 38:
                            feeding(20, 20, R.raw.yum);
                            break;
                        case 39:
                            feeding(5, 5, R.raw.drinkwater);
                            break;
                    }

                    return true;
            }
            return true;
        }
    }

/**�������������� ������ ������� ��������� � ViewFlipper-� �� 1 �����*/
        public void leftfood(View v) {
            foodflip.showPrevious();
        }

    /**�������������� ������ ������� ��������� � ViewFlipper-� �� 1 ������*/
        public void rightfood(View v) {
            foodflip.showNext();
        }

    /**����������� �� ����� � �����������*/
    public void goleftfromkitch(View V) {
        Intent intent8 = new Intent(KitchenActivity.this, WeardrobeActivity.class);
        startActivity(intent8);
    }
    /**����������� �� ����� � ��������*/
    public void gorightfromkitch(View V) {
        Intent intent9 = new Intent(KitchenActivity.this, LobbyActivity.class);
        startActivity(intent9);
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
        timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**������ ����� ��������� �������� ������� ��� ���������� ����� ������������
     * ������� �����������, ��������� ������������� �������� ���������*/
    public void setpb(int d, int m){
        pointprogbar.setProgressDrawable(getResources().getDrawable(d));
        pointprogbar.setMax(m);
        pointprogbar.setProgress(cs.getWorpoints());
    }
/**�����, ����������� ��� ������� �� ������� ����� ������������ ������������ ����������
 * ����� ������� ���������: ����������� ������, ��������� ������ ���������, ������������ �������� �� ����������
 * ������� ������ � ���, ��� �������� ���������; ���������� ���������-�������� ������ ���������� ��������� �� �������.
 * ���� ������� ������ ������������, �� �� ������ ������������ �������� Toast � ��������������� �����������. */
   public void feeding(int coast, int feed, int music)
   {if(cs.getMoney()>=coast)
    {
        cs.setHunger(feed);
        foodprogbar.setProgress(cs.getHunger());
        cs.setMoney(-coast);
        cs.setCfood(1);
        moneyview.setText(cs.getStrMoney());
        cs.makeMusic(getApplicationContext(), music);

    }
    else cs.toastNoMoney(ctxt);
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
               stinkieKitchen.setImageResource(R.drawable.stinkie);
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