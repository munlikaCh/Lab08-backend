package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

import java.util.List;


@Repository
@Profile("db")

public class OrganizerDaoImpl implements OrganizerDao {
    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
//        List<Event> events = eventRepository.findAll();
//        pageSize = pageSize == null ? events.size() : pageSize;
//        page = page == null ? 1 : page;
//        int firstIndex = (page - 1) * pageSize;
//        List<Event> output = events.subList(firstIndex, firstIndex+pageSize);
        return organizerRepository.findAll(PageRequest.of(page -1, pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}