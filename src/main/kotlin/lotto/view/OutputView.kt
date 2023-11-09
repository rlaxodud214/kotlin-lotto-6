package lotto.view

import lotto.Constants
import lotto.model.Lottos
import lotto.util.Match

class OutputView {
    fun printBuyingResults(lottos: Lottos) {
        println(BUYING_COUNT_CONFIRMATION.format(lottos.lottoNumbers.size))

        lottos.lottoNumbers.forEach {
            println(it.numbers)
        }
    }

    fun printWinningResults(result: Map<Int, Int>) {
        println("$WINNING_STATISTICS\n$DIVIDING_LINE")

        Match.values().forEach outer@{ match ->
            if (match == Match.MISS) {
                return@outer
            }

            println(WINNING_STATISTICS_INFO.format(match.info, match.amount, result[match.count] ?: 0))
        }
    }

    fun printRateOfReturn(reward: String) {
        println(TOTAL_RATE_OF_RETURN.format(reward))
    }

    fun printError(errorMessage: String) = println("${Constants.ERROR_TAG} $errorMessage")

    companion object {
        private const val BUYING_COUNT_CONFIRMATION = "%d개를 구매했습니다."

        private const val WINNING_STATISTICS = "당첨 통계"
        private const val DIVIDING_LINE = "---"

        private const val WINNING_ = "---"
        private const val WINNING_STATISTICS_INFO = "%s (%s원) - %d개"


        private const val TOTAL_RATE_OF_RETURN = "총 수익률은 %s입니다."
    }
}