package cn.pcshao.filtertest.filter;

import cn.pcshao.filtertest.Filter;
import cn.pcshao.filtertest.bean.Request;
import cn.pcshao.filtertest.bean.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<Filter>();
    int i = 0;

    public void addFilter(Filter f){
        this.filters.add(f);
    }
    public void addFilter(Filter[] filters){
        for(Filter f : filters)
            this.filters.add(f);
    }

    @Override
    public void doFilter(Request request, Response response) {
        for(Filter f : filters){
            f.doFilter(request, response);
        }
    }

    @Override
    public void doFilter2(Request request, Response response, FilterChain filterChain) {
        if(filters.size()==i)
            return;
        Filter f = filters.get(i++);
        f.doFilter2(request, response, filterChain);

    }
}
