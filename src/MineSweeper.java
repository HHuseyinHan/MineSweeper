import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    int a;
    int b;
    String[][] list;
    String[][] listDisplay;

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.list = new String[this.rowNumber][this.colNumber];
        this.listDisplay = new String[this.rowNumber][this.colNumber];
    }

    void TableCreator() {
        for (int i = 0; i < this.list.length; i++) {
            for (int j = 0; j < this.list[i].length; j++) {
                this.list[i][j] = " - ";
                this.listDisplay[i][j] = " - ";
            }
        }
    }

    boolean Randomizer() {
        int randomNumber = (int) (Math.random() * (100)) + 1;
        return randomNumber >= (100 / (this.rowNumber * this.colNumber));
    }

    void BombPlanter() {
        int k = 1;
        while ((this.rowNumber * this.colNumber) / 4 >= k) {
            for (int i = 0; i < this.list.length; i++) {
                for (int j = 0; j < this.list[i].length; j++) {
                    if (this.list[i][j].equals(" - ")) {
                        if ((this.rowNumber * this.colNumber) / 4 < k) {
                            break;
                        } else if (!Randomizer()) {
                            this.list[i][j] = " * ";
                            k++;
                        }
                    }
                }
            }
        }
    }

    boolean Checker() {
        return this.list[this.a][this.b].equals(" - ");
    }

    String Counter() {
        int count = 0;
        if (this.a - 1 >= 0 && this.rowNumber > this.a - 1) {
            if (this.b - 1 >= 0 && this.colNumber > this.b - 1) {
                if (this.list[this.a - 1][this.b - 1].equals(" * ")) {
                    count++;
                }
            }
            if (this.b >= 0 && this.colNumber > this.b) {
                if (this.list[this.a - 1][this.b].equals(" * ")) {
                    count++;
                }
            }
            if (this.b + 1 >= 0 && this.colNumber > this.b + 1) {
                if (this.list[this.a - 1][this.b + 1].equals(" * ")) {
                    count++;
                }
            }
        }
        if (this.b - 1 >= 0 && this.colNumber > this.b - 1) {
            if (this.list[this.a][this.b - 1].equals(" * ")) {
                count++;
            }
        }
        if (this.b + 1 >= 0 && this.colNumber > this.b + 1) {
            if (this.list[this.a][this.b + 1].equals(" * ")) {
                count++;
            }
        }
        if (this.a + 1 >= 0 && this.rowNumber > this.a + 1) {
            if (this.b - 1 >= 0 && this.colNumber > this.b - 1) {
                if (this.list[this.a + 1][b - 1].equals(" * ")) {
                    count++;
                }
            }
            if (this.b >= 0 && this.colNumber > this.b) {
                if (this.list[this.a + 1][this.b].equals(" * ")) {
                    count++;
                }
            }
            if (this.b + 1 >= 0 && this.colNumber > this.b + 1) {
                if (this.list[this.a + 1][this.b + 1].equals(" * ")) {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }

    void Display() {
        this.listDisplay[this.a][this.b] = " " + Counter() + " ";
        for (String[] strings : this.listDisplay) {
            for (String string : strings) {
                System.out.print(string);

            }
            System.out.println();

        }
    }

    boolean isWin() {
        int tableChecker = 0;
        for (String[] strings : this.listDisplay) {
            for (String string : strings) {
                if (string.equals(" - ")) {
                    tableChecker++;
                }
            }
        }
        return !(tableChecker == (this.rowNumber * this.colNumber) / 4);
    }

    void Input() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Koordinatları boşluk bırakarak giriniz: ");
            this.a = input.nextInt();
            this.b = input.nextInt();
            if (this.a < 0 || this.a > this.rowNumber || this.b < 0 || this.colNumber < this.b) {
                System.out.println("Hatalı koordinat girişi yaptınız!");
            }
        } while (!(a >= 0 && a < this.rowNumber && b >= 0 && b < this.colNumber));
    }

    void Checker2() {
        if (!this.listDisplay[this.a][this.b].equals(" - ")) {
            System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
        }
    }

    void Runner() {
        TableCreator();
        BombPlanter();
        for (String[] strings : this.list) {
            for (String string : strings) {
                System.out.print(string);

            }
            System.out.println();

        }
        while (isWin()) {
            Input();
            Checker2();
            if (!Checker()) {
                System.out.println("Kaybettiniz!");
                break;
            }
            Counter();
            Display();
            if (!isWin()) {
                System.out.println("Kazandınız!");
                break;
            }
        }
    }
}