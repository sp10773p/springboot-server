package io.dhseong.core.config.mybatis;

import io.dhseong.core.model.AjaxModel;
import io.dhseong.core.model.Constant;
import io.dhseong.core.model.UserSessionModel;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Properties;

/**
 * Mybatis Interceptor
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
	@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
@SuppressWarnings("rawtypes")
public class AddCommToParamInterceptor implements Interceptor {
	static int PARAMETER_INDEX = 1;
	
	@SuppressWarnings("unchecked")
	public Object intercept(final Invocation invocation) throws Throwable {
		final Object[] queryArgs = invocation.getArgs();
		final Object parameter = queryArgs[PARAMETER_INDEX];
		
		if(RequestContextHolder.getRequestAttributes() == null) {
			return invocation.proceed();
		}
		
		if(parameter instanceof AjaxModel || parameter instanceof Map) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

			HttpServletRequest request = attr.getRequest();

			// TODO 세션 처리
			//CommonService commonService = new CommonService();
		    UserSessionModel usrSessionMode = new UserSessionModel();//commonService.getUesrSessionModel(request);

		    if(usrSessionMode != null) {
			    if(parameter instanceof AjaxModel) {
			    	((AjaxModel)parameter).getData().put(Constant.SESSION_KEY_USR.getCode(), usrSessionMode);
			    } else {
			    	((Map)parameter).put(Constant.SESSION_KEY_USR.getCode(), usrSessionMode);
			    }
		    }
		}
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}
