package com.stepyen.testdemo

import android.Manifest
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivityTAG"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")
        Log.i(TAG, "onCreate Intent : ${IntentLogUtil.getIntentAllInfo(intent)}")


        btn_content_provider.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContentProviderActivity::class.java))
        }


        btn_scheme_url.setOnClickListener {


            startActivity(Intent(this@MainActivity, SchemeActivity::class.java).run {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("name", "xiaoming")
                    setData(Uri.parse("babybus://game/path?name=peter&age=19#fragment=fragment123"))
            })
        }

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 123)

        startActivity(Intent(this@MainActivity, SchemeActivity::class.java))
        Handler().postDelayed(Runnable {
            finish()
        },1000)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.i(TAG, "onRequestPermissionsResult: requestCode : $requestCode")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i(TAG, "onActivityResult: requestCode : $requestCode")
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        Log.i(TAG, "onAttachFragment: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: ")
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i(TAG, "onConfigurationChanged: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState: ")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState: ")
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i(TAG, "onNewIntent")
        intent?.let {
            Log.i(TAG, "onNewIntent Intent : ${IntentLogUtil.getIntentAllInfo(it)}")
        }
    }


}
