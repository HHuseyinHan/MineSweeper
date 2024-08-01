import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowNumber, colNumber;
        while (true) {
            System.out.print("Lütfen satır sayısını giriniz: ");
            rowNumber = input.nextInt();
            System.out.print("Lütfen sütun sayısını giriniz: ");
            colNumber = input.nextInt();

            if (rowNumber >= 2 && colNumber >= 2) {
                break;
            }

            System.out.println("Hatalı giriş yaptınız! Satır ve sütun sayısı 2'den küçük olamaz.");
        }
        MineSweeper mine = new MineSweeper(rowNumber, colNumber);
        mine.Runner();

    }
}