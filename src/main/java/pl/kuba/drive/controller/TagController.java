package pl.kuba.drive.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping()
    public List<TagDTO> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public TagDTO findById(@PathVariable Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public TagDTO create(@RequestBody TagDTO tagDTO) {
        return tagService.create(tagDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.deleteById(id);
    }

    @PutMapping
    public TagDTO edit(@RequestBody TagDTO tagDTO){
        return tagService.edit(tagDTO);
    }
}
