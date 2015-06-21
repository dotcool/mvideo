package com.ejia.abplayer.fragment;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ejia.abplayer.Aty_UserCenter;
import com.ejia.abplayer.R;
import com.isnc.facesdk.SuperID;
import com.isnc.facesdk.common.Cache;
import com.isnc.facesdk.common.SDKConfig;

public class GamesCenterFragment extends Fragment implements View.OnClickListener{

	private Context context;
	private EditText mUserEditText;
	private EditText mPasswordEditText;
	private Button mLogin;
	private Button mWXButton;
	private Button mYiDengButton;
	private Button mWBButton;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_gamecenter,
				container, false);
		mUserEditText = (EditText)rootView.findViewById(R.id.et_username);
		mPasswordEditText = (EditText)rootView.findViewById(R.id.et_password);
		mLogin = (Button)rootView.findViewById(R.id.btn_login);
		mWXButton = (Button)rootView.findViewById(R.id.btn_wx);
		mYiDengButton = (Button)rootView.findViewById(R.id.btn_yd);
		mWBButton = (Button)rootView.findViewById(R.id.btn_wb);
		
		mLogin.setOnClickListener(this);
		mWXButton.setOnClickListener(this);
		mYiDengButton.setOnClickListener(this);
		mWBButton.setOnClickListener(this);
		context = getActivity();
		
		return rootView;

	}
	
		public static void delete(File file) {
			if (file.isFile()) {
				file.delete();
				return;
			}

			if (file.isDirectory()) {
				File[] childFiles = file.listFiles();
				if (childFiles == null || childFiles.length == 0) {
					file.delete();
					return;
				}

				for (int i = 0; i < childFiles.length; i++) {
					delete(childFiles[i]);
				}
				file.delete();
			}
		}

		// 接口返回
		@Override
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);

			switch (resultCode) {
			// 授权成功
			case SDKConfig.AUTH_SUCCESS:
				System.out.println(Cache.getCached(context, SDKConfig.KEY_APPINFO));
				System.err.println("dddbb");
				Intent intent = new Intent(getActivity(), Aty_UserCenter.class);
				startActivity(intent);
				getActivity().finish();
				break;
			// 取消授权
			case SDKConfig.AUTH_BACK:

				break;
			// 找不到该用户
			case SDKConfig.USER_NOTFOUND:

				break;
			// 登录成功
			case SDKConfig.LOGINSUCCESS:
				System.out.println(Cache.getCached(context, SDKConfig.KEY_APPINFO));
				Intent i = new Intent(getActivity(), Aty_UserCenter.class);
				startActivity(i);
				getActivity().finish();
				break;
			// 登录失败
			case SDKConfig.LOGINFAIL:
				break;
			// 网络有误
			case SDKConfig.NETWORKFAIL:
				break;
			// 一登SDK版本过低
			case SDKConfig.SDKVERSIONEXPIRED:
				break;
			default:
				break;
			}

		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch (v.getId()) {
			case R.id.btn_login:
				startActivity(new Intent(getActivity(), Aty_UserCenter.class));
				getActivity().finish();
				break;
			case R.id.btn_wx:
				break;
			case R.id.btn_wb:
				break;
			case R.id.btn_yd:
				SuperID.faceLogin(getActivity());
				break;
			case R.id.btn_clear:
				Cache.clearCached(context);
				delete(new File(SDKConfig.TEMP_PATH));
				break;
			default:
				break;
			}
			
			
			
		}

}
