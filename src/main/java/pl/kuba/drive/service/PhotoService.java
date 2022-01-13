package pl.kuba.drive.service;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    void upload(String type, Long adviceID, byte[] image);

    byte[] download(Long adviceID, String fileName) throws IOException;

}