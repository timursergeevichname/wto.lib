package wto.lib;

import okhttp3.OkHttpClient;
import okhttp3.internal.JavaNetCookieJar;
import wto.lib.entity.*;
import wto.lib.service.AuthService;
import wto.lib.entity.AuthServiceException;
import wto.lib.service.TankStatisticService;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

public class StatisticApp extends Thread
{
    private final String login;
    private final String password;
    private final OkHttpClient client;
    private final AuthService authService;
    private final TankStatisticService tankStatisticService;
    private final int timeSleep;

    public StatisticApp(String login, String password, int timeSleep){

        this.login = login;
        this.password = password;
        this.timeSleep  = timeSleep;

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        authService = new AuthService(client);

        tankStatisticService = new TankStatisticService(client);

    }

    @Override
    public void run() {

        AuthRequest authRequest = new AuthRequest.Builder()
                .setLogin(login)
                .setPassword(password)
                .setAuthType(AythType.LOGIN)
                .setVersion(52)
                .build();

        AuthResponse auth = null;

        try {
            auth = authService.auth(authRequest);
        } catch (AuthServiceException e) {
            e.printStackTrace();
        }

        if(auth!=null && auth.getStatus().equals(Status.SUCCESS)){

            while (true){

                printStatistic(auth);

                try {
                    TimeUnit.SECONDS.sleep(timeSleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    private void printStatistic(AuthResponse auth) {

            TankStatisticRequest tankStatisticRequest = new TankStatisticRequest.Builder()
                    .setClientId(auth.getUserId())
                    .build();

            try {
                TankStatisticResponse statistic = tankStatisticService.getStatistic(tankStatisticRequest);
                System.out.println("userid " + auth.getUserId());
                for (Statistics statistics : statistic.getStatistics()) {
                    System.out.println(statistics);
                }
            } catch (TankStatisticsException e) {
                e.printStackTrace();
            }


    }

    /**
     *
     *
     * @param args
     * args[0] - login
     * args[1] - password
     * args[2] - time pause seconds
     */
    public static void main( String[] args ) {

        if (args.length < 3) {
            throw new IllegalArgumentException("There must be two arguments. First login, second password.");
        }

        StatisticApp app = new StatisticApp(args[0], args[1], Integer.parseInt(args[2]));
        app.start();


    }
}
