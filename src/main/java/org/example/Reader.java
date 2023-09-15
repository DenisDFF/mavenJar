package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> reader (String file) {
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> createUserListFromLines(List<String> userLines) {
        List<String> users = new ArrayList<>();

        for (int i = 0; i < userLines.size(); i++) {
            users.add(userLines.get(i));
        }

        return users;
    }

    public void writeToJsonFile(List<String> users, String outputFile) {
        Gson gson = new Gson();
        String json = gson.toJson(users);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
