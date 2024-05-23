import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookManager2Test {

    private BookManager manager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        manager = new BookManager();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddBook() {
        manager.addBook(1, "자바 기초", "Jane", 2021);
        assertEquals("BOOK{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021} 도서가 추가되었습니다.\n", outContent.toString());
        outContent.reset();

        manager.addBook(1, "자바 기초", "Jane", 2021);
        assertEquals("해당 ID(1)는 이미 존재합니다.\n", outContent.toString());
    }

    @Test
    public void testSearchBook() {
        manager.addBook(1, "자바 기초", "Jane", 2021);
        manager.addBook(2, "소프트웨어 공학", "Tom", 2014);
        manager.addBook(3, "분산 컴퓨팅", "Yoon", 2024);

        outContent.reset();
        List<Book> foundBooks = manager.searchBook("자바 기초");
        assertEquals("검색 결과:\nBOOK{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}\n", outContent.toString());

        outContent.reset();
        foundBooks = manager.searchBook("소프트웨어 공학");
        assertEquals("검색 결과:\nBOOK{id: '2', 제목: '소프트웨어 공학', 저자: 'Tom', 출판년도: 2014}\n", outContent.toString());

        outContent.reset();
        foundBooks = manager.searchBook("분산 컴퓨팅");
        assertEquals("검색 결과:\nBOOK{id: '3', 제목: '분산 컴퓨팅', 저자: 'Yoon', 출판년도: 2024}\n", outContent.toString());

        outContent.reset();
        foundBooks = manager.searchBook("디지털 회로");
        assertEquals("검색된 도서가 없습니다.\n", outContent.toString());
    }

    @Test
    public void testRemoveBook() {
        manager.addBook(1, "자바 기초", "Jane", 2021);
        manager.addBook(2, "소프트웨어 공학", "Tom", 2014);

        outContent.reset();
        manager.removeBook(1);
        assertEquals("BOOK{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021} 도서를 삭제하였습니다.\n", outContent.toString());

        outContent.reset();
        manager.removeBook(1);
        assertEquals("해당 ID(1)의 도서를 찾을 수 없습니다.\n", outContent.toString());

        outContent.reset();
        manager.removeBook(3);
        assertEquals("해당 ID(3)의 도서를 찾을 수 없습니다.\n", outContent.toString());
    }
}
