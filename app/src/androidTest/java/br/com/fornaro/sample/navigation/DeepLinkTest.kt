package br.com.fornaro.sample.navigation

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeepLinkTest {

    private val screen = "fill"

    private val url = "http://navsample.com/$screen"

    @get:Rule
    var activityTestRule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {
        override fun getActivityIntent(): Intent {
            return Intent(Intent.ACTION_VIEW, Uri.parse(url))
        }
    }

    @Test
    fun deepLink_opens_fill_screen_backs_to_home() {
        assertInFill()
        pressBack()
        assertInHome()
    }

    private fun assertInFill() {
        onView(withId(R.id.integerEditText)).check(matches(isDisplayed()))
    }

    private fun assertInHome() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }
}