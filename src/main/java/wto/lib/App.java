package wto.lib;

import wto.lib.entity.Status;
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
import wto.lib.entity.rating.RatingRequestException;
import wto.lib.entity.rating.RatingResponse;
import wto.lib.entity.rating.Ratings;
import wto.lib.entity.statistic.Statistics;
import wto.lib.entity.statistic.TankStatisticRequest;
import wto.lib.entity.statistic.TankStatisticResponse;
import wto.lib.entity.statistic.TankStatisticsException;
import wto.lib.service.FleetService;
import wto.lib.service.RatingService;
import wto.lib.service.Servise;

public class App {

    private final WTOlib wtOlib;
    private final String login;
    private final String password;

    public App(WTOlib wtOlib, String login, String password) {

        this.wtOlib = wtOlib;
        this.login = login;
        this.password = password;
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            new IllegalArgumentException("The first parameter must be login and the second password");
        }

        new App(new WTOlib(), args[0], args[1]).start();

    }

    public void start() {

        /**
         *  AuthRequest обект авторизации
         *  логин пароль тип и версия обязательные параметры.
         *
         */
        AuthRequest authRequest = new AuthRequest.Builder()
                .setLogin(login)
                .setPassword(password)
                .setAuthType(AythType.LOGIN)
                .setVersion(52)
                .build();

        try {

            /**
             *  Для авторизации. Обязательно в первую очередь!!!
             *  Все последующие запросы будут идти от аторизованого игока.
             */
            AuthResponse auth = wtOlib.getAuthService().auth(authRequest);

            if (auth.getStatus().equals(Status.SUCCESS)) {

                System.out.println(auth);

                /**
                 *  Создаем запрос с текущим авторизованным игроком
                 */
                TankStatisticRequest tankStatisticRequest = new TankStatisticRequest.Builder()
                        .setClientId(auth.getUserId())
                        .build();


                /**
                 *  Отправляем запрос и получаем ответ в виде обьекта TankStatisticResponse
                 *  содержащий в себе список Statistics по конкретнуму танку.
                 */
                TankStatisticResponse tankStatisticResponse = wtOlib.getTankStatisticService().getStatistic(tankStatisticRequest);

                /**
                 * Выводим Statistics
                 */
                for (Statistics statistic : tankStatisticResponse.getStatistics()) {
                    System.out.println(statistic);
                }

                /**
                 *  Создаем запрос с текущим авторизованным игроком
                 */
                ClientProfileRequest clientProfileRequest = new ClientProfileRequest.Builder()
                        .setUserId(auth.getUserId())
                        .build();

                /**
                 *  Отправляем запрос и получаем ответ в виде обьекта ClientProfileResponse
                 *  содержащий в себе список Statistics по конкретнуму игроку содержащий флаги.
                 */
                ClientProfileResponse clientProfileResponse = wtOlib.getClientProfileService().getProfile(clientProfileRequest);
                System.out.println(clientProfileResponse);
                ClientProfileResponse.Statistic statistic = clientProfileResponse.getStatistic();
                System.out.println(statistic);

                RatingService ratingService = wtOlib.getRatingService();

                for (int i = 0; i < 100; i++) {

                    RatingResponse ratingResponce = ratingService.getRatingResponce(10*i);

                    for (Ratings rating : ratingResponce.getRatings()) {
                        System.out.println(rating);
                    }

                }



                /**
                 *  Работа с Взводом
                 */
                System.out.println("########## FLEET #########################");


                FleetService fleetService = wtOlib.getFleetService();

                System.out.println("create fleet");

                /**
                 *  Создаем взвод.
                 */
                System.out.println(fleetService.createFleet());

                System.out.println("info fleet");

                /**
                 *  Информация о взводе
                 */
                AsyncFleetResponse asyncFleetResponse = fleetService.infoFleet();

                if (asyncFleetResponse.getStatus().equals(Status.OK)) {

                    /**
                     *
                     *  Если взвод существует вывести обьект Fleet содержащий информацию о взводе
                     *
                     */
                    System.out.println(asyncFleetResponse.getFleet());

                }


            }

        } catch (AuthServiceException e) {
            e.printStackTrace();
        } catch (ClientProfileException e) {
            e.printStackTrace();
        } catch (CreateFleetException e) {
            e.printStackTrace();
        } catch (AsyncFleetException e) {
            e.printStackTrace();
        } catch (TankStatisticsException e) {
            e.printStackTrace();
        } catch (RatingRequestException e) {
            e.printStackTrace();
        }


    }

}
