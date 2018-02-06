package io.dhseong.core.config.listener;

import io.dhseong.core.dao.CommonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Browser Session Time Out시 Access Log Logout 처리
 * @author 성동훈
 * @since 2017-01-03
 * @version 1.0
 * @see HttpSessionListener
 *
 * <pre>
 * == 개정이력(Modification Information) ==
 *
 * 수정일      수정자  수정내용
 * ----------- ------- ---------------------------
 * 2017.01.03  성동훈  최초 생성
 *
 * </pre>
 */
public class HttpSessionListenerImpl implements HttpSessionListener {
	Logger logger = LoggerFactory.getLogger(HttpSessionListenerImpl.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("sessionCreated.......");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("sessionDestroyed.......");
		CommonDAO dao = (CommonDAO) WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext(), FrameworkServlet.SERVLET_CONTEXT_PREFIX + "dispatcherServlet" ).getBean("commonDAO");
		System.out.println("dao: " + dao);
		//TODO 로그아웃 처리
		/*String sid= KeyGen.getRandomTimeKey();
		Map param =new HashMap();
		param.put("SESSION_ID", se.getSession().getId());		
		param.put("SID", sid);
		param.put("SESSION_TIMEOUT", (se.getSession().getMaxInactiveInterval() * 1.5) / 60 ); // 안정적인 처리를 위해서 1.5배수 잡아줌
		
		dao.insert("common.insertAutoLogoutLog", param);*/
	}
}
