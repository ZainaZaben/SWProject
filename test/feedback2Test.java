/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HP
 */
public class feedback2Test {
    
    public feedback2Test() {
    }
    @Test
    public void feedback(){
        feedback2 f = new feedback2();
        f.SetStatus("2", "1");
        String st = f.getStatus("2");
        assertEquals("1", st);
    }
    
}
