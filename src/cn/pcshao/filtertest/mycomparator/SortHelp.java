package cn.pcshao.filtertest.mycomparator;

import cn.pcshao.filtertest.bean.Apple;

public class SortHelp {

    public static void sort(Comparable[] c, boolean DESC){
        for (int j = 0; j < c.length; j++) {
            for (int i = j+1; i < c.length ; i++) {
                if(DESC) {
                    if (c[j].compareTo(c[i]) == -1) swap(c, j, i);  //降序，-1即小于
                }
                else {
                    if (c[j].compareTo(c[i]) == 1) swap(c, j, i);  //升序， 1即大于
                }
            }
        }
    }

    private static void swap(Comparable[] c, int j, int i) {
        Comparable temp = c[j];
        c[j] = c[i];
        c[i] = temp;
    }

    public static void p(Comparable[] c){
        for (Comparable a : c ) {
            System.out.println(a);
        }
    }


}
