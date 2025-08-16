package tech.buildrun.urleasy.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.urleasy.controller.dto.EasyUrlResponse;
import tech.buildrun.urleasy.controller.dto.UrlEasyRequest;
import tech.buildrun.urleasy.entities.UrlEntity;
import tech.buildrun.urleasy.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class UrlController {

    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @PostMapping("/urleasy")
    public ResponseEntity<EasyUrlResponse> shortenUrl(
            @RequestBody UrlEasyRequest request,
            HttpServletRequest servletRequest) {

        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        UrlEntity urlEntity = new UrlEntity(
                id,
                request.url(),
                LocalDateTime.now().plusMinutes(1));

        urlRepository.save(urlEntity);

        String redirectUrl = servletRequest.getRequestURL()
                .toString()
                .replace("urleasy", id);

        return ResponseEntity.ok(new EasyUrlResponse(redirectUrl));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        Optional<UrlEntity> urlEntity = urlRepository.findById(id);

        if (urlEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlEntity.get().getFullUrl()));

        return ResponseEntity.status(HttpStatus.FOUND)
                .headers(headers)
                .build();
    }
}