package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品管理controller    web
 * @author Administrator
 *
 */
//可被springmvc.xml中的扫描包扫到
@Controller
public class ItemController {
	/**
	 * 调用service
	 */
	@Autowired
	private ItemService itemService;
	
	/** RequestMapping
	 * 用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
	 * url的参数
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	/** ResponseBody
	 * 将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
	 * 写入到response对象的body区，通常用来返回JSON数据或者是XML.
	 * 若有406错误，缺少jackson包，来自common包依赖
	 * @param itemId
	 * @return
	 */
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	/**
	 * 来自/taotao-manager-web/src/main/webapp/WEB-INF/jsp/item-list.jsp里面的url:'/item/list'
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
}
