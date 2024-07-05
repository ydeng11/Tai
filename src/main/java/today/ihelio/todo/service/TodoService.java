package today.ihelio.todo.service;

import io.quarkus.virtual.threads.VirtualThreads;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import org.jooq.DSLContext;
import today.ihelio.jooq.tables.pojos.Todo;
import today.ihelio.jooq.tables.records.TodoRecord;

import static today.ihelio.jooq.Tables.CATEGORIES;
import static today.ihelio.jooq.Tables.HASHTAGS;
import static today.ihelio.jooq.Tables.TODO;

@Singleton
public class TodoService {

  private final DSLContext dslContext;

  private final ExecutorService executorService;

  @Inject
  public TodoService(DSLContext dslContext, @VirtualThreads ExecutorService executorService) {
    this.dslContext = dslContext;
    this.executorService = executorService;
  }

  public void createTodo(Todo todo) {
    var todoRecord = new TodoRecord();
    todoRecord.setId(todo.getId());
    todoRecord.setCategory(todo.getCategory());
    todoRecord.setHashtags(todo.getHashtags());
    todoRecord.setContent(todo.getContent());
    todoRecord.setIsDone(todo.getIsDone());
    todoRecord.setIsDeleted(todo.getIsDeleted());
    todoRecord.setCreatedAt(todo.getCreatedAt());

    CompletableFuture.runAsync(() -> {
      mayInsertNewCategory(todo.getCategory());
    }, executorService);
    CompletableFuture.runAsync(() -> {
      mayInsertNewHashtag(todo.getHashtags());
    }, executorService);

    dslContext.insertInto(TODO)
        .set(todoRecord)
        .execute();
  }

  public void updateTodo(Todo todo) {
    dslContext.update(TODO)
        .set(TODO.IS_DONE, todo.getIsDone())
        .set(TODO.IS_DELETED, todo.getIsDeleted())
        .where(TODO.ID.eq(todo.getId()))
        .execute();

  }

  public void mayInsertNewCategory(String category) {
    dslContext.insertInto(CATEGORIES, CATEGORIES.NAME)
        .values(category)
        .onDuplicateKeyIgnore()
        .execute();
  }

  public void mayInsertNewHashtag(String hashtags) {
    Arrays.stream(hashtags.split(",")).forEach(hashtag -> {
      dslContext.insertInto(HASHTAGS, HASHTAGS.NAME)
          .values(hashtag)
          .onDuplicateKeyIgnore()
          .execute();
    });
  }

  public List<String> getHashtags() {
    return dslContext.selectDistinct(TODO.HASHTAGS)
        .from(TODO)
        .where(TODO.IS_DELETED.eq(0))
        .fetch()
        .getValues(TODO.HASHTAGS)
        .stream().map(s -> s.split(","))
        .flatMap(Arrays::stream).toList();
  }


  public List<String> getCategories() {
    return dslContext.selectDistinct(TODO.CATEGORY)
        .from(TODO)
        .where(TODO.IS_DELETED.eq(0))
        .fetch()
        .getValues(TODO.CATEGORY);
  }

  public List<Todo> getTodos() {
    return dslContext
        .selectFrom(TODO)
        .fetch()
        .map(record -> record.into(Todo.class));
  }
}
