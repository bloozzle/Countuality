package uk.co.bloozzle.counter

class CounterModel {
     var modelObserver : CounterModelObserver? = null

    var currentCount = 0
        set(value) {
            field = value
            modelObserver?.updateCount(currentCount)
        }




}