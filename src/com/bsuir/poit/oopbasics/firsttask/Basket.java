package com.bsuir.poit.oopbasics.firsttask;

import java.util.List;

public class Basket {

    private List<Ball> balls;

    public Basket(List<Ball> balls) {
        this.balls = balls;
    }

    public Basket() {
    }

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

    public static void main(String[] args) {
        var basket = new Basket(List.of(
                    new Ball(1000, Color.BLUE),
                    new Ball(100, Color.RED),
                    new Ball(500, Color.RED),
                    new Ball(300, Color.GREEN),
                    new Ball(900, Color.BLUE),
                    new Ball(800, Color.BLUE),
                    new Ball(1000, Color.BLACK)
            ));

        System.out.println(basket.getBallsWeight());
        System.out.println(basket.getBlueBallsCount());
    }
}
