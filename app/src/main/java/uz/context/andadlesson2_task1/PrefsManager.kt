package uz.context.andadlesson2_task1

import android.content.Context
import android.content.SharedPreferences

class PrefsManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences? =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager!!
        }
    }

    fun saveLong(key: String?, value: Long?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putLong(key, value!!)
        prefsEditor.apply()
    }

    fun saveBoolean(key: String?, value: Boolean?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putBoolean(key, value!!)
        prefsEditor.apply()
    }

    fun saveInt(key: String?, value: Int?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putInt(key, value!!)
        prefsEditor.apply()
    }

    fun saveFloat(key: String?, value: Float?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putFloat(key, value!!)
        prefsEditor.apply()
    }

    fun saveString(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value!!)
        prefsEditor.apply()
    }

    fun getData(key: String?): String? {
        return if (sharedPreferences != null) sharedPreferences.getString(key, "") else ""
    }
}