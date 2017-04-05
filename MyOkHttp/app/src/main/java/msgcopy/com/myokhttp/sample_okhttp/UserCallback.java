package msgcopy.com.myokhttp.sample_okhttp;

import com.google.gson.Gson;

import java.io.IOException;

import msgcopy.com.myokhttp.callbacks.Callback;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class UserCallback extends Callback<User>
{
    @Override
    public User parseNetworkResponse(Response response, int id) throws IOException
    {
        String string = response.body().string();
        User user = new Gson().fromJson(string, User.class);
        return user;
    }


}
