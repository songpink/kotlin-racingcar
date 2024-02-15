package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class ExceptionHandlingTest {
    lateinit var exceptionHandling: ExceptionHandling

    @BeforeEach
    fun setup() {
        exceptionHandling = ExceptionHandling()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 20, 100])
    fun `자동차 개수가 1 ~ 100 개 일 때 true를 반환하는지`(input: Int) {
        val result = exceptionHandling.limitNumberOfCars(input)
        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 101, 200, 1000])
    fun `자동차 개수가 1 ~ 100 개가 아닐 때 false를 반환하는지`(input: Int) {
        val result = exceptionHandling.limitNumberOfCars(input)
        assertThat(result).isFalse()
    }

    @Test
    fun `자동차 이름의 중복이 없을 때 true를 반환하는지`() {
        val result = exceptionHandling.duplicatedCarName(listOf("alsong", "haeum"))
        assertThat(result).isTrue()
    }

    @Test
    fun `자동차 이름의 중복이 있을 때 false를 반환하는지`() {
        val result = exceptionHandling.duplicatedCarName(listOf("alsong", "haeum", "alsong"))
        assertThat(result).isFalse()
    }
}