package database.entity;

import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Collections;


@Data
public class IssLocation  {
    private double longitude;
    private double latitude;

  /*  OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("http://api.open-notify.org/iss-now")
            .build();
*/
   /* JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());
    JsonReader jsonReader = readerFactory.createReader(inputStream);
*/


}