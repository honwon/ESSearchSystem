package com.honwon.essearchsystem


import android.icu.util.TimeUnit.values
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast
import java.net.URLEncoder
import java.time.chrono.JapaneseEra.values


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ES 통합검색 시스템"

        var count = 0

        //스피너 항목 준비 string.xml에서 준비하는 방법도 있다.
        var list_of_items = arrayOf("구글", "네이버", "나무위키", "다음","Bing")
        var list_of_summary = arrayOf("요약설명1", "요약설명2", "요약설명3", "요약설명4")

        button2.setOnClickListener {
            count+=1

            if (count==10){

                if(TextUtils.isEmpty(editText.text)){
                    toast("검색어를 입력하세요")}
                else{
                val product = URLEncoder.encode(editText.text.toString(),"utf-8")
                browse("https://www.google.co.kr/search?sxsrf=ALeKk022idjogkv8Z6smmqNJxxeDb17bNQ%3A1595103933077&ei=vVoTX7mkBJP8wQP73qroBA&q=${product}&oq=${product}&gs_lcp=CgZwc3ktYWIQAzIECCMQJzIECCMQJzIECCMQJzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BQgAELADOgcIABCwAxAKOgQIABBDUJgJWMkLYJ0OaABwAHgAgAHKAYgB6gSSAQUwLjMuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwj59r2a0dfqAhUTfnAKHXuvCk0Q4dUDCAw&uact=5")
                browse("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=${product}")
                browse("https://namu.wiki/w/${product}")
                browse("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=${product}")
                browse("https://www.bing.com/search?q=${product}&form=QBLH&sp=-1&pq=&sc=0-0&qs=n&sk=&cvid=9036164003834AD1A23994A821C2B56B")
                count=0}
            }
        }


        button.setOnClickListener {
            if(TextUtils.isEmpty(editText.text)){
              toast("검색어를 입력하세요")
            }else{
            val product = URLEncoder.encode(editText.text.toString(),"utf-8")
            when (spinner.selectedItemPosition) {
                0 -> browse("https://www.google.co.kr/search?sxsrf=ALeKk022idjogkv8Z6smmqNJxxeDb17bNQ%3A1595103933077&ei=vVoTX7mkBJP8wQP73qroBA&q=${product}&oq=${product}&gs_lcp=CgZwc3ktYWIQAzIECCMQJzIECCMQJzIECCMQJzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BQgAELADOgcIABCwAxAKOgQIABBDUJgJWMkLYJ0OaABwAHgAgAHKAYgB6gSSAQUwLjMuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwj59r2a0dfqAhUTfnAKHXuvCk0Q4dUDCAw&uact=5")
                1 -> browse("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=${product}")
                2 -> browse("https://namu.wiki/w/${product}")
                3 -> browse("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=${product}")
                4 -> browse("https://www.bing.com/search?q=${product}&form=QBLH&sp=-1&pq=&sc=0-0&qs=n&sk=&cvid=9036164003834AD1A23994A821C2B56B")
            }}
        }

        //어답터 설정 - 안드로이드에서 제공하는 어답터를 연결
        spinner.adapter = ArrayAdapter(this, R.layout.spinner_item,list_of_items )

        //아이템 선택 리스너
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                }

        }

        //More.. 버튼 클릭 리스너
    }

}