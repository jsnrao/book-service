import com.word.library.request.controller.BookController
import com.word.library.request.service.BookService
import com.word.library.request.service.BookServiceImpl
import org.junit.Assert
import spock.lang.Specification


class BookControllerSpec extends Specification {

    public BookController bookController
    public BookService bookService = Mock(BookServiceImpl)

    def setup() {
        bookController = new BookController(bookService)
    }

    def "test retrieveBook"() {
        given:
        bookService.retrieveBook(_) >> "The Gruffalo book"
        when:
        String result = bookController.retrieveBook("BOOK-GRUFF472").getBody()
        then:
        Assert.assertEquals(result, "The Gruffalo book")
    }

    def "test getBookSummary"() {
        given:
        bookService.getBookSummary(_) >> "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods."
        when:
        String result = bookController.getBookSummary("BOOK-GRUFF472").getBody()
        then:
        Assert.assertEquals(result, "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods.")
    }
}
