package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**Класс, соответствующий разделу игры "Помощь"*/
public class HelpActivity extends Activity {
    /**Текстовое поле с обучающей информацией*/
    TextView page1, page2, page3, page4, page5, page6, page7, page8, page9;
    /**Поле, с помощью которого можно получать данные из синглтона*/
    CharSin cs;
    /**Разметка для раздела "Помощь"*/
    RelativeLayout help;

    /**Инициализация полей, создание массива с информационными текстовыми полями*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        cs=CharSin.getInstance(getApplicationContext());
        help=(RelativeLayout)findViewById(R.id.help);
        page1=(TextView)findViewById(R.id.page1);
        page2=(TextView)findViewById(R.id.page2);
        page3=(TextView)findViewById(R.id.page3);
        page4=(TextView)findViewById(R.id.page4);
        page5=(TextView)findViewById(R.id.page5);
        page6=(TextView)findViewById(R.id.page6);
        page7=(TextView)findViewById(R.id.page7);
        page8=(TextView)findViewById(R.id.page8);
        page9=(TextView)findViewById(R.id.page9);
TextView texts[]={page1, page2, page3, page4, page5, page6, page7, page8, page9};
/**Установка оформлния в зависимости от выбора игрока в главном меню*/
switch(cs.getThemeNow()){
    case 1: 
    	help.setBackgroundResource(R.drawable.rushelp);
        changeFont("fonts/TETRA.otf", texts);
        changeColor(texts, getResources().getColor(R.color.ruTxtColor));
        break;
    case 2:help.setBackgroundResource(R.drawable.beachhelp);
        changeFont("fonts/Candara.ttf", texts);
        changeColor(texts, getResources().getColor(R.color.seaTxtColor));
       break;
    case 3:help.setBackgroundResource(R.drawable.richhelp);
       changeFont("fonts/Natasha.ttf", texts);
       changeColor(texts, getResources().getColor(R.color.richTxtColor));
       break;

    }}
/**Позволяет установить для текстового поля шрифт*/
    public void changeFont(String str, TextView t[]){
        Typeface typeface = Typeface.createFromAsset(getAssets(), str);
        for (int i=0;i<t.length; i++ ){
            t[i].setTypeface(typeface);
        }
    }
    /**Изменяет цвет текста в текстовом поле*/
    public void changeColor(TextView t[], int col){
        for (int i=0;i<t.length; i++){
            t[i].setTextColor(col);
    }}


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

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    
    @Override
    public void onBackPressed(){}
}
