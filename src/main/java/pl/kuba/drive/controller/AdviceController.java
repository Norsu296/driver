package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.service.AdviceService;

import java.util.List;

@RestController
@RequestMapping("/advices")
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping()
    public List<AdviceDTO> findAll() {
        return adviceService.findAll();
    }

    @GetMapping("/{id}")
    public AdviceDTO findById(@PathVariable Long id) {
        return adviceService.findById(id);
    }

    @PostMapping
    public AdviceDTO create(@RequestBody AdviceDTO adviceDTO) {
        return adviceService.create(adviceDTO);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        adviceService.deleteById(id);
    }
}
