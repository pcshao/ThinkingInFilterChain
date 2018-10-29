package cn.pcshao.filtertest.bean;

import cn.pcshao.filtertest.mycomparator.Comparable;
import cn.pcshao.filtertest.mycomparator.Comparator;
import cn.pcshao.filtertest.mycomparator.impl.ApplePriceComparator;
import cn.pcshao.filtertest.mycomparator.impl.AppleSizeComparator;

public class Apple implements Comparable {

    private double size;
    private double price;
//    private Comparator comparator = new AppleSizeComparator();
    private Comparator comparator = new ApplePriceComparator();

    public Apple(double size, double price) {
        this.size = size;
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Comparable o) {
        return comparator.compare(this, o);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }
}
