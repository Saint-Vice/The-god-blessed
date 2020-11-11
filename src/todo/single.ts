import { Task_Builder } from "./todoBuild";
import { Interface_Source } from "./source";
import { Organizer } from "./organizer";

/**
 * Singleton
 */
export class Task_List {
  private static instance: Task_List;
  private constructor() {
    this.Task_Builder = new Task_Builder();
    this.Organizer = new Organizer();
  }
  static getInstance() {
    if (!Task_List.instance) {
      Task_List.instance = new Task_List();
    }
    return Task_List.instance;
  }

  private Organizer: Organizer;
  private Task_Builder: Task_Builder;

  setTodoSource(source: Interface_Source): void {
    this.Task_Builder.source = source;
  }

  addToEat(food: string, description: string): void {
    console.log("You need to eat!");
    const todo = this.Task_Builder.createEatItem();
    todo.payload = food;
    todo.description = description;
    this.Organizer.addViaEmailTask(todo);
  }

  addToGetGrocery(grocery: string, description: string): void {
    console.log("You need to get groceries!");
    const todo = this.Task_Builder.createGroceryItem();
    todo.payload = grocery;
    todo.description = description;
    this.Organizer.addViaSmsTask(todo);
  }

  addToRead(book: string, description: string): void {
    console.log("You need to read this book!");
    const todo = this.Task_Builder.createReadItem();
    todo.payload = book;
    todo.description = description;
    this.Organizer.addViaEmailTask(todo);
  }

  addToWork(task: string, description: string): void {
    console.log("You need to solve this issue!");
    const todo = this.Task_Builder.createWorkItem();
    todo.payload = task;
    todo.description = description;
    this.Organizer.addViaEmailTask(todo);
  }
}
