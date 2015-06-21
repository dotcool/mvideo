package com.ejia.abplayer;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.ejia.abplayer.fragment.OnlineFragment;
import com.ejia.abplayer.R;
import com.umeng.analytics.MobclickAgent;

public class TVActivity extends ActionBarActivity{
	private View backButton;
	private TextView titleText;
	private OnlineFragment online = new OnlineFragment();
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		 requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_video_info);
	        
	        if (savedInstanceState == null) {
	            getSupportFragmentManager().beginTransaction()
	                    .add(R.id.container, online)
	                    .commit();
	        }
	        backButton = findViewById(R.id.logobutton);
			titleText = (TextView) findViewById(R.id.textViewTitle);
			titleText.setText("网络电视");
			backButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			
	    }
		protected void onResume() {
			super.onResume();
			MobclickAgent.onResume(this);
		}

		protected void onPause() {
			super.onPause();
			MobclickAgent.onPause(this);
		}

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    @Override
	    public void onBackPressed() {
			if (online.onBackPressed())
				return;
			else
				super.onBackPressed();
	    }
}
