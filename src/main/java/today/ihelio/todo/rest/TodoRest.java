package today.ihelio.todo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import today.ihelio.jooq.tables.pojos.Todo;
import today.ihelio.todo.pojo.TodoPojo;
import today.ihelio.todo.service.TodoService;

@Path("/1.0/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class TodoRest {

  private final TodoService todoService;
  private final ObjectMapper mapper;
  private final Gson gson = new Gson();

  @Inject
  public TodoRest(TodoService todoService, ObjectMapper mapper) {
    this.todoService = todoService;
    this.mapper = mapper;
  }

  @GET
  @Path("/all")
  public List<TodoPojo> getTodos() {
    return todoService.getTodos().stream().map(TodoPojo::buildFromJooqTodo).toList();
  }

  @GET
  @Path("/categories")
  public List<String> getCategories() {
    return todoService.getCategories();
  }

  @GET
  @Path("/hashtags")
  public List<String> getHashtags() {
    return todoService.getHashtags();
  }

  @POST
  @Path("/new")
  public Response createNewTodo(String todo) {
    try {
      TodoPojo todoPojo = mapper.readValue(todo, TodoPojo.class);
      Todo todoObj = todoPojo.convertToJooqTodo();
      todoService.createTodo(todoObj);
      return Response.status(Response.Status.OK).build();
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @PUT
  @Path("/update")
  public Response updateTodo(String todo) {
    try {
      var todoPojo = mapper.readValue(todo, TodoPojo.class);
      var todoObj = todoPojo.convertToJooqTodo();
      todoService.updateTodo(todoObj);
      return Response.status(Response.Status.OK).build();
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
