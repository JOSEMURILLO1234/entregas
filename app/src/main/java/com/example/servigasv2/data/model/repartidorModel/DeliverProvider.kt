package com.example.servigasv2

import com.example.servigasv2.data.network.GlpService
import com.example.servigasv2.data.network.deliverInterface
import com.example.servigasv2.model.body
import com.example.servigasv2.model.deliverModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.emptyFlow
import retrofit2.Call
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty

class DeliverProvider {

    companion object{
        var deliver: List<body> = emptyList()
     }

}