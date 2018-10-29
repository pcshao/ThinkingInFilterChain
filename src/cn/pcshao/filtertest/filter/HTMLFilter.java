package cn.pcshao.filtertest.filter;

import cn.pcshao.filtertest.Filter;
import cn.pcshao.filtertest.bean.Request;
import cn.pcshao.filtertest.bean.Response;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response) {
        request.setRequestMesg(
                request.getRequestMesg().replace("<","[").replace(">","]"));
    }

    @Override
    public void doFilter2(Request request, Response response, FilterChain filterChain) {
        request.setRequestMesg(
                request.getRequestMesg().replace("<","[").replace(">","]"));
        filterChain.doFilter2(request, response, filterChain);
        response.setResponseMsg(response.getResponseMsg()+"--HTMLFilter完成--\n");
    }
}
