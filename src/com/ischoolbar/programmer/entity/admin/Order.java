package com.ischoolbar.programmer.entity.admin;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * ����ʵ��
 * @author llq
 *
 */
@Component
public class Order {
	
	private Long id;
	private String sn;//�������
	
	private String sender;//������
	private String senderMobile;//�������ֻ���
	private String senderTel;//�����˹̶��绰
	private String senderAddress;//�����˵�ַ
	
	private String reciever;//�ռ���
	private String recieverMobile;//�ջ����ֻ���
	private String recieverTel;//�ջ��˹̶��绰
	private String recieverAddress;//�ջ��˵�ַ
	
	private String goodsName;//��������
	private String goodsPrice;//��������
	private String goodsWeight;//��������
	private String goodsVolum;//���
	
	private String remark;//��ע
	private Date createTime;//����ʱ��
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public String getSenderTel() {
		return senderTel;
	}
	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getRecieverMobile() {
		return recieverMobile;
	}
	public void setRecieverMobile(String recieverMobile) {
		this.recieverMobile = recieverMobile;
	}
	public String getRecieverTel() {
		return recieverTel;
	}
	public void setRecieverTel(String recieverTel) {
		this.recieverTel = recieverTel;
	}
	public String getRecieverAddress() {
		return recieverAddress;
	}
	public void setRecieverAddress(String recieverAddress) {
		this.recieverAddress = recieverAddress;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsWeight() {
		return goodsWeight;
	}
	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	public String getGoodsVolum() {
		return goodsVolum;
	}
	public void setGoodsVolum(String goodsVolum) {
		this.goodsVolum = goodsVolum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	
	
	
}
