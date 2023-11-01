import java.util.Scanner;
public class LinearEquationLogic {
    public LinearEquationLogic() {}
    public void start() {
        Scanner scan = new Scanner(System.in);
        Boolean repeat = true;
        while (repeat) {
            System.out.print("Enter the first coordinate pair: ");
            String coord = scan.nextLine();
            int x1 = Integer.parseInt(coord.substring(1, coord.indexOf(",")));
            int y1 = Integer.parseInt(coord.substring(coord.indexOf(",") + 2, coord.length()-1));

            System.out.print("Enter the second coordinate pair: ");
            String coord2 = scan.nextLine();
            int x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
            int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.length()-1));
            System.out.println(" ");
            if (x1 != x2) {
                LinearEquation line = new LinearEquation(x1, y1, x2, y2);
                System.out.println(line.lineInfo());
                System.out.println(" ");
                System.out.print("Enter a value for x: ");
                double value = scan.nextDouble();
                scan.nextLine();
                System.out.println("The point on the line is " + line.coordinateForX(value));
            } else {
                System.out.println("You can't enter two points with the same x-value!");
            }
            System.out.println(" ");
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String choice = scan.nextLine();
            if (choice.equals("n")) {
                repeat = false;
            }
        }
    }
}