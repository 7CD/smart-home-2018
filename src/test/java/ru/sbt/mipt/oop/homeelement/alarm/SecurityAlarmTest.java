package ru.sbt.mipt.oop.homeelement.alarm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ??? По отдельности все тесты работают, а все вместе нет.
 */
public class SecurityAlarmTest {

    SecurityAlarm securityAlarm;

    @Before
    public void setUp() {
        securityAlarm = new SecurityAlarm();
        securityAlarm.setPassword(null,"1234");
    }

    @Test
    public void setPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        securityAlarm.setPassword("4321", "1234");
        assertEquals("Can not change alarm security password: wrong old password.\r\n",
                output.toString());

        output.reset();
        securityAlarm.setPassword("1234", "1234");
        assertEquals("Alarm security password has been changed.\r\n",
                output.toString());

        System.setOut(System.out);
    }

    @Test
    public void checkPassword() {
        assertTrue(securityAlarm.checkPassword("1234"));
        assertFalse(securityAlarm.checkPassword("4321"));

        SecurityAlarm securityAlarm1 = new SecurityAlarm();
        assertTrue(securityAlarm1.checkPassword(null));
    }

    @Test
    public void activate() {
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmDeactivatedState);

        securityAlarm.activate("4321");
        assertFalse(getAlarmState(securityAlarm) instanceof SecurityAlarmActivatedState);
        securityAlarm.activate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmActivatedState);

        securityAlarm.activate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmActivatedState);

        securityAlarm.alert();
        securityAlarm.activate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmAlertState);
    }

    @Test
    public void deactivate() {
        securityAlarm.activate("1234");

        assertEquals(getAlarmState(securityAlarm).getClass(), SecurityAlarmActivatedState.class);

        securityAlarm.deactivate("4321");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmAlertState);

        securityAlarm.deactivate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmDeactivatedState);

        securityAlarm.deactivate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmDeactivatedState);

        securityAlarm.alert();
        securityAlarm.deactivate("1234");
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmDeactivatedState);
    }

    @Test
    public void alert() {
        securityAlarm.activate("1234");
        securityAlarm.alert();
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmAlertState);

        securityAlarm.deactivate("1234");
        securityAlarm.alert();
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmAlertState);

        securityAlarm.alert();
        assertTrue(getAlarmState(securityAlarm) instanceof SecurityAlarmAlertState);
    }

    @Test
    public void isActivated() {
        securityAlarm.deactivate("1234");
        assertFalse(securityAlarm.isActivated());

        securityAlarm.activate("1234");
        assertTrue(securityAlarm.isActivated());

        securityAlarm.alert();
        assertTrue(securityAlarm.isActivated());
    }

    private SecurityAlarmState getAlarmState(SecurityAlarm alarm) {
        try {
            Field state = alarm.getClass().getDeclaredField("securityAlarmState");
            state.setAccessible(true);
            return (SecurityAlarmState)state.get(alarm);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }
}