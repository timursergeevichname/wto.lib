package wto.lib;

import wto.lib.entity.*;

public class App {

    private WTOlib wtOlib;
    private String login;
    private String password;

    public App(WTOlib wtOlib, String login, String password) {

        this.wtOlib = wtOlib;
        this.login = login;
        this.password = password;
    }

    public static void main(String[] args) {

        if(args.length < 2){
            new IllegalArgumentException("The first parameter must be login and the second password");
        }

        new App(new WTOlib(),args[0],args[1]).start();

    }

    public void start(){

        AuthRequest authRequest = new AuthRequest.Builder()
                .setLogin(login)
                .setPassword(password)
                .setAuthType(AythType.LOGIN)
                .setVersion(52)
                .build();

        try {
            AuthResponse auth = wtOlib.getAuthService().auth(authRequest);

            if(auth.getStatus().equals(Status.SUCCESS)){

                TankStatisticRequest tankStatisticRequest = new TankStatisticRequest.Builder()
                        .setClientId(1)
                        .build();

                TankStatisticResponse tankStatisticResponse = wtOlib.getTankStatisticService().getStatistic(tankStatisticRequest);

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
