package com.example.spyserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class SpyController {
    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/spy")
    public Map<String, String> spy(@RequestBody SpyDTO spyDTO) {
        System.out.println(spyDTO);
        return Collections.singletonMap("spy", "ok");
    }

    @PostMapping("/uploads/{filename}")
    public Map<String, String> uploads(@PathVariable("filename") String filename,
                                       HttpServletRequest request) throws IOException {
        log.info(filename);

        Files.copy(request.getInputStream(), Paths.get(uploadPath + filename), StandardCopyOption.REPLACE_EXISTING);
        return Collections.singletonMap("spy", "ok");
    }
}
