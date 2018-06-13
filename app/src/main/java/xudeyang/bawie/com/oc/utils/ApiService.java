package xudeyang.bawie.com.oc.utils;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xudeyang.bawie.com.oc.view.recommend.hot.hotbean.RecHotBean;

/**
 * Created by Mac on 2018/6/8.
 */

public interface ApiService {
    //推荐页面的热门页面
    //https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=1&token=F8EB129296C90580807D0C6D9FD9B7F7&page=1
    @GET("quarter/getHotVideos")
    Flowable<RecHotBean>  rechot(@Query("token")String token,@Query("page")String page);
}
