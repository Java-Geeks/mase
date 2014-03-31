package io.github.javageeks.mase.repository;

import io.github.javageeks.mase.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interface for todo repository.
 */
public interface TodoRepository extends MongoRepository<Todo, String> {

    /**
     * Find todo list by user id.
     * @param userId the user id
     * @return the todo list for the given user
     */
    List<Todo> findByUserId(String userId);

    /**
     * Find todo list by title.
     * @param userId the userId
     * @param title the todo title
     * @return the todo list with the given todo title
     */
    List<Todo> findByUserIdAndTitleLike(String userId, String title);

    /**
     * Find todo list by description.
     * @param userId the user id
     * @param description the todo description
     * @return the todo list with the given todo description
     */
    List<Todo> findByUserIdAndDescriptionLike(String userId, String description);

    /**
     * Find todo list by todo status.
     * @param userId the user id
     * @param status the todo status
     * @return the todo list with the given todo status
     */
    List<Todo> findByUserIdAndStatusIsTrue(String userId, boolean status);

}
