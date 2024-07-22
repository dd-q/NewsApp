package com.loc.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp : Hilt 사용 시 반드시 선행되어야 하는 부분. 모든 의존성 주입의 시작점.
/* + Hilt 코드 생성을 시작. 반드시 Application 클래스에 추가한다.
해당 어노테이션 추가만으로 ApplicationComponent 코드를 생성 및 인스턴스화하는 코드가 만들어진다.
*/
@HiltAndroidApp
class NewsApplication : Application() {

}