package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.entity.Option;
import pl.wuniszewski.driver.repository.OptionRepository;

@Service
public class OptionService {
    private OptionRepository repository;

    @Autowired
    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }
    public Option findById(Long id) {
        return repository.getOne(id);
    }
    public Option create (Option option) {
        return repository.save(option);
    }
    public Option update (Option option) {
        return repository.save(option);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
}
