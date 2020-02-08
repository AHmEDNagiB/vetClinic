package com.eme.springTask.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.eme.springTask.utils.Constant.FILES_PATH;

@Component
public class FileUpload {

    public String singleFileUpload(MultipartFile file) {

        if (file.isEmpty()) {
            return FILES_PATH + "/defalutDocImage.png";
        }
        try {

            // Get the file and save it to files folder
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILES_PATH + file.getOriginalFilename());
            Files.write(path, bytes);

            return path.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
