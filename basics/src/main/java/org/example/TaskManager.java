package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of tasks.
 */
public class TaskManager {
  private List<Task> tasks;

  public TaskManager() {
    this.tasks = new ArrayList<>();
  }

  /**
   * Adds a new task to the task list.
   *
   * @param description The description of the task.
   */
  public void addTask(String description) {
    tasks.add(new Task(description));
  }

  /**
   * Returns the list of tasks.
   *
   * @return The list of tasks.
   */
  public List<Task> getTasks() {
    return tasks;
  }

  /**
   * Marks a task as done.
   *
   * @param index The index of the task to mark as done.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public void markTaskAsDone(int index) {
    if (index >= 0 && index < tasks.size()) {
      tasks.get(index).setDone(true);
    } else {
      throw new IndexOutOfBoundsException("Invalid task index");
    }
  }

  /**
 * Removes a task from the task list.
 *
 * @param index The index of the task to remove.
 * @throws IndexOutOfBoundsException if the index is out of range.
 */
public void removeTask(int index) {
  if (index >= 0 && index < tasks.size()) {
    tasks.remove(index);
  } else {
    throw new IndexOutOfBoundsException("Invalid task index");
  }
}

  /**
   * Represents a task with a description and a done flag.
   */
  public static class Task {
    private String description;
    private boolean done;

    public Task(String description) {
      this.description = description;
      this.done = false;
    }

    public String getDescription() {
      return description;
    }

    public boolean isDone() {
      return done;
    }

    public void setDone(boolean done) {
      this.done = done;
    }

    @Override
    public String toString() {
      return "Task[description=\"" + description + "\", done=" + done + "]";
    }
  }
}