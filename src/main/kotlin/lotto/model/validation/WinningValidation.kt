package lotto.model.validation

import lotto.dto.WinningAndBonusNumbers

class WinningValidation(
    private val winningAndBonusNumbers: WinningAndBonusNumbers
) {
    init {
        validateDuplicate(winningAndBonusNumbers)
    }

    private fun validateDuplicate(winningAndBonusNumbers: WinningAndBonusNumbers) {
        require(winningAndBonusNumbers.winNums.count { it == winningAndBonusNumbers.bonusNum } == 0) {
            WINNING_BONUS_NUMBER_IS_NOT_DUPLICATE
        }
    }

    companion object {
        const val WINNING_BONUS_NUMBER_IS_NOT_DUPLICATE = "당첨 번호와 보너스 번호는 중복될 수 없습니다."
    }
}