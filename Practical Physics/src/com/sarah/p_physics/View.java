package com.sarah.p_physics;

import java.text.DecimalFormat;

import com.sarah.p_physics.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class View extends Activity {
	
	private String jawabanBenar, jawabanSalah, score;
	private TextView Score, Benar, Salah;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		Bundle b = getIntent().getExtras();
		jawabanBenar = b.getString("JAWABAN_BENAR");
		jawabanSalah = b.getString("JAWABAN_SALAH");
		score = b.getString("SCORE");
		Score = (TextView) findViewById(R.id.textView2);
		Benar = (TextView) findViewById(R.id.textView3);
		Salah = (TextView) findViewById(R.id.textView4);
		
		Score.setText(score);
		Benar.setText(jawabanBenar);
		Salah.setText(jawabanSalah);
		
		Double scoreStatus = Double.valueOf(score);
		
		if(scoreStatus == .00){
			Score.setText("0");
		}
		if (scoreStatus == 100.00) {
			Score.setText(score.replace(".00", ""));
		}
		if (scoreStatus > 60.00) {
			Score.setTextColor(Color.parseColor("#00B800"));
		} else {
			Score.setTextColor(Color.parseColor("#E60000"));

		}
	}

	
}


