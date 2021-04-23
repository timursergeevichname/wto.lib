package wto.lib;

import okhttp3.OkHttpClient;
import okhttp3.internal.JavaNetCookieJar;
import wto.lib.entity.*;
import wto.lib.service.AuthService;
import wto.lib.entity.AuthServiceException;
import wto.lib.service.TankStatisticService;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class App 
{

    /**
     *
     *
     * @param args
     * args[0] - login
     * args[1] - password
     *
     */
    public static void main( String[] args )
    {
        if(args.length < 2){
            throw new IllegalArgumentException("There must be two arguments. First login, second password.");
        }

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        AuthService authService = new AuthService(client);
        TankStatisticService tankStatisticService = new TankStatisticService(client);


        AuthRequest build = new AuthRequest.Builder()
                .setLogin(args[0])
                .setPassword(args[1])
                .setAuthType(AythType.LOGIN)
                .setVersion(52)
                .build();



        try {
            AuthResponse auth = authService.auth(build);
            if(auth.getStatus().equals(Status.SUCCESS)){
                TankStatisticRequest tankStatisticRequest = new TankStatisticRequest.Builder()
                        .setClientId(auth.getUserId())
                        .build();

                TankStatisticResponse tankStatisticResponse = tankStatisticService.getStatistic(tankStatisticRequest);

                for (Statistics statistic : tankStatisticResponse.getStatistics()) {
                    System.out.println(statistic);
                }

            }
        } catch (AuthServiceException e) {
            e.printStackTrace();
        } catch (TankStatisticsException e) {
            e.printStackTrace();
        }


    }
}
