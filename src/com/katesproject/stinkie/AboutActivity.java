package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**  Класс, описывающий раздел "О программе" */
public class AboutActivity extends Activity {
	/** Объект синглтона*/
    CharSin cs;
    /**Поле, содержащее контекст данного класса*/
    Context ctxt;
    /**Содержит в себе ссылку на разметку для данной активности*/
    RelativeLayout about;
    /**Текстовые поля с разметки*/
    TextView textsiteadress, textlink, bell;

    /**Инициализация полей*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        about=(RelativeLayout)findViewById(R.id.about);
        textsiteadress=(TextView)findViewById(R.id.textsiteadress);
        textlink=(TextView)findViewById(R.id.textlink);
        bell=(TextView)findViewById(R.id.bell);
        /**установка оформления в зависимости выбранной темы*/
        switch (cs.getThemeNow()) {
            case 1:
                about.setBackgroundResource(R.drawable.rushelp);
                setTLColor(textsiteadress, textlink, bell, getResources().getColor(R.color.ruLinkColor));break;
            case 2:
                about.setBackgroundResource(R.drawable.beachhelp);
                setTLColor(textsiteadress, textlink, bell, getResources().getColor(R.color.seaLinkColor));break;
            case 3:
                about.setBackgroundResource(R.drawable.richhelp);
                setTLColor(textsiteadress, textlink, bell, getResources().getColor(R.color.richLinkColor));break;
        }
    }

    /**Отображение на экран пользователя меню*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rightpoints_menu, menu);
        return true;
    }
/**Действие по нажатию на единственный элемент меню*/
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
    
    /**Метод, устанавливающий цвет сразу для трех текстовых полей*/
    public void setTLColor(TextView text, TextView text2, TextView text3, int col){
        text.setLinkTextColor(col);
        text2.setLinkTextColor(col);
        text3.setLinkTextColor(col);
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
    
    /**Не позволяет пользователю нажать кнопку "back" */
    @Override
    public void onBackPressed(){}
}
