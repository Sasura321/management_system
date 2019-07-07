package com.model;

/**
 * 10类名：Item
 * 类用途：数据模型
 */
public class Item {
    //属性
    private  String no;
    private String name;
    private String starTime;
    private String outTime;
    private String finashTime;
    private String place;
    //构造
    public  Item(){}

    public Item(String no,String name,String starTime,String outTime,String finashTime,String place){
        super();
        this.setNo(no);
        this.setName(name);
        this.setStarTime(starTime);
        this.setOutTime(outTime);
        this.setFinashTime(finashTime);
        this.setPlace(place);
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStarTime() {
        return starTime;
    }
    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getOutTime() {
        return outTime;
    }
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
    public String getFinashTime() {
        return finashTime;
    }
    public void setFinashTime(String finashTime) {
        this.finashTime = finashTime;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        result = prime * result + ((no == null) ? 0 : no.hashCode());
//        result = prime * result + ((place == null) ? 0 : place.hashCode());
//        result = prime * result + ((time1 == null) ? 0 : time1.hashCode());
//        result = prime * result + ((time2 == null) ? 0 : time2.hashCode());
//        result = prime * result + ((time3 == null) ? 0 : time3.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Item other = (Item) obj;
//        if (name == null) {
//            if (other.name != null)
//                return false;
//        } else if (!name.equals(other.name))
//            return false;
//        if (no == null) {
//            if (other.no != null)
//                return false;
//        } else if (!no.equals(other.no))
//            return false;
//        if (place == null) {
//            if (other.place != null)
//                return false;
//        } else if (!place.equals(other.place))
//            return false;
//        if (time1 == null) {
//            if (other.time1 != null)
//                return false;
//        } else if (!time1.equals(other.time1))
//            return false;
//        if (time2 == null) {
//            if (other.time2 != null)
//                return false;
//        } else if (!time2.equals(other.time2))
//            return false;
//        if (time3 == null) {
//            if (other.time3 != null)
//                return false;
//        } else if (!time3.equals(other.time3))
//            return false;
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Item [number=" + no + ", name=" + name + ","
//                + " time1=" + time1 + ", time2=" + time2 + ", time3="
//                + time3 + ", place=" + place + "]";
//    }
}

