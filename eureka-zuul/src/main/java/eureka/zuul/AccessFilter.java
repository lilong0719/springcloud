/*
 * 文件名：AccessFilter.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年11月30日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.zuul;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter
{

    @Override
    public Object run()
    {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
   
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容 
            return null;
        }
        return null;
    }

    @Override
    public boolean shouldFilter()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public int filterOrder()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String filterType()
    {
        // TODO Auto-generated method stub
        return "pre";
    }

}
