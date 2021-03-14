package com.dcafe.order.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="posts_id")
	private int postsId;
	
	private String title;
	
	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	private Date postedDate;
	
	private String shopAdminId;
	
	@PrePersist
    public void onPrePersist() {
        setPostedDate(new Date());
    }

	public int getPostsId() {
		return postsId;
	}

	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


	public String getShopAdminId() {
		return shopAdminId;
	}

	public void setShopAdminId(String shopAdminId) {
		this.shopAdminId = shopAdminId;
	}

	@Override
	public String toString() {
		return "Posts [postsId=" + postsId + ", title=" + title + ", body=" + body + ", postedDate=" + postedDate
				+ ", shopAdminId=" + shopAdminId + "]";
	}
	
	
	
	

}
