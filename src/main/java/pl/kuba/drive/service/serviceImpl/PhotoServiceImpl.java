package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.entity.Photo;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.AdviceRepository;
import pl.kuba.drive.repository.PhotoRepository;
import pl.kuba.drive.repository.QuestionRepository;
import pl.kuba.drive.service.PhotoService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final AdviceRepository adviceRepository;
    private final QuestionRepository questionRepository;

    @Override
    public void upload(String type, Long id, byte[] image) {
        if (type.equals("advice")) {
            Photo photo = new Photo();
            photo.setAdvice(adviceRepository.findById(id)
                    .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
            photo.setName(writeImage(type, id, image));
            photoRepository.save(photo);
        } else if (type.equals("question")) {
            Photo photo = new Photo();
            photo.setQuestion(questionRepository.findById(id)
                    .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
            photo.setName(writeImage(type, id, image));
            photoRepository.save(photo);
        }

    }

    @Override
    public byte[] download(Long adviceID, String fileName) throws IOException {
        return readImage(adviceID, fileName);
    }

    private String writeImage(String type, Long id, byte[] image) {
        String path = System.getProperty("user.dir") + "/images";

        if (type.equals("advice")) path = path.concat("/advices");
        if (type.equals("question")) path = path.concat("/questions");


        String directoryName = path.concat(id.toString());
        String fileName = id + "_" + LocalDateTime.now().toString();

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        Path filePath = Paths.get(directoryName + "/" + fileName + ".jpg");
        try {
            Files.write(filePath, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private byte[] readImage(Long adviceID, String fileName) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir") + "/images" + adviceID.toString() + "/" + fileName + ".jpg");
        return Files.readAllBytes(path);
    }
}
