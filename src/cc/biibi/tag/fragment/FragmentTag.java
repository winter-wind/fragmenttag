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
		
		JspFragment bodyContent = getJspBody();//������ǩ��
		//JspFragment.invoke(Writer):Writer��Ϊ��ǩ������������ַ�������Ϊnull
		//�������getjspContext().getOut()�����ҳ����
		bodyContent.invoke(null);
		
		//���������̨
		//����StringWriter�õ���ǩ������
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		//����ǩ���д
		String content = sw.toString().toUpperCase();
		getJspContext().getOut().print(content);//�����ҳ����
		System.out.println(content);
	}
	
}
