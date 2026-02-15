
package com.hackerrank.files;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

@RestController
public class RequestController {
    public static final String UPLOAD_DIR = "uploads";
    private static final long MAX_SIZE_BYTES = 200 * 1024; // 200 KB

    public Path uploader;

    @PostConstruct
    public void init() throws IOException {
        uploader = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
        if (!Files.exists(uploader)) {
            Files.createDirectories(uploader);
        }
    }

    @PostMapping("/uploader")
    public ResponseEntity<?> uploader(
            @RequestParam("fileName") String fileName,
            @RequestParam("file") MultipartFile file) throws IOException {

       

        // Size check (reject at or above limit)
        if (file.getSize() >= MAX_SIZE_BYTES) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }

       
        Path destination = uploader.resolve(fileName).normalize();
        if (!destination.startsWith(uploader)) {
            return ResponseEntity.status(400).body("Bad Request");
        }

        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/downloader")
    public ResponseEntity<?> downloader(@RequestParam String fileName) throws MalformedURLException, IOException {
        if (fileName == null || fileName.isBlank()) {
            return ResponseEntity.status(400).body("Bad Request");
        }

        Path destination = uploader.resolve(fileName).normalize();
        if (!destination.startsWith(uploader) || !Files.exists(destination)) {
            return ResponseEntity.status(404).body("Not Found");
        }

        UrlResource url = new UrlResource(destination.toUri());
        return ResponseEntity.ok(url);
    }
}
