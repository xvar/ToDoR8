package com.github.xvar.todo

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

private const val APP_SING = "SAFSAFDSFSASFASFSAFDS1241243242WFSDF"
object Validate {
    fun validateAppSignature(context: Context): Boolean {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)
        for (signature in packageInfo.signatures!!) {
            val sign = signature.toByteArray().toString(Charsets.UTF_8)
            return APP_SING == sign
        }
        return false
    }

    fun validateAppSignatureFix(context: Context): Boolean {
        val packageName = context.packageName
        val contextClass = Class.forName("android.content.Context")
        val packageNameMethod = contextClass.getMethod("getPackageInfo")
        val packageNameObject = packageNameMethod.invoke(packageName, PackageManager.GET_SIGNATURES) as PackageInfo
        for (signature in packageNameObject.signatures!!) {
            val sign = signature.toByteArray().toString(Charsets.UTF_8)
            return APP_SING == sign
        }
        return false
    }
}