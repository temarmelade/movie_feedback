package org.example.movie_feedback.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.example.movie_feedback.model.Movie;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUtil {
    private final Gson gson;
    private final static String UPLOAD_DIR = "data/";
//    @Autowired
    public FileUtil() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    public List<Movie> getMovies(String path) {
        Type listType = new TypeToken<Map<String, List<Movie>>>() {}.getType();
        try (Reader reader = new FileReader(UPLOAD_DIR + path)) {
            Map<String, List<Movie>> movies = gson.fromJson(reader, listType);
            return movies.get("movies");
        }
        catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
    @SneakyThrows
    public String saveUploadFile(MultipartFile file, String subDir) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + " " + file.getOriginalFilename();

        Path pathDir = Paths.get(UPLOAD_DIR + subDir);
        Files.createDirectories(pathDir);
        return resultFileName;
    }
}
