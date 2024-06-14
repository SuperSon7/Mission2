import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.List;

public class BookManagerTest {
    
    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        
        // 초기 데이터 추가
        bookManager.addBook(1, "Java Programming", "John Doe", 2020);
        bookManager.addBook(2, "Python for Beginners", "Alice Smith", 2021);
    }

    @Test
    public void testAddBook() {
        // 새로운 책 추가
        bookManager.addBook(3, "Clean Code", "Robert C. Martin", 2008);
        
        // 책이 제대로 추가되었는지 확인
        List<Book> books = bookManager.getAllBooks();
        assertEquals(3, books.size());  // 책의 총 개수는 3개여야 함
        assertEquals("Clean Code", books.get(2).getTitle());  // 마지막으로 추가된 책 확인
    }

    @Test
    public void testSearchBook() {
        // 제목으로 책 검색
        List<Book> foundBooks = bookManager.searchBook("java programming");
        
        // 검색 결과 확인
        assertEquals(1, foundBooks.size());  // 검색된 책의 개수는 1개여야 함
        assertEquals("Java Programming", foundBooks.get(0).getTitle());  // 검색된 책의 제목 확인
    }

    @Test
    public void testRemoveBook() {
        // 책 삭제
        bookManager.removeBook(1);
        
        // 삭제 후 책 목록 확인
        List<Book> books = bookManager.getAllBooks();
        assertEquals(1, books.size());  // 책의 총 개수는 1개여야 함
        assertFalse(books.stream().anyMatch(book -> book.getId() == 1));  // 삭제된 책 ID가 없어야 함
    }

    @Test
    public void testDisplayAllBooks() {
        // 모든 책 출력 메서드 호출
        bookManager.displayAllBooks();
        // 테스트가 필요하지 않습니다.
    }
}
