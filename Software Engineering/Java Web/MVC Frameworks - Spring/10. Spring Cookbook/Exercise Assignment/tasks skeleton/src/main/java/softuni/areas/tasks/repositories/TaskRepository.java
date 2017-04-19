package softuni.areas.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.areas.characters.entities.Character;
import softuni.areas.tasks.entities.Task;
import softuni.areas.tasks.enums.Status;
import softuni.areas.tasks.enums.TaskType;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByStatus(Status status);
    Task findTaskByCharacterAndStatus(Character character, Status status);
    Long countByTypeAndCharacter(TaskType taskType, Character character);
}