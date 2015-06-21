package com.ejia.abplayer.util;



/**
 * 
 * @author wwj_748
 * @date 2014/8/10
 */
public class JsoupUtil {
	public static boolean contentFirstPage = true; // 第一页
	public static boolean contentLastPage = true; // 最后一页
	public static boolean multiPages = false; // 多页
	private static final String BILIBILI_HOMEPAGE_URL = "http://www.bilibili.com/mobile/index.html"; // bilibili首页地址
	public static void resetPages() {
		contentFirstPage = true;
		contentLastPage = true;
		multiPages = false;
	}
		
}
