package com.example.servigasv2.data.network

import android.util.Log
import com.example.servigasv2.core.RetrofitHelper
import com.example.servigasv2.model.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GlpService {
    private val retrofit= RetrofitHelper.getRetrofit()


            suspend fun getDeliver(): List<body> {
                return withContext(Dispatchers.IO) {
                    val response = retrofit.create(deliverInterface::class.java).getAllDeliver()
                        response.body()?.contactInfoList ?: emptyList()
                }
            }

            }
