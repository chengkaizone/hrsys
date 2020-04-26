import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SimpleTest {

    @Test
    public void testBCrypt() {
        //$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String text = encoder.encode("123");
        System.err.println("text--> " + text);
    }

}
