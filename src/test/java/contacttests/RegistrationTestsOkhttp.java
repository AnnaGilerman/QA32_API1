package contacttests;

import com.google.gson.Gson;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestsOkhttp {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    @Test
    public void registrationSuccess() throws IOException {
        int i = (int) (System.currentTimeMillis()/1000);
        AuthRequestDto requestDto = AuthRequestDto.builder().email("anna"+i+"@gmail.com").password("Aanna12345$").build();
        RequestBody rBody = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/registration")
                .post(rBody)
                .build();

        Response response = client.newCall(request).execute();
        AuthResponseDto responseDto =
                gson.fromJson(response.body().string(), AuthResponseDto.class);
        String tokenRegistration = responseDto.getToken();
        System.out.println(tokenRegistration);
        Assert.assertEquals(response.code(), 200);
        Assert.assertTrue(response.isSuccessful());
    }

}
