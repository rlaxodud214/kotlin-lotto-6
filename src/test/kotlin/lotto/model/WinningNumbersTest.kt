package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = ["a, 2, 3, 4, 5, 6", "1, 2, 3, _"])
    fun `당첨 번호의 입력값이 Int 타입 List로 변환이 불가능하면, 예외가 발생한다`(data: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(data)
        }
        assertEquals(WinningNumbers.WINNING_NUMBERS_IS_ONLY_DIGIT, exception.message)
    }
}