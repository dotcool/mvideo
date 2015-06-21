package com.ejia.abplayer.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ejia.abplayer.R;
import com.ejia.abplayer.adapter.GameListAdapter;
import com.ejia.abplayer.model.GameItem;

public class PromotionFragment extends Fragment {
	private ListView gameListView;
	private ArrayList<GameItem> gameList = new ArrayList<GameItem>();
	private int[] gameimages = new int[] {
			R.drawable.hxzj_gamecenter_smallbanner, R.drawable.wcat_list,
			R.drawable.xwy_list};
	private String[] gametexts = new String[] { "E家课堂移动版", "E家课堂web", "合智社区" };
	private String[] gamepaths = new String[] {
			"http://shouji.baidu.com/software/item?docid=7709598&from=as",
			"http://www.ejiakt.com", "http://www.andzhi.com/" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		for (int i = 0; i < gameimages.length; i++) {
			GameItem item = new GameItem();
			item.setImg(gameimages[i]);
			item.setText(gametexts[i]);
			item.setPath(gamepaths[i]);
			gameList.add(item);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_promotioncenter,
				container, false);
		gameListView = (ListView) rootView.findViewById(R.id.GameListView);
		gameListView.setAdapter(new GameListAdapter(getActivity(), gameList));
		return rootView;
	}

}
