package com.katesproject.stinkie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
/**Класс, соответствующий примерочной. Позволяет переодевать персонажа.*/
public class DressingroomActivity extends Activity {
/**Изображение персонажа*/
    ImageView stinkieDressingroom;
    /**Изображение костюма из ViewFlipper-а*/
    ImageView wearstinkier, wearstinkie0, wearstinkie1, wearstinkie2, wearstinkie3,
            wearstinkie4, wearstinkie5, wearstinkie6, wearstinkie7, wearstinkie8, wearstinkie9, wearstinkie10,
            wearstinkie11, wearstinkie12, wearstinkie13, wearstinkie14, wearstinkie15, wearstinkie16, wearstinkie17, 
            wearstinkie18, wearstinkie19, wearstinkie20, wearstinkie21;
    /**Кнопка для пролистывания ViewFlipper-а*/
    Button wearleft, wearright;
    /**Поле, с помощью которого можно получать данные из синглтона*/
    CharSin cs;
    /**Текстовое поле, отображающее игровой баланс пользователя*/
    TextView moneyview;
    /**ViewFlipper, одержащий в себе все варианты костюмов для персонажа.*/
    private ViewFlipper dressflip;
    /**Контекст примерочной*/
    Context ctxt;

    /**Инициализация полей, установление правильного изображения для индикатора игровых очков
     * в зависимости от уровня персонажа*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dressingroom);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        stinkieDressingroom = (ImageView) findViewById(R.id.stinkieDressingroom);
        dressflip = (ViewFlipper) findViewById(R.id.dressflip);
        moneyview=(TextView)findViewById(R.id.moneyview);
        wearleft = (Button) findViewById(R.id.wearleft);
        wearright = (Button) findViewById(R.id.wearright);
        wearstinkier = (ImageView) findViewById(R.id.wearstinkier);
        wearstinkie0 = (ImageView) findViewById(R.id.wearstinkie0);
        wearstinkie1 = (ImageView) findViewById(R.id.wearstinkie1);
        wearstinkie2 = (ImageView) findViewById(R.id.wearstinkie2);
        wearstinkie3 = (ImageView) findViewById(R.id.wearstinkie3);
        wearstinkie4 = (ImageView) findViewById(R.id.wearstinkie4);
        wearstinkie5 = (ImageView) findViewById(R.id.wearstinkie5);
        wearstinkie6 = (ImageView) findViewById(R.id.wearstinkie6);
        wearstinkie7 = (ImageView) findViewById(R.id.wearstinkie7);
        wearstinkie8 = (ImageView) findViewById(R.id.wearstinkie8);
        wearstinkie9 = (ImageView) findViewById(R.id.wearstinkie9);
        wearstinkie10 = (ImageView) findViewById(R.id.wearstinkie10);
        wearstinkie11 = (ImageView) findViewById(R.id.wearstinkie11);
        wearstinkie12 = (ImageView) findViewById(R.id.wearstinkie12);
        wearstinkie13 = (ImageView) findViewById(R.id.wearstinkie13);
        wearstinkie14 = (ImageView) findViewById(R.id.wearstinkie14);
        wearstinkie15 = (ImageView) findViewById(R.id.wearstinkie15);
        wearstinkie16 = (ImageView) findViewById(R.id.wearstinkie16);
        wearstinkie17 = (ImageView) findViewById(R.id.wearstinkie17);
        wearstinkie18 = (ImageView) findViewById(R.id.wearstinkie18);
        wearstinkie19 = (ImageView) findViewById(R.id.wearstinkie19);
        wearstinkie20 = (ImageView) findViewById(R.id.wearstinkie20);
        wearstinkie21 = (ImageView) findViewById(R.id.wearstinkie21);
        cs.setDressingWear(stinkieDressingroom);
        ImageView d[]={wearstinkier, wearstinkie0, wearstinkie1, wearstinkie2, wearstinkie3,
                wearstinkie4, wearstinkie5, wearstinkie6, wearstinkie7, wearstinkie8, wearstinkie9,
                wearstinkie10, wearstinkie11, wearstinkie12, wearstinkie13, wearstinkie14, wearstinkie15,
                wearstinkie16, wearstinkie17, wearstinkie18, wearstinkie19,
                wearstinkie20, wearstinkie21};
        for(int i=0; i<d.length; i++){
            d[i].setOnClickListener(new dressChanger());}
        moneyview.setText(cs.getStrMoney());
        setCosFlip(cs.getWear1(),wearstinkie1, R.drawable.stinkie1r);
        setCosFlip(cs.getWear2(),wearstinkie2, R.drawable.stinkie2r);
        setCosFlip(cs.getWear3(),wearstinkie3, R.drawable.stinkie3r);
        setCosFlip(cs.getWear4(),wearstinkie4, R.drawable.stinkie4r);
        setCosFlip(cs.getWear5(),wearstinkie5, R.drawable.stinkie5r);
        setCosFlip(cs.getWear6(),wearstinkie6, R.drawable.stinkie6r);
        setCosFlip(cs.getWear7(),wearstinkie7, R.drawable.stinkie7r);
        setCosFlip(cs.getWear8(),wearstinkie8, R.drawable.stinkie8r);
        setCosFlip(cs.getWear9(),wearstinkie9, R.drawable.stinkie9r);
        setCosFlip(cs.getWear10(),wearstinkie10, R.drawable.stinkie10r);
        setCosFlip(cs.getWear11(),wearstinkie11, R.drawable.stinkie11r);
        setCosFlip(cs.getWear12(),wearstinkie12, R.drawable.stinkie12r);
        setCosFlip(cs.getWear13(),wearstinkie13, R.drawable.stinkie13r);
        setCosFlip(cs.getWear14(),wearstinkie14, R.drawable.stinkie14r);
        setCosFlip(cs.getWear15(),wearstinkie15, R.drawable.stinkie15r);
        setCosFlip(cs.getWear16(),wearstinkie16, R.drawable.stinkie16r);
        setCosFlip(cs.getWear17(),wearstinkie17, R.drawable.stinkie17r);
        setCosFlip(cs.getWear18(),wearstinkie18, R.drawable.stinkie18r);
        setCosFlip(cs.getWear19(),wearstinkie19, R.drawable.stinkie19r);
        setCosFlip(cs.getWear20(),wearstinkie20, R.drawable.stinkie20r);
        setCosFlip(cs.getWear21(),wearstinkie21, R.drawable.stinkie21r);
        cs.teach(ctxt);
        if (cs.getTimes() == 1 && cs.getFirstDressingroom()==false &&cs.getWantTeach())
        { cs.TeachAlertDialog(ctxt,getString(R.string.obuchenie), getString(R.string.s84),
      R.drawable.alert_icon);
            cs.setFirstDressingroom(true);}
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

/**Переход из спальни в гардеробную*/
    public void toweardrobed(View v) {
        Intent intent1 = new Intent(DressingroomActivity.this, WeardrobeActivity.class);
        startActivity(intent1);
    }

    /**Перелистывание изображений во ViewFlipper-е влево.*/
        public void wearlistl(View v) {
            dressflip.showPrevious();
        }

    /**Перелистывание изображений во ViewFlipper-е вправо.*/
        public void wearlistr(View v) {
            dressflip.showNext();
        }

    /**Слушатель, позволяющий покупать костюмы и сменять их на персонаже.*/
            private class dressChanger implements View.OnClickListener{
        public void onClick(View v){
            int curImage = dressflip.getDisplayedChild();
            switch (curImage) {
                case 0:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    stinkieDressingroom.setImageResource(R.drawable.stinkie);
                    cs.setNowWearing(-1);}
                    else cs.toastIll(ctxt);
                    break;
                case 1:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    stinkieDressingroom.setImageResource(R.drawable.stinkie0);
                    cs.setNowWearing(0);}
                else cs.toastIll(ctxt);
                    break;
                case 2:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear1()) {
                        if (cs.getMoney() >= 250) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s86));
                            alertDialog.setIcon(R.drawable.stinkie1rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-250);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear1(true);
                                    cs.setMood(80);
                                    cs.setWorpoints(80);
                                    cs.setCwear(1);
                                    wearstinkie1.setImageResource(R.drawable.stinkie1r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie1);
                        cs.setNowWearing(1);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 3:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear2()) {
                        if (cs.getMoney() >= 300) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s89));
                            alertDialog.setIcon(R.drawable.stinkie2rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-300);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear2(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie2.setImageResource(R.drawable.stinkie2r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie2);
                        cs.setNowWearing(2);
                    }}
                    else cs.toastIll(ctxt);
                    break;

                case 4:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear3()) {
                        if (cs.getMoney() >= 300) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s90));
                            alertDialog.setIcon(R.drawable.stinkie3rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-300);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear3(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie3.setImageResource(R.drawable.stinkie3r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie3);
                        cs.setNowWearing(3);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 5:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear4()) {
                        if (cs.getMoney() >= 300) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s91));
                            alertDialog.setIcon(R.drawable.stinkie4rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-300);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear4(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie4.setImageResource(R.drawable.stinkie4r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie4);
                        cs.setNowWearing(4);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 6:
                	if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear5()) {
                        if (cs.getMoney() >= 150) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s92));
                            alertDialog.setIcon(R.drawable.stinkie5rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-150);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear5(true);
                                    cs.setMood(70);
                                    cs.setWorpoints(70);
                                    cs.setCwear(1);
                                    wearstinkie5.setImageResource(R.drawable.stinkie5r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie5);
                        cs.setNowWearing(5);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 7:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear6()) {
                        if (cs.getMoney() >= 100) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s93));
                            alertDialog.setIcon(R.drawable.stinkie6rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-100);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear6(true);
                                    cs.setMood(60);
                                    cs.setWorpoints(60);
                                    cs.setCwear(1);
                                    wearstinkie6.setImageResource(R.drawable.stinkie6r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie6);
                        cs.setNowWearing(6);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 8:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear7()) {
                        if (cs.getMoney() >= 300) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s94));
                            alertDialog.setIcon(R.drawable.stinkie7rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-300);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear7(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie7.setImageResource(R.drawable.stinkie7r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie7);
                        cs.setNowWearing(7);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 9:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear8()) {
                        if (cs.getMoney() >= 270) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s95));
                            alertDialog.setIcon(R.drawable.stinkie8rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-270);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear8(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie8.setImageResource(R.drawable.stinkie8r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie8);
                        cs.setNowWearing(8);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 10:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear9()) {
                        if (cs.getMoney() >= 250) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s96));
                            alertDialog.setIcon(R.drawable.stinkie9rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-250);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear9(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie9.setImageResource(R.drawable.stinkie9r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie9);
                        cs.setNowWearing(9);
                    }}
                    else cs.toastIll(ctxt);
                    break;
                case 11:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear10()) {
                            if (cs.getMoney() >= 300) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s97));
                                alertDialog.setIcon(R.drawable.stinkie10rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-300);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear10(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie10.setImageResource(R.drawable.stinkie10r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie10);
                            cs.setNowWearing(10);
                        }}
                    else cs.toastIll(ctxt);
                    break;
                case 12:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear11()) {
                            if (cs.getMoney() >= 350) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s98));
                                alertDialog.setIcon(R.drawable.stinkie11rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-350);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear11(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie11.setImageResource(R.drawable.stinkie11r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie11);
                            cs.setNowWearing(11);
                        }}
                    else cs.toastIll(ctxt);
                    break;
                case 13:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear12()) {
                            if (cs.getMoney() >= 300) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s99));
                                alertDialog.setIcon(R.drawable.stinkie12rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-300);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear12(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie12.setImageResource(R.drawable.stinkie12r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie12);
                            cs.setNowWearing(12);
                        }}
                    else cs.toastIll(ctxt);
                    break;
                case 14:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear13()) {
                            if (cs.getMoney() >= 350) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s100));
                                alertDialog.setIcon(R.drawable.stinkie13rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-350);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear13(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie13.setImageResource(R.drawable.stinkie13r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie13);
                            cs.setNowWearing(13);
                        }}
                    else cs.toastIll(ctxt);
                    break;
                case 15:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear14()) {
                            if (cs.getMoney() >= 300) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s157));
                                alertDialog.setIcon(R.drawable.stinkie14rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-300);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear14(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie14.setImageResource(R.drawable.stinkie14r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie14);
                            cs.setNowWearing(14);
                        }}
                    else cs.toastIll(ctxt);
                    break;
                case 16:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                        if (!cs.getWear15()) {
                            if (cs.getMoney() >= 320) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                                alertDialog.setTitle(getString(R.string.s85));
                                alertDialog.setMessage(getString(R.string.s101));
                                alertDialog.setIcon(R.drawable.stinkie15rm);
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        cs.setMoney(-320);
                                        moneyview.setText(cs.getStrMoney());
                                        cs.setWear15(true);
                                        cs.setMood(100);
                                        cs.setWorpoints(100);
                                        cs.setCwear(1);
                                        wearstinkie15.setImageResource(R.drawable.stinkie15r);
                                    }
                                });
                                alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                            } else cs.toastNoMoney(ctxt);
                        } else {
                            stinkieDressingroom.setImageResource(R.drawable.stinkie15);
                            cs.setNowWearing(15);
                        }}
                    else cs.toastIll(ctxt);
                    break;
            case 17:
            if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                if (!cs.getWear16()) {
                    if (cs.getMoney() >= 320) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                        alertDialog.setTitle(getString(R.string.s85));
                        alertDialog.setMessage(getString(R.string.s102));
                        alertDialog.setIcon(R.drawable.stinkie16rm);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                cs.setMoney(-320);
                                moneyview.setText(cs.getStrMoney());
                                cs.setWear16(true);
                                cs.setMood(100);
                                cs.setWorpoints(100);
                                cs.setCwear(1);
                                wearstinkie16.setImageResource(R.drawable.stinkie16r);
                            }
                        });
                        alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                    } else cs.toastNoMoney(ctxt);
                } else {
                    stinkieDressingroom.setImageResource(R.drawable.stinkie16);
                    cs.setNowWearing(16);
                }}
            else cs.toastIll(ctxt);
            break;
                case 18:
                        if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                    if (!cs.getWear17()) {
                        if (cs.getMoney() >= 350) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                            alertDialog.setTitle(getString(R.string.s85));
                            alertDialog.setMessage(getString(R.string.s103));
                            alertDialog.setIcon(R.drawable.stinkie17rm);
                            alertDialog.setCancelable(false);
                            alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    cs.setMoney(-350);
                                    moneyview.setText(cs.getStrMoney());
                                    cs.setWear17(true);
                                    cs.setMood(100);
                                    cs.setWorpoints(100);
                                    cs.setCwear(1);
                                    wearstinkie17.setImageResource(R.drawable.stinkie17r);
                                }
                            });
                            alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                        } else cs.toastNoMoney(ctxt);
                    } else {
                        stinkieDressingroom.setImageResource(R.drawable.stinkie17);
                        cs.setNowWearing(17);
                    }}
                else cs.toastIll(ctxt);
                break;
                case 19:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                if (!cs.getWear18()) {
                    if (cs.getMoney() >= 350) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                        alertDialog.setTitle(getString(R.string.s85));
                        alertDialog.setMessage(getString(R.string.s153));
                        alertDialog.setIcon(R.drawable.stinkie18rm);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                cs.setMoney(-350);
                                moneyview.setText(cs.getStrMoney());
                                cs.setWear18(true);
                                cs.setMood(100);
                                cs.setWorpoints(100);
                                cs.setCwear(1);
                                wearstinkie18.setImageResource(R.drawable.stinkie18r);
                            }
                        });
                        alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                    } else cs.toastNoMoney(ctxt);
                } else {
                    stinkieDressingroom.setImageResource(R.drawable.stinkie18);
                    cs.setNowWearing(18);
                }}
            else cs.toastIll(ctxt);
            break;
                case 20:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                if (!cs.getWear19()) {
                    if (cs.getMoney() >= 300) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                        alertDialog.setTitle(getString(R.string.s85));
                        alertDialog.setMessage(getString(R.string.s154));
                        alertDialog.setIcon(R.drawable.stinkie19rm);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                cs.setMoney(-300);
                                moneyview.setText(cs.getStrMoney());
                                cs.setWear19(true);
                                cs.setMood(100);
                                cs.setWorpoints(100);
                                cs.setCwear(1);
                                wearstinkie19.setImageResource(R.drawable.stinkie19r);
                            }
                        });
                        alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                    } else cs.toastNoMoney(ctxt);
                } else {
                    stinkieDressingroom.setImageResource(R.drawable.stinkie19);
                    cs.setNowWearing(19);
                }}
            else cs.toastIll(ctxt);
            break;
                case 21:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                if (!cs.getWear20()) {
                    if (cs.getMoney() >= 300) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                        alertDialog.setTitle(getString(R.string.s85));
                        alertDialog.setMessage(getString(R.string.s155));
                        alertDialog.setIcon(R.drawable.stinkie20rm);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                cs.setMoney(-300);
                                moneyview.setText(cs.getStrMoney());
                                cs.setWear20(true);
                                cs.setMood(100);
                                cs.setWorpoints(100);
                                cs.setCwear(1);
                                wearstinkie20.setImageResource(R.drawable.stinkie20r);
                            }
                        });
                        alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                    } else cs.toastNoMoney(ctxt);
                } else {
                    stinkieDressingroom.setImageResource(R.drawable.stinkie20);
                    cs.setNowWearing(20);
                }}
            else cs.toastIll(ctxt);
            break;
                case 22:
                    if(cs.getHealth()>=20 && cs.getHunger()>=20 && cs.getMood()>=20){
                if (!cs.getWear21()) {
                    if (cs.getMoney() >= 250) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
                        alertDialog.setTitle(getString(R.string.s85));
                        alertDialog.setMessage(getString(R.string.s156));
                        alertDialog.setIcon(R.drawable.stinkie21rm);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                cs.setMoney(-250);
                                moneyview.setText(cs.getStrMoney());
                                cs.setWear21(true);
                                cs.setMood(100);
                                cs.setWorpoints(100);
                                cs.setCwear(1);
                                wearstinkie21.setImageResource(R.drawable.stinkie21r);
                            }
                        });
                        alertDialog.setNegativeButton(getString(R.string.s88), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                    } else cs.toastNoMoney(ctxt);
                } else {
                    stinkieDressingroom.setImageResource(R.drawable.stinkie21);
                    cs.setNowWearing(21);
                }}
            else cs.toastIll(ctxt);
            break;
            }
        }}
            
    public void setCosFlip(boolean a, ImageView i, int w){
    	 if(a) i.setImageResource(w);
    }
     public void sdc(int a){
    	 dressflip.setDisplayedChild(a);
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
    @Override
    public void onBackPressed(){}
}



