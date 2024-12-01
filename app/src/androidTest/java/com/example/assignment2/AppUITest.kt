package com.example.assignment2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppUITest {

    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        // Initialize the UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Press the Home button to start from the home screen
        device.pressHome()
    }

    @Test
    fun testExplicitActivityLaunch() {
        // Find the launcher icon and click it
        val appName = "assignment2"
        val launcherIcon = device.findObject(UiSelector().descriptionContains(appName))
        assertTrue("Launcher icon not found", launcherIcon.exists())
        launcherIcon.click()

        // Wait for the app to load
        device.waitForIdle(3000)

        // Find and click the "start activity explicitly" button
        val startButton = device.findObject(UiSelector().text("Start Activity Explicitly"))
        assertTrue("Start Activity button not found", startButton.exists())
        startButton.click()

        // Wait for the second activity to load
        device.waitForIdle(3000)

        // Verify that one of the software engineering challenges is displayed
        val challengeText = device.findObject(UiSelector().textContains("Battery Life"))
        assertTrue("Challenge text not found on the second activity", challengeText.exists())
    }
}
