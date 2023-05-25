# SI_2023_lab2_212028
Дарко Секуловски 212028 

# Control Flow Graph 

![ControlFlow Diagram](https://github.com/daresekulovski/SI_2023_lab2_212028/assets/129841215/8e9ec329-6ed6-45a8-b162-db1af73da868)

# Цикломатска комплесност 
E - N + 2 = 35 - 26 = 11 <br> 
* 35 ребра <br> 
* 26 јазли <br> 

# Every Branch

| Every Branch | User=null \|\| pass=null \|\| email=null, <br> username=null,<br> AllUsers=null | User=user1, <br> pass=dare1234, <br> email=dare1234@gmail.com, <br> username=null, <br> AllUsers=null | User=user1, <br> pass=sekulovski, <br> email=dares@gmail.com, <br> username=dare, <br> AllUsers={user1} | User=user2, <br> pass=Sekulovski#1, <br> email=dares@gmail.com, <br> username=dare, <br> AllUsers={user1} | User=user1, <br> pass=se kulovski, <br> email=daresgmail.com, <br> username=dare, <br> AllUsers=null |
|---|---|---|---|---|---|
| 1,2 – 3 | * |  |  |  |  |
| 1,2 – 4 |  | * | * | * | * |
| 3 – 28 | * |  |  |  |  |
| 4 – 5 |  | * |  |  |  |
| 4 – 6,7 |  |  | * | * | * |
| 5 – 6,7 |  | * |  |  |  |
| 6,7 – 8 |  |  | * | * |  |
| 6,7 – 16,17,18,19 |  | * |  |  | * |
| 8 – 9.1 |  |  | * | * |  |
| 9.1 – 9.2 |  |  | * | * |  |
| 9.2 – 10 |  |  | * | * |  |
| 9.2 – 16,17,18,19 |  |  | * | * |  |
| 10 – 11 |  |  | * |  |  |
| 11 – 12 |  |  | * |  |  |
| 11 – 13 |  |  |  | * |  |
| 12 – 13 |  |  | * |  |  |
| 13 – 14 |  |  | * |  |  |
| 13 – 15 |  |  |  | * |  |
| 14 – 15 |  |  | * |  |  |
| 15 – 9.3 |  |  | * | * |  |
| 9.3 – 9.2 |  |  | * | * |  |
| 16,17,18,19 – 20 |  | * |  |  |  |
| 16,17,18,19 – 21,22 |  |  | * | * | * |
| 20 – 28 |  | * |  |  |  |
| 21,22 – 27 |  |  |  |  | * |
| 21,22 – 23.1 |  |  | * | * |  |
| 23.1 – 23.2 |  |  | * | * |  |
| 23.2 – 24 |  |  | * | * |  |
| 23.2 – 27 |  |  | * |  |  |
| 24 – 25 |  |  |  | * |  |
| 24 – 26 |  |  | * | * |  |
| 26 – 23.3 |  |  | * | * |  |
| 23.3 – 23.2 |  |  | * | * |  |
| 27 – 28 |  |  | * |  | * |
| 25 – 28 |  |  |  | * |  |. 

# Multiple Condition <br>

 Multiple ConditionCombination | Test Case | Branch |
|---|---|---|
| TXX | User=null,pass=null,email=null,username=null,AllUsers=null | 1,2 – 3 |
| FTX | User=user1,pass=null,email=null,username=null,AllUsers=null | 1,2 – 3 |
| FFT | User=user1,pass=dare1234,email=null,username=null,AllUsers=null | 1,2 – 3 |
| FFF | User=user1,pass=dare1234,email=dares@gmail.com,username=null,AllUsers=null | 1,2 – 4 |. 

# Tests <br>
```
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
```
