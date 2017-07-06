package cc.biibi.tag.fragment;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PagePrintTag extends SimpleTagSupport {

	//获取属性
	private String time;
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		//获取标签体
		JspFragment bodyContent = getJspBody();
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		String content = sw.toString().toUpperCase();
		
		//循环打印
		int times = Integer.parseInt(time);
		for(int i = 0;i<=times;i++){
			getJspContext().getOut().print(i+1+"."+content+"<br>");
		}
	}
}
