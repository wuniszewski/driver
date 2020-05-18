package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.repository.AdviceRepository;

@Service
public class AdviceService {
    private AdviceRepository repository;
    @Autowired
    public AdviceService(AdviceRepository repository) {
        this.repository = repository;
    }
    public Advice findById(Long id) {
        return repository.getOne(id);
    }
    public Advice create (Advice advice) {
        return repository.save(advice);
    }
    public Advice update (Advice advice) {
        return repository.save(advice);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
}
