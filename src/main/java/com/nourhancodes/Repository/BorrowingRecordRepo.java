package com.nourhancodes.Repository;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nourhancodes.Model.BorrowingRecord;

public interface BorrowingRecordRepo extends MongoRepository<BorrowingRecord,String>{
 List<BorrowingRecord> findByBookIdAndPatronId(String bookId, String patronId);
}
