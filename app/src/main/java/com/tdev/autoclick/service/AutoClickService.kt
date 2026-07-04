package com.tdev.autoclick.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent
import kotlinx.coroutines.*

class AutoClickService : AccessibilityService() {

    private var clickJob: Job? = null
    private var targetX: Float = 500f
    private var targetY: Float = 1000f
    private var intervalMs: Long = 1000L
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    companion object {
        var instance: AutoClickService? = null
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {
        stopClicking()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        instance = null
    }

    fun startClicking(x: Float, y: Float, intervalMs: Long) {
        this.targetX = x
        this.targetY = y
        this.intervalMs = intervalMs
        clickJob?.cancel()
        clickJob = scope.launch {
            while (isActive) {
                performClick(targetX, targetY)
                delay(intervalMs)
            }
        }
    }

    fun stopClicking() {
        clickJob?.cancel()
        clickJob = null
    }

    private fun performClick(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }
        val stroke = GestureDescription.StrokeDescription(path, 0, 50)
        val gesture = GestureDescription.Builder().addStroke(stroke).build()
        dispatchGesture(gesture, null, null)
    }
}
