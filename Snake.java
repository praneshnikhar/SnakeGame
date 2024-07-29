//import java.awt.Graphics;
//import java.awt.Color;
//import java.awt.event.KeyEvent;
//import java.awt.Point;
//import java.util.LinkedList;
//
//public class Snake {
//    private LinkedList<Point> body;
//    private Direction direction;
//    private static final int UNIT_SIZE = 25;
//
//    public Snake() {
//        body = new LinkedList<>();
//        body.add(new Point(UNIT_SIZE, UNIT_SIZE));
//        direction = Direction.RIGHT;
//    }
//
//    public void move() {
//        Point head = body.getFirst();
//        Point newHead = new Point(head.x + direction.x, head.y + direction.y);
//        body.addFirst(newHead);
//        body.removeLast();
//    }
//
//    public void draw(Graphics g) {
//        g.setColor(Color.GREEN);
//        for (Point p : body) {
//            g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
//        }
//    }
//
//    public boolean eat(Apple apple) {
//        Point head = body.getFirst();
//        if (head.equals(apple.getPosition())) {
//            body.addLast(new Point(-UNIT_SIZE, -UNIT_SIZE)); // Extend the snake
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkCollision() {
//        Point head = body.getFirst();
//        for (int i = 1; i < body.size(); i++) {
//            if (head.equals(body.get(i))) {
//                return true;
//            }
//        }
//        return head.x < 0 || head.y < 0 || head.x >= GamePanel.WIDTH || head.y >= GamePanel.HEIGHT;
//    }
//
//    public void changeDirection(int keyCode) {
//        switch (keyCode) {
//            case KeyEvent.VK_UP:
//                if (direction != Direction.DOWN) direction = Direction.UP;
//                break;
//            case KeyEvent.VK_DOWN:
//                if (direction != Direction.UP) direction = Direction.DOWN;
//                break;
//            case KeyEvent.VK_LEFT:
//                if (direction != Direction.RIGHT) direction = Direction.LEFT;
//                break;
//            case KeyEvent.VK_RIGHT:
//                if (direction != Direction.LEFT) direction = Direction.RIGHT;
//                break;
//        }
//    }
//
//    public LinkedList<Point> getBody() {
//        return body;
//    }
//
//    private enum Direction {
//        UP(0, -UNIT_SIZE), DOWN(0, UNIT_SIZE), LEFT(-UNIT_SIZE, 0), RIGHT(UNIT_SIZE, 0);
//        int x, y;
//        Direction(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}


import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private static final int UNIT_SIZE = 25;

    public Snake(int initialSize) {
        body = new LinkedList<>();
        direction = Direction.RIGHT;

        for (int i = 0; i < 1; i++) {
            body.add(new Point(UNIT_SIZE - i * UNIT_SIZE, UNIT_SIZE));
        }
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.x + direction.x, head.y + direction.y);
        body.addFirst(newHead);
        body.removeLast();
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point p : body) {
            g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
        }
    }

    public boolean eat(Apple apple) {
        Point head = body.getFirst();
        if (head.equals(apple.getPosition())) {
            body.addLast(new Point(-UNIT_SIZE, -UNIT_SIZE)); // Extend the snake
            return true;
        }
        return false;
    }

    public boolean checkCollision() {
        Point head = body.getFirst();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return head.x < 0 || head.y < 0 || head.x >= GamePanel.WIDTH || head.y >= GamePanel.HEIGHT;
    }

    public void changeDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (direction != Direction.DOWN) direction = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                if (direction != Direction.UP) direction = Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                if (direction != Direction.RIGHT) direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != Direction.LEFT) direction = Direction.RIGHT;
                break;
        }
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    private enum Direction {
        UP(0, -UNIT_SIZE), DOWN(0, UNIT_SIZE), LEFT(-UNIT_SIZE, 0), RIGHT(UNIT_SIZE, 0);
        int x, y;
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
