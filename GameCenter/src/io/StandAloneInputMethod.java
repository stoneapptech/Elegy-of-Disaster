package io;

import java.util.Scanner;

public class StandAloneInputMethod implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String getMessage() {
        return scanner.nextLine();
    }

    @Override
    public int getNumber() {
        return scanner.nextInt();
    }
}
