package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
    @GetMapping
    public TagDto getTagByName (@RequestParam(name = "name") String name) {
        TagDto tagDto;
        try {
            Tag entity = tagService.getTagByName(name);
            tagDto = tagService.convertToDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This tag doesn't exist");
        }
        return tagDto;
    }
//    @GetMapping
//    public List<TagDto> getAllTags () {
//        return tagService.getAllTags().stream()
//                .map(tagService::convertToDto)
//                .collect(Collectors.toList());
//    }
    @PostMapping
    public TagDto createNewTag (@RequestBody TagDto tagDto) {
        Tag newTag = tagService.convertToEntity(tagDto);
        Tag savedTag = tagService.create(newTag);
        return tagService.convertToDto(savedTag);
    }
}
