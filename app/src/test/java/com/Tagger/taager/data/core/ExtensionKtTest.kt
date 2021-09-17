package com.Tagger.taager.data.core

import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionKtTest {

    @Test
    fun `convertIntToTime() with Integer then return a correct Date String`() {
        //arrange
        val intDate: Int = 1618928797
        // expected
        val expected = "1970.01.19 19:42"

        //val act
        val actual = intDate.convertIntToTime()
        assertEquals(expected, actual)

    }


}