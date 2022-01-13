package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.service.PhotoService;

import java.io.IOException;


@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;


    @PostMapping(value = "/{type}/{id}")
    public void upload(@PathVariable String type, @PathVariable Long id, @RequestBody byte[] image){
       photoService.upload(type, id, image);
    }

    @GetMapping(value = "/{adviceID}/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] download(@PathVariable Long adviceID, @PathVariable String fileName) throws IOException {
        return photoService.download(adviceID, fileName);
    }

}
