package cn.pcshao.filtertest;

import cn.pcshao.filtertest.bean.Apple;
import cn.pcshao.filtertest.bean.Request;
import cn.pcshao.filtertest.bean.Response;
import cn.pcshao.filtertest.filter.FilterChain;
import cn.pcshao.filtertest.filter.HTMLFilter;
import cn.pcshao.filtertest.filter.NumberFilter;
import cn.pcshao.filtertest.filter.SensitiveFilter;
import cn.pcshao.filtertest.mycomparator.Comparable;
import cn.pcshao.filtertest.mycomparator.SortHelp;
import org.junit.Test;

public class Main {

    public static void main(String[] args) {
        String message = "这是一条要把数字2拦3截掉2的消息123<script>alter(\"广告屏蔽\");</script>";
        Request request = new Request();
        request.setRequestMesg(message);
        Response response = new Response();
        response.setResponseMsg("");

        //方法①挨个调用
//        new NumberFilter().doFilter(request, response);
//        new HTMLFilter().doFilter(request, response);

        //方法②存入特定链类
//        FilterChain filterChain = new FilterChain();
//        FilterChain filterChain2 = new FilterChain();
//
//        filterChain2.addFilter(new Filter[]{new NumberFilter(),new HTMLFilter()});
//        filterChain.addFilter(new NumberFilter());
//        filterChain.addFilter(new HTMLFilter());
//        filterChain.addFilter(filterChain2);
//        filterChain.doFilter(request, response);

        //方法③response过滤
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new Filter[]{new NumberFilter(),new HTMLFilter()});
        filterChain.addFilter(new SensitiveFilter());

        filterChain.doFilter2(request, response, filterChain);

        System.out.println(request.getRequestMesg());
        System.out.println(response.getResponseMsg());
    }
    /**
     * 测试设计strategy模式，comparable接口设计
     */
    @Test
    public void TestComparable(){
        Comparable[] objs = {new Apple(4,4.0),new Apple(5,3.5),new Apple(3,3.0)};
        System.out.println("before:");
        SortHelp.p(objs);
        SortHelp.sort(objs, true);
        System.out.println("after:");

        SortHelp.p(objs);
    }

}
