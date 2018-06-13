package xudeyang.bawie.com.oc.utils;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xudeyang.bawie.com.oc.view.passage.PassageBean;
import xudeyang.bawie.com.oc.view.recommend.hot.hotbean.RecHotBean;

/**
 * Created by Mac on 2018/6/8.
 */

public interface ApiService {
    //推荐页面的热门页面
    //https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=1&token=F8EB129296C90580807D0C6D9FD9B7F7&page=1
    @GET("quarter/getHotVideos")
    Flowable<RecHotBean>  rechot(@Query("token")String token,@Query("page")String page);

    //段子页面获取段子页面
    //https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=1&token=162E9092F47163863A2EADA56A038B4D&page=1
    @GET("quarter/getJokes")
    Flowable<PassageBean> passageZong(@Query("token")String token, @Query("page")String page);
}
