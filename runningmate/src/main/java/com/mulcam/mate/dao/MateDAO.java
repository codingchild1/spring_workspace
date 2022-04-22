package com.mulcam.mate.dao;

import java.util.List;

import com.mulcam.mate.dto.Group;
import com.mulcam.mate.dto.Mate;
import com.mulcam.mate.dto.Report;

public interface MateDAO {
//	public List<post> postList() throws Exception;  //전체 게시물
	
	public List<Mate> mateList() throws Exception;  //번개 전체조회
	public List<Group> groupList() throws Exception; //소모임 전체조회
	
	public Mate queryMate(int mate_articleNO) throws Exception; //번개 조회,정보
	public Group queryGroup(int group_articleNO) throws Exception; //소모임 조회,정보
	
	public void updateMate(int mate_articleNO)throws Exception;  //번개 글,내용수정
	public void updateGroup(int group_articleNO)throws Exception; //소모임 글,내용수정
	
	public void deleteMate(int mate_articleNO) throws Exception;  //번개 삭제
	public void deleteGroup(int group_articleNO) throws Exception; //소모임 삭제
	
	public void updateMateviews(int mate_articleNO) throws Exception; //번개 글 삭제시 조회수 -1변경
	public void updateGroupviews(int group_articleNO) throws Exception; //번개 글 삭제시 조회수 -1변경
	
	public void insertMate(Mate mate)throws Exception; //번개 생성
	public void insertGroup(Group group)throws Exception;  //소모임 생성
	
	public void insertReport(Report report)throws Exception; //신고 접수
	public void ptpInfo(int mate_articleNO)throws Exception; //참여자 조회 (매개변수 나중에 다시 생각)
	public void like()throws Exception; //참여버튼(참여자수 +1)
	
	//게시물 검색
	
}
