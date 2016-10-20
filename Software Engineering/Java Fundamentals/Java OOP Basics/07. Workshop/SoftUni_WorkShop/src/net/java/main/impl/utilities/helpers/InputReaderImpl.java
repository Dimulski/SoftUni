package net.java.main.impl.utilities.helpers;

import net.java.main.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader{

    @Override
    public String readLine() {
        return new Scanner(System.in).nextLine();
    }
}
