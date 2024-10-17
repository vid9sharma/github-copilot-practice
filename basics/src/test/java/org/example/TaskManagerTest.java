package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TaskManagerTest {

  @Test
  public void addTask_shouldAddTaskToList() {
    TaskManager taskManager = new TaskManager();
    taskManager.addTask("New Task");

    List<TaskManager.Task> tasks = taskManager.getTasks();
    assertEquals(1, tasks.size());
    assertEquals("New Task", tasks.get(0).getDescription());
    assertFalse(tasks.get(0).isDone());
  }

  @Test
  public void getTasks_shouldReturnAllTasks() {
    TaskManager taskManager = new TaskManager();
    taskManager.addTask("Task 1");
    taskManager.addTask("Task 2");

    List<TaskManager.Task> tasks = taskManager.getTasks();
    assertEquals(2, tasks.size());
    assertEquals("Task 1", tasks.get(0).getDescription());
    assertEquals("Task 2", tasks.get(1).getDescription());
  }

  @Test
  public void markTaskAsDone_shouldMarkTaskAsDone() {
    TaskManager taskManager = new TaskManager();
    taskManager.addTask("Task to be done");

    taskManager.markTaskAsDone(0);

    List<TaskManager.Task> tasks = taskManager.getTasks();
    assertTrue(tasks.get(0).isDone());
  }

  @Test
  public void markTaskAsDone_withInvalidIndex_shouldThrowException() {
    TaskManager taskManager = new TaskManager();
    taskManager.addTask("Task");

    try {
      taskManager.markTaskAsDone(1);
      fail("Expected an IndexOutOfBoundsException to be thrown");
    } catch (IndexOutOfBoundsException e) {
      assertEquals("Invalid task index", e.getMessage());
    }
  }

    @Test
  public void removeTask_shouldRemoveTaskFromList() {
    TaskManager taskManager = new TaskManager();
    taskManager.addTask("Task to be removed");
    taskManager.removeTask(0);

    List<TaskManager.Task> tasks = taskManager.getTasks();
    assertEquals(0, tasks.size());
  }

    @Test
    public void removeTask_withInvalidIndex_shouldThrowException() {
      TaskManager taskManager = new TaskManager();
      taskManager.addTask("Task");

      try {
        taskManager.removeTask(1);
        fail("Expected an IndexOutOfBoundsException to be thrown");
      } catch (IndexOutOfBoundsException e) {
        assertEquals("Invalid task index", e.getMessage());
      }
    }

    @Test
    public void removeTask_withNegativeIndex_shouldThrowException() {
      TaskManager taskManager = new TaskManager();
      taskManager.addTask("Task");

      try {
        taskManager.removeTask(-1);
        fail("Expected an IndexOutOfBoundsException to be thrown");
      } catch (IndexOutOfBoundsException e) {
        assertEquals("Invalid task index", e.getMessage());
      }
    }

    @Test
    public void removeTask_withIndexEqualToSize_shouldThrowException() {
      TaskManager taskManager = new TaskManager();
      taskManager.addTask("Task");

      try {
        taskManager.removeTask(1);
        fail("Expected an IndexOutOfBoundsException to be thrown");
      } catch (IndexOutOfBoundsException e) {
        assertEquals("Invalid task index", e.getMessage());
      }
    }
}