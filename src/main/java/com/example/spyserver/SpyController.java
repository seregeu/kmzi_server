package com.example.spyserver;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/spy")
public class SpyController {

    @PostMapping
    public Map<String, String> spy(@RequestBody SpyDTO spyDTO) {
        System.out.println(spyDTO);
        return Collections.singletonMap("spy", "ok");
    }
}
