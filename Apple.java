import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Apple {
    private Point position;
    private static final int UNIT_SIZE = 25;
    private static final Random random = new Random();

    public Apple(Snake snake) {
        generateNewPosition(snake);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(position.x, position.y, UNIT_SIZE, UNIT_SIZE);
    }

    public Point getPosition() {
        return position;
    }

    private void generateNewPosition(Snake snake) {
        int x, y;
        do {
            x = random.nextInt(GamePanel.WIDTH / UNIT_SIZE) * UNIT_SIZE;
            y = random.nextInt(GamePanel.HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        } while (snakeContains(x, y, snake));
        position = new Point(x, y);
    }

    private boolean snakeContains(int x, int y, Snake snake) {
        for (Point p : snake.getBody()) {
            if (p.x == x && p.y == y) {
                return true;
            }
        }
        return false;
    }
}
