package com.normal.samples;
import java.util.function.Supplier;

/**
 * https://www.javabrahman.com/java-8/java-8-java-util-function-supplier-tutorial-with-examples/
 * @author hemant.singh
 *
 */

public class TestSupplier {
    public static void main(String[] args) {
        Supplier < String > supplier = () -> { return new String("T" + "Programmer" ); };
        String p = supplier.get();
        System.out.println("supplier get output" + p);
    }
}