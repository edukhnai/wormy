package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;
/**
 * Класс, описывающий раздел "Достижения"
 */
public class AchivListActivity extends Activity {
/**Хранит в себе список достижений*/
    private ArrayList<HashMap<String, Object>> mAchList;
    /**Заголовок элемента списка*/
    private static final String TITLE = "name";
    /**Описание элемента списка*/
    private static final String DESCRIPTION = "description";
    /**Иконка элемента списка*/
    private static final String ICON = "icon";
    /** Объект синглтона*/
    CharSin cs;
    /**Содержит в себе ссылку на разметку для данной активности*/
    RelativeLayout achievs;
    /** Поле, необходимое для дальнейшего использования SharedPreferences*/
    public static SharedPreferences mSettings;
    /**Поле, содержащее контекст данного класса*/
    Context ctxt;
    /**Текстовые поля с разметки*/
    TextView textttl, texttxt;

    /**Инициализация полей, установка оформления в зависимости выбранной темы*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievs);
        ListView listView = (ListView) findViewById(R.id.listAchieves);
        cs=CharSin.getInstance(getApplicationContext());
        ctxt=this;
        mSettings = ctxt.getSharedPreferences("Wormy", Context.MODE_PRIVATE);
        achievs=(RelativeLayout)findViewById(R.id.achievs);
        textttl=(TextView)findViewById(R.id.textttl);
        texttxt=(TextView)findViewById(R.id.texttxt);
        switch(cs.getThemeNow()){
            case 1: achievs.setBackgroundResource(R.drawable.fonrus);break;
            case 2: achievs.setBackgroundResource(R.drawable.fongirl);break;
            case 3: achievs.setBackgroundResource(R.drawable.fonboy);break;
        }
/**Инициализация поля ArrayList*/
        mAchList = new ArrayList<HashMap<String, Object>>();
        /**Создание поля HashMap*/
        HashMap<String, Object> hm;
/**Инициализация поля HashMap*/
        hm = new HashMap<String, Object>();
        /**Добавление заголовка элемента HashMap*/
        hm.put(TITLE, getString(R.string.s15));
        /**Добавление описания элемента HashMap*/
        hm.put(DESCRIPTION, getString(R.string.s16));
        /**Добавление иконки для элемента HashMap. 
         * Если достижение открыто, то используется иизображение замка
         *  с зеленой галочкой, если нет - замка с красным крестиком*/
        if (cs.getTimes() == 1 && cs.getFirstLobby()==false){hm.put(ICON, R.drawable.locked);} else hm.put(ICON, R.drawable.unlocked);
        /**Добавление поля HashMap в список*/
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s17));
        hm.put(DESCRIPTION, getString(R.string.s18));
      if(cs.getRecordScore()>200) { hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s19));
        hm.put(DESCRIPTION, getString(R.string.s20));
        if(cs.getCclean()>=50){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s21));
        hm.put(DESCRIPTION, getString(R.string.s22));
      if(cs.getCclean()>=100) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s23));
        hm.put(DESCRIPTION, getString(R.string.s24));
       if(cs.getCclean()>=250) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s25));
        hm.put(DESCRIPTION, getString(R.string.s26));
       if(cs.getCfood()>=50) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s27));
        hm.put(DESCRIPTION, getString(R.string.s28));
     if(cs.getCfood()>=100) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s29));
        hm.put(DESCRIPTION, getString(R.string.s30));
     if(cs.getCfood()>=250) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s31));
        hm.put(DESCRIPTION, getString(R.string.s32));
       if(cs.getCmood()>=50) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s33));
        hm.put(DESCRIPTION, getString(R.string.s34));
     if(cs.getCmood()>=100) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s35));
        hm.put(DESCRIPTION, getString(R.string.s36));
     if(cs.getCmood()>=250) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s37));
        hm.put(DESCRIPTION, getString(R.string.s38));
        if(cs.getLevel()>=2){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s39));
        hm.put(DESCRIPTION, getString(R.string.s40));
     if(cs.getLevel()>=3){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s41));
        hm.put(DESCRIPTION, getString(R.string.s42));
     if(cs.getLevel()>=4){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s43));
        hm.put(DESCRIPTION,getString(R.string.s44));
     if(cs.getLevel()>=5){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s45));
        hm.put(DESCRIPTION, getString(R.string.s46));
     if(cs.getLevel()>=6){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s47));
        hm.put(DESCRIPTION, getString(R.string.s48));
     if(cs.getLevel()>=7){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s49));
        hm.put(DESCRIPTION, getString(R.string.s50));
     if(cs.getLevel()>=8){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s51));
        hm.put(DESCRIPTION, getString(R.string.s52));
     if(cs.getLevel()>=9){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s53));
        hm.put(DESCRIPTION, getString(R.string.s54));
     if(cs.getLevel()>=10){hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s55));
        hm.put(DESCRIPTION,getString(R.string.s56));
        if(cs.getCwear()>=10) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s57));
        hm.put(DESCRIPTION, getString(R.string.s58));
       if (cs.getTimes()>=10) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s59));
        hm.put(DESCRIPTION, getString(R.string.s60));
     if (cs.getTimes()>=25) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s61));
        hm.put(DESCRIPTION, getString(R.string.s62));
     if (cs.getTimes()>=50) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s63));
        hm.put(DESCRIPTION, getString(R.string.s64));
     if (cs.getTimes()>=100) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s65));
        hm.put(DESCRIPTION, getString(R.string.s66));
     if (cs.getTimes()>=150) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s67));
        hm.put(DESCRIPTION, getString(R.string.s68));
     if (cs.getTimes()>=200) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s69));
        hm.put(DESCRIPTION, getString(R.string.s70));
     if (cs.getTimes()>=250) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(TITLE, getString(R.string.s71));
        hm.put(DESCRIPTION, getString(R.string.s72));
     if (cs.getTimes()>=300) {hm.put(ICON, R.drawable.unlocked);}
     else hm.put(ICON, R.drawable.locked);
        mAchList.add(hm);
      /**Создание и инициализация адаптера для заполнения HashMap, при этом указывается контекст,
       *  поле ArrayList, макет одного элемента списка, строка с заголовком, описанием и иконкой в виде констант,
       *   массив из двух соответствующих текстовых полей и иконки */
        SimpleAdapter adapter = new SimpleAdapter(this, mAchList,
                R.layout.achievs_item, new String[]{TITLE, DESCRIPTION, ICON},
                new int[]{R.id.textttl, R.id.texttxt, R.id.img});
/**Установка адаптера на listView*/
        listView.setAdapter(adapter);
        /**Установка слушателя на нажития по listView*/
     listView.setOnItemClickListener(itemClickListener);
    }

/**Метод, выводящий toast с количеством начисленной игровой валюты и баллов, а также их начисляющий и воспроизводящий звук фанфар.*/
    public void cong(int mon, int po){
    	SuperToast.create(ctxt, getString(R.string.s73)+mon+getString(R.string.s74)+po+getString(R.string.s75), SuperToast.Duration.VERY_SHORT, 
    		      Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
       cs.makeMusic(ctxt, R.raw.flourish);
        cs.setMoney(mon);
        cs.setWorpoints(po);
    }

/**Метод, выводящий toast с информацией, что игрок еще не открыл данное достижение и воспроизводящий звук "ой".*/
public void t(){ SuperToast.create(ctxt, getString(R.string.s76), SuperToast.Duration.VERY_SHORT, 
	      Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	cs.makeMusic(ctxt, R.raw.oi);}
/**Метод, выводящий toast с информацией, что уже получил данное достижение и воспроизводящий звук "ой".*/
    public void tt(){SuperToast.create(ctxt, getString(R.string.s77), SuperToast.Duration.VERY_SHORT, 
		      Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show(); 
    	cs.makeMusic(ctxt, R.raw.oi);}
    /**Инициализация слушателя listView*/
 AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
  @Override
  /**Здесь описывается, что происходит при нажатии на элемент listView. 
   * Если достижение не открыто, то используется метод с toast-ом, содержащим соответствующую информацию, 
   * если открыто и награда получена - все аналогично. Если достижение открыто, но награда еще не получено, то также используется
   * метож с похожим содержанием, но при этом начисляется установленная награда.*/
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
   switch(position){
       case 0: tt();
       case 1: if(cs.getRecordScore()>=200){
           if (!cs.masterlines){
    		   cs.setMasterlines(true);
    	   cong(30, 30);} else tt();}
        else t();
        break;
       case 2: if (cs.getCclean()>=50){
    	  if(!cs.chistulya){
    	   cs.setChistulya(true);cong(50, 100);}
    	  else tt();}
       else t();break;
       case 3: if (cs.getCclean()>=100){
    	   if(!cs.masterclean){
    	   cs.setMasterclean(true); cong(70, 200);}
           else tt();}else t(); break;
       case 4:if(cs.getCclean()>=250) {
    	   if(!cs.nachumiv){
    	   cs.setNachumiv(true); cong(150, 250);}
    	   else tt();}
           else t(); break;
       case 5: if (cs.getCfood()>=50){
    	   if(!cs.cock){
    	   cs.setCock(true);cong( 50, 100);}
           else tt();}
       else t();break;
       case 6:if (cs.getCfood()>=100){
    	  if(!cs.gourm){cs.setGourm(true); cong(70, 200);}
           else tt();}else t(); break;
       case 7: if (cs.getCfood()>=250 && !cs.obedalo){
    	if(!cs.obedalo) {cs.setObedalo(true); cong(150, 250);}
           else tt();}
       else t(); break;
       case 8:if (cs.getCmood()>=50){
    	   if(!cs.funny){
    	   cs.setFunny(true); cong( 50, 100);}
    	   else tt();}
           else t(); break;
       case 9:if (cs.getCmood()>=100 && !cs.youngclown){
    	  if(!cs.youngclown){ cs.setYoungclown(true); cong(70, 200);}
    	  else tt();}
           else t();break;
       case 10:if (cs.getCmood()>=250){
    	   if(!cs.masterfun){
    	   cs.setMasterfun(true); cong( 150, 250);}
           else tt();}
       else t(); break;
       case 11: if (cs.getLevel()>=2) tt();
           else t();break;
       case 12: if (cs.getLevel()>=3) tt();
       else t();break;
       case 13: if (cs.getLevel()>=4) tt();
       else t();break;
       case 14: if (cs.getLevel()>=5) tt();
       else t();break;
       case 15: if (cs.getLevel()>=6) tt();
       else t();break;
       case 16: if (cs.getLevel()>=7) tt();
       else t();break;
       case 17: if (cs.getLevel()>=8) tt();
       else t();break;
       case 18: if (cs.getLevel()>=9) tt();
       else t();break;
       case 19: if (cs.getLevel()>=10) tt();
       else t();break;
       case 20:if (cs.getCwear()>=10){
    	if(!cs.fashioner) {cs.setFashioner(true);cong(250, 500);}
           else tt();}
       else t(); break;
       case 21: if (cs.getTimes()>=10) tt();
       else t();break;
       case 22: if (cs.getTimes()>=25) tt();
       else t();break;
       case 23: if (cs.getTimes()>=50) tt();
       else t();break;
       case 24: if (cs.getTimes()>=100) tt();
       else t();break;
       case 25:if (cs.getTimes()>=150) tt();
       else t();break;
       case 26: if (cs.getTimes()>=200) tt();
       else t();break;
       case 27:if (cs.getTimes()>=250) tt();
       else t();break;
       case 28: if (cs.getTimes()>=300) tt();
       else t();break;
   }
  }
 };
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
    public void onBackPressed(){}
}