package com.example.spyserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class SpyController {
    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/uploads/{filename}")
    public Map<String, String> uploads(@PathVariable("filename") String filename,
                                       @RequestBody String data,
                                       HttpServletRequest request) throws IOException {
        log.info(filename);
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        InputStream in = new ByteArrayInputStream(decodedBytes);
        Files.copy(in, Paths.get(uploadPath + filename), StandardCopyOption.REPLACE_EXISTING);
        return Collections.singletonMap("spy", "ok");
    }
}
