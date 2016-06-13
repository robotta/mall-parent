package com.malaysia.mongo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用于存储mongo log bean
 * @author zhaoyun
 * @create 2015年1月23日
 */
public class MongoLogBean {
	private String operator;
	private String funciton;
	private Date date;
	private String functionLog;
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getFunciton() {
		return funciton;
	}
	public void setFunciton(String funciton) {
		this.funciton = funciton;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFunctionLog() {
		return functionLog;
	}
	public void setFunctionLog(String functionLog) {
		this.functionLog = functionLog;
	}
	
	/**
	 * 有参的构造方法
	 * @param operator
	 * @param funciton
	 * @param date
	 * @param functionLog
	 */
	public MongoLogBean(String operator, String funciton, Date date,
			String functionLog) {
		super();
		this.operator = operator;
		this.funciton = funciton;
		this.date = date;
		this.functionLog = functionLog;
	}
	@Override
	public String toString() {
		return "MongoLogBean [operator=" + operator + ", funciton=" + funciton
				+ ", date=" + date + ", functionLog=" + functionLog + "]";
	}
	
}
