package cc.biibi.tag.fragment;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FragmentTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment bodyContent = getJspBody();//创建标签体
		//JspFragment.invoke(Writer):Writer即为标签体内容输出的字符流，若为null
		//则输出到getjspContext().getOut()浏览器页面上
		bodyContent.invoke(null);
		
		//输出到控制台
		//利用StringWriter得到标签体内容
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		//将标签体大写
		String content = sw.toString().toUpperCase();
		getJspContext().getOut().print(content);//输出到页面上
		System.out.println(content);
	}
	
}
