package com.katesproject.stinkie;


import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

/**Класс, отвечающий за действия в главном меню*/

public class MainMenuActivity extends Activity {

/**Длина имени игрока в виде целого числа*/

    int lengname;

    /**ажение с текстовым облаком и приветствием*/

    ImageView hallo0;

    /**Кнопка, позволяющая зайти в дом персонажа*/

    Button play;

    /**Кнопка, позволяющая зайти в раздел "О программе"*/

    Button about;

    /**Кнопка, позволяющая зайти в раздел "Помощь"*/

    Button help;

    /**Кнопка, позволяющая зайти в раздел "Достижение"*/

    Button achiv;

    /**Кнопка, позволяющая выйти из приложения*/

    Button exit;

    /**Изображение персонажа в тематичском костюме в правой части экрана*/

    ImageView russiangirl;

    /**Имя игрока*/

    String name;

    /**Текстовое поле с именем игрока*/

    TextView addName, textname;

    /**Поле, с помощью которого можно обращаться к содержимому синглтона*/

    CharSin cs;

    /**Контекст главного меню*/

    Context ctxt;

/**Разметка главного меню*/

    RelativeLayout mainmenu;

/**Вращающийся цветок для стандартного оформления главного меню*/

    ProgressBar flower1, flower2, flower3;

    /**Флажок для уведомлений*/

    CheckBox notifyCheck;
    

/**Инициализация полей, установка выбранной ранее темы при необходимости,

 *  в нужных ситуациях - запуск AlertDialog-а с соответствующим содержанием (например, что пользователь посетил игру 100 раз).*/

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainmenu);

        cs=CharSin.getInstance(getApplicationContext());

        ctxt=this;
        
        achiv=(Button)findViewById(R.id.achiv);

        hallo0=(ImageView)findViewById(R.id.hallo0);

        russiangirl=(ImageView)findViewById(R.id.russiangirl);

        mainmenu=(RelativeLayout)findViewById(R.id.mainmenu);

        textname=(TextView)findViewById(R.id.textname);
      
        notifyCheck = (CheckBox)findViewById(R.id.notifyCheck);
        
        notifyCheck.setOnClickListener(new notifyChanger());
        
        if(cs.getNotify()) {notifyCheck.setChecked(true);}
        
        else  {notifyCheck.setChecked(false);}
        
        addName = (TextView) findViewById(R.id.addName);

        addName.setText(cs.getCharName()+"!");

        flower1=(ProgressBar)findViewById(R.id.flower1);

        flower2=(ProgressBar)findViewById(R.id.flower2);

        flower3=(ProgressBar)findViewById(R.id.flower3);

        lengname = addName.getText().length();

        play=(Button)findViewById(R.id.play);

        about=(Button)findViewById(R.id.about);

        help=(Button)findViewById(R.id.help);

        exit=(Button)findViewById(R.id.exit);

        switch (cs.getThemeNow()){

            case 1:

                play.setBackgroundResource(R.drawable.playruss);

                about.setBackgroundResource(R.drawable.aboutruss);

                help.setBackgroundResource(R.drawable.helpruss);

                achiv.setBackgroundResource(R.drawable.achivrus);

                exit.setBackgroundResource(R.drawable.exitruss);

                mainmenu.setBackgroundResource(R.drawable.mainmenu);

                russiangirl.setImageResource(R.drawable.russiangirl);

                String fontPath2 = "fonts/Tetra decorative.ttf";

                Typeface typeface2 = Typeface.createFromAsset(getAssets(), fontPath2);

                textname.setTypeface(typeface2);

                addName.setTypeface(typeface2);

                setTColor(textname, addName, getResources().getColor(R.color.ruColor));

                notifyCheck.setTextColor(getResources().getColor(R.color.checkrus));

                flower1.setVisibility(View.VISIBLE);

                flower2.setVisibility(View.VISIBLE);

                flower3.setVisibility(View.VISIBLE);break;

            case 2:

            play.setBackgroundResource(R.drawable.playsea);

            about.setBackgroundResource(R.drawable.aboutseas);

            help.setBackgroundResource(R.drawable.helpsea);

                achiv.setBackgroundResource(R.drawable.achivseas);

            exit.setBackgroundResource(R.drawable.exitsea);

            mainmenu.setBackgroundResource(R.drawable.beachbackground);

                russiangirl.setImageResource(R.drawable.stinkie2);

                String fontPath = "fonts/Natasha.ttf";

                Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);

                textname.setTypeface(typeface);

                addName.setTypeface(typeface);

                setTColor(textname, addName, getResources().getColor(R.color.seaColor));

                notifyCheck.setTextColor(getResources().getColor(R.color.richColor));

                flower1.setVisibility(View.INVISIBLE);

                flower2.setVisibility(View.INVISIBLE);

                flower3.setVisibility(View.INVISIBLE);break;

            case 3:

                play.setBackgroundResource(R.drawable.playrich);

                about.setBackgroundResource(R.drawable.aboutrichs);

                help.setBackgroundResource(R.drawable.helprich);

                achiv.setBackgroundResource(R.drawable.achivrichs);

                exit.setBackgroundResource(R.drawable.exitrich);

                mainmenu.setBackgroundResource(R.drawable.richbackground);

                russiangirl.setImageResource(R.drawable.richstink);

                String fontPath1 = "fonts/Docker One.ttf";

                Typeface typeface1 = Typeface.createFromAsset(getAssets(), fontPath1);

                textname.setTypeface(typeface1);

                addName.setTypeface(typeface1);

                setTColor(textname, addName, getResources().getColor(R.color.richColor));

                notifyCheck.setTextColor(getResources().getColor(R.color.whiteColor));

                flower1.setVisibility(View.INVISIBLE);

                flower2.setVisibility(View.INVISIBLE);

                flower3.setVisibility(View.INVISIBLE);

                break;

        }

        switch(cs.getTimes()){

            case 1: if(cs.getTB1()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s113), getString(R.string.s114),

                    R.drawable.happycake, getString(R.string.s115), 0, 0);

            cs.setTB1(true);}break;

        case 10: if(cs.getTB10()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s116), getString(R.string.s117),

                    R.drawable.happycake, getString(R.string.s118), 50, 50);

            cs.setTB10(true);}break;

        case 25: if(cs.getTB25()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s119), getString(R.string.s120),

                    R.drawable.happycake, getString(R.string.s118), 80, 80);

            cs.setTB25(true);}break;

        case 50:if(cs.getTB50()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s121), getString(R.string.s122),

                    R.drawable.happycake, getString(R.string.s118), 100, 100);

            cs.setTB50(true);}break;

        case 100:if(cs.getTB100()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s123), getString(R.string.s124),

                    R.drawable.happycake, getString(R.string.s118), 200, 200);

            cs.setTB100(true);}break;

        case 150:if(cs.getTB150()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s125), getString(R.string.s126),

                    R.drawable.happycake, getString(R.string.s118), 250, 250);

            cs.setTB150(true);}break;

        case 200: if(cs.getTB200()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s127),  getString(R.string.s128),

                    R.drawable.happycake, getString(R.string.s118), 300, 300);

            cs.setTB200(true);}break;

        case 250:if(cs.getTB250()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s129),  getString(R.string.s130),

                    R.drawable.happycake, getString(R.string.s118), 350, 350);

            cs.setTB250(true);}break;

        case 300:if(cs.getTB300()==false){

            cs.CongratsAlertDialog(ctxt, getString(R.string.s131), getString(R.string.s132),

                R.drawable.happycake, getString(R.string.s118), 400, 400);

            cs.setTB300(true);}break;

}

    

    }



    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.themes_mainmenu, menu);

        return true;

    }

/**В зависимости от выбора пользователя - установка нужного оформления*/

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.russiantheme:

                play.setBackgroundResource(R.drawable.playruss);

                about.setBackgroundResource(R.drawable.aboutruss);

                help.setBackgroundResource(R.drawable.helpruss);

                achiv.setBackgroundResource(R.drawable.achivrus);

                exit.setBackgroundResource(R.drawable.exitruss);

                mainmenu.setBackgroundResource(R.drawable.mainmenu);

                russiangirl.setImageResource(R.drawable.russiangirl);

                String fontPath2 = "fonts/Tetra decorative.ttf";

                Typeface typeface2 = Typeface.createFromAsset(getAssets(), fontPath2);

                textname.setTypeface(typeface2);

                addName.setTypeface(typeface2);

                notifyCheck.setTextColor(getResources().getColor(R.color.checkrus));

                setTColor(textname, addName, getResources().getColor(R.color.ruColor));

                flower1.setVisibility(View.VISIBLE);

                flower2.setVisibility(View.VISIBLE);

                flower3.setVisibility(View.VISIBLE);

                cs.setThemeNow(1);

                break;

            case R.id.seatheme:

                if(cs.getLevel()>=3){

                play.setBackgroundResource(R.drawable.playsea);

                about.setBackgroundResource(R.drawable.aboutseas);

                help.setBackgroundResource(R.drawable.helpsea);

                    achiv.setBackgroundResource(R.drawable.achivseas);

                exit.setBackgroundResource(R.drawable.exitsea);

                mainmenu.setBackgroundResource(R.drawable.beachbackground);

                russiangirl.setImageResource(R.drawable.stinkie2);

                String fontPath = "fonts/Natasha.ttf";

                Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);

                textname.setTypeface(typeface);

                addName.setTypeface(typeface);

                setTColor(textname, addName, getResources().getColor(R.color.seaColor));

                notifyCheck.setTextColor(getResources().getColor(R.color.richColor));

                flower1.setVisibility(View.INVISIBLE);

                flower2.setVisibility(View.INVISIBLE);

                flower3.setVisibility(View.INVISIBLE);

                cs.setThemeNow(2);}

                else {    SuperToast.create(this,getString(R.string.s133), SuperToast.Duration.LONG, 
                    
                		Style.getStyle(Style.PURPLE, SuperToast.Animations.FLYIN)).show();

                    cs.makeMusic(ctxt, R.raw.oi);}

                break;

            case R.id.richtheme:

                if (cs.getLevel()>=3){

                play.setBackgroundResource(R.drawable.playrich);

                about.setBackgroundResource(R.drawable.aboutrichs);

                help.setBackgroundResource(R.drawable.helprich);

                    achiv.setBackgroundResource(R.drawable.achivrichs);

                exit.setBackgroundResource(R.drawable.exitrich);

                mainmenu.setBackgroundResource(R.drawable.richbackground);

                russiangirl.setImageResource(R.drawable.richstink);

                String fontPath1 = "fonts/Docker One.ttf";

                Typeface typeface1 = Typeface.createFromAsset(getAssets(), fontPath1);

                textname.setTypeface(typeface1);

                addName.setTypeface(typeface1);

                setTColor(textname, addName, getResources().getColor(R.color.richColor));

                  notifyCheck.setTextColor(getResources().getColor(R.color.whiteColor));

                flower1.setVisibility(View.INVISIBLE);

                flower2.setVisibility(View.INVISIBLE);

                flower3.setVisibility(View.INVISIBLE);

                cs.setThemeNow(3);}

                else {SuperToast.create(this,getString(R.string.s134), SuperToast.Duration.LONG, 
                	
                		Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();

                cs.makeMusic(ctxt, R.raw.oi);}

                break;



        }

        return super.onOptionsItemSelected(item);

    }

/**Получение имени пользователя путем отображения на его экран lertDialog-а с текстовым полем для ввода имени

 * при нажатии на слово "игрок" (или же, если игрок уже ранее вписал свое имя, то по клику на текущее имя).*/

    public void nameUser(View V){



        AlertDialog.Builder builder = new AlertDialog.Builder(

                MainMenuActivity.this);

        final Context context = this;

        LayoutInflater inflater = LayoutInflater.from(this);

        View dialogview = inflater.inflate(R.layout.foraldial, null);

        builder.setView(dialogview)

                .setTitle(getString(R.string.s135))

                .setMessage(getString(R.string.s136))

                .setCancelable(false)

                .setIcon(R.drawable.alert_icon)

                .setPositiveButton(getString(R.string.ready),

                        new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog, int id) {

                                AlertDialog alertDialog=(AlertDialog)dialog;

                                EditText poleaddname = (EditText) alertDialog.findViewById(R.id.poleaddname);

                                String straddName = poleaddname.getText().toString();
                                if(straddName.isEmpty()){straddName=getString(R.string.s149);}
                                if(UnnormalWords.check(straddName))
                           		{SuperToast.create(ctxt, getString(R.string.s148), SuperToast.Duration.LONG, 
                                	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	                         	straddName=getString(R.string.s149);
	                         	return;}
                                else  straddName=cs.setCharName(straddName);
                                SuperToast.create(ctxt, getString(R.string.s137)
                                        + straddName+"!", SuperToast.Duration.LONG, 
                                	    Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
                               

                                addName.setText(cs.getCharName()+"!");

                                addName.setClickable(false);

                                dialog.dismiss();

                            }

                        })



                .show();

    }

/**Метод, отображающий текстовое облако около изображния персонажа в правой части экрана.*/

    public void hiuser(View S) {

        int prog = (int) (Math.random() * 10);

        switch (prog) {

        case 0:

          hallo0.setVisibility(View.VISIBLE);

          hallo0.setImageResource(R.drawable.hallo0);

            break;

        case 1:

           hallo0.setVisibility(View.VISIBLE);

           hallo0.setImageResource(R.drawable.hallo1);

            break;

        case 2:

          hallo0.setVisibility(View.VISIBLE);

          hallo0.setImageResource(R.drawable.hallo2);

            break;

        case 3:

           hallo0.setVisibility(View.VISIBLE);

           hallo0.setImageResource(R.drawable.hallo0);

            break;

        case 4:

    hallo0.setVisibility(View.VISIBLE);

    hallo0.setImageResource(R.drawable.hallo1);

            break;

        case 5:

       hallo0.setVisibility(View.VISIBLE);

       hallo0.setImageResource(R.drawable.hallo2);

            break;

        case 6:

          hallo0.setVisibility(View.VISIBLE);

          hallo0.setImageResource(R.drawable.hallo0);

            break;

        case 7:

         hallo0.setVisibility(View.VISIBLE);

         hallo0.setImageResource(R.drawable.hallo1);

            break;

        case 8:

          hallo0.setVisibility(View.VISIBLE);

          hallo0.setImageResource(R.drawable.hallo2);

            break;

        default:

         hallo0.setVisibility(View.VISIBLE);

         hallo0.setImageResource(R.drawable.hallo0);

    }



    }

/**Выход из приложения*/

    public void exitWormy(View v) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenuActivity.this);

            alertDialog.setTitle(getString(R.string.s138));

            alertDialog.setMessage(getString(R.string.s139));

            alertDialog.setIcon(R.drawable.alert_cry);

            alertDialog.setPositiveButton(getString(R.string.s140), new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    Intent j = new Intent(Intent.ACTION_MAIN);

                    j.addCategory(Intent.CATEGORY_HOME);

                    j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(j);

                    stopService(new Intent(getApplicationContext(), BackgroundSound.class));

                    finish();

                    System.exit(0);



                }

            }

            );

            alertDialog.setNegativeButton(getString(R.string.s141), new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }

            });

        alertDialog.show();

    }

    /**Переход из главного меню в дом существа, а именно - в прихожую*/

                    public void tolobby(View v){
if(cs.getTimes()==1 && cs.getClickhome()==0){
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxt);
    alertDialog.setTitle(getString(R.string.obuchenie));
    alertDialog.setMessage(getString(R.string.s150));
    alertDialog.setIcon(R.drawable.alert_icon);
    alertDialog.setCancelable(false);
    alertDialog.setPositiveButton(getString(R.string.s87), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            cs.setWantTeach(true);
            Intent inn=new Intent(ctxt, LobbyActivity.class);
            startActivity(inn);
        }
    });
    alertDialog.setNegativeButton(getString(R.string.s151), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            cs.setWantTeach(false);
            dialog.cancel();
            Intent inn=new Intent(ctxt, LobbyActivity.class);
            startActivity(inn);
        }
    });
    cs.setClickhome(1);
    alertDialog.show();
}
                    else  {Intent inn=new Intent(ctxt, LobbyActivity.class);
                        startActivity(inn);}}



    /**Переход из главного меню в раздел "О программе"*/

                    public void toabout(View v){

                            Intent intent = new Intent(MainMenuActivity.this, AboutActivity.class);

                            startActivity(intent);}

    /**Переход из главного меню в раздел "Помощь"*/

                    public void tohelp(View v){

                            Intent intent2 = new Intent(MainMenuActivity.this, HelpActivity.class);

                            startActivity(intent2);}

    /**Переход из главного меню в раздел "Достижения"*/

                    public void sa(View v){

                        Intent intent1=new Intent(MainMenuActivity.this, AchivListActivity.class);

                        startActivity(intent1);}

    /**Установка цвета текста*/

public void setTColor(TextView text, TextView text2, int col){

    text.setTextColor(col);

    text2.setTextColor(col);

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

    /**Класс, позволяющий включать/выключать уведомления и выводить Toast с соответствующей информацией.*/
    private class notifyChanger implements View.OnClickListener{
        @Override
            public void onClick(View v){
            if(notifyCheck.isChecked()) {
                cs.setNotify(true);
                notifyCheck.setChecked(true);
                
                SuperToast.create(ctxt, getString(R.string.s147), SuperToast.Duration.LONG, 
                	    Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
            }
            else  {cs.setNotify(false); notifyCheck.setChecked(false);
            SuperToast.create(ctxt, getString(R.string.s146), SuperToast.Duration.LONG, 
            	    Style.getStyle(Style.GRAY, SuperToast.Animations.FLYIN)).show();}
        }
        }

    }


