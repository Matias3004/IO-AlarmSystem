package AlarmSystem.System;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;
import jdk.jfr.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@Category("Zadanie 4")
class ControllerTest {

    User testAdminUser;
    UserData testAdminData;

    Controller cont;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    User testUser;
    UserData testUserData;
    @BeforeEach
    void setUp() {
        cont = new Controller();
        testAdminUser = new User("admin");
        testAdminData = new UserData();
        testAdminData.setPassword("1234");
        testAdminData.setUsername("admin");
        testAdminData.setId(1);
        testAdminUser.setUserData(testAdminData);
        cont.addUser(testAdminUser);

        testUserData = new UserData();
        testUserData.setUsername("adm1n");
        testUserData.setPassword("1111");
        testUserData.setId(0);
        testUser = new User("adm1n");
        testUser.setUserData(testUserData);
    }

    @Test
    void activateSystemTest() throws InterruptedException {
        assertFalse(Controller.activateSystem(testAdminUser));
        cont.authorize(testAdminUser.getUserData().getUsername(), testAdminUser.getUserData().getPassword());
        assertTrue(Controller.activateSystem(testAdminUser));
        assertTrue(Controller.isActive());
    }

    @Test
    void callAuthoritiesTest() {
        Event fev = new Event(LocalDateTime.now().format(formatter),
                "TestLocation",
                EventType.FIRE);

        assertEquals("Firefighters", cont.callAuthorities(fev.toString(), fev.getType()));

        Event bev = new Event(LocalDateTime.now().format(formatter),
                "TestLocation",
                EventType.BURGLARY);
        assertEquals("Cops", cont.callAuthorities(bev.toString(), bev.getType()));

        assertEquals("Error", cont.callAuthorities(null, null));

    }

    @Test
    void authorizeTest() {
        assertFalse(cont.authorize(testUser.getUserData().getUsername(), testUser.getUserData().getPassword()));
        assertFalse(cont.authorize("", ""));
        String username = testAdminUser.getUserData().getUsername();
        String password = testAdminUser.getUserData().getPassword();
        assertTrue(cont.authorize(username, password));
    }
}