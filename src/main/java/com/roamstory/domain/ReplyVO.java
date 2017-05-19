package com.roamstory.domain;

import java.util.Date;

public class ReplyVO {
	
	private Integer replyno;
	private Integer bbsno;
	private String replytext;
	private String replyer;
	
	private Date regdate;
	private Date updatedate;
	public Integer getReplyno() {
		return replyno;
	}
	public void setReplyno(Integer replyno) {
		this.replyno = replyno;
	}
	public Integer getBbsno() {
		return bbsno;
	}
	public void setBbsno(Integer bbsno) {
		this.bbsno = bbsno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyno=" + replyno + ", bbsno=" + bbsno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
}
