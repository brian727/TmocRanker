package com.briansdigital.p1TmocRunRanker.tmocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TmockerService {

    private final TmockerRepo tmockerRepo;

    @Autowired
    public TmockerService(TmockerRepo tmockerRepo) {

        this.tmockerRepo = tmockerRepo;
    }

    public List<Tmocker> getTmockers() {

        return tmockerRepo.findAll();
    }

    public void addNewTmocker(Tmocker tmocker) {
        Optional<Tmocker> tmockerOptional = tmockerRepo.findTmockerByEmail(tmocker.getEmail());
        if (tmockerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        tmockerRepo.save(tmocker);
    }



    @Transactional
    public void updateTmocker(Long tmockerId, String name, String email) {
        Tmocker tmocker = tmockerRepo.findById(tmockerId).orElseThrow(() -> new IllegalStateException(
                "tmocker with id " + tmockerId + " does not exist!"
        ));
                if (name != null && name.length() > 0 && !Objects.equals(tmocker.getName(), name)) {
                    tmocker.setName(name);
                }
                if(email !=null && email.length() > 0 && !Objects.equals(tmocker.getEmail(), email)) {
                    Optional<Tmocker> tmockerOptional = tmockerRepo.findTmockerByEmail(email);
                    if (tmockerOptional.isPresent()) {
                        throw new IllegalStateException("email taken!");
                    }
                    tmocker.setEmail(email);
                }
    }

    public void deleteTmocker(Long tmockerId) {

    }
}
