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
		//����items��Ӧ�ļ���
		if(items != null){
			Iterator<Map.Entry<String, Customers>> it = items.entrySet().iterator();
			while (it.hasNext()) {//ѭ������
				//��ֵ����ertry��
				Map.Entry<String, Customers> entry = it.next();
						
				//�����ڱ����Ķ�����뵽pageContext ��
				//����var ֵ�����ڱ����Ķ���
				getJspContext().setAttribute(var,entry);
				//�ѱ�ǩ�������ֱ�������ҳ����
				getJspBody().invoke(null);
			}
		}
	}
}
