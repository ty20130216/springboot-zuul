package com.example.zuul.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot-zuul
 * @ClassName: TokenFilter
 * @description: TODO
 * @author PF01429
 * @date 2020-11-18 23:17:57
 * @version 1.0
 */

 @Component
 public class TokenFilter extends ZuulFilter {
  @Override
  public Object run() throws ZuulException {
   RequestContext rc = RequestContext.getCurrentContext();
   HttpServletRequest request = rc.getRequest();
   String token = request.getParameter("token");
   if(token == null) {
    //如果token为null则结束请求，不再继续传递下去
    rc.setSendZuulResponse(false);
    rc.setResponseStatusCode(401);
    rc.setResponseBody("{\"result\":\"token is null\"}");
    rc.getResponse().setContentType("text/html;charset=utf-8");
   }else {
    //假如token未超时且成功解析出里面的键值对name=xiaoming
    //把解析出的键值对放入请求参数中
    Map<String, List<String>> mq = rc.getRequestQueryParams();
    if(mq == null){mq = new HashMap<>(32);}
    mq.put("name", Collections.singletonList("xiaoming"));
    rc.setRequestQueryParams(mq);
   }
   return null;
  }

  @Override
  public boolean shouldFilter() {
   return true;
  }
  @Override
  public String filterType() {
   return "pre";
  }
  @Override
  public int filterOrder() {
   return 0;
  }
 }