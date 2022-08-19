package com.arthur.bucar.wikipokemon.connection.monitor

import android.text.TextUtils
import android.util.Log
import com.arthur.bucar.wikipokemon.connection.response.BaseResponse
import com.google.gson.JsonSyntaxException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


open class BaseMonitor<T : BaseResponse> : Observer<T> {
    override fun onError(e: Throwable) {
        if (!TextUtils.isEmpty(e.message)) {
            e.message?.let { Log.e(javaClass.name, it) }
        }

        errorMessage = "Error Unexpected"

        when (e) {
            is SocketTimeoutException -> errorMessage = e.message.toString()
            is JsonSyntaxException -> errorMessage = e.message.toString()
            else -> try {
                val response = (e as HttpException).response().errorBody().string()
                networkError = e.response().code()

                val jObj = JSONObject(response)
                errorMessage = jObj.getString("verbose")
                errorCode = jObj.getInt("error_code")

                Log.e(javaClass.name, "onError : $errorMessage")
            } catch (e1: IOException) {
                e1.printStackTrace()
                errorMessage = (e as HttpException).response().message()
            } catch (e1: JSONException) {
                e1.printStackTrace()
                errorMessage = (e as HttpException).response().message()
            } catch (e1: Exception) {
                errorMessage = "Error Unexpected"
                e1.printStackTrace()
            }
        }
    }

    internal lateinit var errorMessage: String
    private var errorCode: Int = 0
    private var networkError: Int = 0

    override fun onSubscribe(d: Disposable) {}

    override fun onNext(response: T) {}

    override fun onComplete() {}
}
