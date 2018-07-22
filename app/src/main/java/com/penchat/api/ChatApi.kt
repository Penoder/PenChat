package com.penchat.api

class ChatApi {
    // 支持 static 静态访问
    companion object {
        val BASE_URL = "http://192.168.2.106:8080/DBManager/PenChat/"

        val CONNECT_IM = BASE_URL + "connectIM"
    }
}