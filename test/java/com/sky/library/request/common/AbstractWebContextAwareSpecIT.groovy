package java.com.sky.library.request.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

class AbstractWebContextAwareSpecIT extends Specification {
    @Autowired
    WebApplicationContext webApplicationContext
    @Shared
    MockMvc mockMvc
}
