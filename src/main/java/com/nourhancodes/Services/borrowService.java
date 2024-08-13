package com.nourhancodes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.nourhancodes.Exceptions.ResourceNotFound;
import com.nourhancodes.Model.Book;
import com.nourhancodes.Model.BorrowingRecord;
import com.nourhancodes.Model.Patron;
import com.nourhancodes.Repository.BookRepo;
import com.nourhancodes.Repository.BorrowingRecordRepo;
import com.nourhancodes.Repository.PatronRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@Validated
public class borrowService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PatronRepo patronRepo;

    @Autowired
    private BorrowingRecordRepo borrowingRecordRepo;

   

    @Transactional
    public BorrowingRecord borrowBook(String bookTitle, String patronName) {
    Book book = bookRepo.findByTitle(bookTitle).orElseThrow(() -> new ResourceNotFound("Book not found"));
    Patron patron = patronRepo.findByName(patronName).orElseThrow(() -> new ResourceNotFound("Patron not found"));
    
    BorrowingRecord record = new BorrowingRecord();
    record.setBook(book);
    record.setPatron(patron);
    record.setBorrowDate(LocalDate.now());

    return borrowingRecordRepo.save(record);
}

    @Transactional
    public BorrowingRecord returnBook(@PathVariable String bookId, @PathVariable String patronId) {
        List<BorrowingRecord> records = borrowingRecordRepo.findByBookIdAndPatronId(bookId, patronId);
        if (records.isEmpty()) {
            System.out.print(new ResourceNotFound("No record"));
            return null;
        }

        BorrowingRecord record = records.get(0);
        record.setReturnDate(LocalDate.now());

        return borrowingRecordRepo.save(record);
    }

    public List<BorrowingRecord> getAllBorrowingRecords()
    {
        return borrowingRecordRepo.findAll();
    }
}
