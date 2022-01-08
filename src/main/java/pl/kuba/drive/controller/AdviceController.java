package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.service.AdviceService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/advices")
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @RolesAllowed("user")
    @GetMapping()
    public List<AdviceDTO> findAll() {
        return adviceService.findAll();
    }

    @RolesAllowed("admin")
    @GetMapping("/{id}")
    public AdviceDTO findById(@PathVariable Long id) {
        return adviceService.findById(id);
    }

    @PatchMapping("/like/add/{id}")
    public AdviceDTO addLike(@PathVariable Long id) {
        return adviceService.like(id, "add");
    }

    @PatchMapping("/like/remove/{id}")
    public AdviceDTO removeLike(@PathVariable Long id) {
        return adviceService.like(id, "remove");
    }

    @PostMapping
    public AdviceDTO create(@RequestBody AdviceDTO adviceDTO) {
        return adviceService.create(adviceDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adviceService.deleteById(id);
    }

    @PutMapping
    public AdviceDTO edit(@RequestBody AdviceDTO adviceDTO) {
        return adviceService.edit(adviceDTO);
    }

}
