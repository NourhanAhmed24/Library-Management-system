package com.nourhancodes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nourhancodes.Model.Patron;
import com.nourhancodes.Repository.PatronRepo;
import com.nourhancodes.Services.patronService;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronRepo patronRepo;
    @Autowired
    private patronService patronService;
    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable String id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public Patron addPatron(@RequestBody Patron patron) {
        return patronService.addPatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable String id, @RequestBody Patron updatedPatron) {
       
        return patronService.updatePatron(id, updatedPatron);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable String id) {
      patronService.deletePatron(id);
    }
}
