package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.repository.OptionRepository;

@Service
public class OptionService {
    private OptionRepository repository;

    @Autowired
    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }
}
