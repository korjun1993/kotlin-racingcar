package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import racingcar.domain.Car

class CarTest : FunSpec({
    context("자동차가 5 글자가 넘는 이름을 가지면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> { Car(name = "kotlin") }
    }

    context("자동차에 4 이상의 힘을 가하면 전진 혹은 정지한다") {
        withData(
            row(0, 0),
            row(1, 0),
            row(2, 0),
            row(3, 0),
            row(4, 1),
            row(5, 1),
            row(6, 1),
            row(7, 1),
            row(8, 1),
            row(9, 1),
        ) { (power, expected) ->
            val car = Car(name = "hojun")
            car.moveOrStop { power }
            car.location shouldBe expected
        }
    }
})
