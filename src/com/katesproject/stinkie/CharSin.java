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
 * �����, �������� ��� �������� ���������� ����������, ������� � ������� ���
 * ���,
 * 
 * � ����� ��������� ������, ������������ �� ������ ������ �������.
 */

class CharSin {

	/** ������� ���������� ������ �������� ��������� */

	public static int health = 100;

	/** ������� ���������� ������ ������� ��������� */

	public static int hunger = 100;

	/** ������� ���������� ������ ���������� ��������� */

	public static int mood = 100;

	/** ������� ���������� ������ ������� ����� ��������� */

	public static int worpoints = 0;

	/** ������� ���������� ������ ������ � ��������� */

	public static int money = 100;

	/** ������� ������� ��������� */

	public static int level = 1;

	/** ������� ���������� ������� ������ � ���� */

	public static int times = 0;

	/** �������, ���������� �� ����������� */

	public static boolean notif = true;

	/** ������� ���������� �������� ���� */

	public static int themeNow = 1;

	/** ������� ���������� �����, ��������� � ���� "�����" */

	public static int curlinesscore = 0;

	/** ��������� ���������� �����, ��������� � ���� "�����" */

	public static int reclinesscore = 0;

	/**
	 * ����������, ������� ��� ����� ����������� ����������, �����������
	 * ��������� �������� ���������
	 */

	public static int countclean = 0;

	/**
	 * ����������, ������� ��� ����� ����������� ����������, ����������� �������
	 * ���������
	 */

	public static int countfood = 0;

	/**
	 * ����������, ������� ��� ����� ����������� ����������, �����������
	 * ���������� ���������
	 */

	public static int countmood = 0;

    /**
     * ���������� ������� ������ �� ������ "������!"
     */

    public static int clickhome = 0;
    
    /**
     * �����, ��������������� ������������ �������� �� �������� � ��������
     */

    public static int desktopNow = 0;
    
	/** ������ �������� ������������� ������������� ������� */

	public static int countwear = 0;

	/** ��������� ��� ��� ����� ��� �������� � ������� */

	public static final int secretcode = 24061999;

	/** ����������, ��� �� ����� � �������� */

	public static boolean firstlobby = false;

	/** ����������, ��� �� ����� �� ����� */

	public static boolean firstkitchen = false;

	/** ����������, ��� �� ����� � ����������� */

	public static boolean firstweardrobe = false;

	/** ����������, ��� �� ����� � ����������� */

	public static boolean firstdressingroom = false;

	/** ����������, ��� �� ����� � ������� */

	public static boolean firstgameroom = false;

	/** ����������, ��� �� ����� � ������ */

	public static boolean firstbathroom = false;

	/** ����������, ��� �� ����� � ������� */

	public static boolean firstbedroom = false;

	/** ����������, ��� �� ����� �� ����� */

	public static boolean firststreet = false;

	/** ����������, ��� �� ����� � �������� */

	public static boolean firstcomputerroom = false;

	/** ����������, ��� �� ������� AlertDialog � ���, ��� �������� �������� */

	public static boolean teaching = false;

	/** ����������, ������� �� ����� � ���� � ������ ��� */

	public static boolean times1 = false;

	/** ����������, ������� �� ����� � ���� � ������� ��� */

	public static boolean times10 = false;

	/** ����������, ������� �� ����� � ���� � �������� ����� ��� */

	public static boolean times25 = false;

	/** ����������, ������� �� ����� � ���� � ����������� ��� */

	public static boolean times50 = false;

	/** ����������, ������� �� ����� � ���� � ����� ��� */

	public static boolean times100 = false;

	/** ����������, ������� �� ����� � ���� � �������������� ��� */

	public static boolean times150 = false;

	/** ����������, ������� �� ����� � ���� � ��������� ��� */

	public static boolean times200 = false;

	/** ����������, ������� �� ����� � ���� � ������ ����������� ��� */

	public static boolean times250 = false;

	/** ����������, ������� �� ����� � ���� � ��������� ��� */

	public static boolean times300 = false;

	/** ����������, ����� �� ����� "������� ������ ��� ��������" */

	public static boolean wear1 = false;

	/** ����������, ����� �� ����� "������� ������ ��� �������" */

	public static boolean wear2 = false;

	/** ����������, ����� �� ����� "������ ����� �������-����������" */

	public static boolean wear3 = false;

	/** ����������, ����� �� ����� "������ ����� �������-����������" */

	public static boolean wear4 = false;

	/** ����������, ����� �� ����� "������ � �������" */

	public static boolean wear5 = false;

	/** ����������, ����� �� ����� "������� ����� � ��������" */

	public static boolean wear6 = false;

	/** ����������, ����� �� ����� "������ ������" */

	public static boolean wear7 = false;

	/** ����������, ����� �� ����� "������ �������" */

	public static boolean wear8 = false;

	/** ����������, ����� �� ����� "������ ������" */

	public static boolean wear9 = false;

	/** ����������, ����� �� ����� "������ ������ �� ��������� by BanyaBell" */

	public static boolean wear10 = false;

	/** ����������, ����� �� ����� "������ ��������� �� ��������� by BanyaBell" */

	public static boolean wear11 = false;

	/** ����������, ����� �� ����� "������ ���������� �� ��������� by BanyaBell" */

	public static boolean wear12 = false;

	/** ����������, ����� �� ����� "������ ������� �� ��������� by BanyaBell" */

	public static boolean wear13 = false;

	/** ����������, ����� �� ����� "������ ������� �� ��������� by BanyaBell" */

	public static boolean wear14 = false;

	/** ����������, ����� �� ����� "������ ������ �� ��������� by BanyaBell" */

	public static boolean wear15 = false;

	/** ����������, ����� �� ����� "������ ������ �� ��������� by BanyaBell" */

	public static boolean wear16 = false;

	/** ����������, ����� �� ����� "������ ��������� �� ��������� by BanyaBell" */

	public static boolean wear17 = false;
	
	/** ����������, ����� �� ����� "������ ��������� �� ��������� by BanyaBell" */

	public static boolean wear18 = false;
	
	/** ����������, ����� �� ����� "������ ������ �� ��������� by BanyaBell" */

	public static boolean wear19 = false;
	
	/** ����������, ����� �� ����� "������ ����� �� ��������� by BanyaBell" */

	public static boolean wear20 = false;
	
	/** ����������, ����� �� ����� "������ ������� �� ��������� by BanyaBell" */

	public static boolean wear21 = false;

	/** ����������, ������� �� ����� ���������� "������ "�����"" */

	public static boolean masterlines = false;

	/** ����������, ������� �� ����� ���������� "�������" */

	public static boolean chistulya = false;

	/** ����������, ������� �� ����� ���������� "������ �������" */

	public static boolean masterclean = false;

	/** ����������, ������� �� ����� ���������� "���������-����������" */

	public static boolean nachumiv = false;

	/** ����������, ������� �� ����� ���������� "�����" */

	public static boolean cock = false;

	/** ����������, ������� �� ����� ���������� "������" */

	public static boolean gourm = false;

	/** ����������, ������� �� ����� ���������� "��������" */

	public static boolean obedalo = false;

	/** ����������, ������� �� ����� ���������� "���������" */

	public static boolean funny = false;

	/** ����������, ������� �� ����� ���������� "���� �����" */

	public static boolean youngclown = false;

	/** ����������, ������� �� ����� ���������� "������ �����������" */

	public static boolean masterfun = false;

	/** ����������, ������� �� ����� ���������� "������" */

	public static boolean fashioner = false;

	/** ������ ��������� */

	private static CharSin instance;

	/** ���������� ������, ������������ �� ���� */

	public static int maxearn = 0;

	/** ������� �� ��������� ������ */

	public static int nowWearing = -2;
	
	/**����� �� ������������ ��������� ��������*/
	
	public static boolean wantTeach=true;

	/** ��������� ��� ��������� ������� */

	public static final String HUNGER_CONDITION = "hungercond";

	/** ��������� ��� ��������� �������� */

	public static final String HEALTH_CONDITION = "healthcond";

	/** ��������� ��� ���������� ��������� */

	public static final String MOOD_CONDITION = "moodcond";

	/** ��������� ��� ���������� ������� ����� */

	public static final String WORPOINTS_CONDITION = "worpointscond";

	/** ��������� ��� ������� ������ */

	public static final String MONEY_CONDITION = "moneycond";

	/** ��������� ��� ����� ������ */

	public static final String PLAYER_NAME = "playername";

	/** ��������� ��� ������ */

	public static final String PLAYER_LEVEL = "playerlevel";
	
	/** ��������� ��� ������� �������� �� �������� � �������� */

	public static final String DESKTOPNOW = "desktopnow";

	/** ��������� ��� ���������� ������� ������������ � ���� */

	public static final String PLAYERTIMES = "playertimes";

	/** ��������� ��� ����������� ��� ������ ��������� ���������� */

	public static final String PLAYERTIMES1 = "playertimes1";

	/** ��������� ��� ����������� ��� ������� ��������� ���������� */

	public static final String PLAYERTIMES10 = "playertimes10";

	/** ��������� ��� ����������� ��� �������� ����� ��������� ���������� */

	public static final String PLAYERTIMES25 = "playertimes25";

	/** ��������� ��� ����������� ��� ����������� ��������� ���������� */

	public static final String PLAYERTIMES50 = "playertimes50";

	/** ��������� ��� ����������� ��� ����� ��������� ���������� */

	public static final String PLAYERTIMES100 = "playertimes100";

	/** ��������� ��� ����������� ��� �������������� ��������� ���������� */

	public static final String PLAYERTIMES150 = "playertimes150";

	/** ��������� ��� ����������� ��� ��������� ��������� ���������� */

	public static final String PLAYERTIMES200 = "playertimes200";

	/** ��������� ��� ����������� ��� ������ ����������� ��������� ���������� */

	public static final String PLAYERTIMES250 = "playertimes250";

	/** ��������� ��� ����������� ��� ��������� ��������� ���������� */

	public static final String PLAYERTIMES300 = "playertimes300";

	/** ��������� ��� ����������� ��� ������� "�������� ������� ��� ���������" */

	public static final String BUYWEAR1 = "wear1";

	/** ��������� ��� ����������� ��� ������� "�������� ������� ��� �������" */

	public static final String BUYWEAR2 = "wear2";

	/** ��������� ��� ����������� ��� ������� "������� ����� �������-����������" */

	public static final String BUYWEAR3 = "wear3";

	/** ��������� ��� ����������� ��� ������� "������� ����� �������-����������" */

	public static final String BUYWEAR4 = "wear4";

	/** ��������� ��� ����������� ��� ������� "������ � �������" */

	public static final String BUYWEAR5 = "wear5";

	/** ��������� ��� ����������� ��� ������� "������� ����� � ��������" */

	public static final String BUYWEAR6 = "wear6";

	/** ��������� ��� ����������� ��� ������� "������� ������" */

	public static final String BUYWEAR7 = "wear7";

	/** ��������� ��� ����������� ��� ������� "������� �������" */

	public static final String BUYWEAR8 = "wear8";

	/** ��������� ��� ����������� ��� ������� "������� ������" */

	public static final String BUYWEAR9 = "wear9";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������ �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR10 = "wear10";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ��������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR11 = "wear11";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ���������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR12 = "wear12";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR13 = "wear13";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR14 = "wear14";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������ �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR15 = "wear15";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������ �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR16 = "wear16";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ��������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR17 = "wear17";
	
	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ��������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR18 = "wear18";
	
	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������ �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR19 = "wear19";

	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ����� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR20 = "wear20";
	
	/**
	 * ��������� ��� ����������� ��� �������
	 * "������� ������� �� ��������� by BanyaBell"
	 */

	public static final String BUYWEAR21 = "wear21";
	
	/** ��������� ��� �������� �� ��������� ������� */

	public static final String WEARINGNOW = "wearnow";

	/** ��������� ��� ������������ �� ���� ������� ������ */

	public static final String MAXEARN = "maxearning";

	/** ��������� ��� �������������� � ������� ���� ���������� */

	public static final String THEMENOW = "mainmenutheme";

	/** ��������� ��� ���������� ���������� ��������� ����� � ���� "�����" */

	public static final String CURRENTSCORE = "currentscore";

	/** ��������� ��� ���������� ���������� ��������� ����� � ���� "�����" */

	public static final String RECORDSCORE = "recordscore";

	/** ��������� ��� ����������� � ��������� ������������� �������� */

	public static final String FIRSTLOBBY = "firstlobby";

	/** ��������� ��� ����������� � ��������� ������������� ����������� */

	public static final String FIRSTWEARDROBE = "firstweardrobe";

	/** ��������� ��� ����������� � ��������� ������������� ����� */

	public static final String FIRSTKITCHEN = "firstkitchen";

	/** ��������� ��� ����������� � ��������� ������������� ������ */

	public static final String FIRSTBATHROOM = "firstbathroom";

	/** ��������� ��� ����������� � ��������� ������������� ������� */

	public static final String FIRSTBEDROOM = "firstbedroom";

	/** ��������� ��� ����������� � ��������� ������������� ������� */

	public static final String FIRSTGAMEROOM = "firstgameroom";

	/** ��������� ��� ����������� � ��������� ������������� ����� */

	public static final String FIRSTSTREET = "firststreet";

	/** ��������� ��� ����������� � ��������� ������������� ����������� */

	public static final String FIRSTDRESSINGROOM = "firstdressingroom";

    /** ��������� ��� ����������� � ��������� ������������� �������� */

    public static final String FIRSTCOMPUTERROOM = "firstcomputerroom";

	/**
	 * ��������� ��� ���������� ��������, ���������� ��������� ��������
	 * ���������
	 */

	public static final String COUNTCLEAN = "cclean";

	/** ��������� ��� ���������� ��������, ���������� ������� ��������� */

	public static final String COUNTFOOD = "cfood";

	/** ��������� ��� ���������� ��������, ���������� ���������� ��������� */

	public static final String COUNTMOOD = "cmood";

	/** ��������� ��� �����������, ������ �� ����� �������� */

	public static final String TEACHING = "teaching";

	/** ��������� ��� �������� �� ��������� ������� */

	public static final String COUNTWEAR = "cwear";

	/** ��������� ��� �����������, ������ �� ����� ��������� "������ "�����"" */

	public static final String MASTERLINES = "masterlines";

	/** ��������� ��� �����������, ������ �� ����� ���������� "�������" */

	public static final String CHISTULYA = "chistulya";

	/** ��������� ��� �����������, ������ �� ����� ���������� "������ �������" */

	public static final String MASTERCLEAN = "masterclean";

	/**
	 * ��������� ��� �����������, ������ �� ����� ����������
	 * "���������-����������"
	 */

	public static final String NACHUMIV = "nachumiv";

	/** ��������� ��� �����������, ������ �� ����� ���������� "�����" */

	public static final String COCK = "cock";

	/** ��������� ��� �����������, ������ �� ����� ���������� "������" */

	public static final String GOURM = "gourm";

	/** ��������� ��� �����������, ������ �� ����� ���������� "��������" */

	public static final String OBEDALO = "obedalo";

	/** ��������� ��� �����������, ������ �� ����� ���������� "���������" */

	public static final String FUNNY = "funny";

	/** ��������� ��� �����������, ������ �� ����� ���������� "���� �����" */

	public static final String YOUNGCLOWN = "youngclown";

	/**
	 * ��������� ��� �����������, ������ �� ����� ����������
	 * "������ �����������"
	 */

	public static final String MASTERFUN = "masterfun";

	/** ��������� ��� �����������, ������ �� ����� ���������� "������" */

	public static final String FASHIONER = "fashioner";

	/** ��������� ��� �����������, ���������� �� ����������� */

	public static final String NOTIF = "notif";
	
	/**��������� ��� ����������� � ����������� ��������*/
	
	public static final String WANTTEACH="toteach";


    /**��������� ��� ����������� � ����������� ��������*/

    public static final String CLICKHOME="homeclick";
    
	/**
	 * ����, � ������� �������� �� ������� ����������� ���������
	 * SharedPreferences
	 */

	public static SharedPreferences mSettings;

	/** ��� ������, ������� �� ������� � ������� ���� */

	public static String CharName;

	/** �������� ��������� */

	private Context context;

	/** �����������, ��������� �������� */

	private CharSin() {

	}

	/** ����� ��� ��������� �������� ���������� */

	public void loadParameters(Context context) {

		/** ��������� �������� �� ������ ���������� */

		mSettings = context.getSharedPreferences("Wormy", Context.MODE_PRIVATE);

		/** ��� ������. ���� �����������, �� ������ "�����". */

		CharName = mSettings.getString(PLAYER_NAME, "�����");

		/**
		 * ������� ��������� ��������. �� ��������� - 100 ������, ������������
		 * �������.
		 */

		health = mSettings.getInt(HEALTH_CONDITION, 100);
      
		/** ������� ��������� �������. �� ��������� - �����������, 100 ������. */

		hunger = mSettings.getInt(HUNGER_CONDITION, 100);

		/**
		 * ������� ���������� ���������. �� ��������� - �����������, 100 ������.
		 */

		mood = mSettings.getInt(MOOD_CONDITION, 100);

		/** ������� ���������� ������� �����. �� ��������� - ����. */

		worpoints = mSettings.getInt(WORPOINTS_CONDITION, 0);

		/** ������� ������ ������. �� ��������� - ����. */

		money = mSettings.getInt(MONEY_CONDITION, 0);

		/** ������� �������. �� ��������� - ������. */

		level = mSettings.getInt(PLAYER_LEVEL, 1);

		/** ���������� ������� ������������ � ����. �� ��������� - ����. */

		times = mSettings.getInt(PLAYERTIMES, 0);
		
		/** ������� �������� �� �������� � ��������. �� ��������� - ����. */

		desktopNow = mSettings.getInt(DESKTOPNOW, 0);
	

		/** �����������, ���������� �� �����������. �� ��������� - true. */

		notif = mSettings.getBoolean(NOTIF, true);

		/**
		 * �����������, ������� �� ����� ���������� ���� ���. �� ��������� -
		 * false.
		 */

		times1 = mSettings.getBoolean(PLAYERTIMES1, false);

		/**
		 * �����������, ������� �� ����� ���������� ������ ���. �� ��������� -
		 * false.
		 */

		times10 = mSettings.getBoolean(PLAYERTIMES10, false);

		/**
		 * �����������, ������� �� ����� ���������� �������� ���� ���. ��
		 * ��������� - false.
		 */

		times25 = mSettings.getBoolean(PLAYERTIMES25, false);

		/**
		 * �����������, ������� �� ����� ���������� ��������� ���. �� ���������
		 * - false.
		 */

		times50 = mSettings.getBoolean(PLAYERTIMES50, false);

		/**
		 * �����������, ������� �� ����� ���������� ��� ���. �� ��������� -
		 * false.
		 */

		times100 = mSettings.getBoolean(PLAYERTIMES100, false);

		/**
		 * �����������, ������� �� ����� ���������� ��� ��������� ���. ��
		 * ��������� - false.
		 */

		times150 = mSettings.getBoolean(PLAYERTIMES150, false);

		/**
		 * �����������, ������� �� ����� ���������� ������ ���. �� ��������� -
		 * false.
		 */

		times200 = mSettings.getBoolean(PLAYERTIMES200, false);

		/**
		 * �����������, ������� �� ����� ���������� ������ ��������� ���. ��
		 * ��������� - false.
		 */

		times250 = mSettings.getBoolean(PLAYERTIMES250, false);

		/**
		 * �����������, ������� �� ����� ���������� ������ ���. �� ��������� -
		 * false.
		 */

		times300 = mSettings.getBoolean(PLAYERTIMES300, false);

		/**
		 * �����������, ����� �� ����� "������� ������ ��� ��������". ��
		 * ��������� - false.
		 */

		wear1 = mSettings.getBoolean(BUYWEAR1, false);

		/**
		 * �����������, ����� �� ����� "������� ������ ��� �������". ��
		 * ��������� - false.
		 */

		wear2 = mSettings.getBoolean(BUYWEAR2, false);

		/**
		 * �����������, ����� �� ����� "������ ����� �������-����������". ��
		 * ��������� - false.
		 */

		wear3 = mSettings.getBoolean(BUYWEAR3, false);

		/**
		 * �����������, ����� �� ����� "������ ����� �������-����������". ��
		 * ��������� - false.
		 */

		wear4 = mSettings.getBoolean(BUYWEAR4, false);

		/**
		 * �����������, ����� �� ����� "������ � �������". �� ��������� - false.
		 */

		wear5 = mSettings.getBoolean(BUYWEAR5, false);

		/**
		 * �����������, ����� �� ����� "������� ����� � ��������". �� ���������
		 * - false.
		 */

		wear6 = mSettings.getBoolean(BUYWEAR6, false);

		/** �����������, ����� �� ����� "������ ������". �� ��������� - false. */

		wear7 = mSettings.getBoolean(BUYWEAR7, false);

		/** �����������, ����� �� ����� "������ �������". �� ��������� - false. */

		wear8 = mSettings.getBoolean(BUYWEAR8, false);

		/** �����������, ����� �� ����� "������ ������". �� ��������� - false. */

		wear9 = mSettings.getBoolean(BUYWEAR9, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������ �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear10 = mSettings.getBoolean(BUYWEAR10, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ��������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear11 = mSettings.getBoolean(BUYWEAR11, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ���������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear12 = mSettings.getBoolean(BUYWEAR12, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear13 = mSettings.getBoolean(BUYWEAR13, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear14 = mSettings.getBoolean(BUYWEAR14, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������ �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear15 = mSettings.getBoolean(BUYWEAR15, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������ �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear16 = mSettings.getBoolean(BUYWEAR16, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ��������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear17 = mSettings.getBoolean(BUYWEAR17, false);
		
		/**
		 * �����������, ����� �� �����
		 * "������ ��������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear18 = mSettings.getBoolean(BUYWEAR18, false);

		/**
		 * �����������, ����� �� �����
		 * "������ ������ �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear19 = mSettings.getBoolean(BUYWEAR19, false);
		
		/**
		 * �����������, ����� �� �����
		 * "������ ����� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear20 = mSettings.getBoolean(BUYWEAR20, false);
		
		/**
		 * �����������, ����� �� �����
		 * "������ ������� �� ��������� by BanyaBell". �� ��������� - false.
		 */

		wear21 = mSettings.getBoolean(BUYWEAR21, false);
		
		/**
		 * ������� ������ �� ���������. �� ��������� -2, ��� �������������
		 * ���������-�������.
		 */

		nowWearing = mSettings.getInt(WEARINGNOW, -2);

		/** ���������� ������������ �� ���� ������. �� ��������� - ����. */

		maxearn = mSettings.getInt(MAXEARN, 0);

		/**
		 * ���������� �������� ����. �� ��������� 1, ��� �������������
		 * ����������� ����.
		 */

		themeNow = mSettings.getInt(THEMENOW, 1);

		/**
		 * ��������� ���������� ��������� ����� � ���� "�����". �� ��������� -
		 * ����.
		 */

		curlinesscore = mSettings.getInt(CURRENTSCORE, 0);

		/**
		 * ��������� ���������� ��������� ����� � ���� "�����". �� ��������� -
		 * ����.
		 */

		reclinesscore = mSettings.getInt(RECORDSCORE, 0);
		
		/** �����������, ������� �� ��� ����� ��������. �� ��������� - false. */

		firstlobby = mSettings.getBoolean(FIRSTLOBBY, false);

		/** �����������, ������� �� ��� ����� �����������. �� ��������� - false. */

		firstweardrobe = mSettings.getBoolean(FIRSTWEARDROBE, false);

		/** �����������, ������� �� ��� ����� �����. �� ��������� - false. */

		firstkitchen = mSettings.getBoolean(FIRSTKITCHEN, false);

		/** �����������, ������� �� ��� ����� ������. �� ��������� - false. */

		firstbathroom = mSettings.getBoolean(FIRSTBATHROOM, false);

		/** �����������, ������� �� ��� ����� �������. �� ��������� - false. */

		firstbedroom = mSettings.getBoolean(FIRSTBEDROOM, false);

		/** �����������, ������� �� ��� ����� �������. �� ��������� - false. */

		firstgameroom = mSettings.getBoolean(FIRSTGAMEROOM, false);

		/** �����������, ������� �� ��� ����� ����. �� ��������� - false. */

		firststreet = mSettings.getBoolean(FIRSTSTREET, false);

		/** �����������, ������� �� ��� ����� �����������. �� ��������� - false. */

		firstdressingroom = mSettings.getBoolean(FIRSTDRESSINGROOM, false);

        /** �����������, ������� �� ��� ����� �������. �� ��������� - false. */

        firstcomputerroom = mSettings.getBoolean(FIRSTCOMPUTERROOM, false);

		/**
		 * �����������, ������ �� ����� AlertDialog �� ��������� ��������. ��
		 * ��������� - false.
		 */

		teaching = mSettings.getBoolean(TEACHING, false);

		/**
		 * ���������� ����������� ������� ��������, ���������� ���������
		 * �������� ��������. �� ��������� - ����.
		 */

		countclean = mSettings.getInt(COUNTCLEAN, 0);

		/**
		 * ���������� ����������� ������� ��������, ���������� ������� ��������.
		 * �� ��������� - ����.
		 */

		countfood = mSettings.getInt(COUNTFOOD, 0);

		/**
		 * ���������� ����������� ������� ��������, ���������� ����������
		 * ��������. �� ��������� - ����.
		 */

		countmood = mSettings.getInt(COUNTMOOD, 0);

		/** ���������� ��������� ��������. �� ��������� - ����. */

		countwear = mSettings.getInt(COUNTWEAR, 0);

		/**
		 * �����������, ������ �� ����� ���������� "������ "�����"". ��
		 * ��������� - false.
		 */

		masterlines = mSettings.getBoolean(MASTERLINES, false);

		/**
		 * �����������, ������ �� ����� ���������� "�������". �� ��������� -
		 * false.
		 */

		chistulya = mSettings.getBoolean(CHISTULYA, false);

		/**
		 * �����������, ������ �� ����� ���������� "������ �������". ��
		 * ��������� - false.
		 */

		masterclean = mSettings.getBoolean(MASTERCLEAN, false);

		/**
		 * �����������, ������ �� ����� ���������� "���������-����������". ��
		 * ��������� - false.
		 */

		nachumiv = mSettings.getBoolean(NACHUMIV, false);

		/**
		 * �����������, ������ �� ����� ���������� "�����". �� ��������� -
		 * false.
		 */

		cock = mSettings.getBoolean(COCK, false);

		/**
		 * �����������, ������ �� ����� ���������� "������". �� ��������� -
		 * false.
		 */

		gourm = mSettings.getBoolean(GOURM, false);

		/**
		 * �����������, ������ �� ����� ���������� "��������". �� ��������� -
		 * false.
		 */

		obedalo = mSettings.getBoolean(OBEDALO, false);

		/**
		 * �����������, ������ �� ����� ���������� "���������". �� ��������� -
		 * false.
		 */

		funny = mSettings.getBoolean(FUNNY, false);

		/**
		 * �����������, ������ �� ����� ���������� "���� �����". �� ��������� -
		 * false.
		 */

		youngclown = mSettings.getBoolean(YOUNGCLOWN, false);

		/**
		 * �����������, ������ �� ����� ���������� "������ �����������". ��
		 * ��������� - false.
		 */

		masterfun = mSettings.getBoolean(MASTERFUN, false);

		/**
		 * �����������, ������ �� ����� ���������� "������". �� ��������� -
		 * false.
		 */

		fashioner = mSettings.getBoolean(FASHIONER, false);
		
		/**�����������, ����� �� ����� ��������� ��������. �� ��������� - true.*/

		wantTeach=mSettings.getBoolean(WANTTEACH, true);

        /**���������� ������� ������ �� ������ "������!". �� ��������� - ����.*/

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
	 * ���������� � ��������� ����� �������� ��������, � ����� ���������� ������
	 * � ������� ������� �� �����
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
	 * ���������� � ��������� ����� �������� �������, � ����� ���������� ������
	 * � ������� ������� �� �����
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
	 * ���������� � ��������� ����� �������� ���������, � ����� ����������
	 * ������ � ������� ������� �� �����
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
	 * ���������� � ��������� ����� �������� ������� �����, � ����� ����������
	 * ������ � ������� ������� �� �����
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
	 * ���������� � ��������� ����� ��������, ��������������� ������� �������� �� �������� � ��������
	 */

	public int setDesktopNow(int dn) {

        desktopNow= dn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(DESKTOPNOW, desktopNow);

		editor.apply();

		return desktopNow;

	}
	
	/**
	 * ���������� � ��������� ����� �������� ������� ������, � ����� ����������
	 * ������ � ������� ������� �� �����
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
	 * ���������� � ��������� ����� ��� ������, � ����� ���������� ������ �
	 * ������� ������� �� �����
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
	 * ���������� � ��������� ����� �������� ������ ������, � ����� ����������
	 * ������ � ������� ������� �� �����
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
	 * ���������� � ��������� ����� �������� ���������� ������� ������������ �
	 * ����,
	 * 
	 * � ����� ���������� ������ � ������� ������� �� �����
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
	 * �������������, ��� ����� �����/�� ����� � ���� � ������ ��� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setTB1(boolean tmb) {

		times1 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES1, times1);

		editor.apply();

		return times1;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB10(boolean tmb) {

		times10 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES10, times10);

		editor.apply();

		return times10;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � �������� ����� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB25(boolean tmb) {

		times25 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES25, times25);

		editor.apply();

		return times25;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ����������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB50(boolean tmb) {

		times50 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES50, times50);

		editor.apply();

		return times50;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ����� ��� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setTB100(boolean tmb) {

		times100 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES100, times100);

		editor.apply();

		return times100;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � �������������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB150(boolean tmb) {

		times150 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES150, times150);

		editor.apply();

		return times150;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ��������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB200(boolean tmb) {

		times200 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES200, times200);

		editor.apply();

		return times200;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ������ ����������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB250(boolean tmb) {

		times250 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES250, times250);

		editor.apply();

		return times250;

	}

	/** �������������, ����� �� ����� ������ ����������� */

	public boolean setNotify(boolean n) {

		notif = n;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(NOTIF, notif);

		editor.apply();

		return notif;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "������ "�����"" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setMasterlines(boolean ml) {

		masterlines = ml;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERLINES, masterlines);

		editor.apply();

		return masterlines;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "�������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setChistulya(boolean ch) {

		chistulya = ch;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(CHISTULYA, chistulya);

		editor.apply();

		return chistulya;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "������ �������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setMasterclean(boolean tmb) {

		masterclean = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERLINES, masterclean);

		editor.apply();

		return masterclean;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ����������
	 * "���������-����������" � ����������� �� �������� �������� ���������
	 */

	public boolean setNachumiv(boolean tmb) {

		nachumiv = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(NACHUMIV, nachumiv);

		editor.apply();

		return nachumiv;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "�����" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setCock(boolean tmb) {

		cock = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(COCK, cock);

		editor.apply();

		return cock;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setGourm(boolean tmb) {

		gourm = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(GOURM, gourm);

		editor.apply();

		return gourm;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "��������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setObedalo(boolean tmb) {

		obedalo = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(OBEDALO, obedalo);

		editor.apply();

		return obedalo;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "���������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setFunny(boolean tmb) {

		funny = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FUNNY, funny);

		editor.apply();

		return funny;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "���� �����" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setYoungclown(boolean tmb) {

		youngclown = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(YOUNGCLOWN, youngclown);

		editor.apply();

		return youngclown;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ����������
	 * "������ �����������" � ����������� �� �������� �������� ���������
	 */

	public boolean setMasterfun(boolean tmb) {

		masterfun = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(MASTERFUN, masterfun);

		editor.apply();

		return masterfun;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���������� "������" �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setFashioner(boolean tmb) {

		fashioner = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FASHIONER, fashioner);

		editor.apply();

		return fashioner;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� � ���� � ��������� ��� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setTB300(boolean tmb) {

		times300 = tmb;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(PLAYERTIMES300, times300);

		editor.apply();

		return times300;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� �������� ������� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setFirstLobby(boolean fl) {

		firstlobby = fl;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTLOBBY, firstlobby);

		editor.apply();

		return firstlobby;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ����������� ������� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setFirstWeardrobe(boolean fw) {

		firstweardrobe = fw;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTWEARDROBE, firstweardrobe);

		editor.apply();

		return firstweardrobe;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ����� ������� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setFirstKitchen(boolean fk) {

		firstkitchen = fk;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTKITCHEN, firstkitchen);

		editor.apply();

		return firstkitchen;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ������ ������� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setFirstBathroom(boolean fba) {

		firstbathroom = fba;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTBATHROOM, firstbathroom);

		editor.apply();

		return firstbathroom;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ������� ������� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setFirstBedroom(boolean fbe) {

		firstbedroom = fbe;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTBEDROOM, firstbedroom);

		editor.apply();

		return firstbedroom;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ������� ������� � �����������
	 * �� �������� �������� ���������
	 */

	public boolean setFirstGameroom(boolean fg) {

		firstgameroom = fg;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTGAMEROOM, firstgameroom);

		editor.apply();

		return firstgameroom;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ���� ������� � ����������� ��
	 * �������� �������� ���������
	 */

	public boolean setFirstStreet(boolean fs) {

		firststreet = fs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTSTREET, firststreet);

		editor.apply();

		return firststreet;

	}

	/**
	 * �������������, ��� ����� �������/�� ������� ����������� ������� �
	 * ����������� �� �������� �������� ���������
	 */

	public boolean setFirstDressingroom(boolean fs) {

		firstdressingroom = fs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(FIRSTDRESSINGROOM, firstdressingroom);

		editor.apply();

		return firstdressingroom;

	}

    /**
     * �������������, ��� ����� �������/�� ������� ������� ������� �
     * ����������� �� �������� �������� ���������
     */

    public boolean setFirstComputerroom(boolean cr) {

        firstcomputerroom = cr;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putBoolean(FIRSTCOMPUTERROOM, firstcomputerroom);

        editor.apply();

        return firstcomputerroom;

    }

	/**
	 * �������������, ��� ����� ������/�� ������ AlertDialog �� ���������
	 * ��������
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setTeaching(boolean t) {

		teaching = t;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(TEACHING, teaching);

		editor.apply();

		return teaching;

	}
	/**
	 * �������������, ��� ����� �����/�� ����� ���������
	 * �������� � ����������� �� �������� �������� ���������
	 */

	public boolean setWantTeach(boolean wt) {

		wantTeach = wt;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(WANTTEACH, wantTeach);

		editor.apply();

		return wantTeach;

	}
	/**
	 * �������������, ��� ����� �����/�� ����� "������� ������ ��� ��������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear1(boolean w) {

		wear1 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR1, wear1);

		editor.apply();

		return wear1;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������� ������ ��� �������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear2(boolean w) {

		wear2 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR2, wear2);

		editor.apply();

		return wear2;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ ����� �������-����������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear3(boolean w) {

		wear3 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR3, wear3);

		editor.apply();

		return wear3;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ ����� �������-����������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear4(boolean w) {

		wear4 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR4, wear4);

		editor.apply();

		return wear4;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ � �������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear5(boolean w) {

		wear5 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR5, wear5);

		editor.apply();

		return wear5;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������� ����� � ��������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear6(boolean w) {

		wear6 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR6, wear6);

		editor.apply();

		return wear6;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ ������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear7(boolean w) {

		wear7 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR7, wear7);

		editor.apply();

		return wear7;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ �������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear8(boolean w) {

		wear8 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR8, wear8);

		editor.apply();

		return wear8;

	}

	/**
	 * �������������, ��� ����� �����/�� ����� "������ ������"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear9(boolean w) {

		wear9 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR9, wear9);

		editor.apply();

		return wear9;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear10(boolean w) {

		wear10 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR10, wear10);

		editor.apply();

		return wear10;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear11(boolean w) {

		wear11 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR11, wear11);

		editor.apply();

		return wear11;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ���������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear12(boolean w) {

		wear12 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR12, wear12);

		editor.apply();

		return wear12;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear13(boolean w) {

		wear13 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR13, wear13);

		editor.apply();

		return wear13;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear14(boolean w) {

		wear14 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR14, wear14);

		editor.apply();

		return wear14;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear15(boolean w) {

		wear15 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR15, wear15);

		editor.apply();

		return wear15;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear16(boolean w) {

		wear16 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR16, wear16);

		editor.apply();

		return wear16;

	}

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear17(boolean w) {

		wear17 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR17, wear17);

		editor.apply();

		return wear17;

	}
	

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear18(boolean w) {

		wear18 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR18, wear18);

		editor.apply();

		return wear18;

	}


	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear19(boolean w) {

		wear19 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR19, wear19);

		editor.apply();

		return wear19;

	}
	

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ����� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear20(boolean w) {

		wear20 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR20, wear20);

		editor.apply();

		return wear20;

	}
	

	/**
	 * �������������, ��� ����� �����/�� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 * 
	 * � ����������� �� �������� �������� ���������
	 */

	public boolean setWear21(boolean w) {

		wear21 = w;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putBoolean(BUYWEAR21, wear21);

		editor.apply();

		return wear21;

	}
	
	/**
	 * ������������� �����, ��������������� ������������� �������, � ����������
	 * ������ � ������� �������
	 */

	public int setNowWearing(int wn) {

		new mAsyncTask().execute();

		nowWearing = wn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(WEARINGNOW, nowWearing);

		editor.apply();

		return nowWearing;

	}

	/** ������������� ���������� ��� ������������ �� ������ ���� ������ */

	public int setMaxEarn(int me) {

		maxearn += me;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MAXEARN, maxearn);

		editor.apply();

		return maxearn;

	}

	/**
	 * ������������� �����, ��������������� ������������� ���������� ��������
	 * ����
	 */

	public int setThemeNow(int tn) {

		themeNow = tn;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(THEMENOW, themeNow);

		editor.apply();

		return themeNow;

	}

	/** ��������� ���������� ��������� ����� � ���� "�����" */

	public int setCurrentScore(int crs) {

		curlinesscore = crs;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(CURRENTSCORE, curlinesscore);

		editor.apply();

		return curlinesscore;

	}

	/** ��������� ���������� ��������� ����� � ���� "�����" */

	public int setRecordScore(int rds) {

		reclinesscore = rds;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(RECORDSCORE, reclinesscore);

		editor.apply();

		return reclinesscore;

	}

	/**
	 * ���������� ����������� ��������, ������������ �� ��������� ���������
	 * �������� ���������
	 */

	public int setCclean(int cc) {

		countclean += cc;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTCLEAN, countclean);

		editor.apply();

		return countclean;

	}

	/**
	 * ���������� ����������� ��������, ������������ �� ��������� �������
	 * ���������
	 */

	public int setCfood(int cf) {

		countfood += cf;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTFOOD, countfood);

		editor.apply();

		return countfood;

	}

	/**
	 * ���������� ����������� ��������, ������������ �� ��������� ����������
	 * ���������
	 */

	public int setCmood(int cm) {

		countmood += cm;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTMOOD, countmood);

		editor.apply();

		return countmood;

	}

	/** ���������� ��������� �������� */

	public int setCwear(int cw) {

		countwear += cw;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(COUNTWEAR, countwear);

		editor.apply();

		return countwear;

	}

    /** ��������� ���������� ������� ������ �� ������ "������! */

    public int setClickhome(int ch) {

        clickhome += ch;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putInt(CLICKHOME, clickhome);

        editor.apply();

        return clickhome;

    }

	/** ��������� �������� �������� �������� ��������� */

	public int getHealth() {

		return health;

	}

	/** ��������� �������� �������� ������� ��������� */

	public int getHunger() {

		return hunger;

	}

	/** ��������� �������� �������� ���������� ��������� */

	public int getMood() {

		return mood;

	}

	/** ��������� �������� ������ ��������� */

	public int getLevel() {
		return level;
	}
	
	/** ��������� �������� ���������� ������� ����� ��������� */

	public int getWorpoints() {

		return worpoints;

	}

	/** ��������� �������� ������� ��������� � ���� ����� */

	public int getMoney() {
		return money;
	}

	/** ��������� �������� ������� ��������� � ���� ������ */

	public String getStrMoney() {
		return String.valueOf(money);
	}

	/** ��������� ����� ������ */

	public String getCharName() {
		return CharName;
	}

	/** ��������� ���������� ������� ������ � ���� */

	public int getTimes() {
		return times;
	}

	/** ���������� true, ���� ����� ������� � ���� 1 � ����� ��� */

	public boolean getTB1() {
		return times1;
	}

	/** ���������� true, ���� ����� ������� � ���� 10 � ����� ��� */

	public boolean getTB10() {
		return times10;
	}

	/** ���������� true, ���� ����� ������� � ���� 25 � ����� ��� */

	public boolean getTB25() {
		return times25;
	}

	/** ���������� true, ���� ����� ������� � ���� 50 � ����� ��� */

	public boolean getTB50() {
		return times50;
	}

	/** ���������� true, ���� ����� ������� � ���� 100 � ����� ��� */

	public boolean getTB100() {
		return times100;
	}

	/** ���������� true, ���� ����� ������� � ���� 150 � ����� ��� */

	public boolean getTB150() {
		return times150;
	}

	/** ���������� true, ���� ����� ������� � ���� 200 � ����� ��� */

	public boolean getTB200() {
		return times200;
	}

	/** ���������� true, ���� ����� ������� � ���� 250 � ����� ��� */

	public boolean getTB250() {
		return times250;
	}

	/** ���������� true, ���� ����� ������� � ���� 300 � ����� ��� */

	public boolean getTB300() {
		return times300;
	}

	/** ���������� true, ���� ����� ��������� ������ ��� ������ �����������. */

	public boolean getNotify() {
		return notif;
	}

	/** ���������� true, ���� ����� ����� "������� ������ ��� ��������" */

	public boolean getWear1() {
		return wear1;
	}

	/** ���������� true, ���� ����� ����� "������� ������ ��� �������" */

	public boolean getWear2() {
		return wear2;
	}

	/** ���������� true, ���� ����� ����� "������ ����� �������-����������" */

	public boolean getWear3() {
		return wear3;
	}

	/** ���������� true, ���� ����� ����� "������ ����� �������-����������" */

	public boolean getWear4() {
		return wear4;
	}

	/** ���������� true, ���� ����� ����� "������� ������ � �������" */

	public boolean getWear5() {
		return wear5;
	}

	/** ���������� true, ���� ����� ����� "������� ����� � ��������" */

	public boolean getWear6() {
		return wear6;
	}

	/** ���������� true, ���� ����� ����� "������ ������" */

	public boolean getWear7() {
		return wear7;
	}

	/** ���������� true, ���� ����� ����� "������ �������" */

	public boolean getWear8() {
		return wear8;
	}

	/** ���������� true, ���� ����� ����� "������ ������" */

	public boolean getWear9() {
		return wear9;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 */

	public boolean getWear10() {
		return wear10;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 */

	public boolean getWear11() {
		return wear11;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ���������� �� ��������� by BanyaBell"
	 */

	public boolean getWear12() {
		return wear12;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 */

	public boolean getWear13() {
		return wear13;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 */

	public boolean getWear14() {
		return wear14;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 */

	public boolean getWear15() {
		return wear15;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 */

	public boolean getWear16() {
		return wear16;
	}

	/**
	 * ���������� true, ���� ����� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 */

	public boolean getWear17() {
		return wear17;
	}
	
	/**
	 * ���������� true, ���� ����� �����
	 * "������ ��������� �� ��������� by BanyaBell"
	 */

	public boolean getWear18() {
		return wear18;
	}
	
	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������ �� ��������� by BanyaBell"
	 */

	public boolean getWear19() {
		return wear19;
	}
	
	/**
	 * ���������� true, ���� ����� �����
	 * "������ ����� �� ��������� by BanyaBell"
	 */

	public boolean getWear20() {
		return wear20;
	}
	
	/**
	 * ���������� true, ���� ����� �����
	 * "������ ������� �� ��������� by BanyaBell"
	 */

	public boolean getWear21() {
		return wear21;
	}

	/** ���������� �����, ��������������� �������� ������� �� ���������" */

	public int getNowWearing() {
		return nowWearing;
	}

	/** ���������� ���������� ��� ������������ �� ���� ������� ������" */

	public int getMaxEarn() {
		return maxearn;
	}

	/**
	 * ���������� �����, ��������������� �������������� ���������� ������� ����"
	 */

	public int getThemeNow() {
		return themeNow;
	}

	/**
	 * ���������� ���������� ��������� ��������� ����� � ���� "�����" � ����
	 * �����
	 */

	public int getCurrentScore() {
		return curlinesscore;
	}
	
	/**
	 * ���������� �����, ��������������� ������� �������� �� �������� � �������� 
	 */

	public int getDesktopNow() {
		return desktopNow;
	}

	/**
	 * ���������� ���������� ��������� ��������� ����� � ���� "�����" � ����
	 * ������
	 */

	public String getStrCurrentScore() {
		return String.valueOf(curlinesscore);
	}

	/**
	 * ���������� ��������� ���������� ��������� ����� � ���� "�����" � ����
	 * �����
	 */

	public int getRecordScore() {
		return reclinesscore;
	}

	/**
	 * ���������� ��������� ���������� ��������� ����� � ���� "�����" � ����
	 * ������
	 */

	public String getStrRecordScore() {
		return String.valueOf(reclinesscore);
	}

	public boolean getFirstLobby() {
		return firstlobby;
	}

	/** ���������� true, ���� ����� ��� ��� ������� � ����������� */

	public boolean getFirstWeardrobe() {
		return firstweardrobe;
	}

	/** ���������� true, ���� ����� ��� ��� ������� �� ����� */

	public boolean getFirstKitchen() {
		return firstkitchen;
	}

	/** ���������� true, ���� ����� ��� ��� ������� � ������ */

	public boolean getFirstBathroom() {
		return firstbathroom;
	}

	/** ���������� true, ���� ����� ��� ��� ������� � ������� */

	public boolean getFirstBedroom() {
		return firstbedroom;
	}

	/** ���������� true, ���� ����� ��� ��� ������� � ������� */

	public boolean getFirstGameroom() {
		return firstgameroom;
	}

	/** ���������� true, ���� ����� ��� ��� ������� �� ����� */

	public boolean getFirstStreet() {
		return firststreet;
	}

	/** ���������� true, ���� ����� ��� ��� ������� � ����������� */

	public boolean getFirstDressingroom() {
		return firstdressingroom;
	}

    /** ���������� true, ���� ����� ��� ��� ������� � �������� */

    public boolean getFirstComputerroom() {
        return firstcomputerroom;
    }

	/** ���������� true, ���� ����� ��� ������ AlertDialog �� ��������� �������� */

	public boolean getTeaching() {
		return teaching;
	}
	
	/** ���������� true, ���� ����� ����� ��������� ��������(�������� ��������������� ������) */

	public boolean getWantTeach() {
		return wantTeach;
	}

	/**
	 * ���������� ���������� ����������� ��������, ������������ �� ���������
	 * ��������� �������� ���������
	 */

	public int getCclean() {
		return countclean;
	}

	/**
	 * ���������� ���������� ����������� ��������, ������������ �� ���������
	 * ������� ���������
	 */

	public int getCfood() {
		return countfood;
	}

	/**
	 * ���������� ���������� ����������� ��������, ������������ �� ���������
	 * ���������� ���������
	 */

	public int getCmood() {
		return countmood;
	}

	/**
	 * ���������� ���������� ����������� ��������, ������������ �� ���������
	 * ��������� �������� ���������
	 */

	public int getCwear() {
		return countwear;
	}

    /**
     * ���������� ���������� ������� ������ �� ������ "������!"
     */

    public int getClickhome() {
        return clickhome;
    }


    /** �������� ���������� ������������ �� ���� ������� ������ */

	public int ClearMaxEarn() {

		maxearn = 0;

		SharedPreferences.Editor editor = mSettings.edit();

		editor.putInt(MAXEARN, maxearn);

		editor.apply();

		return maxearn;

	}

	/**
	 * ������� toast � ���, ��� � ������ �� ������� ������� ������ ���
	 * ���������� �������.
	 */

	public void toastNoMoney(Context ct) {
		SuperToast.create(ct, "��� ������� ���� �� ������� ��������!", SuperToast.Duration.LONG, 
        	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	

	}

	/**
	 * ������� toast � ���, ��� � ��������� ������� ������ ������� ���������
	 * ���������� ��� ���� ����� ��� �����������.
	 */

	public void toastIll(Context ct) {
		SuperToast.create(ct, "���� �������� �������, ��� ������ �� �� ������!", SuperToast.Duration.VERY_SHORT, 
        	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
	}


	/**
	 * ������� ��������� AlertDialog. ����������� ���������, �������� ����� �
	 * ������.
	 */

	public void TeachAlertDialog(Context context, String ttl, String msg, int icn) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(ttl);
		alertDialog.setMessage(msg);
		alertDialog.setIcon(icn);
		alertDialog.show();

	}

	/**
	 * � ����������� �� �����, ����������� � ����������, ���������� �� �������
	 * ������, �������� ��� �� ���������.
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

	/** �������� ���������. */

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

	/** ������� AlertDialog � ���, ��� �������� ��������. */
	public void teach(Context ct) {

		if (getFirstLobby() == true && getFirstWeardrobe() == true
				&& getFirstBathroom() == true && getFirstBedroom() == true

				&& getFirstGameroom() == true && getFirstStreet() == true
				&& getFirstKitchen() == true && getFirstComputerroom() == true && getTeaching() == false) {

			CongratsAlertDialog(
					ct,
					"�������� ��������!",
					"�� ���� �������� ���������, �������! �� ��� � ���� ���� ��� 100 �������� � 100 ������� ������! ���� � ���� �������� �����-�� �������, �� ����������� ������� � ������ ''������'', ������� ����� �������, ����� �� ����������� ������ � ������� ����. � ���� � ��� ������ �� ���� ������ ���, �� ����� ����� �� ����������� ���� ����, ������ �� ������� ��������� � ������� ''� ���������'', � ����� ������ ����� ���������, ���������������� ������ ��� �������� ����� � ������ ����� ��������. �� ����������� ���� ������� � ��������� �����!",

					R.drawable.alert_icon, "���!", 100, 100);

			setTeaching(true);
		}

	}
	/**���������/���������� ������ ��������� AlertDialog-�� � ��������*/
public void TeachChanger(Context ct, CheckBox chb){
    if(chb.isChecked()) {
        setWantTeach(true);
        chb.setChecked(true);
        SuperToast.create(ct, "�������� ��������!", SuperToast.Duration.VERY_SHORT, 
        	    Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
    }
    else  {setWantTeach(false); chb.setChecked(false);
    SuperToast.create(ct, "�������� ���������!", SuperToast.Duration.VERY_SHORT, 
    	    Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();}
}
    /**
	 * �������� AlertDialog � ��������������, ��������� ��������� ����������
	 * ������� ����� � ������, ������� ���� ������.
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
	 * �����, ����������� ��� �������� ������ �� ������. ���������� � ����
	 * AsyncTask, ������ ��� ������
	 * 
	 * ������ ������������ ���������� �� �������� ������.
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
	 * �����, � ������� �������� ���������� ���������� � �������� � ��������
	 * ������.
	 */

	/**����� ��� �������� ����������� �� ������*/
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

	/**����� ��� �������� ����� �� ������*/
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
