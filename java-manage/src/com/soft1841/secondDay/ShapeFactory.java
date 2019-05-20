package com.soft1841.secondDay;

public class ShapeFactory {
    public static Shape getCircleInstance(){
        return new Cirle();
    }
    public static Shape getRectangleInstance(){
        return new Rectangle();
    }
}
