public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private double toRound(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double xDiff = Math.pow((x2 - x1), 2);
        double yDiff = Math.pow((y2 - y1), 2);
        double space = toRound(Math.sqrt(xDiff + yDiff));
        return space;
    }
    public double slope() {
        return toRound(((double) y2-y1) / ((double) x2-x1));
    }
    public double yIntercept() {
        double yInt = toRound(y1 - (slope() * x1));
        return yInt;
    }

    public String equation() {
        int factor = 1;
        int y = y2-y1;
        int x = x2-x1;
        int i = 1;
        while (i < y && i < x)  {
            if(x % i == 0 && y % i == 0) {
                factor = i;
            }
            i++;
        }
        int numerator = y / factor;
        int denominator = x / factor;
        int s = (int) slope();
        if (slope() > s) {
            if (slope() != 0) {
                return "y = " + numerator + "/" + denominator + "x + " + yIntercept();
            } else {
                return "y = " + yIntercept();
            }
        } else if (slope() == 0) {
            return "y = " + yIntercept();
        } else {
            return "y = " + s + "x + " + yIntercept();
        }
    }

    public String coordinateForX (double x) {
        double yCoord = toRound(x * slope() + yIntercept());
        return "(" + x + ", " + yCoord + ")";
    }
    public String lineInfo () {
        return "The two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance();
    }

}

