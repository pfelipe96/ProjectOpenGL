package com.example.paulofelipeoliveirasouza.projectwithopengl

import android.opengl.GLSurfaceView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class OpenGLES20Activity: AppCompatActivity(){

    private lateinit var mGLSurfaceView: GLSurfaceView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mGLSurfaceView = MyGLSurfaceView(this)
        setContentView(mGLSurfaceView)

    }
}