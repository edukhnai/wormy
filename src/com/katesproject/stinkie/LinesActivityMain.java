package com.katesproject.stinkie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**�����, ���������� �� ��������, ������������ � �������� ����-���� "�����" */
public class LinesActivityMain extends Activity {
/**�����������, ������������ �� ��������� ����*/
	ImageView win1, gettedscores, recordscores;
	/**������ ����������� � ������� �������*/
	Button backlines;
	/**��������� ���� � ���������� ������*/
	TextView scoreView;
	/**��������� ���� � ��������� ����������� ����� � ������� ������������*/
	TextView scoreRView;
	/**����, ������ ��� �������� �������, ������������ ��� ����*/
	CountDownTimer timer;
	/**�������� ������ ����������*/
	Context ctxt;
	/**����, � ������� �������� ����� �������� ������ �� ���������*/
	CharSin cs;


	/**������������� �����, ������ ����-����, �������� ����������� �������, ���� �� ���� ��� ��� ���������.
	 * �� ������ ������ ���������� �����������, ��������� ���� � ������� ����������� ����� � ��������,
	 * ������ ����������� � �������.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lines_last);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		LinesView.pubMode=LinesConsts.RUNNING;
		cs=CharSin.getInstance(getApplicationContext());
		win1=(ImageView)findViewById(R.id.win1);
		backlines=(Button)findViewById(R.id.backlines);
		scoreView=(TextView)findViewById(R.id.scoreView);
		scoreRView=(TextView)findViewById(R.id.scoreRView);
		gettedscores=(ImageView)findViewById(R.id.gettedscores);
		recordscores=(ImageView)findViewById(R.id.recordscores);
		win1.setVisibility(View.INVISIBLE);
		backlines.setVisibility(View.INVISIBLE);
		gettedscores.setVisibility(View.INVISIBLE);
		recordscores.setVisibility(View.INVISIBLE);
		scoreView.setVisibility(View.INVISIBLE);
		scoreRView.setVisibility(View.INVISIBLE);
		timer = new CountDownTimer(900000000, 100) {
			public void onTick(long millisUntilFinished) {
				if (LinesView.pubMode == LinesConsts.RUNNING){
					win1.setVisibility(View.INVISIBLE);
					backlines.setVisibility(View.INVISIBLE);
					gettedscores.setVisibility(View.INVISIBLE);
					recordscores.setVisibility(View.INVISIBLE);
					scoreView.setVisibility(View.INVISIBLE);
					scoreRView.setVisibility(View.INVISIBLE);
				}
				else if (LinesView.pubMode == LinesConsts.LOSE) {
					win1.setVisibility(View.VISIBLE);
					backlines.setVisibility(View.VISIBLE);
					gettedscores.setVisibility(View.VISIBLE);
					recordscores.setVisibility(View.VISIBLE);
					scoreView.setVisibility(View.VISIBLE);
					scoreView.setText(cs.getStrCurrentScore());
					scoreRView.setVisibility(View.VISIBLE);
					scoreRView.setText(cs.getStrRecordScore());}
				}

			public void onFinish() {
				timer.start();
			}
		};
		timer.start();}
/**�����, ����������� ������ �� ����-���� � ������� �������*/
	public void backgame(View v){
		Intent intent=new Intent(LinesActivityMain.this, GameroomActivity.class);
		startActivity(intent);
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