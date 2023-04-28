import com.word.library.exception.BookNotFoundException
import com.word.library.repository.BookRepository
import com.word.library.request.service.BookService
import com.word.library.request.service.BookServiceImpl
import org.junit.Assert
import spock.lang.Specification

class BookServiceSpec extends Specification{

    BookService booksService

    BookRepository bookRepository = Mock(BookRepository)

    def setup() {
        booksService = new BookServiceImpl(bookRepository)
    }
    def "test retrieveBook"() {
        given:
        bookRepository.retrieveBook(_) >> "The Gruffalo book"
        when:
        String result = booksService.retrieveBook("BOOK-GRUFF472")
        then:
        Assert.assertEquals(result, "The Gruffalo book")
    }

    def "test getBookSummary "() {
        given:
        bookRepository.getBookSummary(_) >> "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods."
        when:
        String result = booksService.getBookSummary("BOOK-GRUFF472")
        then:
        Assert.assertEquals(result, "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods.")
    }

    def "test getBookSummary with invalid book reference prefix"() {
      //  given:
        when:
        booksService.getBookSummary("PPPP-GRUFF472")
        then:
        thrown BookNotFoundException
    }

    def "test retrieveBook with invalid book reference prefix"() {
      //  given:
        when:
        booksService.retrieveBook("PPPP-GRUFF472")
        then:
        thrown BookNotFoundException
    }

}
