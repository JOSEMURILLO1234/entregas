package com.example.servigasv2.data.network

import android.util.Log
import com.example.servigasv2.core.RetrofitHelper
import com.example.servigasv2.model.body
import com.example.servigasv2.model.deliverModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY

class GlpService {
    private val retrofit= RetrofitHelper.getRetrofit()


            suspend fun getDeliver(): List<body> {
                return withContext(Dispatchers.IO) {
                    val response = retrofit.create(deliverInterface::class.java).getAllDeliver()
                        response.body()?.contactInfoList ?: emptyList()
                }
            }

            }
