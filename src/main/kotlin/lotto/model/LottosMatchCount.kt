package lotto.model

import lotto.dto.LottoMatchCount
import lotto.util.Match

class LottosMatchCount(
    private val _result: MutableMap<Int, Int> = Match.values()
        .associate { it.count to RESULT_DEFAULT_VALUE }
        .toMutableMap()
) {
    val result get() = _result

    fun update(lottoMatchCount: LottoMatchCount) {
        require (lottoMatchCount.winning in NO_WINNING_MATCHES..MAX_WINNING_MATCHES) {
            UNPREDICTABLE_WINNING_MATCHES_VALUE
        }

        var key = lottoMatchCount.winning.takeIf { it >= MIN_WINNING_MATCHES } ?: 0
        if (lottoMatchCount.winning == SPECIAL_MATCH_COUNT) {
            key = Match.FIFTH.count.takeIf { lottoMatchCount.bonus == NO_BONUS_MATCH }
                ?: Match.FIFTH_BONUS.count
        }

        _result[key] = _result.getOrDefault(key, RESULT_DEFAULT_VALUE) + COUNT_PLUS_VALUE
    }

    companion object {
        private const val RESULT_DEFAULT_VALUE = 0
        private const val COUNT_PLUS_VALUE = 1

        private const val NO_WINNING_MATCHES = 0
        private const val MIN_WINNING_MATCHES = 3
        private const val MAX_WINNING_MATCHES = 6
        private const val UNPREDICTABLE_WINNING_MATCHES_VALUE =
            "매칭된 당첨 번호의 개수가 $NO_WINNING_MATCHES~$MAX_WINNING_MATCHES 범위를 벗어났습니다."

        private const val SPECIAL_MATCH_COUNT = 5
        private const val NO_BONUS_MATCH = 0
    }
}