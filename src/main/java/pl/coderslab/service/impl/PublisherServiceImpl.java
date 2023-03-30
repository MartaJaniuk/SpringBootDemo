package pl.coderslab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;
import pl.coderslab.service.PublisherService;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;



    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id).get();
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

//    @Override
//    public List<pl.coderslab.model.Publisher> findAllPublisherModel(){
//
//        final List<Publisher> publishers = publisherRepository.findAll();
//        return publishers
//                .stream()
//                .map(publisherEntity -> {
//                    pl.coderslab.model.Publisher publisher = new pl.coderslab.model.Publisher();
//                    publisher.setId(publisherEntity.getId());
//                    publisher.setName(publisherEntity.getName());
//                    return publisher;
//                })
//                .collect(Collectors.toList());
//
//    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

}
