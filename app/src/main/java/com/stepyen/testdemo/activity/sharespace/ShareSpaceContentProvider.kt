package com.stepyen.testdemo.activity.sharespace

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import com.orhanobut.logger.Logger

/**
 * date：2020-03-17
 * author：stepyen
 * description：
 *
 */
class ShareSpaceContentProvider : ContentProvider() {

    companion object {
        const val AUTHORITY = "com.stepyen.testdemo.ShareSpaceContentProvider"
        const val PING = "ping"
        const val MATCHER_CODE_PING = 100
    }

    private lateinit var uriMatcher: UriMatcher


    override fun onCreate(): Boolean {
        Logger.d("onCreate")
        uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, PING, MATCHER_CODE_PING)
        }
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        Logger.d("query")
        return when (uriMatcher.match(uri)) {
            MATCHER_CODE_PING -> MatrixCursor(arrayOf("ping"))
            else -> null
        }
    }


    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
       return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
      return null
    }
}