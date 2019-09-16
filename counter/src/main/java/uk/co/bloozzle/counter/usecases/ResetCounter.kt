package uk.co.bloozzle.counter.usecases

import uk.co.bloozzle.counter.CounterModel

class ResetCounter(val counterModel: CounterModel) : Usecase {
    override fun execute() {
        counterModel.currentCount = 0
    }
}