package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.repository.AdviceRepository;

@Service
public class AdviceService {
    private AdviceRepository repository;
    @Autowired
    public AdviceService(AdviceRepository repository) {
        this.repository = repository;
    }
}
