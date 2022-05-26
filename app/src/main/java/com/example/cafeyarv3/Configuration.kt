package com.example.cafeyarv3

import android.R
import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

/**
 * Created by abolfazl_dv on 31,March,2022
 */
class Configuration : Application() {
    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("Fonts/Yekan.ttf")
                            .setFontAttrId(R.attr.fontFamily)
                            .build()
                    )
                )
                .build()
        )
    }
}