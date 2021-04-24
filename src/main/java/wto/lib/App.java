package wto.lib;

import wto.lib.entity.*;
import wto.lib.entity.auth.AuthRequest;
import wto.lib.entity.auth.AuthResponse;
import wto.lib.entity.auth.AuthServiceException;
import wto.lib.entity.auth.AythType;
import wto.lib.entity.fleet.AsyncFleetException;
import wto.lib.entity.fleet.AsyncFleetResponse;
import wto.lib.entity.fleet.CreateFleetException;
import wto.lib.entity.profile.ClientProfileException;
import wto.lib.entity.profile.ClientProfileRequest;
import wto.lib.entity.profile.ClientProfileResponse;
import wto.lib.entity.statistic.Statistics;
import wto.lib.entity.statistic.TankStatisticRequest;
import wto.lib.entity.statistic.TankStatisticResponse;
import wto.lib.entity.statistic.TankStatisticsException;
import wto.lib.service.FleetService;

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
                        .setClientId(auth.getUserId())
                        .build();

                TankStatisticResponse tankStatisticResponse = wtOlib.getTankStatisticService().getStatistic(tankStatisticRequest);

                for (Statistics statistic : tankStatisticResponse.getStatistics()) {
                    System.out.println(statistic);
                }

                ClientProfileRequest clientProfileRequest = new ClientProfileRequest.Builder()
                        .setUserId(auth.getUserId())
                        .build();

                ClientProfileResponse clientProfileResponse = wtOlib.getClientProfileService().getProfile(clientProfileRequest);
                System.out.println(clientProfileResponse);
                ClientProfileResponse.Statistic statistic = clientProfileResponse.getStatistic();
                System.out.println(statistic);


                System.out.println("##########FLEET #########################");

                FleetService fleetService = wtOlib.getFleetService();

                System.out.println("create fleet");
                System.out.println(fleetService.createFleet());

                System.out.println("info fleet");
                AsyncFleetResponse asyncFleetResponse = fleetService.infoFleet();

                if(asyncFleetResponse.getStatus().equals(Status.OK)){

                    //
                    System.out.println(asyncFleetResponse.getFleet());

                }


            }

        } catch (AuthServiceException e) {
            e.printStackTrace();
        } catch (TankStatisticsException e) {
            e.printStackTrace();
        } catch (ClientProfileException e) {
            e.printStackTrace();
        } catch (CreateFleetException e) {
            e.printStackTrace();
        } catch (AsyncFleetException e) {
            e.printStackTrace();
        }


    }

}
