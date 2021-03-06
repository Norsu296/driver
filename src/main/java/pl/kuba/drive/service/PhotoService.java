package pl.kuba.drive.service;

import java.io.IOException;

public interface PhotoService {

    void upload(String type, Long id, byte[] image);

    byte[] download(String type, Long id, String fileName) throws IOException;

}
