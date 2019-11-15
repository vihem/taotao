package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 网络传输使用implements Serializable
 * @author Administrator
 *
 */
public class EasyUIDataGridResult implements Serializable{
	/**
	 * total总记录数
	 * rows 数据集
	 */
	private long total;
	private List rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
