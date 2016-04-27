import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cds/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cd-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("artists/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cds", CD.all());
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("artists", Artist.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      CD newCD = new CD(name);
      model.put("template", "templates/cdsuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cdsupdated", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      int id = Integer.parseInt(request.queryParams("id"));
      String artist = request.queryParams("newartist");
      CD newCD = new CD(name, artist, id);
      model.put("template", "templates/cdsuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/artists", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String artist = request.queryParams("artist");
      Artist newArtist = new Artist(artist);
      model.put("Artist", newArtist);
      model.put("template", "templates/artistsuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      CD cd = CD.find(Integer.parseInt(request.params(":id")));
      model.put("artists", Artist.all());
      model.put("cd", cd);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Artist artistId = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artistId", artistId);
      model.put("cds", CD.all());
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
