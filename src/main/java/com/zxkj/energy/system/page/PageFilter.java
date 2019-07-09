package com.zxkj.energy.system.page;

import cn.hutool.core.util.NumberUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 刘万琼
 *
 * 分页过滤器 目的：拿到分页信息：页数（第几页）和每页条数
 */
@WebFilter(filterName = "pageFilter", urlPatterns = "/*")
public class PageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 过滤器拦截到的参数名为page
        String page = request.getParameter("page");
        if (page != null && NumberUtil.isInteger(page)){
            PageContext.setPageNum(Integer.valueOf(page));
        }
        // 过滤器拦截到的参数名为limit
        String size = request.getParameter("limit");
        if (size != null && NumberUtil.isInteger(size)){
            PageContext.setPageSize(Integer.valueOf(size));
        }
        // 拦截器默认的执行方法，如果不加则不会往下执行访问的接口
        filterChain.doFilter(request, servletResponse);
        // 执行完访问的接口之后，移除缓存
        PageContext.removePageNum();
        PageContext.removePageSize();
    }

    @Override
    public void destroy() {

    }
}
