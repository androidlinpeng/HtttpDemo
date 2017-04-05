package msgcopy.com.myokhttp.Builder;


import msgcopy.com.myokhttp.request.OtherRequest;
import msgcopy.com.myokhttp.request.RequestCall;
import msgcopy.com.myokhttp.utils.OkHttpUtils;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
