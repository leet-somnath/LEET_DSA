import java.util.Scanner;

public class C_Clock_Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            String[] parts = s.split(":");
            int hour = Integer.parseInt(parts[0]);
            StringBuilder result = new StringBuilder();
            if (hour != 0 && hour!=12) {
                int h=hour % 12;
                if(h<10){
                result.append(0);
                result.append(h);
                }
                else
                result.append(h);
            } 
            else {
                result.append(12);
            }
            result.append(":").append(parts[1]).append(" ");
            result.append(hour < 12 ? "AM" : "PM");
            System.out.println(result);
        }
        scanner.close();
    }
}
