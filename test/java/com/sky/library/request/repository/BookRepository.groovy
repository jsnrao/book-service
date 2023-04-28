import com.word.library.exception.BookNotFoundException
import com.word.library.repository.BookRepository
import com.word.library.repository.BookRepositoryStub
import org.junit.Assert
import spock.lang.Specification

class BookRepositorySpec extends Specification {

    BookRepository bookRepository

    def setup() {
        bookRepository = new BookRepositoryStub()
    }

    def "test retrieveBook"() {
        when:
        String result = bookRepository.retrieveBook("BOOK-GRUFF472")
        then:
        Assert.assertEquals(result, "The Gruffalo book ")
    }

    def "test getBookSummary "() {
        when:
        String result = bookRepository.getBookSummary(bookReferenceValue)
        then:
        Assert.assertEquals(result, resultValue)
        where:
        bookReferenceValue || resultValue
        "BOOK-GRUFF472"    || "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods."
        "BOOK-POOH222"     || "[BOOK-POOH222] Winnie The Pooh - In this first volume, we meet all the friends..."
        "BOOK-WILL987"     || "[BOOK-WILL987] The Wind In The Willows - With the arrival of spring and fine weather outside,..."
    }

    def "test getBookSummary with invalid book reference prefix"() {
        //  given:
        when:
        bookRepository.getBookSummary("BOOK-999")
        then:
        thrown BookNotFoundException
    }

    def "test retrieveBook with invalid book reference prefix"() {
        //  given:
        when:
        bookRepository.retrieveBook("BOOK-999")
        then:
        thrown BookNotFoundException
    }

}
