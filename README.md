# EasyAndroid
项目初衷：使用比较火的框架及架构来搭建一套快速开发Android App的框架，使用ButterKnife、Dagger2等注解框架，Material Design、BaseRecyclerViewAdapterHelper、AVLoading、PhotoView等UI框架，LeakCanary、BlockCanary、Logger、Stetho等调试框架，RxJava2、RxAndroid、Retrofit2、OkHttp3、Rxlifecycle2、PersistentCookieJar等网络框架。(注：由于在library中使用Dagger无发在主Module中应用注解，因此后将Dagger2更改为主Module中应用，library中不再使用Dagger2框架。如有大神了解library中如何引入Dagger2，并使主Module也可以正常应用，还烦请告知)

# 项目结构
### easy Library
--com.mazaiting.easy<Br/>
	----app<Br/>
		------AppBlockCanaryContext.java<Br/>
		------ApplicationComponent.java<Br/>
		------BaseApplication.java<Br/>
	----base<Br/>
		------activity<Br/>
			--------BaseActivity.java<Br/>
			--------BaseMultiStateActivity.java<Br/>
		------fragment<Br/>
			--------BaseFragment.java<Br/>
			--------BaseLazyFragment.java<Br/>
			--------BaseLazyMultiStateFragment.java<Br/>
		------interfaces<Br/>
			--------IView.java<Br/>
		------mvp<Br/>
			--------IBasePresenter.java<Br/>
			--------IBaseView.java<Br/>
		------presenter<Br/>
			--------BasePresenter.java<Br/>
	----config<Br/>
		------BaseConfig.java<Br/>
		------Constant.java<Br/>
	----net<Br/>
		------BaseObserver.java<Br/>
	----utils<Br/>
		------NetUtil.java<Br/>
		------RxScheduler.java<Br/>

### widget Library<Br/>
--com.mazaiting.widget<Br/>
	----multistate<Br/>
		------MultiStateView.java<Br/>
		------SimpleMultiStateView.java<Br/>
	----view<Br/>
		------IteView.java<Br/>
		------ItiView.java<Br/>
		------ItsView.java<Br/>

***********************************************************************************<Br/>
\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\***easy Library**\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*<Br/>
***********************************************************************************<Br/>

# app 包<Br/>
### BaseApplication<Br/>
全局Application，使用时自定义一个Application，并继承在BaseApplication。可重写的方法：
- setConfig()，可选，如果重写此方法，必须自定义一个类来继承BaseConfig，BaseConfig中可重写的方法有isDebug()设置是否为调试，isUseLeakCanary()设置是否使用LeakCanary内存检测，isUseLogger()设置是否使用Logger日志打印，isUseBlockCanary()设置是否使用BlockCanary进行UI卡顿检测，isUseStetho()设置是否使用Stetho来使用网页查看数据。
- initApp()，必须重写此方法，并且返回this，即当前类对象。
- initApplicationComponent()方法，如果使用Dagger2框架，则需要重写此方法，并且此方法中设置ApplicationComponent。重写的Component必须继承自ApplicationComponent才可在Activity中使用，否则无法使用。

# base包<Br/>
## activity<Br/>
### BaseActivity<Br/>
BaseActivity中实现了View，Presenter的绑定，并且使用ButterKnife注解，使用Lifecycle对其声明周期进行绑定。
### BaseMultiStateActivity<Br/>
BaseMultiStateActivity继承自BaseActivity且使用了SimpleMultiStateView，继承此类时，必须在布局文件中提供一个android:id为simpleMultiStateView的父布局，且必须包含子节点，否则会抛出运行时或空指针异常。
## fragment<Br/>
### BaseFragment<Br/>
BaseFragment中实现了View，Presenter的绑定，使用ButterKnife注解，使用Lifecycle对其声明周期进行绑定。isLazyFetchData()方法标记是否为懒加载。
### BaseLazyFragment<Br/>
BaseLazyFragment继承自BaseFragment且重写isLazyFetchData()标记为懒加载的Fragment，继承此类后必须实现lazyFetchData()方法来进行懒加载数据。
### BaseLazyMultiStateFragment<Br/>
BaseLazyMultiStateFragment继承自BaseLazyFragment，且使用了SimpleMultiStateView，继承此类时，必须在布局文件中提供一个android:id为simpleMultiStateView的父布局，且必须包含子节点，否则会抛出运行时或空指针异常。
## presenter<Br/>
### BasePresenter<Br/>
主Module中创建的Presenter必须继承自BasePresenter，来进行对View的绑定。

*************************************************************************************<Br/>
\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\***widget Library**\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*<Br/>
*************************************************************************************<Br/>
### widget Library<Br/>
# multistate包<Br/>
###SimpleMultiStateView使用<Br/>
```
    <com.mazaiting.widget.multistate.SimpleMultiStateView
        android:id="@+id/simpleMultiStateView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:empty="@layout/view_empty"
        app:loading="@layout/view_loading"
        app:fail="@layout/view_failed"
        app:no_net="@layout/view_no_net">
        <Button
            android:text="按钮"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </com.mazaiting.widget.multistate.SimpleMultiStateView>
```
其中app:empty、app:loading、app:fail、app:no_net中的布局文件，可自己定义，也可使用Module中已定义好的布局。
其中，app:fail对应的布局文件中请提供一个重新加载的按钮或者其他view，其android:id为retry_bt。
# view包<Br/>
### IteView.java<Br/>
```
            <com.mazaiting.widget.view.IteView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:hint_txt_ite="请输入用户名"
                app:pic_ite="@mipmap/ic_launcher"
                app:txt_ite="用户名:"
                />
```
### ItiView.java<Br/>
```
            <com.mazaiting.widget.view.ItiView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:pic_iti="@mipmap/ic_launcher"
                app:txt_iti="属性"/>
```
### ItsView.java<Br/>
```
            <com.mazaiting.widget.view.ItsView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:pic_its="@mipmap/ic_launcher"
                app:txt_its="菜单"
                app:menu_its="@array/its_view_menu"/>
```
