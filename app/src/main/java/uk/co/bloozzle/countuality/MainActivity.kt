package uk.co.bloozzle.countuality

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import uk.co.bloozzle.counter.CounterModel
import uk.co.bloozzle.counter.CounterModelObserver
import uk.co.bloozzle.counter.usecases.IncrementCounter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val counterModel = CounterModel()
        val incrementCounter = IncrementCounter(counterModel)

        val counterModelObserver = object:CounterModelObserver {
            override fun updateCount(currentCount: Int) {
                count.text = currentCount.toString()
            }

        }

        counterModel.modelObserver = counterModelObserver

        count_container.setOnClickListener {
            incrementCounter.execute()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
