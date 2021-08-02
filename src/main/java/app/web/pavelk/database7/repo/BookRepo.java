package app.web.pavelk.database7.repo;


import app.web.pavelk.database7.shema.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);
}