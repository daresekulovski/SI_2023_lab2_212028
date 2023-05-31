import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SILab2Test {
@Test
    void EveryBranch() {
    RuntimeException ex;
    ex = Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
    Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    Assertions.assertEquals(false, SILab2.function(new User(null, "dare1234", "dare1234gmailcom"), Collections.emptyList()));

    User user1 = new User("dare", "sekulovski", "dares@gmail.com");
    List<User> users = new ArrayList<>();
    users.add(user1);
    Assertions.assertEquals(false, SILab2.function(user1, users));

    User user2 = new User("Dare", "Sekulovski#1","dareS@gmail.com");
    Assertions.assertEquals(true, SILab2.function(user2, users));

    Assertions.assertEquals(false, SILab2.function(new User("dare", "se kulovski", "daresgmail.com"), Collections.emptyList()));
}
@Test
    void MultipleCondition() {
    //TXX
    RuntimeException ex;
    ex = Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
    Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    //FTX
    ex = Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), null));
    Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    //FFT
    ex = Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, "dare1234", null), null));
    Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    //FFF
    Assertions.assertEquals(false, SILab2.function(new User(null, "dare1234", "dares@gmail.com"), Collections.emptyList()));
}
}
