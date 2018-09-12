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

/**Класс, отвечающий за действия, происходящие в разметке мини-игры "Линии" */
public class LinesActivityMain extends Activity {
/**Изображение, появляющееся по окончании игры*/
	ImageView win1, gettedscores, recordscores;
	/**Кнопка возвращения в игровую комнату*/
	Button backlines;
	/**Текстовое поле с набранными очками*/
	TextView scoreView;
	/**Текстовое поле с рекордным количеством очков у данного пользователя*/
	TextView scoreRView;
	/**Поле, нужное для создания таймера, проверяющего ход игры*/
	CountDownTimer timer;
	/**Контекст данной активности*/
	Context ctxt;
	/**Поле, с помощью которого можно получать данные из синглтона*/
	CharSin cs;


	/**Инициализация полей, запуск мини-игры, проверка посредством таймера, идет ли игра или она закончена.
	 * Во втором случае появляются изображения, текстовые поля с текущим количеством очков и рекордом,
	 * кнопка возвращения в игровую.*/
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
/**Метод, переносящий игрока из мини-игры в игровую комнату*/
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