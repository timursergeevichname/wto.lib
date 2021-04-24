package wto.lib;

import okhttp3.OkHttpClient;
import okhttp3.internal.JavaNetCookieJar;
import wto.lib.service.AuthService;
import wto.lib.service.ClientProfileService;
import wto.lib.service.FleetService;
import wto.lib.service.TankStatisticService;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class WTOlib {

    private final OkHttpClient client;
    private final AuthService authService;
    private final TankStatisticService tankStatisticService;
    private final ClientProfileService clientProfileService;
    private final FleetService fleetService;

    public WTOlib(){

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        authService = new AuthService(client);
        tankStatisticService = new TankStatisticService(client);
        clientProfileService = new ClientProfileService(client);
        fleetService = new FleetService(client);

    }

    public AuthService getAuthService() {
        return authService;
    }

    public TankStatisticService getTankStatisticService() {
        return tankStatisticService;
    }

    public ClientProfileService getClientProfileService() {
        return clientProfileService;
    }

    public FleetService getFleetService() {
        return fleetService;
    }
}
