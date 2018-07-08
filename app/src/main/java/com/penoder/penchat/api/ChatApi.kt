package com.penoder.penchat.api

class ChatApi {
    // 支持 static 静态访问
    companion object {
        val BASE_URL = "http://192.168.2.247:8090/DBManager/PenChat/"

        val CONNECT_IM = BASE_URL + "connectIM"
    }
}