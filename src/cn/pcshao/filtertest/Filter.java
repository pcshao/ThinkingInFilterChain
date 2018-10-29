package cn.pcshao.filtertest;

import cn.pcshao.filtertest.bean.Request;
import cn.pcshao.filtertest.bean.Response;
import cn.pcshao.filtertest.filter.FilterChain;

public interface Filter {

    public void doFilter(Request request, Response response);
    public void doFilter2(Request request, Response response, FilterChain filterChain);

}
