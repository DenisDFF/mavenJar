package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args) {
        Reader reader = new Reader() {
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            public void close() throws IOException {

            }
        };

        List<String> userLine = new ArrayList<>();
        String outputFile = "myname.json";
        userLine.add("Denys");
        userLine.add("Petrov");
        List<String> user = reader.createUserListFromLines(userLine);
        reader.writeToJsonFile(user, outputFile);

        String file = "myname.json";
        List<String> myName = reader.reader(file);
        System.out.println(myName);
    }
}
