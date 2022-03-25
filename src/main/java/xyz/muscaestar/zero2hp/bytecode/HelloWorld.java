package xyz.muscaestar.zero2hp.bytecode;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public class HelloWorld implements Runnable {
    private static final int aInt = -999999999;
    private static final long aLong = 9999999999999L;
    private static final double aDouble = 3.2D;
    private static final float aFloat = 4.3F;
    public static void main(String[] args) {
        System.out.printf("%d, %d, %f, %f%n", aInt, aLong, aDouble, aFloat);
        final HelloWorld helloWorld = new HelloWorld();
        helloWorld.run();
    }

    @Override
    public void run() {
        System.out.println("Hello World");
    }
}
