package com.workbench.shiro;

import com.google.common.base.Strings;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Shiro FIlter
 */
public class WorkbenchShiroFilter extends AuthenticatingFilter {

    private Logger logger = LoggerFactory.getLogger(WorkbenchShiroFilter.class);

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse)  {
        logger.debug("create token is running.....");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String token = httpRequest.getHeader("token");

        //如果header中不存在token，则从参数中获取token
        if(Strings.isNullOrEmpty(token)){
            token = httpRequest.getParameter("token");
        }

        if(Strings.isNullOrEmpty(token)){
            return null;
        }

        WorkbenchShiroToken workbenchShiroToken = new WorkbenchShiroToken(token);

        return workbenchShiroToken;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse)  {
        logger.debug("on access denied is running.....");

        return false;
    }
}
