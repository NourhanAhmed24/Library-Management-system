package com.nourhancodes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nourhancodes.Model.Book;
import com.nourhancodes.Model.BorrowingRecord;
import com.nourhancodes.Model.Patron;
import com.nourhancodes.Repository.BookRepo;
import com.nourhancodes.Repository.BorrowingRecordRepo;
import com.nourhancodes.Repository.PatronRepo;
import com.nourhancodes.Services.borrowService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordRepo borrowRecordRepo;

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private PatronRepo patronRepository;

    @Autowired
    private borrowService borrowService;

    @PostMapping("/{bookTitle}/patron/{patronName}")
    public BorrowingRecord borrowBook(
        @PathVariable String bookTitle, 
        @PathVariable String patronName) {
 
    
    return borrowService.borrowBook(bookTitle, patronName);
}


    @PutMapping("/return/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@PathVariable String bookId, @PathVariable String patronId) {
       

        return borrowService.returnBook(bookId, patronId);
    }

    @GetMapping
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowService.getAllBorrowingRecords();
    }
}
