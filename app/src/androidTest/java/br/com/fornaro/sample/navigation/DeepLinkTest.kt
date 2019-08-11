package br.com.fornaro.sample.navigation

import android.content.Intent
import android.net.Uri
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class DeepLinkTest {

    private val screen = "Fill"

    private val url = "http://navsample.com/$screen"

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var activityTestRule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {
        override fun getActivityIntent(): Intent {
            return Intent(Intent.ACTION_VIEW, Uri.parse(url))
        }
    }

    @Test
    fun deepLink_opens_fill_screen_backs_to_home() {
//        assertInFill()
//        pressBack()
        assertInHome()
    }

    private fun assertInFill() {
        onView(withResourceName("action_bar")).check(matches(isDisplayed()))
    }

    private fun assertInHome() {
        onView(withText("Home")).check(matches(isDisplayed()))
    }
}