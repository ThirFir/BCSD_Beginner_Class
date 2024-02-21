package com.strone.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


// val, var
var age : Int = 26
var GPA : Double = 4.5

val name : String = "이상일"

// 타입 추론
var grade = 'A'

val track = "Android"

// null
var nickname : String? = null   // nickname은 null일 수 있음

//var nickname2 : String = nickname!!

fun main() {
    /**
     * trim() : 문자열의 시작과 끝의 공백을 없앤 문자열을 반환
     * ex ) "  Hello "  -->  "Hello"
     */
    nickname.trim()

    var nickname2 = nickname?.trim()
}