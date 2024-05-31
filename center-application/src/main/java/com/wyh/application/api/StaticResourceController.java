package com.wyh.application.api;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/static")
public class StaticResourceController {

    @GetMapping("/image/{name}")
    public void getImage(@PathVariable(value = "name") String name, HttpServletResponse response) throws IOException {
        ClassPathResource resource = new ClassPathResource("static/swiper_image/" + name);
        try (InputStream inputStream = resource.getInputStream()){
            StreamUtils.copy(inputStream, response.getOutputStream());
        }
    }
    @GetMapping("/images")
    public List<String> getImageList() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("static/swiper_image/*");
        return Arrays.stream(resources).map(Resource::getFilename).collect(Collectors.toList());
    }
}
