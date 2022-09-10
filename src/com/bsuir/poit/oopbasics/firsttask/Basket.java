package com.bsuir.poit.oopbasics.firsttask;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Ball> balls;

    public int getBallsWeight() {
        return balls.stream()
            .mapToInt(Ball::getWeight)
            .sum();
    }

    public long getBlueBallsCount() {
        return balls.stream()
            .filter(b -> b.getColor().equals(Color.BLUE))
            .count();
    }
}
