package com.mulcam.mate.dto;

public class Mate {
	int mate_articleNO;
	String user_id;
	String mate_title;
	String mate_cont;
	String user_img;
	int mate_like;
	String mate_ptp;
	String mate_tag;
	String mate_date;
	int mate_views;
	String mate_mapinfo;
	boolean warning;
	
	public Mate() {}
	public Mate(int mate_articleNO,String user_id, String mate_title,
			String mate_cont, String user_img,int mate_like, String mate_ptp, String mate_tag,
			String mate_date, int mate_views, String mate_mapinfo, boolean warning) {
		this.mate_articleNO=mate_articleNO;
		this.user_id=user_id;
		this.mate_title=mate_title;
		this.mate_cont=mate_cont;
		this.user_img=user_img;
		this.mate_like=mate_like;
		this.mate_ptp=mate_ptp;
		this.mate_tag=mate_tag;
		this.mate_date=mate_date;
		this.mate_views=mate_views;
		this.mate_mapinfo=mate_mapinfo;
		this.warning=warning;
	}

	public int getMate_articleNO() {
		return mate_articleNO;
	}
	public void setMate_articleNO(int mate_articleNO) {
		this.mate_articleNO = mate_articleNO;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMate_title() {
		return mate_title;
	}
	public void setMate_title(String mate_title) {
		this.mate_title = mate_title;
	}
	public String getMate_cont() {
		return mate_cont;
	}
	public void setMate_cont(String mate_cont) {
		this.mate_cont = mate_cont;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public int getMate_like() {
		return mate_like;
	}
	public void setMate_like(int mate_like) {
		this.mate_like = mate_like;
	}
	public String getMate_ptp() {
		return mate_ptp;
	}
	public void setMate_ptp(String mate_ptp) {
		this.mate_ptp = mate_ptp;
	}
	public String getMate_tag() {
		return mate_tag;
	}
	public void setMate_tag(String mate_tag) {
		this.mate_tag = mate_tag;
	}
	public String getMate_date() {
		return mate_date;
	}
	public void setMate_date(String mate_date) {
		this.mate_date = mate_date;
	}
	public int getMate_views() {
		return mate_views;
	}
	public void setMate_views(int mate_views) {
		this.mate_views = mate_views;
	}
	public String getMate_mapinfo() {
		return mate_mapinfo;
	}
	public void setMate_mapinfo(String mate_mapinfo) {
		this.mate_mapinfo = mate_mapinfo;
	}
	public boolean isWarning() {
		return warning;
	}
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
}

	
	