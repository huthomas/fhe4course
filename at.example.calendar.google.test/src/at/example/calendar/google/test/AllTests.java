package at.example.calendar.google.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import at.example.calendar.google.internal.GoogleCalendarServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ GoogleCalendarServiceTest.class })
public class AllTests {

}
