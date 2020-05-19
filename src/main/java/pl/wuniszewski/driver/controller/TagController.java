package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wuniszewski.driver.converter.TagConverter;
import pl.wuniszewski.driver.dto.TagDto;
import pl.wuniszewski.driver.entity.Tag;
import pl.wuniszewski.driver.service.TagService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;
    private TagConverter tagConverter;
    @Autowired
    public TagController(TagService tagService, TagConverter tagConverter) {
        this.tagService = tagService;
        this.tagConverter = tagConverter;
    }
    @GetMapping("/{name}")
    public TagDto getTagByName (@PathVariable(name = "name") String name) throws EntityNotFoundException{
        Tag entity = tagService.getTagByName(name);
        return tagConverter.convertToDto(entity);
    }
    @GetMapping
    public List<TagDto> getAllTags () {
        return tagService.getAllTags().stream()
                .map(tagConverter::convertToDto)
                .collect(Collectors.toList());
    }
    @PostMapping
    public TagDto createNewTag (@RequestBody TagDto tagDto) {
        Tag newTag = tagConverter.convertToEntity(tagDto);
        Tag savedTag = tagService.create(newTag);
        return tagConverter.convertToDto(savedTag);
    }
}
