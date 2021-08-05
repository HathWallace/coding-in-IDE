package UtilLib;

import java.util.Scanner;

public class LeetCodeIO {

    private final Scanner in;
    private final InputFactory inputFactory;
    private final OutputFactory outputFactory;

    public LeetCodeIO() {
        in = new Scanner(System.in);
        inputFactory = new InputFactory();
        outputFactory = new OutputFactory();
    }

    public Object input(Class<?> parameterType) {
        String line = in.nextLine();
        return inputFactory.product(parameterType, line);
    }

    public void output(Object res) {
        String outputRes = outputFactory.product(res);
        System.out.println(outputRes);
    }
}