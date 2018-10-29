package cn.pcshao.filtertest.mycomparator.impl;

import cn.pcshao.filtertest.bean.Apple;
import cn.pcshao.filtertest.mycomparator.Comparable;
import cn.pcshao.filtertest.mycomparator.Comparator;

public class ApplePriceComparator implements Comparator {

    @Override
    public int compare(Comparable a, Comparable b) {
        Apple a1 = (Apple) a;
        Apple a2 = (Apple) b;
        if(a1.getPrice()<a2.getPrice()) return -1;
        else if(a1.getPrice()>a2.getPrice()) return 1;;
        return 0;
    }
}
