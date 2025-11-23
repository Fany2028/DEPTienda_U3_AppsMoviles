package com.example.deptienda.screen

//Android studio no guardó los cambios y ya no recuerdo como habóa quedado help
import org.junit.Test
import org.junit.Assert.*

class PostScreenTest {

    @Test
    fun titulo_post() {
        assertTrue("Test básico de PostScreen", true)
    }

    @Test
    fun test_screen_logic() {
        val expected = 2
        val actual = 1 + 1
        assertEquals(expected, actual)
    }
}