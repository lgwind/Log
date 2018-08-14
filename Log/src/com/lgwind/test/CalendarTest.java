package com.lgwind.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.util.IData;

public class CalendarTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void yearTest() {
        System.out.println(IData.year());
    }
    
    @Test
    public void monthTest() {
        System.out.println(IData.month());
    }
    
    @Test
    public void dayTest() {
        System.out.println(IData.day());
    }
    
    @Test
    public void weekDayTest() {
        System.out.println(IData.weekDay());
    }
    
    @Test
    public void weekOfDayTest() {
        System.out.println(IData.weekOfDay(2011, 1, 22));
    }
    
    @Test
    public void daysOfMonthTest() {
        System.out.println(IData.daysOfMonth(2011, 2));
    }
    
    @Test
    public void daysTest(){
        String [] days = IData.days(2018, 4);
        for(int i=0; i<days.length; i++ ){
            System.out.println(days[i]);
        }
    }

}
