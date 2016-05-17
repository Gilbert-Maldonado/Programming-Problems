import java.util.*;
import java.io.*;

// Explains stuff about stringbuffer

public class StringBuffer {

    public static void main(String [] args) {

        StringBuffer hello = new StringBuffer();
        hello.append("Hello");
        StringBuffer b = new StringBuffer();
        b.append(hello.reverse());
        System.out.println(hello.toString());
    }
}