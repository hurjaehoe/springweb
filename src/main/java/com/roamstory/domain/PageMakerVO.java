package com.roamstory.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMakerVO {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private PageCriteriaVO criteriaVO;
	
	public void setCriteriaVO(PageCriteriaVO criteriaVO) {
		this.criteriaVO = criteriaVO;
	}

	private void calculateData() {
		
		endPage = (int)(Math.ceil(criteriaVO.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double) criteriaVO.getPerPageNum()));
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * criteriaVO.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", criteriaVO.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", criteriaVO.getPerPageNum())
				.queryParam("searchType", ((SearchCriteriaVO) criteriaVO).getSearchType())
				.queryParam("keyword", encoding(((SearchCriteriaVO) criteriaVO).getKeyword()))
				.build();
		
		return uriComponents.toUriString();
	}
	
	
	public String encoding(String keyword) {
		if (keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
		   return URLEncoder.encode(keyword,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calculateData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public PageCriteriaVO getCriteriaVO() {
		return criteriaVO;
	}

	@Override
	public String toString() {
		return "PageMakerVO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteriaVO=" + criteriaVO
				+ "]";
	}
	
	
}
