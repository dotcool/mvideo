package com.ejia.abplayer;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import cn.jpush.android.api.JPushInterface;

import com.ejia.abplayer.adapter.MainTabAdapter;
import com.isnc.facesdk.SuperID;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;
import com.viewpagerindicator.PageIndicator;

public class MainActivity extends ActionBarActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentPagerAdapter adapter = new MainTabAdapter(
				getSupportFragmentManager());
		// 视图切换器
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setOffscreenPageLimit(1);
		pager.setAdapter(adapter);

		// 页面指示器
		PageIndicator indicator = (PageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		
		SuperID.initFaceSDK(this);
		UmengUpdateAgent.update(this);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	protected void onResume() {
		super.onResume();
		JPushInterface.onResume(MainActivity.this);
		MobclickAgent.onResume(this);
	}

	protected void onPause() {
		super.onPause();
		JPushInterface.onPause(MainActivity.this);
		MobclickAgent.onPause(this);
	}
	/**
	 * On key up.
	 * 
	 * @param keyCode
	 *            the key code
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			show_existDialog();
			return false;
		} else {
			return true;
		}
	}

	private void show_existDialog() {
		// 弹出退出对话框
		Builder dialog = new AlertDialog.Builder(MainActivity.this)
				.setMessage("您确定要退出吗？")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// 退出程序
						finish();
					}
				})
				.setNegativeButton("支持我",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
							}
						});
		dialog.show();
	}

	public void onBackPressed() {
		// 如果有需要，可以点击后退关闭插播广告。
		// if (!SpotManager.getInstance(this).disMiss()) {
		// // 弹出退出窗口，可以使用自定义退屏弹出和回退动画,参照demo,若不使用动画，传入-1
		// super.onBackPressed();
		// }
	}

	@Override
	protected void onStop() {
		// 如果不调用此方法，则按home键的时候会出现图标无法显示的情况。
		// SpotManager.getInstance(this).onStop();
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// SpotManager.getInstance(this).onDestroy();
		super.onDestroy();
	}

}
