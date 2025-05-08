package AndrewWebServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    private Database database;
    private RecSys stubRecommender; // Загвар классыг testGetRecommendation-д ашиглана
    private PromoService mockPromoService;
    private AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        // We probably don't want to access our real database...
        database = new InMemoryDatabase(); // Хуурамч ӨС-г хэрэглэнэ
        
        // Stub класс ашиглаж тестийг хурдасгах
        stubRecommender = new StubRecSys("Animal House");
        
        // mockPromoService-д mock ашиглана
        mockPromoService = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(database, stubRecommender, mockPromoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        //assertTrue(andrewWebService.logIn("Scotty", 17214));

        assertTrue(andrewWebService.logIn("Scotty", 17214));
        assertFalse(andrewWebService.logIn("WrongUser", 12345));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        //assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
        
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?

        andrewWebService.sendPromoEmail("test@example.com");
        verify(mockPromoService).mailTo("test@example.com");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?

        // Verify no interactions with promoService have occurred
        verifyZeroInteractions(mockPromoService);
    }
}
