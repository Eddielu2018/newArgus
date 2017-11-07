package cn.htd.argus.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

public class URLInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		Map<String, String[]> map = arg0.getParameterMap();
		
		for (Map.Entry<String, String[]> e : map.entrySet())
		{
			String[] value = new String[e.getValue().length];
			
			for (int i = 0; i < e.getValue().length; i++)
			{
				value[i] = HtmlUtils.htmlEscape(e.getValue()[i]);
			}
			
			e.setValue(value);
		}
		return true;
	}

}
