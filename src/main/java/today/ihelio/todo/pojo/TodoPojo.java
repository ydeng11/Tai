package today.ihelio.todo.pojo;

import java.time.LocalDateTime;
import java.util.List;
import today.ihelio.jooq.tables.pojos.Todo;

public class TodoPojo {
  public String id;
  public String content;
  public Integer isDone;
  public String category;
  public List<String> hashtags;
  public LocalDateTime createdAt;
  public Integer isDeleted;

  public Todo convertToJooqTodo() {
    var todoPojo = new Todo();
    todoPojo.setId(id);
    todoPojo.setContent(content);
    todoPojo.setIsDone(isDone);
    todoPojo.setCategory(category);
    todoPojo.setHashtags(hashtags.stream().reduce((cur, prev) -> cur + "," + prev).orElse(""));
    todoPojo.setCreatedAt(createdAt);
    todoPojo.setIsDeleted(isDeleted);
    return todoPojo;
  }

  public static TodoPojo buildFromJooqTodo(Todo todo) {
    var todoPojo = new TodoPojo();
    todoPojo.id = todo.getId();
    todoPojo.content = todo.getContent();
    todoPojo.isDone = todo.getIsDone();
    todoPojo.category = todo.getCategory();
    todoPojo.hashtags = List.of(todo.getHashtags().split(","));
    todoPojo.createdAt = todo.getCreatedAt();
    todoPojo.isDeleted = todo.getIsDeleted();
    return todoPojo;
  }
}
