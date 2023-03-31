package com.hiruni.bumblebee.accessLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessLevelService {

    private final AccessLevelRepository accessLevelRepository;

    @Autowired
    public AccessLevelService(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    public void addNewAccessLevel(AccessLevel accessLevel) {
        accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> getAccessLevel() {
        return accessLevelRepository.findAll();
    }
}
