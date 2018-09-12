package com.katesproject.stinkie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Base64;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

/**
 * Класс, хранящий все наиболее глобальные переменные, геттеры и сеттеры для
 * них,
 * 
 * а также некоторые методы, используемые во многих других классах.
 */

class CharSin {

	/** Текущее количество единиц здоровья персонажа */

	public static int health = 100;

	/** Текущее количество единиц сытости персонажа */

	public static int hunger = 100;

	/** Текущее количество единиц настроения персонажа */

	public static int mood = 100;

	/** Текущее количество единиц игровых очков персонажа */

	public static int worpoints = 0;

	/** Текущее количество единиц валюты у персонажа */

	public static int money = 100;

	/** Текущий уровень персонажа */

	public static int level = 1;

	/** Текущее количество заходов игрока в игру */

	public static int times = 0;

	/** Отметка, показывать ли уведомления */

	public static boolean notif = true;

	/** Текущее оформление главного меню */

	public static int themeNow = 1;

	/** Текущее количество очков, набранных в игре "Линии" */

	public static int curlinesscore = 0;

	/** Рекордное количество очков, набранных в игре "Линии" */

	public static int reclinesscore = 0;

	/**
	 * Показывает, сколько раз игрок пользовался предметами, повышающими
	 * состояние здоровья персонажа
	 */

	public static int countclean = 0;

	/**
	 * Показывает, сколько раз игрок пользовался предметами, повышающими сытость
	 * персонажа
	 */

	public static int countfood = 0;

	/**
	 * Показывает, сколько раз игрок пользовался предметами, повышающими
	 * настроение персонажа
	 */

	public static int countmood = 0;

    /**
     * Количество нажатий игрока на кнопку "Играть!"
     */

    public static int clickhome = 0;
    
    /**
     * Число, соответствующее определенной заставке на мониторе в кабинете
     */

    public static int desktopNow = 0;
    
	/** Каждое значение соответствует определенному костюму */

	public static int countwear = 0;

	/** Секретный код для сейфа под картиной в спальне */

	public static final int secretcode = 24061999;

	/** Показывает, был ли игрок в прихожей */

	public static boolean firstlobby = false;

	/** Показывает, был ли игрок на кухне */

	public static boolean firstkitchen = false;

	/** Показывает, был ли игрок в гардеробной */

	public static boolean firstweardrobe = false;

	/** Показывает, был ли игрок в примерочной */

	public static boolean firstdressingroom = false;

	/** Показывает, был ли игрок в игровой */

	public static boolean firstgameroom = false;

	/** Показывает, был ли игрок в ванной */

	public static boolean firstbathroom = false;

	/** Показывает, был ли игрок в спальне */

	public static boolean firstbedroom = false;

	/** Показывает, был ли игрок во дворе */

	public static boolean firststreet = false;

	/** Показывает, был ли игрок в кабинете */

	public static boolean firstcomputerroom = false;

	/** Показывает, был ли показан AlertDialog о том, что обучение пройдено */

	public static boolean teaching = false;

	/** Показывает, заходил ли игрок в игру в первый раз */

	public static boolean times1 = false;

	/** Показывает, заходил ли игрок в игру в десятый раз */

	public static boolean times10 = false;

	/** Показывает, заходил ли игрок в игру в двадцать пятый раз */

	public static boolean times25 = false;

	/** Показывает, заходил ли игрок в игру в пятидесятый раз */

	public static boolean times50 = false;

	/** Показывает, заходил ли игрок в игру в сотый раз */

	public static boolean times100 = false;

	/** Показывает, заходил ли игрок в игру в стопятидесятый раз */

	public static boolean times150 = false;

	/** Показывает, заходил ли игрок в игру в двухсотый раз */

	public static boolean times200 = false;

	/** Показывает, заходил ли игрок в игру в двести пятидесятый раз */

	public static boolean times250 = false;

	/** Показывает, заходил ли игрок в игру в трехсотый раз */

	public static boolean times300 = false;

	/** Показывает, купил ли игрок "пляжный костюм для мальчика" */

	public static boolean wear1 = false;

	/** Показывает, купил ли игрок "пляжный костюм для девочки" */

	public static boolean wear2 = false;

	/** Показывает, купил ли игрок "костюм рыжей девочки-припевочки" */

	public static boolean wear3 = false;

	/** Показывает, купил ли игрок "костюм русой девочки-припевочки" */

	public static boolean wear4 = false;

	/** Показывает, купил ли игрок "куртку с цветами" */

	public static boolean wear5 = false;

	/** Показывает, купил ли игрок "голубую майку в цветочек" */

	public static boolean wear6 = false;

	/** Показывает, купил ли игрок "костюм моряка" */

	public static boolean wear7 = false;

	/** Показывает, купил ли игрок "костюм папуаса" */

	public static boolean wear8 = false;

	/** Показывает, купил ли игрок "костюм пирата" */

	public static boolean wear9 = false;

	/** Показывает, купил ли игрок "костюм пирата из коллекции by BanyaBell" */

	public static boolean wear10 = false;

	/** Показывает, купил ли игрок "костюм динозавра из коллекции by BanyaBell" */

	public static boolean wear11 = false;

	/** Показывает, купил ли игрок "костюм космонавта из коллекции by BanyaBell" */

	public static boolean wear12 = false;

	/** Показывает, купил ли игрок "костюм модницы из коллекции by BanyaBell" */

	public static boolean wear13 = false;

	/** Показывает, купил ли игрок "костюм ученого из коллекции by BanyaBell" */

	public static boolean wear14 = false;

	/** Показывает, купил ли игрок "костюм клоуна из коллекции by BanyaBell" */

	public static boolean wear15 = false;

	/** Показывает, купил ли игрок "костюм принца из коллекции by BanyaBell" */

	public static boolean wear16 = false;

	/** Показывает, купил ли игрок "костюм принцессы из коллекции by BanyaBell" */

	public static boolean wear17 = false;
	
	/** Показывает, купил ли игрок "костюм русалочки из коллекции by BanyaBell" */

	public static boolean wear18 = false;
	
	/** Показывает, купил ли игрок "костюм рыбака из коллекции by BanyaBell" */

	public static boolean wear19 = false;
	
	/** Показывает, купил ли игрок "костюм белки из коллекции by BanyaBell" */

	public static boolean wear20 = false;
	
	/** Показывает, купил ли игрок "костюм серфера из коллекции by BanyaBell" */

	public static boolean wear21 = false;

	/** Показывает, получил ли игрок достижение "Мастер "Линий"" */

	public static boolean masterlines = false;

	/** Показывает, получил ли игрок достижение "Чистюля" */

	public static boolean chistulya = false;

	/** Показывает, получил ли игрок достижение "Мастер чистоты" */

	public static boolean masterclean = false;

	/** Показывает, получил ли игрок достижение "Начальник-умывальник" */

	public static boolean nachumiv = false;

	/** Показывает, получил ли игрок достижение "Повар" */

	public static boolean cock = false;

	/** Показывает, получил ли игрок достижение "Гурман" */

	public static boolean gourm = false;

	/** Показывает, получил ли игрок достижение "Объедало" */

	public static boolean obedalo = false;

	/** Показывает, получил ли игрок достижение "Весельчак" */

	public static boolean funny = false;

	/** Показывает, получил ли игрок достижение "Юный клоун" */

	public static boolean youngclown = false;

	/** Показывает, получил ли игрок достижение "Мастер развлечений" */

	public static boolean masterfun = false;

	/** Показывает, получил ли игрок достижение "Модник" */

	public static boolean fashioner = false;

	/** Объект синглтона */

	private static CharSin instance;

	/** Количество валюты, заработанной за день */

	public static int maxearn = 0;

	/** Надетый на персонажа костюм */

	public static int nowWearing = -2;
	
	/**Хочет ли пользователь проходить обучение*/
	
	public static boolean wantTeach=true;

	/** Константа для состояния сытости */

	public static final String HUNGER_CONDITION = "hungercond";

	/** Константа для состояния здоровья */

	public static final String HEALTH_CONDITION = "healthcond";

	/** Константа для настроения персонажа */

	public static final String MOOD_CONDITION = "moodcond";

	/** Константа для количества игровых очков */

	public static final String WORPOINTS_CONDITION = "worpointscond";

	/** Константа для баланса игрока */

	public static final String MONEY_CONDITION = "moneycond";

	/** Константа для имени игрока */

	public static final String PLAYER_NAME = "playername";

	/** Константа для уровня */

	public static final String PLAYER_LEVEL = "playerlevel";
	
	/** Константа для текущей заставки на мониторе в кабинете */

	public static final String DESKTOPNOW = "desktopnow";

	/** Константа для количества заходов пользователя в игру */

	public static final String PLAYERTIMES = "playertimes";

	/** Константа для утверждения про первое посещение приложения */

	public static final String PLAYERTIMES1 = "playertimes1";

	/** Константа для утверждения про десятое посещение приложения */

	public static final String PLAYERTIMES10 = "playertimes10";

	/** Константа для утверждения про двадцать пятое посещение приложения */

	public static final String PLAYERTIMES25 = "playertimes25";

	/** Константа для утверждения про пятидесятое посещение приложения */

	public static final String PLAYERTIMES50 = "playertimes50";

	/** Константа для утверждения про сотое посещение приложения */

	public static final String PLAYERTIMES100 = "playertimes100";

	/** Константа для утверждения про стопятидесятое посещение приложения */

	public static final String PLAYERTIMES150 = "playertimes150";

	/** Константа для утверждения про двухсотое посещение приложения */

	public static final String PLAYERTIMES200 = "playertimes200";

	/** Константа для утверждения про двести пятидесятое посещение приложения */

	public static final String PLAYERTIMES250 = "playertimes250";

	/** Константа для утверждения про трехсотое посещение приложения */

	public static final String PLAYERTIMES300 = "playertimes300";

	/** Константа для утверждения про покупку "пляжного костюма для мальчиков" */

	public static final String BUYWEAR1 = "wear1";

	/** Константа для утверждения про покупку "пляжного костюма для девочек" */

	public static final String BUYWEAR2 = "wear2";

	/** Константа для утверждения про покупку "костюма рыжей девочки-припевочки" */

	public static final String BUYWEAR3 = "wear3";

	/** Константа для утверждения про покупку "костюма русой девочки-припевочки" */

	public static final String BUYWEAR4 = "wear4";

	/** Константа для утверждения про покупку "куртки с цветами" */

	public static final String BUYWEAR5 = "wear5";

	/** Константа для утверждения про покупку "голубой майки в цветочек" */

	public static final String BUYWEAR6 = "wear6";

	/** Константа для утверждения про покупку "костюма моряка" */

	public static final String BUYWEAR7 = "wear7";

	/** Константа для утверждения про покупку "костюма папуаса" */

	public static final String BUYWEAR8 = "wear8";

	/** Константа для утверждения про покупку "костюма пирата" */

	public static final String BUYWEAR9 = "wear9";

	/**
	 * Константа для утверждения про покупку
	 * "костюма пирата из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR10 = "wear10";

	/**
	 * Константа для утверждения про покупку
	 * "костюма динозавра из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR11 = "wear11";

	/**
	 * Константа для утверждения про покупку
	 * "костюма космонавта из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR12 = "wear12";

	/**
	 * Константа для утверждения про покупку
	 * "костюма модницы из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR13 = "wear13";

	/**
	 * Константа для утверждения про покупку
	 * "костюма ученого из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR14 = "wear14";

	/**
	 * Константа для утверждения про покупку
	 * "костюма клоуна из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR15 = "wear15";

	/**
	 * Константа для утверждения про покупку
	 * "костюма принца из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR16 = "wear16";

	/**
	 * Константа для утверждения про покупку
	 * "костюма принцессы из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR17 = "wear17";
	
	/**
	 * Константа для утверждения про покупку
	 * "костюма русалочки из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR18 = "wear18";
	
	/**
	 * Константа для утверждения про покупку
	 * "костюма рыбака из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR19 = "wear19";

	/**
	 * Константа для утверждения про покупку
	 * "костюма белки из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR20 = "wear20";
	
	/**
	 * Константа для утверждения про покупку
	 * "костюма серфера из коллекции by BanyaBell"
	 */

	public static final String BUYWEAR21 = "wear21";
	
	/** Константа для надетого на персонажа костюма */

	public static final String WEARINGNOW = "wearnow";

	/** Константа для заработанной за день игровой валюты */

	public static final String MAXEARN = "maxearning";

	/** Константа для установленного в главном меню оформления */

	public static final String THEMENOW = "mainmenutheme";

	/** Константа для последнего количества набранных очков в игре "Линии" */

	public static final String CURRENTSCORE = "currentscore";

	/** Константа для рекордного количества набранных очков в игре "Линии" */

	public static final String RECORDSCORE = "recordscore";

	/** Константа для утверждения о посещении пользователем прихожей */

	public static final String FIRSTLOBBY = "firstlobby";

	/** Константа для утверждения о посещении пользователем гардеробной */

	public static final String FIRSTWEARDROBE = "firstweardrobe";

	/** Константа для утверждения о посещении пользователем кухни */

	public static final String FIRSTKITCHEN = "firstkitchen";

	/** Константа для утверждения о посещении пользователем ванной */

	public static final String FIRSTBATHROOM = "firstbathroom";

	/** Константа для утверждения о посещении пользователем спальни */

	public static final String FIRSTBEDROOM = "firstbedroom";

	/** Константа для утверждения о посещении пользователем игровой */

	public static final String FIRSTGAMEROOM = "firstgameroom";

	/** Константа для утверждения о посещении пользователем двора */

	public static final String FIRSTSTREET = "firststreet";

	/** Константа для утверждения о посещении пользователем примерочной */

	public static final String FIRSTDRESSINGROOM = "firstdressingroom";

    /** Константа для утверждения о посещении пользователем кабинета */

    public static final String FIRSTCOMPUTERROOM = "firstcomputerroom";

	/**
	 * Константа для количества действий, повышающих состояние здоровья
	 * персонажа
	 */

	public static final String COUNTCLEAN = "cclean";

	/** Константа для количества действий, повышающих сытость персонажа */

	public static final String COUNTFOOD = "cfood";

	/** Константа для количества действий, повышающих настроение персонажа */

	public static final String COUNTMOOD = "cmood";

	/** Константа для утверждения, прошел ли игрок обучение */

	public static final String TEACHING = "teaching";

	/** Константа для надетого на персонажа костюма */

	public static final String COUNTWEAR = "cwear";

	/** Константа для утверждения, открыл ли игрок достиение "Мастер "Линий"" */

	public static final String MASTERLINES = "masterlines";

	/** Константа для утверждения, открыл ли игрок достижение "Чистюля" */

	public static final String CHISTULYA = "chistulya";

	/** Константа для утверждения, открыл ли игрок достижение "Мастер чистоты" */

	public static final String MASTERCLEAN = "masterclean";

	/**
	 * Константа для утверждения, открыл ли игрок достижение
	 * "Начальник-умывальник"
	 */

	public static final String NACHUMIV = "nachumiv";

	/** Константа для утверждения, открыл ли игрок достижение "Повар" */

	public static final String COCK = "cock";

	/** Константа для утверждения, открыл ли игрок достижение "Гурман" */

	public static final String GOURM = "gourm";

	/** Константа для утверждения, открыл ли игрок достижение "Объедало" */

	public static final String OBEDALO = "obedalo";

	/** Константа для утверждения, открыл ли игрок достижение "Весельчак" */

	public static final String FUNNY = "funny";

	/** Константа для утверждения, открыл ли игрок достижение "Юный клоун" */

	public static final String YOUNGCLOWN = "youngclown";

	/**
	 * Константа для утверждения, открыл ли игрок достижение
	 * "Мастер развлечений"
	 */

	public static final String MASTERFUN = "masterfun";

	/** Константа для утверждения, открыл ли игрок достижение "Модник" */

	public static final String FASHIONER = "fashioner";

	/** Константа для утверждения, показывать ли уведомления */

	public static final String NOTIF = "notif";
	
	/**Константа для утверждения о прохождении обучения*/
	
	public static final String WANTTEACH="toteach";


    /**Константа для утверждения о прохождении обучения*/

    public static final String CLICKHOME="homeclick";
    
	/**
	 * Поле, с помощью которого из системы извлекаются настройки
	 * SharedPreferences
	 */

	public static SharedPreferences mSettings;

	/** Имя игрока, которое он добавил в главном меню */

	public static String CharName;

	/** Контекст синглтона */

	private Context context;

	/** Конструктор, создающий синглтон */

	private CharSin() {

	}

	/** Метод для получения настроек приложения */

	public void loadParameters(Context context) {

		/** Получение настроек на уровне приложения */

		mSettings = context.getSharedPreferences("Wormy", Context.MODE_PRIVATE);

		/** Имя игрока. Если отсутствует, то строка "игрок". */

		CharName = mSettings.getString(PLAYER_NAME, "игрок");

		/**
		 * Текущее состояние здоровья. По умолчанию - 100 единиц, максимальное
		 * знчение.
		 */

		health = mSettings.getInt(HEALTH_CONDITION, 100);
      
		/** Текущее состояние сытости. По умолчанию - максимально, 100 единиц. */

		hunger = mSettings.getInt(HUNGER_CONDITION, 100);

		/**
		 * Текущее настроение персонажа. По умолчанию - максимально, 100 единиц.
		 */

		mood = mSettings.getInt(MOOD_CONDITION, 100);

		/** Текущее количество игровых очков. По умолчанию - нуль. */

		worpoints = mSettings.getInt(WORPOINTS_CONDITION, 0);

		/** Текущий баланс игрока. По умолчанию - нуль. */

		money = mSettings.getInt(MONEY_CONDITION, 0);

		/** Текущий уровень. По умолчанию - первый. */

		level = mSettings.getInt(PLAYER_LEVEL, 1);

		/** Количество заходов пользователя в игру. По умолчанию - нуль. */

		times = mSettings.getInt(PLAYERTIMES, 0);
		
		/** Текущая заставка на мониторе в кабинете. По умолчанию - нуль. */

		desktopNow = mSettings.getInt(DESKTOPNOW, 0);
	

		/** Утверждение, показывать ли уведомления. По умолчанию - true. */

		notif = mSettings.getBoolean(NOTIF, true);

		/**
		 * Утверждение, посетил ли игрок приложение один раз. По умолчанию -
		 * false.
		 */

		times1 = mSettings.getBoolean(PLAYERTIMES1, false);

		/**
		 * Утверждение, посетил ли игрок приложение десять раз. По умолчанию -
		 * false.
		 */

		times10 = mSettings.getBoolean(PLAYERTIMES10, false);

		/**
		 * Утверждение, посетил ли игрок приложение двадцать пять раз. По
		 * умолчанию - false.
		 */

		times25 = mSettings.getBoolean(PLAYERTIMES25, false);

		/**
		 * Утверждение, посетил ли игрок приложение пятьдесят раз. По умолчанию
		 * - false.
		 */

		times50 = mSettings.getBoolean(PLAYERTIMES50, false);

		/**
		 * Утверждение, посетил ли игрок приложение сто раз. По умолчанию -
		 * false.
		 */

		times100 = mSettings.getBoolean(PLAYERTIMES100, false);

		/**
		 * Утверждение, посетил ли игрок приложение сто пятьдесят раз. По
		 * умолчанию - false.
		 */

		times150 = mSettings.getBoolean(PLAYERTIMES150, false);

		/**
		 * Утверждение, посетил ли игрок приложение двести раз. По умолчанию -
		 * false.
		 */

		times200 = mSettings.getBoolean(PLAYERTIMES200, false);

		/**
		 * Утверждение, посетил ли игрок приложение двести пятьдесят раз. По
		 * умолчанию - false.
		 */

		times250 = mSettings.getBoolean(PLAYERTIMES250, false);

		/**
		 * Утверждение, посетил ли игрок приложение триста раз. По умолчанию -
		 * false.
		 */

		times300 = mSettings.getBoolean(PLAYERTIMES300, false);

		/**
		 * Утверждение, купил ли игрок "пляжный костюм для мальчика". По
		 * умолчанию - false.
		 */

		wear1 = mSettings.getBoolean(BUYWEAR1, false);

		/**
		 * Утверждение, купил ли игрок "пляжный костюм для девочки". По
		 * умолчанию - false.
		 */

		wear2 = mSettings.getBoolean(BUYWEAR2, false);

		/**
		 * Утверждение, купил ли игрок "костюм рыжей девочки-припевочки". По
		 * умолчанию - false.
		 */

		wear3 = mSettings.getBoolean(BUYWEAR3, false);

		/**
		 * Утверждение, купил ли игрок "костюм русой девочки-припевочки". По
		 * умолчанию - false.
		 */

		wear4 = mSettings.getBoolean(BUYWEAR4, false);

		/**
		 * Утверждение, купил ли игрок "куртку с цветами". По умолчанию - false.
		 */

		wear5 = mSettings.getBoolean(BUYWEAR5, false);

		/**
		 * Утверждение, купил ли игрок "голубую майку в цветочек". По умолчанию
		 * - false.
		 */

		wear6 = mSettings.getBoolean(BUYWEAR6, false);

		/** Утверждение, купил ли игрок "костюм моряка". По умолчанию - false. */

		wear7 = mSettings.getBoolean(BUYWEAR7, false);

		/** Утверждение, купил ли игрок "костюм папуаса". По умолчанию - false. */

		wear8 = mSettings.getBoolean(BUYWEAR8, false);

		/** Утверждение, купил ли игрок "костюм пирата". По умолчанию - false. */

		wear9 = mSettings.getBoolean(BUYWEAR9, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм пирата из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear10 = mSettings.getBoolean(BUYWEAR10, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм динозавра из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear11 = mSettings.getBoolean(BUYWEAR11, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм космонавта из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear12 = mSettings.getBoolean(BUYWEAR12, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм модницы из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear13 = mSettings.getBoolean(BUYWEAR13, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм ученого из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear14 = mSettings.getBoolean(BUYWEAR14, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм клоуна из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear15 = mSettings.getBoolean(BUYWEAR15, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм принца из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear16 = mSettings.getBoolean(BUYWEAR16, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм принцессы из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear17 = mSettings.getBoolean(BUYWEAR17, false);
		
		/**
		 * Утверждение, купил ли игрок
		 * "костюм русалочки из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear18 = mSettings.getBoolean(BUYWEAR18, false);

		/**
		 * Утверждение, купил ли игрок
		 * "костюм рыбака из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear19 = mSettings.getBoolean(BUYWEAR19, false);
		
		/**
		 * Утверждение, купил ли игрок
		 * "костюм белки из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear20 = mSettings.getBoolean(BUYWEAR20, false);
		
		/**
		 * Утверждение, купил ли игрок
		 * "костюм серфера из коллекции by BanyaBell". По умолчанию - false.
		 */

		wear21 = mSettings.getBoolean(BUYWEAR21, false);
		
		/**
		 * Текущий костюм на персонаже. По умолчанию -2, что соответствует
		 * персонажу-ребенку.
		 */

		nowWearing = mSettings.getInt(WEARINGNOW, -2);

		/** Количество заработанной за день валюты. По умолчанию - нуль. */

		maxearn = mSettings.getInt(MAXEARN, 0);

		/**
		 * Оформление главного меню. По умолчанию 1, что соответствует
		 * стандартной теме.
		 */

		themeNow = mSettings.getInt(THEMENOW, 1);

		/**
		 * Последнее количество набранных очков в игре "Линии". По умолчанию -
		 * нуль.
		 */

		curlinesscore = mSettings.getInt(CURRENTSCORE, 0);

		/**
		 * Рекордное количество набранных очков в игре "Линии". По умолчанию -
		 * нуль.
		 */

		reclinesscore = mSettings.getInt(RECORDSCORE, 0);
		
		/** Утверждение, посетил ли уже игрок прихожую. По умолчанию - false. */

		firstlobby = mSettings.getBoolean(FIRSTLOBBY, false);

		/** Утверждение, посетил ли уже игрок гардеробную. По умолчанию - false. */

		firstweardrobe = mSettings.getBoolean(FIRSTWEARDROBE, false);

		/** Утверждение, посетил ли уже игрок кухню. По умолчанию - false. */

		firstkitchen = mSettings.getBoolean(FIRSTKITCHEN, false);

		/** Утверждение, посетил ли уже игрок ванную. По умолчанию - false. */

		firstbathroom = mSettings.getBoolean(FIRSTBATHROOM, false);

		/** Утверждение, посетил ли уже игрок спальню. По умолчанию - false. */

		firstbedroom = mSettings.getBoolean(FIRSTBEDROOM, false);

		/** Утверждение, посетил ли уже игрок игровую. По умолчанию - false. */

		firstgameroom = mSettings.getBoolean(FIRSTGAMEROOM, false);

		/** Утверждение, посетил ли уже игрок двор. По умолчанию - false. */

		firststreet = mSettings.getBoolean(FIRSTSTREET, false);

		/** Утверждение, посетил ли уже игрок примерочную. По умолчанию - false. */

		firstdressingroom = mSettings.getBoolean(FIRSTDRESSINGROOM, false);

        /** Утверждение, посетил ли уже игрок кабинет. По умолчанию - false. */

        firstcomputerroom = mSettings.getBoolean(FIRSTCOMPUTERROOM, false);

		/**
		 * Утверждение, увидел ли игрок AlertDialog об окончании обучения. По
		 * умолчанию - false.
		 */

		teaching = mSettings.getBoolean(TEACHING, false);

		/**
		 * Количество проделанных игроком действий, повышающих состояние
		 * здоровья перонажа. По умолчанию - нуль.
		 */

		countclean = mSettings.getInt(COUNTCLEAN, 0);

		/**
		 * Количество проделанных игроком действий, повышающих сытость перонажа.
		 * По умолчанию - нуль.
		 */

		countfood = mSettings.getInt(COUNTFOOD, 0);

		/**
		 * Количество проделанных игроком действий, повышающих настроение
		 * перонажа. По умолчанию - нуль.
		 */

		countmood = mSettings.getInt(COUNTMOOD, 0);

		/** Количество купленных костюмов. По умолчанию - нуль. */

		countwear = mSettings.getInt(COUNTWEAR, 0);

		/**
		 * Утверждение, открыл ли игрок достижение "Мастер "Линий"". По
		 * умолчанию - false.
		 */

		masterlines = mSettings.getBoolean(MASTERLINES, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Чистюля". По умолчанию -
		 * false.
		 */

		chistulya = mSettings.getBoolean(CHISTULYA, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Мастер чистоты". По
		 * умолчанию - false.
		 */

		masterclean = mSettings.getBoolean(MASTERCLEAN, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Начальник-умывальник". По
		 * умолчанию - false.
		 */

		nachumiv = mSettings.getBoolean(NACHUMIV, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Повар". По умолчанию -
		 * false.
		 */

		cock = mSettings.getBoolean(COCK, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Гурман". По умолчанию -
		 * false.
		 */

		gourm = mSettings.getBoolean(GOURM, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Объедало". По умолчанию -
		 * false.
		 */

		obedalo = mSettings.getBoolean(OBEDALO, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Весельчак". По умолчанию -
		 * false.
		 */

		funny = mSettings.getBoolean(FUNNY, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Юный клоун". По умолчанию -
		 * false.
		 */

		youngclown = mSettings.getBoolean(YOUNGCLOWN, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Мастер развлечений". По
		 * умолчанию - false.
		 */

		masterfun = mSettings.getBoolean(MASTERFUN, false);

		/**
		 * Утверждение, открыл ли игрок достижение "Модник". По умолчанию -
		 * false.
		 */

		fashioner = mSettings.getBoolean(FASHIONER, false);
		
		/**Утверждение, хочет ли игрок проходить обучение. По умолчанию - true.*/

		wantTeach=mSettings.getBoolean(WANTTEACH, true);

        /**Количество нажатий игрока на кнопку "Играть!". По умолчанию - нуль.*/

        clickhome=mSettings.getInt(CLICKHOME, 0);
	}

	public static synchronized CharSin getInstance(Context context) {

		if (instance == null) {

			instance = new CharSin();

		}

		instance.context = context;

		instance.loadParameters(context);

		return instance;

	}

	/**
	 * Выставляет и сохраняет новое значение здоровья, а также отправляет данные
	 * в таблицу игроков на сайте
	 */

	public int setHealth(int hel) {

		new mAsyncTask().execute();

		if(health+hel<=100)health += hel;
		
		else health=100;
		
		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(HEALTH_CONDITION, health);

		editor.apply();

		return health;

	}

	/**
	 * Выставляет и сохраняет новое значение сытости, а также отправляет данные
	 * в таблицу игроков на сайте
	 */

	public int setHunger(int hung) {

		new mAsyncTask().execute();

		if(hunger+hung<=100)hunger += hung;
	
		else hunger=100;
	
		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(HUNGER_CONDITION, hunger);

		editor.apply();
		return hunger;

	}

	/**
	 * Выставляет и сохраняет новое значение настоения, а также отправляет
	 * данные в таблицу игроков на сайте
	 */

	public int setMood(int m) {

		new mAsyncTask().execute();

		if(mood+m<=100)mood += m;
		
		else mood=100;
	
		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MOOD_CONDITION, mood);

		editor.apply();

		return mood;

	}

	/**
	 * Выставляет и сохраняет новое значение игровых очков, а также отправляет
	 * данные в таблицу игроков на сайте
	 */

	public int setWorpoints(int w) {

		new mAsyncTask().execute();

		worpoints += w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(WORPOINTS_CONDITION, worpoints);

		editor.apply();

		return worpoints;

	}
	
	/**
	 * Выставляет и сохраняет новое значение, соответствующее текущей заставке на мониторе в кабинете
	 */

	public int setDesktopNow(int dn) {

        desktopNow= dn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(DESKTOPNOW, desktopNow);

		editor.apply();

		return desktopNow;

	}
	
	/**
	 * Выставляет и сохраняет новое значение баланса игрока, а также отправляет
	 * данные в таблицу игроков на сайте
	 */

	public int setMoney(int mon) {

		new mAsyncTask().execute();

		money += mon;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MONEY_CONDITION, money);

		editor.apply();

		return money;

	}

	/**
	 * Выставляет и сохраняет новое имя игрока, а также отправляет данные в
	 * таблицу игроков на сайте
	 */

	public String setCharName(String str) {

		new mAsyncTask().execute();

		CharName = str;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putString(PLAYER_NAME, CharName);

		editor.apply();

		return CharName;

	}

	/**
	 * Выставляет и сохраняет новое значение уровня игрока, а также отправляет
	 * данные в таблицу игроков на сайте
	 */

	public int setLevel(int l) {

		new mAsyncTask().execute();

		level = l;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(PLAYER_LEVEL, level);

		editor.apply();

		return level;

	}

	/**
	 * Выставляет и сохраняет новое значение количество заходов пользователя в
	 * игру,
	 * 
	 * а также отправляет данные в таблицу игроков на сайте
	 */

	public int setTimes(int time) {

		new mAsyncTask().execute();

		times += time;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(PLAYERTIMES, times);

		editor.apply();

		return times;

	}
	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в первый раз в зависимости
	 * от значения входного параметра
	 */

	public boolean setTB1(boolean tmb) {

		times1 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES1, times1);

		editor.apply();

		return times1;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в десятый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB10(boolean tmb) {

		times10 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES10, times10);

		editor.apply();

		return times10;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в двадцать пятый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB25(boolean tmb) {

		times25 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES25, times25);

		editor.apply();

		return times25;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в пятидесятый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB50(boolean tmb) {

		times50 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES50, times50);

		editor.apply();

		return times50;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в сотый раз в зависимости
	 * от значения входного параметра
	 */

	public boolean setTB100(boolean tmb) {

		times100 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES100, times100);

		editor.apply();

		return times100;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в стопятидесятый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB150(boolean tmb) {

		times150 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES150, times150);

		editor.apply();

		return times150;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в двухсотый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB200(boolean tmb) {

		times200 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES200, times200);

		editor.apply();

		return times200;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в двести пятидесятый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB250(boolean tmb) {

		times250 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES250, times250);

		editor.apply();

		return times250;

	}

	/** Устанавливает, хочет ли игрок видеть уведомления */

	public boolean setNotify(boolean n) {

		notif = n;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(NOTIF, notif);

		editor.apply();

		return notif;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Мастер "Линий"" в
	 * зависимости от значения входного параметра
	 */

	public boolean setMasterlines(boolean ml) {

		masterlines = ml;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERLINES, masterlines);

		editor.apply();

		return masterlines;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Чистюля" в
	 * зависимости от значения входного параметра
	 */

	public boolean setChistulya(boolean ch) {

		chistulya = ch;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(CHISTULYA, chistulya);

		editor.apply();

		return chistulya;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Мастер чистоты" в
	 * зависимости от значения входного параметра
	 */

	public boolean setMasterclean(boolean tmb) {

		masterclean = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERLINES, masterclean);

		editor.apply();

		return masterclean;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение
	 * "Начальник-умывальник" в зависимости от значения входного параметра
	 */

	public boolean setNachumiv(boolean tmb) {

		nachumiv = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(NACHUMIV, nachumiv);

		editor.apply();

		return nachumiv;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Повар" в
	 * зависимости от значения входного параметра
	 */

	public boolean setCock(boolean tmb) {

		cock = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(COCK, cock);

		editor.apply();

		return cock;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Гурман" в
	 * зависимости от значения входного параметра
	 */

	public boolean setGourm(boolean tmb) {

		gourm = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(GOURM, gourm);

		editor.apply();

		return gourm;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Объедало" в
	 * зависимости от значения входного параметра
	 */

	public boolean setObedalo(boolean tmb) {

		obedalo = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(OBEDALO, obedalo);

		editor.apply();

		return obedalo;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Весельчак" в
	 * зависимости от значения входного параметра
	 */

	public boolean setFunny(boolean tmb) {

		funny = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FUNNY, funny);

		editor.apply();

		return funny;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Юный клоун" в
	 * зависимости от значения входного параметра
	 */

	public boolean setYoungclown(boolean tmb) {

		youngclown = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(YOUNGCLOWN, youngclown);

		editor.apply();

		return youngclown;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение
	 * "Мастер развлечений" в зависимости от значения входного параметра
	 */

	public boolean setMasterfun(boolean tmb) {

		masterfun = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERFUN, masterfun);

		editor.apply();

		return masterfun;

	}

	/**
	 * Устанавливает, что игрок получил/не получил достижение "Модник" в
	 * зависимости от значения входного параметра
	 */

	public boolean setFashioner(boolean tmb) {

		fashioner = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FASHIONER, fashioner);

		editor.apply();

		return fashioner;

	}

	/**
	 * Устанавливает, что игрок зашел/не зашел в игру в трехсотый раз в
	 * зависимости от значения входного параметра
	 */

	public boolean setTB300(boolean tmb) {

		times300 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES300, times300);

		editor.apply();

		return times300;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил прихожую впервые в
	 * зависимости от значения входного параметра
	 */

	public boolean setFirstLobby(boolean fl) {

		firstlobby = fl;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTLOBBY, firstlobby);

		editor.apply();

		return firstlobby;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил гардеробную впервые в
	 * зависимости от значения входного параметра
	 */

	public boolean setFirstWeardrobe(boolean fw) {

		firstweardrobe = fw;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTWEARDROBE, firstweardrobe);

		editor.apply();

		return firstweardrobe;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил кухню впервые в зависимости
	 * от значения входного параметра
	 */

	public boolean setFirstKitchen(boolean fk) {

		firstkitchen = fk;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTKITCHEN, firstkitchen);

		editor.apply();

		return firstkitchen;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил ванную впервые в зависимости
	 * от значения входного параметра
	 */

	public boolean setFirstBathroom(boolean fba) {

		firstbathroom = fba;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTBATHROOM, firstbathroom);

		editor.apply();

		return firstbathroom;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил спальню впервые в зависимости
	 * от значения входного параметра
	 */

	public boolean setFirstBedroom(boolean fbe) {

		firstbedroom = fbe;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTBEDROOM, firstbedroom);

		editor.apply();

		return firstbedroom;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил игровую впервые в зависимости
	 * от значения входного параметра
	 */

	public boolean setFirstGameroom(boolean fg) {

		firstgameroom = fg;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTGAMEROOM, firstgameroom);

		editor.apply();

		return firstgameroom;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил двор впервые в зависимости от
	 * значения входного параметра
	 */

	public boolean setFirstStreet(boolean fs) {

		firststreet = fs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTSTREET, firststreet);

		editor.apply();

		return firststreet;

	}

	/**
	 * Устанавливает, что игрок посетил/не посетил примерочную впервые в
	 * зависимости от значения входного параметра
	 */

	public boolean setFirstDressingroom(boolean fs) {

		firstdressingroom = fs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTDRESSINGROOM, firstdressingroom);

		editor.apply();

		return firstdressingroom;

	}

    /**
     * Устанавливает, что игрок посетил/не посетил кабинет впервые в
     * зависимости от значения входного параметра
     */

    public boolean setFirstComputerroom(boolean cr) {

        firstcomputerroom = cr;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putBoolean(FIRSTCOMPUTERROOM, firstcomputerroom);

        editor.apply();

        return firstcomputerroom;

    }

	/**
	 * Устанавливает, что игрок увидел/не увидел AlertDialog об окончании
	 * обучения
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setTeaching(boolean t) {

		teaching = t;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(TEACHING, teaching);

		editor.apply();

		return teaching;

	}
	/**
	 * Устанавливает, что игрок хочет/не хочет проходить
	 * обучение в зависимости от значения входного параметра
	 */

	public boolean setWantTeach(boolean wt) {

		wantTeach = wt;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(WANTTEACH, wantTeach);

		editor.apply();

		return wantTeach;

	}
	/**
	 * Устанавливает, что игрок купил/не купил "пляжный костюм для мальчика"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear1(boolean w) {

		wear1 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR1, wear1);

		editor.apply();

		return wear1;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "пляжный костюм для девочки"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear2(boolean w) {

		wear2 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR2, wear2);

		editor.apply();

		return wear2;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "костюм рыжей девочки-припевочки"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear3(boolean w) {

		wear3 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR3, wear3);

		editor.apply();

		return wear3;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "костюм русой девочки-припевочки"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear4(boolean w) {

		wear4 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR4, wear4);

		editor.apply();

		return wear4;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "куртку с цветами"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear5(boolean w) {

		wear5 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR5, wear5);

		editor.apply();

		return wear5;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "голубую майку в цветочек"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear6(boolean w) {

		wear6 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR6, wear6);

		editor.apply();

		return wear6;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "костюм моряка"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear7(boolean w) {

		wear7 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR7, wear7);

		editor.apply();

		return wear7;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "костюм папуаса"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear8(boolean w) {

		wear8 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR8, wear8);

		editor.apply();

		return wear8;

	}

	/**
	 * Устанавливает, что игрок купил/не купил "костюм пирата"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear9(boolean w) {

		wear9 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR9, wear9);

		editor.apply();

		return wear9;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм пирата из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear10(boolean w) {

		wear10 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR10, wear10);

		editor.apply();

		return wear10;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм динозавра из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear11(boolean w) {

		wear11 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR11, wear11);

		editor.apply();

		return wear11;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм космонавта из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear12(boolean w) {

		wear12 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR12, wear12);

		editor.apply();

		return wear12;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм модницы из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear13(boolean w) {

		wear13 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR13, wear13);

		editor.apply();

		return wear13;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм ученого из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear14(boolean w) {

		wear14 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR14, wear14);

		editor.apply();

		return wear14;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм клоуна из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear15(boolean w) {

		wear15 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR15, wear15);

		editor.apply();

		return wear15;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм принца из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear16(boolean w) {

		wear16 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR16, wear16);

		editor.apply();

		return wear16;

	}

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм принцессы из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear17(boolean w) {

		wear17 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR17, wear17);

		editor.apply();

		return wear17;

	}
	

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм русалочки из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear18(boolean w) {

		wear18 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR18, wear18);

		editor.apply();

		return wear18;

	}


	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм рыбака из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear19(boolean w) {

		wear19 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR19, wear19);

		editor.apply();

		return wear19;

	}
	

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм белки из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear20(boolean w) {

		wear20 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR20, wear20);

		editor.apply();

		return wear20;

	}
	

	/**
	 * Устанавливает, что игрок купил/не купил
	 * "костюм серфера из коллекции by BanyaBell"
	 * 
	 * в зависимости от значения входного параметра
	 */

	public boolean setWear21(boolean w) {

		wear21 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR21, wear21);

		editor.apply();

		return wear21;

	}
	
	/**
	 * Устанавливает число, соответствующее определенному костюму, и отправляет
	 * данные в таблицу игроков
	 */

	public int setNowWearing(int wn) {

		new mAsyncTask().execute();

		nowWearing = wn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(WEARINGNOW, nowWearing);

		editor.apply();

		return nowWearing;

	}

	/** Устанавливает количество уже заработанной за данный день валюты */

	public int setMaxEarn(int me) {

		maxearn += me;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MAXEARN, maxearn);

		editor.apply();

		return maxearn;

	}

	/**
	 * Устанавливает число, соответствующее определенному оформлению главного
	 * меню
	 */

	public int setThemeNow(int tn) {

		themeNow = tn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(THEMENOW, themeNow);

		editor.apply();

		return themeNow;

	}

	/** Последнее количество набранных очков в игре "Линии" */

	public int setCurrentScore(int crs) {

		curlinesscore = crs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(CURRENTSCORE, curlinesscore);

		editor.apply();

		return curlinesscore;

	}

	/** Рекордное количество набранных очков в игре "Линии" */

	public int setRecordScore(int rds) {

		reclinesscore = rds;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(RECORDSCORE, reclinesscore);

		editor.apply();

		return reclinesscore;

	}

	/**
	 * Количество проделанных действий, направленных на улучшение состояния
	 * здоровья персонажа
	 */

	public int setCclean(int cc) {

		countclean += cc;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTCLEAN, countclean);

		editor.apply();

		return countclean;

	}

	/**
	 * Количество проделанных действий, направленных на повышение сытости
	 * персонажа
	 */

	public int setCfood(int cf) {

		countfood += cf;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTFOOD, countfood);

		editor.apply();

		return countfood;

	}

	/**
	 * Количество проделанных действий, направленных на улучшение настроения
	 * персонажа
	 */

	public int setCmood(int cm) {

		countmood += cm;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTMOOD, countmood);

		editor.apply();

		return countmood;

	}

	/** Количество купленных костюмов */

	public int setCwear(int cw) {

		countwear += cw;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTWEAR, countwear);

		editor.apply();

		return countwear;

	}

    /** Изменение количества нажатий игрока на кнопку "Играть! */

    public int setClickhome(int ch) {

        clickhome += ch;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(CLICKHOME, clickhome);

        editor.apply();

        return clickhome;

    }

	/** Получение текущего значения здоровья персонажа */

	public int getHealth() {

		return health;

	}

	/** Получение текущего значения сытости персонажа */

	public int getHunger() {

		return hunger;

	}

	/** Получение текущего значения настроения персонажа */

	public int getMood() {

		return mood;

	}

	/** Получение текущего уровня персонажа */

	public int getLevel() {
		return level;
	}
	
	/** Получение текущего количества игровых очков персонажа */

	public int getWorpoints() {

		return worpoints;

	}

	/** Получение текущего баланса персонажа в виде числа */

	public int getMoney() {
		return money;
	}

	/** Получение текущего баланса персонажа в виде строки */

	public String getStrMoney() {
		return String.valueOf(money);
	}

	/** Получение имени игрока */

	public String getCharName() {
		return CharName;
	}

	/** Получение количества заходов игрока в игру */

	public int getTimes() {
		return times;
	}

	/** Возвращает true, если игрок заходил в игру 1 и более раз */

	public boolean getTB1() {
		return times1;
	}

	/** Возвращает true, если игрок заходил в игру 10 и более раз */

	public boolean getTB10() {
		return times10;
	}

	/** Возвращает true, если игрок заходил в игру 25 и более раз */

	public boolean getTB25() {
		return times25;
	}

	/** Возвращает true, если игрок заходил в игру 50 и более раз */

	public boolean getTB50() {
		return times50;
	}

	/** Возвращает true, если игрок заходил в игру 100 и более раз */

	public boolean getTB100() {
		return times100;
	}

	/** Возвращает true, если игрок заходил в игру 150 и более раз */

	public boolean getTB150() {
		return times150;
	}

	/** Возвращает true, если игрок заходил в игру 200 и более раз */

	public boolean getTB200() {
		return times200;
	}

	/** Возвращает true, если игрок заходил в игру 250 и более раз */

	public boolean getTB250() {
		return times250;
	}

	/** Возвращает true, если игрок заходил в игру 300 и более раз */

	public boolean getTB300() {
		return times300;
	}

	/** Возвращает true, если игрок установил флажок для показа уведомлений. */

	public boolean getNotify() {
		return notif;
	}

	/** Возвращает true, если игрок купил "пляжный костюм для мальчика" */

	public boolean getWear1() {
		return wear1;
	}

	/** Возвращает true, если игрок купил "пляжный костюм для девочки" */

	public boolean getWear2() {
		return wear2;
	}

	/** Возвращает true, если игрок купил "костюм рыжей девочки-припевочки" */

	public boolean getWear3() {
		return wear3;
	}

	/** Возвращает true, если игрок купил "костюм русой девочки-припевочки" */

	public boolean getWear4() {
		return wear4;
	}

	/** Возвращает true, если игрок купил "красную куртку с цветами" */

	public boolean getWear5() {
		return wear5;
	}

	/** Возвращает true, если игрок купил "голубую майку в цветочек" */

	public boolean getWear6() {
		return wear6;
	}

	/** Возвращает true, если игрок купил "костюм моряка" */

	public boolean getWear7() {
		return wear7;
	}

	/** Возвращает true, если игрок купил "костюм папуаса" */

	public boolean getWear8() {
		return wear8;
	}

	/** Возвращает true, если игрок купил "костюм пирата" */

	public boolean getWear9() {
		return wear9;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм пирата из коллекции by BanyaBell"
	 */

	public boolean getWear10() {
		return wear10;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм динозавра из коллекции by BanyaBell"
	 */

	public boolean getWear11() {
		return wear11;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм космонавта из коллекции by BanyaBell"
	 */

	public boolean getWear12() {
		return wear12;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм модницы из коллекции by BanyaBell"
	 */

	public boolean getWear13() {
		return wear13;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм ученого из коллекции by BanyaBell"
	 */

	public boolean getWear14() {
		return wear14;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм клоуна из коллекции by BanyaBell"
	 */

	public boolean getWear15() {
		return wear15;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм принца из коллекции by BanyaBell"
	 */

	public boolean getWear16() {
		return wear16;
	}

	/**
	 * Возвращает true, если игрок купил
	 * "костюм принцессы из коллекции by BanyaBell"
	 */

	public boolean getWear17() {
		return wear17;
	}
	
	/**
	 * Возвращает true, если игрок купил
	 * "костюм русалочки из коллекции by BanyaBell"
	 */

	public boolean getWear18() {
		return wear18;
	}
	
	/**
	 * Возвращает true, если игрок купил
	 * "костюм рыбака из коллекции by BanyaBell"
	 */

	public boolean getWear19() {
		return wear19;
	}
	
	/**
	 * Возвращает true, если игрок купил
	 * "костюм белки из коллекции by BanyaBell"
	 */

	public boolean getWear20() {
		return wear20;
	}
	
	/**
	 * Возвращает true, если игрок купил
	 * "костюм серфера из коллекции by BanyaBell"
	 */

	public boolean getWear21() {
		return wear21;
	}

	/** Возвращает цифру, соответствующую текущему костюму на персонаже" */

	public int getNowWearing() {
		return nowWearing;
	}

	/** Возвращает количество уже заработанной за день игровой валюты" */

	public int getMaxEarn() {
		return maxearn;
	}

	/**
	 * Возвращает цифру, соответствующую установленному оформлению главном меню"
	 */

	public int getThemeNow() {
		return themeNow;
	}

	/**
	 * Возвращает количество последних набранных очков в игре "Линии" в виде
	 * числа
	 */

	public int getCurrentScore() {
		return curlinesscore;
	}
	
	/**
	 * Возвращает цифру, соответствующую текущей заставке на мониторе в кабинете 
	 */

	public int getDesktopNow() {
		return desktopNow;
	}

	/**
	 * Возвращает количество последних набранных очков в игре "Линии" в виде
	 * строки
	 */

	public String getStrCurrentScore() {
		return String.valueOf(curlinesscore);
	}

	/**
	 * Возвращает рекордное количество набранных очков в игре "Линии" в виде
	 * числа
	 */

	public int getRecordScore() {
		return reclinesscore;
	}

	/**
	 * Возвращает рекордное количество набранных очков в игре "Линии" в виде
	 * строки
	 */

	public String getStrRecordScore() {
		return String.valueOf(reclinesscore);
	}

	public boolean getFirstLobby() {
		return firstlobby;
	}

	/** Возвращает true, если игрок уже был однажды в гардеробной */

	public boolean getFirstWeardrobe() {
		return firstweardrobe;
	}

	/** Возвращает true, если игрок уже был однажды на кухне */

	public boolean getFirstKitchen() {
		return firstkitchen;
	}

	/** Возвращает true, если игрок уже был однажды в ванной */

	public boolean getFirstBathroom() {
		return firstbathroom;
	}

	/** Возвращает true, если игрок уже был однажды в спальне */

	public boolean getFirstBedroom() {
		return firstbedroom;
	}

	/** Возвращает true, если игрок уже был однажды в игровой */

	public boolean getFirstGameroom() {
		return firstgameroom;
	}

	/** Возвращает true, если игрок уже был однажды во дворе */

	public boolean getFirstStreet() {
		return firststreet;
	}

	/** Возвращает true, если игрок уже был однажды в примерочной */

	public boolean getFirstDressingroom() {
		return firstdressingroom;
	}

    /** Возвращает true, если игрок уже был однажды в кабинете */

    public boolean getFirstComputerroom() {
        return firstcomputerroom;
    }

	/** Возвращает true, если игрок уже увидел AlertDialog об окончании обучения */

	public boolean getTeaching() {
		return teaching;
	}
	
	/** Возвращает true, если игрок хочет проходить обучение(поставил соответствующий флажок) */

	public boolean getWantTeach() {
		return wantTeach;
	}

	/**
	 * Возвращает количество проделанных действий, направленных на улучшение
	 * состояния здоровья персонажа
	 */

	public int getCclean() {
		return countclean;
	}

	/**
	 * Возвращает количество проделанных действий, направленных на повышение
	 * сытости персонажа
	 */

	public int getCfood() {
		return countfood;
	}

	/**
	 * Возвращает количество проделанных действий, направленных на улучшение
	 * настроения персонажа
	 */

	public int getCmood() {
		return countmood;
	}

	/**
	 * Возвращает количество проделанных действий, направленных на улучшение
	 * состояния здоровья персонажа
	 */

	public int getCwear() {
		return countwear;
	}

    /**
     * Возвращает количество нажатий игрока на кнопку "Играть!"
     */

    public int getClickhome() {
        return clickhome;
    }


    /** Обнуляет количество заработанной за день игровой валюты */

	public int ClearMaxEarn() {

		maxearn = 0;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MAXEARN, maxearn);

		editor.apply();

		return maxearn;

	}

	/**
	 * Выводит toast о том, что у игрока не хватает игровой валюты для
	 * совершения покупки.
	 */

	public void toastNoMoney(Context ct) {
		SuperToast.create(ct, "Для покупки тебе не хватает вормиков!", SuperToast.Duration.LONG, 
        	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	

	}

	/**
	 * Выводит toast о том, что у персонажа слишком низкий уровень жизненных
	 * параметров для того чтобы его переодевать.
	 */

	public void toastIll(Context ct) {
		SuperToast.create(ct, "Твой червячок заболел, ему сейчас не до одежды!", SuperToast.Duration.VERY_SHORT, 
        	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	}


	/**
	 * Выводит обучающий AlertDialog. Указываются заголовок, основной текст и
	 * иконка.
	 */

	public void TeachAlertDialog(Context context, String ttl, String msg, int icn) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(ttl);
		alertDialog.setMessage(msg);
		alertDialog.setIcon(icn);
		alertDialog.show();

	}

	/**
	 * В зависимости от числа, хранящегося в переменной, отвечающей за текущий
	 * костюм, изменяет тот на персонаже.
	 */

	public void setDressingWear(ImageView iv) {

		if (getLevel() == 1) {
			iv.setImageResource(R.drawable.stinkiesmallchild);
		}

		else {
			if (getHunger() < 20 && getHealth() < 20 && getMood() < 20) {

				iv.setImageResource(R.drawable.ill);
			}

			else {
				switch (getNowWearing()) {

				case -1:

					iv.setImageResource(R.drawable.stinkie);
					break;

				case 0:

					iv.setImageResource(R.drawable.stinkie0);
					break;

				case 1:

					iv.setImageResource(R.drawable.stinkie1);
					break;

				case 2:

					iv.setImageResource(R.drawable.stinkie2);
					break;

				case 3:

					iv.setImageResource(R.drawable.stinkie3);
					break;

				case 4:

					iv.setImageResource(R.drawable.stinkie4);
					break;

				case 5:

					iv.setImageResource(R.drawable.stinkie5);
					break;

				case 6:

					iv.setImageResource(R.drawable.stinkie6);
					break;

				case 7:

					iv.setImageResource(R.drawable.stinkie7);
					break;

				case 8:

					iv.setImageResource(R.drawable.stinkie8);
					break;

				case 9:

					iv.setImageResource(R.drawable.stinkie9);
					break;

				case 10:

					iv.setImageResource(R.drawable.stinkie10);
					break;

				case 11:

					iv.setImageResource(R.drawable.stinkie11);
					break;

				case 12:

					iv.setImageResource(R.drawable.stinkie12);
					break;

				case 13:

					iv.setImageResource(R.drawable.stinkie13);
					break;

				case 14:

					iv.setImageResource(R.drawable.stinkie14);
					break;

				case 15:

					iv.setImageResource(R.drawable.stinkie15);
					break;

				case 16:

					iv.setImageResource(R.drawable.stinkie16);
					break;

				case 17:

					iv.setImageResource(R.drawable.stinkie17);
					break;
				case 18:

					iv.setImageResource(R.drawable.stinkie18);
					break;
				case 19:

					iv.setImageResource(R.drawable.stinkie19);
					break;
				case 20:

					iv.setImageResource(R.drawable.stinkie20);
					break;
				case 21:

					iv.setImageResource(R.drawable.stinkie21);
					break;
				}

			}
		}
	}

	/** Включает аудиотрек. */

	public void makeMusic(Context c, int muz) {
		MediaPlayer mp = MediaPlayer.create(c, muz);

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

	/** Выводит AlertDialog о том, что обучение пройдено. */
	public void teach(Context ct) {

		if (getFirstLobby() == true && getFirstWeardrobe() == true
				&& getFirstBathroom() == true && getFirstBedroom() == true

				&& getFirstGameroom() == true && getFirstStreet() == true
				&& getFirstKitchen() == true && getFirstComputerroom() == true && getTeaching() == false) {

			CongratsAlertDialog(
					ct,
					"Обучение пройдено!",
					"На этом обучение закончено, молодец! За это я дарю тебе еще 100 вормиков и 100 игровых баллов! Если у тебя остались какие-то вопросы, то обязательно загляни в раздел ''помощь'', который можно открыть, нажав на одноименную кнопку в главном меню. А если и там ответа на твой вопрос нет, то тогда зайди на официальный сайт игры, ссылка на который находится в разделе ''о программе'', и задай вопрос моему создателю, воспользовавшись формой для отправки писем в нижней части страницы. Он обязательно тебе ответит в ближайшее время!",

					R.drawable.alert_icon, "Ура!", 100, 100);

			setTeaching(true);
		}

	}
	/**Включение/выключение показа обучающих AlertDialog-ов в комнатах*/
public void TeachChanger(Context ct, CheckBox chb){
    if(chb.isChecked()) {
        setWantTeach(true);
        chb.setChecked(true);
        SuperToast.create(ct, "Обучение включено!", SuperToast.Duration.VERY_SHORT, 
        	    Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
    }
    else  {setWantTeach(false); chb.setChecked(false);
    SuperToast.create(ct, "Обучение выключено!", SuperToast.Duration.VERY_SHORT, 
    	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();}
}
    /**
	 * Вызывает AlertDialog с поздравлениями, начисляет указанное количество
	 * игровых очков и валюты, включет звук фанфар.
	 */

	public void CongratsAlertDialog(Context context, String ttl,

	String msg, int icn, String positive, final int givemoney,

	final int giveworpoints) {

		makeMusic(context, R.raw.flourish);

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

		alertDialog.setTitle(ttl);

		alertDialog.setMessage(msg);

		alertDialog.setIcon(icn);

		alertDialog.setCancelable(false);

		alertDialog.setPositiveButton(positive,

		new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {

				setMoney(givemoney);

				setWorpoints(giveworpoints);

			}

		});

		alertDialog.show();

	}

	/**
	 * Класс, необходимый для передачи данных на сервер. Реализован в виде
	 * AsyncTask, потому что данные
	 * 
	 * должны передаваться независимо от главного потока.
	 */

	class mAsyncTask extends AsyncTask<Void, Integer, View> {

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values);
		}

		 @Override
	        protected View doInBackground(Void... params ) {
	              for (int i=0;i < Math.random()*300+300; i++)
	                    SystemClock.sleep(2);
	              sendWord();
	              for (int i=0;i < Math.random()*300; i++)
	                    SystemClock.sleep(2);
	              return null;

	        }

	        @Override
	        protected void onPostExecute(View a) {
	            sendImage();
	        }

	}

	/**
	 * Метод, с помощью которого происходит соединение с сервером и передача
	 * данных.
	 */

	/**Метод для отправки изображения на сервер*/
	public void sendImage() {
		new Thread(new Runnable() {
			public void run() {
				try {
					Log.d("Start", "start");
					URL url = new URL(
							"http://1-dot-disco-circuit-92606.appspot.com/wormyserver");
					URLConnection connection = url.openConnection();
					((ImageView) LobbyActivity.stinkieLobby.findViewById(R.id.stinkieLobby))
					.buildDrawingCache();
					Bitmap bitmap = ((ImageView) LobbyActivity.stinkieLobby.findViewById(R.id.stinkieLobby))
							.getDrawingCache();
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					bitmap.compress(CompressFormat.PNG, 100, bos);
					byte[] byteArray = bos.toByteArray();
					String out_string=Base64.encodeToString(byteArray,Base64.CRLF);
					Log.d("image", out_string);
					connection.setDoOutput(true);
					BufferedOutputStream out = new BufferedOutputStream(connection
							.getOutputStream());
					String inputString=CharName;
					out.write("name\n".getBytes());
					out.write((Base64.encodeToString(inputString.getBytes(), Base64.CRLF)).getBytes());
					out.write("image\n".getBytes());
					out.write(out_string.getBytes());
					out.flush();
					out.close();
					ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
					final String returnString = in.readLine();
					in.close();
					((Activity)context).runOnUiThread(new Runnable() {
						public void run() {
						}
					});
				} catch (Exception e) {
					Log.d("Exception",  e.toString());
				}

			}
		}).start();
	}

	/**Метод для отправки слова на сервер*/
	public void sendWord() {
		new Thread(new Runnable() {
			public void run() {
				try {
					Log.d("Start", "start");
					URL url = new URL(
							"http://1-dot-disco-circuit-92606.appspot.com/wormyserver");
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					BufferedOutputStream out = new BufferedOutputStream(connection
							.getOutputStream());
					out.write("name\n".getBytes());
					  out.write((Base64.encodeToString(CharName.getBytes(), Base64.CRLF)).getBytes());
					out.write("health\n".getBytes());
					out.write((String.valueOf(health)+"\n").getBytes());
					out.write("hunger\n".getBytes());
					out.write((String.valueOf(hunger)+"\n").getBytes());
					out.write("mood\n".getBytes());
					out.write((String.valueOf(mood)+"\n").getBytes());
					out.write("worpoints\n".getBytes());
					out.write((String.valueOf(worpoints)+"\n").getBytes());
					out.flush();
					out.close();
					ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
					final String returnString = in.readLine();
					in.close();
					((Activity)context).runOnUiThread(new Runnable() {
						public void run() {
						}
					});
				} catch (Exception e) {
					Log.d("Exception", e.toString());
				}

			}
		}).start();
	}

}
