package cc.biibi.fordeom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTagMap extends SimpleTagSupport{

	private HashMap<String, Customers> items;
	private String var;
	
	
	public HashMap<String, Customers> getItems() {
		return items;
	}


	public void setItems(HashMap<String, Customers> items) {
		this.items = items;
	}


	public String getVar() {
		return var;
	}


	public void setVar(String var) {
		this.var = var;
	}


	@Override
	public void doTag() throws JspException, IOException {
		//遍历items对应的集合
		if(items != null){
			Iterator<Map.Entry<String, Customers>> it = items.entrySet().iterator();
			while (it.hasNext()) {//循环遍历
				//将值放入ertry中
				Map.Entry<String, Customers> entry = it.next();
						
				//把正在遍历的对象放入到pageContext 中
				//键：var 值：正在遍历的对象
				getJspContext().setAttribute(var,entry);
				//把标签体的内容直接输出到页面上
				getJspBody().invoke(null);
			}
		}
	}
}
