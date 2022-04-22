package com.mulcam.mate.dto;

public class Group {
	String group_articleNO;
	String user_id;
	String group_title;
	String group_cont;
	String user_img;
	String group_ki;
	String group_il;
	String group_tag;
	String group_date;
	String group_area;
	int group_views;
	boolean waring;
	
	public Group() {}
	public Group(String group_articleNO,String user_id, String group_title, String group_cont,
			String user_img, String group_ki, String group_il, String group_tag, String group_date,
			String group_area, int group_views, boolean waring) {
		this.group_articleNO=group_articleNO;
		this.user_id=user_id;
		this.group_title=group_title;
		this.group_cont=group_cont;
		this.user_img=user_img;
		this.group_ki=group_ki;
		this.group_il=group_il;
		this.group_tag=group_tag;
		this.group_date=group_date;
		this.group_area=group_area;
		this.group_views=group_views;
		this.waring=waring;
	}
	
	
	public String getGroup_articleNO() {
		return group_articleNO;
	}
	public void setGroup_articleNO(String group_articleNO) {
		this.group_articleNO = group_articleNO;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getGroup_title() {
		return group_title;
	}
	public void setGroup_title(String group_title) {
		this.group_title = group_title;
	}
	public String getGroup_cont() {
		return group_cont;
	}
	public void setGroup_cont(String group_cont) {
		this.group_cont = group_cont;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getGroup_ki() {
		return group_ki;
	}
	public void setGroup_ki(String group_ki) {
		this.group_ki = group_ki;
	}
	public String getGroup_il() {
		return group_il;
	}
	public void setGroup_il(String group_il) {
		this.group_il = group_il;
	}
	public String getGroup_tag() {
		return group_tag;
	}
	public void setGroup_tag(String group_tag) {
		this.group_tag = group_tag;
	}
	public String getGroup_date() {
		return group_date;
	}
	public void setGroup_date(String group_date) {
		this.group_date = group_date;
	}
	public String getGroup_area() {
		return group_area;
	}
	public void setGroup_area(String group_area) {
		this.group_area = group_area;
	}
	public int getGroup_views() {
		return group_views;
	}
	public void setGroup_views(int group_views) {
		this.group_views = group_views;
	}
	public boolean isWaring() {
		return waring;
	}
	public void setWaring(boolean waring) {
		this.waring = waring;
	}
}
