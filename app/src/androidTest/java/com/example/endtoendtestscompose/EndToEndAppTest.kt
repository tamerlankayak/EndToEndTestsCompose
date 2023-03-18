package com.example.endtoendtestscompose

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.endtoendtestscompose.ui.theme.EndToEndTestsComposeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
//here is starting test
class EndToEndAppTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.activity.setContent {
            EndToEndTestsComposeTheme {
                Navigation()
            }
        }
    }

    @Test
    fun testAppNavigationWorksProperly() {
        val context = composeRule.activity.applicationContext
        composeRule
            .onNodeWithText(context.getString(R.string.first_screen_description))
            .assertIsDisplayed()
        composeRule
            .onNodeWithText(context.getString(R.string.navigate_to_second_screen))
            .performClick()
        composeRule
            .onNodeWithText(context.getString(R.string.second_screen_description))
            .assertIsDisplayed()
        composeRule
            .onNodeWithText(context.getString(R.string.navigate_to_third_screen))
            .performClick()
        composeRule
            .onNodeWithText(context.getString(R.string.third_screen_description))
            .assertIsDisplayed()
    }

    @Test
    fun testNavigateToSecondScreenShowAndHideDetails() {
        val context = composeRule.activity.applicationContext
        composeRule
            .onNodeWithText(context.getString(R.string.navigate_to_second_screen))
            .performClick()
        composeRule
            .onNodeWithText(context.getString(R.string.second_screen_detail_text))
            .assertDoesNotExist()
        composeRule
            .onNodeWithText(context.getString(R.string.button_show_details))
            .performClick()
        composeRule
            .onNodeWithText(context.getString(R.string.second_screen_detail_text))
            .assertIsDisplayed()
        composeRule
            .onNodeWithText(context.getString(R.string.button_show_details))
            .performClick()
        composeRule
            .onNodeWithText(context.getString(R.string.second_screen_detail_text))
            .assertDoesNotExist()
    }


}
