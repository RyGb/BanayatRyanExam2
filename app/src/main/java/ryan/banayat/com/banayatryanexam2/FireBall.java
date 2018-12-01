package ryan.banayat.com.banayatryanexam2;

import android.app.Application;
import com.firebase.client.Firebase;

public class FireBall extends Application {

    @Override
        public void onCreate(){
            super.onCreate();

            Firebase.setAndroidContext(this);

    }

}
