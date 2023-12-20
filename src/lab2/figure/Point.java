package lab2.figure;

public class Point {
    private int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
        System.out.println("point (" + this.x + ", " + this.y + ")");
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("point (" + this.x + ", " + this.y + ")");
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
