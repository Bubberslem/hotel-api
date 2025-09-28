package app.routes;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {

//    private HighscoresRoutes highscoresRoutes = new HighscoresRoutes();
//    private HighscoreRoutes highscoreRoutes = new HighscoreRoutes();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/", ctx -> ctx.result("Hello World"));
//            path("/highscores", highscoresRoutes.getRoutes());
//            path("/highscore", highscoreRoutes.getRoutes());
        };
    }
}