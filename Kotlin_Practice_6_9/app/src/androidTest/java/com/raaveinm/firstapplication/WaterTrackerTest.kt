package com.raaveinm.firstapplication

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    // Это правило нужно, чтобы запустить тестовую активность
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // Тест 1: Проверяем кнопку добавления воды
    @Test
    fun testAddWaterButton() {
        // 1. Запускаем наш Трекер воды
        composeTestRule.setContent {
            WaterTracker()
        }

        // 2. Проверяем, что изначально 750 мл
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        // 3. Нажимаем кнопку "+250 мл"
        composeTestRule.onNodeWithText("+250 мл").performClick()

        // 4. Проверяем, что стало 1000 мл
        composeTestRule.onNodeWithText("1000 мл").assertIsDisplayed()
    }

    // Тест 2: Проверяем кнопку "Завершить день" и счетчик дней
    @Test
    fun testFinishDayButton() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // 1. Нажимаем +250 мл три раза (750 + 250*3 = 1500)
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("+250 мл").performClick()

        // 2. Проверяем, что достигли 1500 мл
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()

        // 3. Нажимаем "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // 4. Проверяем, что счетчик дней стал 1, а вода сбросилась на 0
        composeTestRule.onNodeWithText("Дней подряд: 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }
}