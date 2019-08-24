package br.com.fornaro.sample.navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.fail
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomNavigationTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickAllItems() {
        assertFirstScreen()
        openThirdScreen()
        assertThirdScreen()
        openSecondScreen()
        assertSecondScreen()
        openFirstScreen()
        assertFirstScreen()
    }

    @Test
    fun backGoesToFirstItem() {
        openThirdScreen()
        pressBack()
        assertFirstScreen()
    }

    @Test(expected = NoActivityResumedException::class)
    fun backFromFirstItemExits() {
        assertFirstScreen()
        pressBack() // This should throw NoActivityResumedException
        fail() // If it doesn't throw
    }

    private fun assertSecondScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withText(R.string.second),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.action_bar))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun openSecondScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withContentDescription(R.string.second),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(click())
    }

    private fun openFirstScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withContentDescription(R.string.home),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(click())
    }

    private fun assertFirstScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withText(R.string.home),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.action_bar))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun openThirdScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withContentDescription(R.string.third),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(click())
    }

    private fun assertThirdScreen() {
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withContentDescription(R.string.third),
                ViewMatchers.isDisplayed()
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}