import { Todo, Task_Type, Task_Interface } from "./todo";
import { Interface_Source } from "./source";

/**
 *  Builder
 */
export class Task_Builder {
  source: Interface_Source = {
    university: "",
    work: "",
    life: "",
  };

  constructor(source?: Interface_Source) {
    this.todo = new Todo(this.counter++);
  }

  private counter = 0;
  private todo: Todo;

  private reset(): void {
    this.todo = new Todo(this.counter++);
  }

  private getNewTodoInstance(): Todo {
    const res = this.todo;
    this.reset();
    return res;
  }

  createEatItem(): Task_Interface {
    const res = this.getNewTodoInstance();
    res.type = Task_Type.eat;
    res.source = this.source.life;
    console.log(`Add to eat`);
    return res;
  }

  createGroceryItem(): Task_Interface {
    const res = this.getNewTodoInstance();
    res.type = Task_Type.grocery;
    res.source = this.source.life;
    console.log(`Add to get grocery`);
    return res;
  }

  createReadItem(): Task_Interface {
    const res = this.getNewTodoInstance();
    res.type = Task_Type.read;
    res.source = this.source.university;
    console.log(`Add to read`);
    return res;
  }

  createWorkItem(): Task_Interface {
    const res = this.getNewTodoInstance();
    res.type = Task_Type.work;
    res.source = this.source.work;
    console.log(`Add to work`);
    return res;
  }
}
