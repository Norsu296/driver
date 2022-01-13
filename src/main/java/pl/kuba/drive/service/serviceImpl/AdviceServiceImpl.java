package pl.kuba.drive.service.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.AdviceMapper;
import pl.kuba.drive.dto.mapper.TagMapper;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.entity.Advice;
import pl.kuba.drive.entity.Photo;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.AdviceRepository;
import pl.kuba.drive.service.AdviceService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;
    private final TagMapper tagMapper;

    @Override
    public List<AdviceDTO> findAll() {
        return adviceMapper.toAdviceDTOs(adviceRepository.findAll());
    }

    @Override
    public AdviceDTO findById(Long id) {
        if(adviceRepository.findById(id).isPresent()){
            List<Photo> photos = adviceRepository.getById(id).getPhotos();
            List<String> photoPaths = new ArrayList<>();
            for(Photo photo : photos){
                photoPaths.add("http://localhost:8080/photos/" + id + "/" + photo.getName());
            }
            AdviceDTO adviceDTO = adviceMapper.toAdviceDTO(adviceRepository.getById(id));
            adviceDTO.setPhotos(photoPaths);
            return adviceDTO;
        }
        throw new ControllerException(ErrorMessage.NOT_FOUND);
    }

    @Override
    public AdviceDTO create(AdviceDTO adviceDTO) {
        return adviceMapper.toAdviceDTO(adviceRepository.save(adviceMapper.toAdvice(adviceDTO)));
    }

    @Override
    public void deleteById(Long id) {
        adviceRepository.deleteById(id);
    }

    @Override
    public AdviceDTO edit(AdviceDTO advice) {
        return adviceMapper.toAdviceDTO(adviceRepository.findById(advice.getId())
                .map(adviceFromDb -> {
                    adviceFromDb.setTitle(advice.getTitle());
                    adviceFromDb.setContent(advice.getContent());
                    adviceFromDb.setTags(tagMapper.toTagsFromAdvice(advice.getTags()));
                    return adviceRepository.save(adviceFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public AdviceDTO like(Long id, String action) {
        if (adviceRepository.findById(id).isPresent()) {
            Advice advice = adviceRepository.getById(id);
            if (action.equals("add")) {
                advice.setPoints(advice.getPoints() + 1);
                return adviceMapper.toAdviceDTO(adviceRepository.save(advice));
            } else if (action.equals("remove")) {
                advice.setPoints(advice.getPoints() - 1);
                return adviceMapper.toAdviceDTO(adviceRepository.save(advice));
            } else {
                throw new ControllerException(ErrorMessage.BAD_REQUEST);
            }
        } else {
            throw new ControllerException(ErrorMessage.NOT_FOUND);
        }
    }


}
