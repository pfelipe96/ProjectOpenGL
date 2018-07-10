package com.example.paulofelipeoliveirasouza.projectwithopengl

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent



internal class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {

    private val mRenderer: MyGLRenderer

    private val TOUCH_SCALE_FACTOR = 180.0f / 320
    private var mPreviousX: Float = 0.toFloat()
    private var mPreviousY: Float = 0.toFloat()

    init {
        setEGLContextClientVersion(2)
        mRenderer = MyGLRenderer()
        setRenderer(mRenderer)
        renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        val x = e.x
        val y = e.y

        when (e.action) {
            MotionEvent.ACTION_MOVE -> {

                var dx = x - mPreviousX
                var dy = y - mPreviousY

                // reverse direction of rotation above the mid-line
                if (y > height / 2) {
                    dx *= -1
                }

                // reverse direction of rotation to left of the mid-line
                if (x < width / 2) {
                    dy *= -1
                }

                mRenderer.setAngle(
                        mRenderer.getAngle() + (dx + dy) * TOUCH_SCALE_FACTOR)
                requestRender()
            }
        }

        mPreviousX = x
        mPreviousY = y
        return true
    }
}