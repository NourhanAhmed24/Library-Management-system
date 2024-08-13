package com.nourhancodes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.nourhancodes.Model.Patron;
import com.nourhancodes.Repository.PatronRepo;

import java.util.List;

@Service
@Validated
public class patronService {

    @Autowired
    private PatronRepo patronRepo;

    public List<Patron> getAllPatrons() {
        return patronRepo.findAll();
    }

    public Patron getPatronById(String id) {
        return patronRepo.findById(id).orElse(null);
    }

    public Patron getPatronByName(String name) {
        return patronRepo.findByName(name).orElse(null);
    }

    public Patron addPatron(Patron patron) {
        return patronRepo.save(patron);
    }

    public Patron updatePatron(String name, Patron updatedPatron) {
        updatedPatron.setName(name);
        return patronRepo.save(updatedPatron);
    }

    public void deletePatron(String id) {
        patronRepo.deleteById(id);
    }
}
