import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BookManager();
    }

    @Test
    public void testAddBook() {
        System.out.println("BOOK{id: '1', 제목: '해리포터', 저자: 'Rolling', 출판년도: 2013} 도서가 추가되었습니다.");
        manager.addBook(1, "해리 포터", "Rolling", 2013); // 중복 추가 테스트
        
        System.out.println("해당 ID(1) 는 이미 존재합니다.");
        manager.addBook(1, "퍼시", "Jane", 2021);
        
        System.out.println("검색 결과:");
        List<Book> foundBooks = manager.searchBook("해리포터");
        assertEquals(1, foundBooks.size());
        assertEquals("Rolling", foundBooks.get(1).getAuthor());
        System.out.println();

        System.out.println("BOOK{id: '1', 제목: '해리포터', 저자: 'Rolling', 출판년도: 2013} 도서를 삭제하였습니다.");
        manager.removeBook(1);
        System.out.println("해당 ID(1)의 도서를 찾을 수 없습니다.");
        manager.removeBook(1);
        System.out.println("검색된 도서가 없습니다.");
        
        foundBooks = manager.searchBook("오리고기");
        assertEquals(0, foundBooks.size());
    }
}
