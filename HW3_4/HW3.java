import java.util.Scanner;

class Point {
    private int vertical, horizontal;

    public void Set(int x, int y) {
        vertical = x;
        horizontal = y;
    }

    public void Move(int x, int y) {
        vertical += x;
        horizontal += y;
    }

    public void Rotate() {
        int tmp = vertical;
        vertical = horizontal;
        horizontal = -tmp;
    }

    public int RetrieveVertical(){
        return vertical;
    }

    public int RetrieveHorizontal(){
        return horizontal;
    }

    int calculateManhattanDistance(Point other){
        return Math.abs(vertical - other.vertical) + Math.abs(horizontal - other.horizontal);
    }

    double ChebyshevDistance(Point other){
        return Math.max(Math.abs(vertical - other.vertical), Math.abs(horizontal - other.horizontal));
    }
}

class HW3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int x, y;

        x = scanner.nextInt();
        y = scanner.nextInt();
        Point Main_Point = new Point();
        Main_Point.Set(x, y);

        x = scanner.nextInt();
        y = scanner.nextInt();
        Point Other_Point = new Point();
        Other_Point.Set(x, y);

        int move_x = scanner.nextInt();
        int move_y = scanner.nextInt();

        System.out.println(Main_Point.RetrieveVertical() + " " + Main_Point.RetrieveHorizontal());
        Main_Point.Move(move_x, move_y);
        System.out.println(Main_Point.RetrieveVertical() + " " + Main_Point.RetrieveHorizontal());
        for(int i=0;i<4;i++){
            Main_Point.Rotate();
            System.out.println(Main_Point.RetrieveVertical() + " " + Main_Point.RetrieveHorizontal());    
        }
        System.out.println(Main_Point.calculateManhattanDistance(Other_Point));
        System.out.println(Main_Point.ChebyshevDistance(Other_Point));
        scanner.close();
    }
}