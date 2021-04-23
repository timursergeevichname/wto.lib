package wto.lib;

import okhttp3.OkHttpClient;
import okhttp3.internal.JavaNetCookieJar;
import wto.lib.service.AuthService;
import wto.lib.service.TankStatisticService;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class WTOlib {

    private final OkHttpClient client;
    private final AuthService authService;

    private final TankStatisticService tankStatisticService;

    public WTOlib(){

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        authService = new AuthService(client);

        tankStatisticService = new TankStatisticService(client);

    }

    public AuthService getAuthService() {
        return authService;
    }

    public TankStatisticService getTankStatisticService() {
        return tankStatisticService;
    }




}
