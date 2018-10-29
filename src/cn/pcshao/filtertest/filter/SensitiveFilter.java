package cn.pcshao.filtertest.filter;

import cn.pcshao.filtertest.Filter;
import cn.pcshao.filtertest.bean.Request;
import cn.pcshao.filtertest.bean.Response;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response) {

    }

    @Override
    public void doFilter2(Request request, Response response, FilterChain filterChain) {
        request.setRequestMesg(
                request.getRequestMesg().replace("广告","**"));
        filterChain.doFilter2(request, response, filterChain);
        response.setResponseMsg(response.getResponseMsg()+"--SensitiveFilter完成--\n");
    }
}
